package org.example.project2notif.exception.config;


import lombok.extern.slf4j.Slf4j;
import org.example.project2notif.config.Messages;
import org.example.project2notif.exception.FunctionalException;
import org.example.project2notif.exception.TechnicalException;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends BaseResponseEntityExceptionHandler {
    public CustomizedResponseEntityExceptionHandler(Messages messages) {
        super(messages);
    }

    @ExceptionHandler(TechnicalException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Problem onTechnicalException(TechnicalException e) {
        log.error(e.getMessage(), e);
        return buildProblem(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FunctionalException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Problem onFunctionalException(FunctionalException e) {
        log.error(e.getMessage(), e);
        return buildProblem(e, HttpStatus.BAD_REQUEST);
    }
}
