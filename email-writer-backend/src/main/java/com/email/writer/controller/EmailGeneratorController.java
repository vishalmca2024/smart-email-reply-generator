package com.email.writer.controller;

import com.email.writer.EmailGeneratorService;
import com.email.writer.EmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmailGeneratorController {

    private EmailGeneratorService emailGeneratorService ;

     @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailREquest){

        String response = emailGeneratorService.generateEmailReply(emailREquest);
        return ResponseEntity.ok(response);
    }
}
