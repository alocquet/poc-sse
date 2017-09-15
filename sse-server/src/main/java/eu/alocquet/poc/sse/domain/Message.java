package eu.alocquet.poc.sse.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author alocquet
 */
@Document
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "uid")
public class Message implements Serializable {
    @Id
    private String uid;
    private String from;
    private LocalDateTime date;
    private String data;
}
