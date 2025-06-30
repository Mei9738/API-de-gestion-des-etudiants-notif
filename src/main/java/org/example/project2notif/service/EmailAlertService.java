package org.example.project2notif.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.dto.NotificationDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailAlertService implements AlertService {
    @Override
    public void send(String recipientId, NotificationDto notificationDto) {
        // Simulate sending an Email notification
        final var mockMsg = String.format("Sending Email to recipient ID: %s", recipientId);
        System.out.println(mockMsg);
    }
}
