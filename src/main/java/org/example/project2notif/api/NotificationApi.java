package org.example.project2notif.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.dto.NotificationDto;
import org.example.project2notif.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
@Slf4j
public class NotificationApi {
    private final NotificationService notificationService;

    @Operation(
            summary = "Create Notification",
            description = "Create a new notification record",
            responses = {
                    @ApiResponse(
                            description = "Notification created successfully",
                            responseCode = "201",
                            content = @Content(
                                    schema = @Schema(implementation = NotificationDto.class)
                            )
                    )
            }
    )
    @PostMapping
    public NotificationDto send(@RequestBody NotificationDto notificationDto) {
        log.info("Start Api: create notification");
        final var result = notificationService.send(notificationDto);
        log.info("End Api: create notification with id {}", notificationDto.id());
        return result;
    }
}
