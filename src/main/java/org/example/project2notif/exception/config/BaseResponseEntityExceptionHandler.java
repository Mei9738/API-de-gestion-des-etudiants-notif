package org.example.project2notif.exception.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.config.Messages;
import org.example.project2notif.exception.TechnicalException;
import org.example.project2notif.util.consts.GlobalConstants;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;

@Slf4j
@RequiredArgsConstructor
public class BaseResponseEntityExceptionHandler {
    private final Messages messages;

    Problem buildProblem(Exception e, HttpStatus status) {
        String title = e.getClass()
                .getSimpleName();
        String detail = e.getMessage();
        if (e instanceof TechnicalException) {
            detail = messages.get(GlobalConstants.ERROR_WS_TECHNICAL);
        }
        return buildProblem(title, status, detail);
    }

    Problem buildProblem(String title, HttpStatus status, String detail) {
        return Problem.create()
                .withTitle(title)
                .withStatus(status)
                .withDetail(detail);
    }
}