package org.example.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.LogFactory;
import org.example.web.exception.TaskNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class TaskTimingInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TaskNotFoundException.class);
    private static final String START ="startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START, System.currentTimeMillis());

        if(handler instanceof HandlerMethod hm){
            log.info("[INTERCEPTOR] preHandle -- ABOUT TO INVOKE {}#{}",
                    hm.getBeanType().getSimpleName(), hm.getMethod().getName());
        }
                return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            long elapsed =System.currentTimeMillis()-(long) request.getAttribute(START);
            log.info("[Interceptor] afterCompletion -- {} took {} ms",
                    request.getRequestURI(), elapsed,
                    ex != null ? "(failed: "+ex + ")" : "");
    }
}
