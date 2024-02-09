package am.itspace.studentmanagement.service;

import am.itspace.studentmanagement.entity.Message;

import java.util.List;

public interface MessageService {
    void save(Message message);

    List<Message> findAllByFromIdAndToId(int fromId,int toId);
}
