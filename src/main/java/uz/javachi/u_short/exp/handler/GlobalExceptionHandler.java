package uz.javachi.u_short.exp.handler;

import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.javachi.u_short.dtos.ErrorDTO;
import uz.javachi.u_short.dtos.UrlRequest;
import uz.javachi.u_short.exp.UrlNotFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UrlNotFoundException.class)
    public String handleUrlNotFound(UrlNotFoundException ex, Model model) {
        List<ErrorDTO> errors = new ArrayList<>();
        errors.add(new ErrorDTO("shortCode", ex.getMessage()));

        model.addAttribute("urlRequest", new UrlRequest());
        model.addAttribute("errors", errors);
        ex.printStackTrace();

        return "index";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationErrors(MethodArgumentNotValidException ex, Model model) {
        List<ErrorDTO> errors = new ArrayList<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        model.addAttribute("urlRequest", new UrlRequest());
        model.addAttribute("errors", errors);
        ex.printStackTrace();

        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneric(Exception ex, Model model) {
        List<ErrorDTO> errors = new ArrayList<>();
        String message = ex.getMessage();
        String parsedMessage = (message != null && message.contains(":")) ? message.substring(message.indexOf(":") + 1) : message;
        errors.add(new ErrorDTO("", "Error " + parsedMessage));

        model.addAttribute("urlRequest", new UrlRequest());
        model.addAttribute("errors", errors);
        ex.printStackTrace();

        return "index";
    }
}
