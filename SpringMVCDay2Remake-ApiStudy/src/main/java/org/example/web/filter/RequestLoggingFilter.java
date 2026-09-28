package org.example.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;


public class RequestLoggingFilter implements Filter {

    private final Logger log = (Logger) LoggerFactory.getLogger(RequestLoggingFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("[Filter] >>> incoming {}{}", req.getMethod(), req.getRequestURI());

        chain.doFilter(request, response);

        log.info("[FILTER] <<< Finished {}{}", req.getMethod(), req.getRequestURI());
    }
}
