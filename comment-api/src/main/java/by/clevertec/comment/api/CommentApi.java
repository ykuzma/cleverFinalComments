package by.clevertec.comment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"by.clevertec.comment.api", "by.clevertec.comment.core"})
@EnableJpaRepositories
@EntityScan
public class CommentApi {
    public static void main(String[] args) {
        SpringApplication.run(CommentApi.class, args);
    }


}
