package com.scm.validators;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
// import java.awt.image.*;
// import java.io.IOException;

// import javax.imageio.*;

public class FileValidator implements ConstraintValidator<ValidFile,MultipartFile> {

    private static final long MAX_FILE_SIZE  = 1024*1024*2; //2MB

   
    //file is coming or not
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
       
        if(file == null || file.isEmpty()){
            // context.disableDefaultConstraintViolation();
            // context.buildConstraintViolationWithTemplate("File cannot be empty").addConstraintViolation();
            return true;
        }

        //file size

        if(file.getSize()> MAX_FILE_SIZE){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File size should be less than 2 MB").addConstraintViolation();
            return false;
        }

        //resolution

        // try {
        //     BufferedImage bufferedImage = ImageIO.read(file.getInputStream());

        //     if(bufferedImage.getWidth()>500){

        //     }

        //     if(bufferedImage.getHeight()>500){

        //     }

        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


        return true;
    }

}
