package com.scm.helpers;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    @Value("${server.baseUrl}")
    private  String baseUrl;

    public static String getEmailOfLoggedInUser(Authentication authentication){

        // AuthenticationPrincipal principal = (AuthenticationPrincipal) authentication;

        //logic of find email after login with different credentials
        if(authentication instanceof OAuth2AuthenticationToken){

            var oauth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

            String clientId = oauth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User = (DefaultOAuth2User)authentication.getPrincipal();
            String username="";

            if(clientId.equalsIgnoreCase("google")){
                //If I login with google then write code to find email
                System.out.println("Getting email from google");
                username = oauth2User.getAttribute("email").toString();


            }else if(clientId.equalsIgnoreCase("github")){
                //If I login with github then write code to find email
                System.out.println("Getting email from github");
                username = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString() : oauth2User.getAttribute("login").toString()+"@gmail.com";


            }else{
                System.out.println("You are unathorized user");
            }
             
            return username;
        }
        else{
            //if I login with email and password then write code to find email
            System.out.println("Getting data from local database");
            return authentication.getName();
        }

    }

    public  String getLinkForEmailVerification(String emailToken){

        return this.baseUrl+"/auth/verify-email?token="+emailToken;
    }
}
