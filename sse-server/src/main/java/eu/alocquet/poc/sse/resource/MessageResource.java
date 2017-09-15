package eu.alocquet.poc.sse.resource;

import eu.alocquet.poc.sse.domain.Message;
import eu.alocquet.poc.sse.service.MessageService;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author alocquet
 */
@RestController
@RequestMapping("api/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageResource {

    private final MessageService service;

    public MessageResource(final MessageService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Message> findAll() {
        return service.findAll();
    }

    @GetMapping("stream")
    public Flux<ServerSentEvent<Message>> getMessageStream() {
        return service.getMessageStream();
    }

    @PostMapping
    public void addMessage(@RequestBody final Message message) {
        service.addMessage(message);
    }

}
