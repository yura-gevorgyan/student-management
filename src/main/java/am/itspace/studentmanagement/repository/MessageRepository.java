package am.itspace.studentmanagement.repository;

import am.itspace.studentmanagement.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findAllByFromIdAndToId(int fromId, int toId);
}
