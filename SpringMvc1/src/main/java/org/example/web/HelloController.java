package org.example.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.GreetingService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

    private final GreetingService greetingService;
    public HelloController(GreetingService greetingService){
        this.greetingService=greetingService;
    }
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "This is the message: ");
        modelAndView.addObject("name ",greetingService.greet("Omar"));
        return modelAndView;
    }
}
