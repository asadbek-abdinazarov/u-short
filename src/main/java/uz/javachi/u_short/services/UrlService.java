package uz.javachi.u_short.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface UrlService {
    CompletableFuture<String> shortenUrl(String url);

    CompletableFuture<String> getOriginalUrl(String code);
}

