package middleware.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class APILoggingInterceptor implements HandlerInterceptor {

    /**
     * APILoggingInterceptor prints in the console the requests header User-Agent,
     * before handling them
     */

    /**
     * Suggerimento di chatGPT
     */
    public static final Logger logger = LoggerFactory.getLogger(APILoggingInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("Received request: " + request.getRequestURI());
        System.out.println("User-Agent:: " + request.getHeader("User-Agent"));
        return true;
        }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("Sending response: " + request.getRequestURI());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }



}
