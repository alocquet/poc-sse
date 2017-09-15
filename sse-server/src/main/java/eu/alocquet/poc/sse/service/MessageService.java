package eu.alocquet.poc.sse.service;

import eu.alocquet.poc.sse.domain.Message;
import eu.alocquet.poc.sse.repository.MessageRepository;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author alocquet
 */
@Service
public class MessageService {

    private final EmitterProcessor<ServerSentEvent<Message>> emitter;
    private final MessageRepository repo;

    public MessageService(final MessageRepository repo) {
        this.repo = repo;
        emitter = EmitterProcessor.create(false);
    }

    public Flux<ServerSentEvent<Message>> getMessageStream() {
        return emitter.log();
    }

    public Flux<Message> findAll() {
        return repo.findAll();
    }

    public void addMessage(final Message message) {
        repo.insert(message).subscribe(newMessage ->
                emitter.onNext(ServerSentEvent.builder(newMessage).build()));
    }
}
