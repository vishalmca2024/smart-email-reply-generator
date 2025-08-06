# ✉️ Smart Email Reply Generator

An AI-powered full-stack web application that helps users generate intelligent email replies based on tone using **Gemini AI**. Built with **Java Spring Boot** (backend) and **React.js** (frontend).

---

## 🚀 Live Demo

⏳ Live link coming soon...

🔗 In the meantime, check out my [LinkedIn Profile](https://www.linkedin.com/in/vishal-chourdiya-288a8a23a/) to connect or explore more of my work.

---

## 🔧 Tech Stack

| Layer       | Technology                   |
|-------------|-------------------------------|
| Frontend    | React.js (Vite), CSS, HTML    |
| Backend     | Java 17, Spring Boot, WebClient |
| AI          | Gemini API (Google AI)        |
| Future Plan | Chrome Extension + Gmail Integration |

---

## 🎯 Features

✅ Generate smart replies based on your input  
✅ **Select a reply tone**:  
- `None` (default AI response)  
- `Casual`  
- `Professional`  
- `Friendly`

✅ **Copy to clipboard** with one click  
✅ Minimal, clean user interface  
✅ Gemini API integration using Spring WebClient  
✅ Secure and scalable backend with layered architecture  
✅ Ready for **future integration with Gmail** via Chrome Extension

---

## 🧠 Use Case

You input a message (e.g., an email you received) and choose the **tone** of the reply you'd like. The system will then generate an appropriate response:

### Example:

**Input:**  
> "Hey, just checking if we can reschedule tomorrow’s meeting?"

**Tone Selected:**  
- **Professional:**  
  "Thank you for reaching out. I’m available to reschedule. Please let me know your preferred time."

- **Friendly:**  
  "Sure! Totally fine to move it. Just let me know when works best 😊"

---

## 📁 Folder Structure

Smart-Email-Reply-Generator/
├── email-writer-backend/ # Spring Boot backend
│ ├── controller/
│ ├── service/
│ └── EmailWriterSbApplication.java
├── email-writer-react/ # React frontend
│ ├── src/
│ │ └── App.jsx
│ └── public/
└── README.md
