package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.UserType;
import am.itspace.studentmanagement.security.SpringUser;
import am.itspace.studentmanagement.service.impl.LessonServiceImpl;
import am.itspace.studentmanagement.service.impl.MessageServiceImpl;
import am.itspace.studentmanagement.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final LessonServiceImpl lessonService;
    private final UserServiceImpl userService;
    private final MessageServiceImpl messageService;

    @GetMapping("/student/home")
    public String studentPage(@AuthenticationPrincipal SpringUser springUser, ModelMap modelMap) {
        modelMap.addAttribute("lessons", lessonService.findAll());
        Lesson lesson = springUser.getUser().getLesson();
        if (lesson != null) {
            modelMap.addAttribute("lesson", lessonService.findById(lesson.getId()));
        }

        modelMap.addAttribute("students", userService.findAllByLessonAndUserType(springUser.getUser().getLesson(), UserType.STUDENT));
        return "studentHome";
    }

    @GetMapping("/student/lesson/add/{id}")
    public String addLesson(@AuthenticationPrincipal SpringUser springUser, @PathVariable("id") int id) {
        Lesson lesson = lessonService.findById(id);
        springUser.getUser().setLesson(lesson);
        userService.saveUser(springUser.getUser());
        return "redirect:/student/home";
    }


}
