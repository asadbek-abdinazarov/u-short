package uz.javachi.u_short.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class UrlAccessInterceptor implements HandlerInterceptor {

    private static final Set<String> allowedUrls = Set.of(
            "shorten", "c"
    );

    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler) throws IOException {
        String uri = request.getRequestURI();

        String[] parts = uri.split("/");
        if (parts.length > 1) {
            String shortKey = parts[1];
            if (allowedUrls.contains(shortKey)) {
                return true;
            }
        }

        response.sendRedirect("/");
        return false;
    }
}