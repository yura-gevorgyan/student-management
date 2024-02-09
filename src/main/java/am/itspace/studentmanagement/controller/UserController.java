package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public String userPage(@ModelAttribute User user, @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        User byEmail = userService.findByEmail(user.getEmail());
        if (byEmail == null) {
            userService.save(user, multipartFile);
            return "redirect:/";
        } else {
            String msg = "WITH THIS EMAIL HAVE ALREADY REGISTERED !!!";
            return "redirect:/register?msg=" + msg;
        }

    }

}
