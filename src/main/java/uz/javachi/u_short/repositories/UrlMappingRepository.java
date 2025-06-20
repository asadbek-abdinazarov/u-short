package uz.javachi.u_short.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.javachi.u_short.models.UrlMapping;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    Optional<UrlMapping> findByShortCode(String shortCode);

    Optional<UrlMapping> findByOriginalUrl(String originalUrl);

}