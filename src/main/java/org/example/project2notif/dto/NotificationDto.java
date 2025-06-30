package org.example.project2notif.dto;

import org.example.project2notif.enumeration.NotificationType;

import java.util.UUID;

public record NotificationDto(
        UUID id,
        UUID studentId,
        String message,
        NotificationType type
) {}
