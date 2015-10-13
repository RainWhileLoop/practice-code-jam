package com.rwl.codejam.t9spelling.algorithm;

import com.rwl.codejam.t9spelling.model.T9Spelling;
import com.rwl.codejam.utils.ProcessorCallback;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author rainwhileloop
 */
public class Speller implements ProcessorCallback {

    private int caseNo = 1;

    public String pressButtonFollowText(String text) {
        StringBuilder builder = new StringBuilder();
        Character lastButtonPress = null;
        for (int i = 0; i < text.length(); i++) {
            String current = T9Spelling.valueOf(text.charAt(i));
            if (current.isEmpty()) {
                continue;
            }
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

    private Character getLastCharacter(String text) {
        if (text != null && !text.isEmpty()) {
            return text.charAt(text.length() - 1);
        }
        return null;
    }

    @Override
    public String process(String input) {
        String output;
        int minimalFormatRange = 20;

        output = pressButtonFollowText(input);
        if (!output.isEmpty()) {
            System.out.printf("%3d -> %" + (minimalFormatRange - input.length()) + "s|%" + input.length() + "s| : %s\n",
                    caseNo++,
                    "",
                    input,
                    output);
        }
        return output;

    }

    @Override
    public String process(char input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
