package am.itspace.studentmanagement.service.impl;

import am.itspace.studentmanagement.entity.Message;
import am.itspace.studentmanagement.repository.MessageRepository;
import am.itspace.studentmanagement.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> findAllByFromIdAndToId(int fromId, int toId) {
        return messageRepository.findAllByFromIdAndToId(fromId, toId);
    }

}
