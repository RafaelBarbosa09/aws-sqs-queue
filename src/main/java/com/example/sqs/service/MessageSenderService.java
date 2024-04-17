package com.example.sqs.service;

import com.example.sqs.dto.Message;
import com.example.sqs.exception.SendMessageException;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {
    private final SqsTemplate sqsTemplate;
    private final String queueUrl;

    public MessageSenderService(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
        this.queueUrl = "http://localhost:4566/000000000000/minha-fila";
    }

    public void sendMessage(Message message) {
        try {
            sqsTemplate.send(queueUrl, new Message(message.content()));
        } catch (Exception e) {
            throw new SendMessageException("Erro ao enviar mensagem: " + e.getMessage());
        }
    }
}
