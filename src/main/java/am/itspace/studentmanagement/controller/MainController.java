package am.itspace.studentmanagement.controller;

import am.itspace.studentmanagement.entity.UserType;
import am.itspace.studentmanagement.security.SpringUser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class MainController {

    @Value("${picture.directory}")
    private String pictureDirectory;

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal SpringUser springUser) {
        if (springUser.getUser().getUserType() == UserType.TEACHER) {
            return "redirect:/teacher/home";
        } else {
            return "redirect:/student/home";
        }
    }

    @GetMapping("/register")
    public String registerPage(@RequestParam(value = "msg", required = false) String msg, ModelMap modelMap) {
        if (msg != null) {
            modelMap.addAttribute("msg", msg);
        }
        return "register";
    }

    @GetMapping("/downloadImage")
    public @ResponseBody byte[] getImage(@RequestParam("picName") String picName) throws IOException {
        File file = new File(pictureDirectory, picName);
        if (file.exists()) {
            return IOUtils.toByteArray(new FileInputStream(file));
        }
        return null;
    }

}
