package org.example.project2notif.service;

import org.example.project2notif.dto.NotificationDto;
import java.util.UUID;

public interface AlertService {
    void send(UUID recipientId, NotificationDto notificationDto);
}

