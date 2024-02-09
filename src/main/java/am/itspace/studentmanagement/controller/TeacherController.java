package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserType;
import am.itspace.studentmanagement.security.SpringUser;
import am.itspace.studentmanagement.service.impl.LessonServiceImpl;
import am.itspace.studentmanagement.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class TeacherController {

    private final LessonServiceImpl lessonService;
    private final UserServiceImpl userService;

    @GetMapping("/teacher/home")
    public String teacherPage(@AuthenticationPrincipal SpringUser springUser, ModelMap modelMap) {
        List<User> allByLessonId = userService.findAllByLessonAndUserType(springUser.getUser().getLesson(), UserType.STUDENT);
        modelMap.addAttribute("lesson", lessonService.findByTeacher(springUser.getUser()));
        modelMap.addAttribute("students", allByLessonId);
        return "teacherHome";
    }


}
