package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
    

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");

        // sending data to view
        model.addAttribute("name","Rajeev Ranjan Private Limited");
        model.addAttribute("YoutubeChannel", "Learn Code with Rajeev");
        model.addAttribute("GithubRepo", "https://github.com/rajeevkr45");
        return "home";
    }

    //about route
    @RequestMapping("/about")
    public String  aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("About page loading");
        return "about";
    }

    //services route
    @RequestMapping("/services")
    public String  servicesPage(){
        System.out.println("services page loading");
        return "services";
    }


    
    //this is login page
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }
    
    //contact page
    @GetMapping("/contact")
    public String contact(){
        return new String("contact");
    }

    //this is registation controller-view
    //regrister page
    @GetMapping("/register")
    public String register(Model model){

        UserForm userForm = new UserForm();
        //default date bhi send kar sakte h
        // userForm.setName("Rajeev");
        // userForm.setAbout("This is about : Write somethig about yourself");
        model.addAttribute("userForm", userForm);
        return "register";
    }


    //processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("Processing registration");
        //fetch form data
        //userForm
        System.out.println(userForm);

        //validate from data
        if(rBindingResult.hasErrors()){
            return "register";
        }


        //save to database
        //userservice
        //userForm --> User mapper
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("@{'/images/profileImage.avif'}")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic("/images/profileImage.avif");

        
       User savedUser = userService.saveUser(user);

       System.out.println("User saved");
       System.out.println(savedUser);
        //message = "Registartion successfull"
        //add the message
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);
        //redirect to login page
        return "redirect:/register";
    }
}
