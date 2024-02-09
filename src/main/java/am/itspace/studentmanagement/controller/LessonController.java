package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.security.SpringUser;
import am.itspace.studentmanagement.service.impl.LessonServiceImpl;
import am.itspace.studentmanagement.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LessonController {

    private final LessonServiceImpl lessonService;
    private final UserServiceImpl userService;

    @GetMapping("/teacher/lesson/add")
    public String addLessonPage() {
        return "addLesson";
    }

    @PostMapping("/teacher/lesson/add")
    public String addLesson(@ModelAttribute Lesson lesson, @AuthenticationPrincipal SpringUser springUser) {
        User user = springUser.getUser();
        lesson.setUser(user);
        userService.saveUser(user);
        lessonService.save(lesson);
        return "redirect:/teacher/home";
    }


}
