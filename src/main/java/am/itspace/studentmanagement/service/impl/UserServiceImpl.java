package am.itspace.studentmanagement.service.impl;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserType;
import am.itspace.studentmanagement.repository.UserRepository;
import am.itspace.studentmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${picture.directory}")
    private String pictureDirectory;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public void save(User user, MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String picName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            File file = new File(pictureDirectory, picName);
            multipartFile.transferTo(file);
            user.setPicName(picName);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    @Override
    public List<User> findAllByLessonAndUserType(Lesson lesson, UserType userType) {
        return userRepository.findAllByLessonAndUserType(lesson, userType);
    }


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


}
