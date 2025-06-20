package uz.javachi.u_short.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import uz.javachi.u_short.models.UrlMapping;
import uz.javachi.u_short.repositories.UrlMappingRepository;
import uz.javachi.u_short.services.UrlService;
import uz.javachi.u_short.utils.Base52Encoder;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
    private final UrlMappingRepository repository;

    @Async
    public CompletableFuture<String> shortenUrl(String url) {
        return CompletableFuture.completedFuture(repository.findByOriginalUrl(url)
                .map(UrlMapping::getShortCode)
                .orElseGet(() -> {
                    UrlMapping mapping = repository.save(new UrlMapping(null, url, "",
                            LocalDateTime.now(), LocalDateTime.now().plusDays(40), true));
                    String shortCode = Base52Encoder.encode(mapping.getId());
                    mapping.setShortCode(shortCode);
                    repository.save(mapping);
                    return shortCode;
                }));
    }

    @Async
    public CompletableFuture<String> getOriginalUrl(String code) {
        return CompletableFuture.completedFuture(repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("%s uchun URL topilmadi!".formatted(code)))
                .getOriginalUrl());
    }
}

