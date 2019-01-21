package mesquita.springframework.utils;

import mesquita.springframework.model.User;
import mesquita.springframework.security.dto.JUserDTO;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author augusto
 */
public class JConvertToDtoUtil {

    public static JUserDTO convertUser(User user) {
        return new JUserDTO(user.getName(), user.getEmail(), user.getPhotoUrl());
    }
}
