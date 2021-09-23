/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author lixia
 */
public class Validator {
    
    public Validator() {}
    
    public boolean onlyNumber (String ageTrimmed) {
        char[] ageArray = ageTrimmed.toCharArray();
        for (char letter : ageArray) {
            if (! Character.isDigit(letter)) {
                return false;
            }
        }
        return true;
    }
}
