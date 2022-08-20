package com.bakulic.onlineherbarium.controller.UserManagement;

import com.bakulic.onlineherbarium.model.Image;
import com.bakulic.onlineherbarium.model.UserList;
import com.bakulic.onlineherbarium.model.dto.RegisterUserAccountDTO;
import com.bakulic.onlineherbarium.service.ImageService;
import com.bakulic.onlineherbarium.service.UserListService;
import com.bakulic.onlineherbarium.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private final UserServiceImpl userService;

    @Autowired
    private final ImageService imageService;

    @Autowired
    private final UserListService userListService;


    @ModelAttribute("newUser")
    public RegisterUserAccountDTO registerUserAccountDTO(){return new RegisterUserAccountDTO();}

    @GetMapping
    public String getCreateUserForm(Model model){
        RegisterUserAccountDTO newUser = new RegisterUserAccountDTO();
        model.addAttribute("user", newUser);
        return "create-user";
    }

    @PostMapping
    public String savCreateUserForm (@ModelAttribute("newUser") RegisterUserAccountDTO registerUserAccountDTO) {
        userService.register(registerUserAccountDTO);
        return "redirect:user/all";
    }


    @GetMapping("/all")
    public String getUserList(Model model) {
        var list = userService.getAllUsers();
        model.addAttribute("users",list);
        return "all-users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
//        List<Image> allImageList = imageService.getAllImages();
//        Collection<Image> imageList = imageService.getAllImagesByUser(id);
//
//        allImageList.removeAll(imageList);
//
//        List<UserList> allIUserLists = userListService.getAllUserLists();
//        Collection<UserList> userLists = userListService.getAllListsByUser(id);
//
//        allIUserLists.removeAll(userLists);

        userService.getUserRepository().deleteById(id);
        return "redirect:/user/all";
    }

}
