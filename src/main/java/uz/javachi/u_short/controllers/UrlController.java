package uz.javachi.u_short.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import uz.javachi.u_short.dtos.UrlRequest;
import uz.javachi.u_short.services.UrlService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
public class UrlController {
    @Value("${app.base-url}")
    private String baseUrl;
    private final UrlService urlService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("urlRequest", new UrlRequest());
        return "index";
    }

    @PostMapping("/shorten")
    public String shorten(@ModelAttribute @Valid UrlRequest urlRequest, Model model) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = urlService.shortenUrl(urlRequest.getOriginalUrl());
        String shortCode = stringCompletableFuture.get();
        model.addAttribute("shortUrl", baseUrl + "/c/" + shortCode);
        return "index";
    }

    @GetMapping("/c/{code}")
    public RedirectView redirect(@PathVariable String code) throws ExecutionException, InterruptedException {
        CompletableFuture<String> originalUrl = urlService.getOriginalUrl(code);
        String url = originalUrl.get();
        return new RedirectView(url);
    }
}