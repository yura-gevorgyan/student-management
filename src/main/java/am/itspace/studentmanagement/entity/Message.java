package am.itspace.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fromId;
    private int toId;
    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date dateTime;

}
