package eu.alocquet.poc.sse.repository;

import eu.alocquet.poc.sse.domain.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alocquet
 */
@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
}
