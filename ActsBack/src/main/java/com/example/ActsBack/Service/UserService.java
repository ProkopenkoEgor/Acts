package com.example.ActsBack.Service;

import com.example.ActsBack.Exceptions.AppException;
import com.example.ActsBack.mapper.UserMapper;
import com.example.ActsBack.Model.DTO.CredentialsDto;
import com.example.ActsBack.Model.DTO.SignUpDto;
import com.example.ActsBack.Model.DTO.UserDto;
import com.example.ActsBack.Model.UserModel;
import com.example.ActsBack.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        UserModel user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new AppException("Пользователь не найден", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Неверный пароль", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<UserModel> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Такой логин уже занят", HttpStatus.BAD_REQUEST);
        }

        UserModel user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        UserModel savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        UserModel user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Неизвестный пользователь", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
