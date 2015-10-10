package com.rwl.codejam.t9spelling.algorithm;

import com.rwl.codejam.t9spelling.model.T9Spelling;
import com.rwl.codejam.utils.FileReaderCallback;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author rainwhileloop
 */
public class Speller implements FileReaderCallback {

    @Override
    public void doing(BufferedReader br) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        System.out.println("Total test case : " + testCase);
        String input, output;
        int minimalFormatRange = 20;
        int i = 1;
        while ((input = br.readLine()) != null) {

            output = pressButtonFollowText(input);
            System.out.printf("%3d -> %" + (minimalFormatRange - input.length()) + "s|%" + input.length() + "s| : %s\n",
                    i++,
                    "",
                    input,
                    output);
        }
    }

    public String pressButtonFollowText(String text) {
        StringBuilder builder = new StringBuilder();
        Character lastButtonPress = null;
        for (int i = 0; i < text.length(); i++) {
            String current = T9Spelling.valueOf(text.charAt(i));
            if (i == 0) {
                builder.append(current);
            } else {
                if (isSameButton(getLastCharacter(current), lastButtonPress)) {
                    builder.append(" ");
                }
                builder.append(current);
            }
            lastButtonPress = builder.charAt(builder.length() - 1);
        }
        return builder.toString();
    }

    private boolean isSameButton(char newBottonPress, char lastButtonPress) {
        return newBottonPress == lastButtonPress;
    }

    private Character getLastCharacter(String text){
        if(text != null && !text.isEmpty()){
            return text.charAt(text.length() - 1);
        }
        return null;
    }
}
