package org.example.project2notif.mapper;

import org.example.project2notif.domain.Notification;
import org.example.project2notif.domain.Student;
import org.example.project2notif.dto.NotificationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "studentId", source = "student.id")
    NotificationDto toDto(Notification notification);

    @Mapping(target = "student", source = "studentId", qualifiedByName = "studentIdToStudent")
    Notification toEntity(NotificationDto notificationDto);

    @Named("studentIdToStudent")
    default Student studentIdToStudent(UUID studentId) {
        if (studentId == null) {
            return null;
        }

        return Student.builder()
                .id(studentId)
                .build();
    }
}
