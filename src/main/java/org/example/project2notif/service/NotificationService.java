package org.example.project2notif.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.dto.NotificationDto;
import org.example.project2notif.mapper.NotificationMapper;
import org.example.project2notif.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final AlertService smsAlertService;

    public NotificationDto send(NotificationDto notificationDto) {
        log.info("Start Service: create");
        final var notification = notificationMapper.toEntity(notificationDto);
        final var result = notificationMapper.toDto(notificationRepository.save(notification));
        smsAlertService.send(
                Objects.toString(result.studentId(), null),
                result
        );
//        throw new RuntimeException("This is a test exception to simulate a failure in the notification service");
        log.info("End Service: create with notification id {}", notification.getId());
        return result;
    }
}
