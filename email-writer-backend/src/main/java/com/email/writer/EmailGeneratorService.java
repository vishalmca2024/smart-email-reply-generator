package com.email.writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
@Service
public class EmailGeneratorService {

    private final WebClient webClient ;


    @Value("${gemini.api.url}")
    private String geminiApiUrl ;
    @Value("${gemini.api.key}")
    private String geminiApiKey ;

    public EmailGeneratorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String generateEmailReply(EmailRequest emailRequest) {

        //  STEP 1 -> Build  the prompt
        String prompt = buildPromt(emailRequest);
        //  STEP 2 -> Craft a Request
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );
        //  STEP 3 -> Do Request and get Response
        String response = webClient.post()
                .uri(geminiApiUrl+geminiApiKey)
                .header("Content-Type" , "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block() ;


        //  STEP 4 -> Extract Response and Return
         return  extractResponseContent(response);
    }

    private String extractResponseContent(String response) {

        try{
            ObjectMapper mapper = new ObjectMapper() ;
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

        }catch (Exception e){
            return "Error processing request: " + e.getMessage();
        }
    }

    private String buildPromt(EmailRequest emailRequest) {

        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content.Please do not  generate a subject line. Don't include options, explanations, or subject lines. Just write the reply only");

        if(emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a").append(emailRequest.getTone()).append("tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}

