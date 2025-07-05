package org.example.project2notif.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.dto.NotificationDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsAlertService implements AlertService {

    @Override
    public void send(UUID recipientId, NotificationDto notificationDto) {
        // Simulate sending an SMS notification
        final var mockMsg = String.format("Sending SMS to recipient ID: %s", recipientId);
        System.out.println(mockMsg);
    }
}
