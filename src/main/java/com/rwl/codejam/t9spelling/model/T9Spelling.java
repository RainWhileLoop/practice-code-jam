/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwl.codejam.t9spelling.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rainwhileloop
 */
public class T9Spelling {

    private static final Map<Character, String> button = new HashMap<>();

    static {
        button.put('A', "2");
        button.put('B', "22");
        button.put('C', "222");
        button.put('D', "3");
        button.put('E', "33");
        button.put('F', "333");
        button.put('G', "4");
        button.put('H', "44");
        button.put('I', "444");
        button.put('J', "5");
        button.put('K', "55");
        button.put('L', "555");
        button.put('M', "6");
        button.put('N', "66");
        button.put('O', "666");
        button.put('P', "7");
        button.put('Q', "77");
        button.put('R', "777");
        button.put('S', "7777");
        button.put('T', "8");
        button.put('U', "88");
        button.put('V', "888");
        button.put('W', "9");
        button.put('X', "99");
        button.put('Y', "999");
        button.put('Z', "9999");
        button.put(' ', "0");
    }

    public static String valueOf(char ch) {
        String output = button.get(Character.toUpperCase(ch));
        return output == null ? "" : output ;
    }
}
