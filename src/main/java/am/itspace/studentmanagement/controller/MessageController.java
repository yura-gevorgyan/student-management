package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.Message;
import am.itspace.studentmanagement.security.SpringUser;
import am.itspace.studentmanagement.service.impl.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageServiceImpl messageService;

    @GetMapping("/message/{id}")
    public String sendMessagePage(@AuthenticationPrincipal SpringUser springUser, @PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("studentId", id);
        modelMap.addAttribute("messages", messageService.findAllByFromIdAndToId(id, springUser.getUser().getId()));
        return "messenger";
    }

    @PostMapping("/message/send")
    public String sendMessage(@ModelAttribute Message message, @RequestParam("studentId") int id, @AuthenticationPrincipal SpringUser springUser) {
        message.setFromId(springUser.getUser().getId());
        message.setToId(id);
        message.setDateTime(new Date());
        messageService.save(message);
        return "redirect:/student/home";
    }

}
