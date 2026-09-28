package org.example.web.advice;

import org.example.web.exception.TaskNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public String classNotFound(TaskNotFoundException ex, Model model){
        model.addAttribute("message", ex.getMessage());
        return "error/notfound";
    }
}
