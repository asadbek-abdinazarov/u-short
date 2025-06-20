package uz.javachi.u_short.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final UrlAccessInterceptor urlAccessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlAccessInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/static/**", "/css/**", "/js/**");
    }
}
