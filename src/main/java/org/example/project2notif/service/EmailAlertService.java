package org.example.project2notif.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.dto.NotificationDto;
import org.example.project2notif.repository.StudentRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailAlertService implements AlertService {
    private static final String SOURCE_EMAIL = "p2@no-reply.com";
    private final JavaMailSender emailSender;
    private final StudentRepository studentRepository;

    @Override
    public void send(UUID recipientId, NotificationDto notificationDto) {
        studentRepository.findById(recipientId).ifPresent(student -> {
            final var message = new SimpleMailMessage();
            message.setFrom(SOURCE_EMAIL);
            message.setTo(student.getEmail());
            message.setSubject(notificationDto.type().name());
            message.setText(notificationDto.message());
            emailSender.send(message);
        });
    }
}
