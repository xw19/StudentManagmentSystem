/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import java.security.MessageDigest;

/**
 *
 * @author sourav
 */
public class Authenticate {
    public static String hashit(String password) {
        String hashed = null;
        //String salt = "brjejjqnjnjnnnjnnnannnkna  bjbjewbnkwfkwn72y83y5u$$$$^";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] byt = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < byt.length; i++) {
                sb.append(Integer.toString((byt[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashed = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashed;
    }
}
