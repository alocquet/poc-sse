package eu.alocquet.poc.sse.conf;

import eu.alocquet.poc.sse.domain.Message;
import eu.alocquet.poc.sse.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.time.LocalDateTime;

/**
 * mongodb configuration
 *
 * @author alocquet
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "eu.alocquet.poc.sse.repository")
public class MongoConfiguration {

    /**
     * initialize database
     *
     * @param messageRepository repository
     * @return database initialization script
     */
    @Bean
    CommandLineRunner initData(final MessageRepository messageRepository) {
        return (p) -> {
            messageRepository.deleteAll().block();
            messageRepository.save(Message.builder().from("Arnaud").date(LocalDateTime.now().minusMinutes(1)).data("Bonjour !").build()).block();
        };
    }
}
