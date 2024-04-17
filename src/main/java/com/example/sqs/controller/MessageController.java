package com.example.sqs.controller;

import com.example.sqs.dto.Message;
import com.example.sqs.service.MessageSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageSenderService messageSenderService;

    public MessageController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping("/send-message")
    public ResponseEntity<Object> sendMessage(@RequestBody Message message) {
        try {
            messageSenderService.sendMessage(message);
            return ResponseEntity.status(HttpStatus.CREATED).body("Mensagem enviada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
