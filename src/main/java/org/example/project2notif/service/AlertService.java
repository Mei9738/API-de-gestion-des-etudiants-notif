package org.example.project2notif.service;

import org.example.project2notif.dto.NotificationDto;

public interface AlertService {
    void send(String recipientId, NotificationDto notificationDto);
}
