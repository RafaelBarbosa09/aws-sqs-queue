package com.example.sqs.service;

import com.example.sqs.dto.Message;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {
    @SqsListener("${queue.name}")
    public void listen(Message message) {
        System.out.println("Mensagem Recebida: " + message.content());
    }
}
