package com.example.librarysystem.usecases;

import com.example.librarysystem.adapters.dtos.UserDTO;
import com.example.librarysystem.domain.user.User;
import com.example.librarysystem.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

//    public void validateLoan(User user) throws Exception{
//
//        if(user.getBorrowedBooksAmount() == 0){
//            throw new Exception("Você não tem livros para devolver");
//        }
//
//        if(user.getBorrowedBooksAmount() == 3){
//            throw new Exception("Seu limite é 3 livros por vez");
//        }
//
//    }

    public void saveUser(User user){
        this.repository.save(user);
    }


    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new ExpressionException("Usuário não encontrado"));
    }

}
