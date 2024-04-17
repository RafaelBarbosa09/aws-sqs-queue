package com.example.sqs.service;

import com.example.sqs.dto.Message;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {
    @SqsListener("minha-fila")
    public void listen(Message message) {
        System.out.println("Mensagem Recebida: " + message.content());
    }
}
