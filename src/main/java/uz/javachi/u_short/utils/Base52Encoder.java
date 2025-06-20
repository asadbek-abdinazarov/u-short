package uz.javachi.u_short.utils;

import java.security.SecureRandom;
import java.time.Instant;

public class Base52Encoder {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String encode(long id) {
        long timestamp = Instant.now().toEpochMilli();
        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int index = (int) (timestamp % CHARACTERS.length());
            shortCode.append(CHARACTERS.charAt(index));
            timestamp /= CHARACTERS.length();
        }

        for (int i = 0; i < 3; i++) {
            shortCode.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return shortCode.toString() + id;
    }
}

/* /*function createParticles() {
        const particlesContainer = document.querySelector('.floating-particles');
        const particleCount = 100; // Changed from 20 to 40

        for (let i = 0; i < particleCount; i++) {
            const particle = document.createElement('div');
            particle.className = 'particle';
            particle.style.left = Math.random() * 100 + '%';
            particle.style.animationDelay = Math.random() * 20 + 's';
            particle.style.animationDuration = (Math.random() * 15 + 15) + 's';
            particlesContainer.appendChild(particle);
        }
    }*/

