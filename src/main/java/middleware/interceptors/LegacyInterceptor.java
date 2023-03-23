package middleware.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LegacyInterceptor implements HandlerInterceptor {

    /**
     *    LegacyInterceptor:
     *    - blocks the API calls to the legacy endpoint
     *    - returns a response with the right HTTP code status for Gone
     *    (The HyperText Transfer Protocol (HTTP) 410 Gone client error response code
     *    indicates that access to the target resource is no longer available at the origin server
     *    and that this condition is likely to be permanent)
     */

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(!(request.getRequestURL().toString().contains("/legacy"))){
            return true;
        }
        //altrimenti esegui questa logica
        response.setStatus(410);
        throw new Exception("This endpoint (\"/legacy\") is blocked");
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }



}
