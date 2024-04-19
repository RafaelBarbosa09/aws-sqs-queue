package com.example.sqs.service;

import com.example.sqs.dto.Message;
import com.example.sqs.exception.SendMessageException;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {
    @Value("${queue.url}")
    private String queueUrl;
    private final SqsTemplate sqsTemplate;

    public MessageSenderService(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public void sendMessage(Message message) {
        try {
            sqsTemplate.send(queueUrl, new Message(message.content()));
        } catch (Exception e) {
            throw new SendMessageException("Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}
