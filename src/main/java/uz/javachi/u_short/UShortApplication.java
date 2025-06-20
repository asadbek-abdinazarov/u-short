package uz.javachi.u_short;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class UShortApplication {

    public static void main(String[] args) {
        SpringApplication.run(UShortApplication.class, args);
    }

}
