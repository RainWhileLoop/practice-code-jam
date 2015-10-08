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
        for (int i = 0; i < text.length(); i++) {
            try {
                String current = T9Spelling.valueOf(text.charAt(i));
                if (i == 0) {
                    builder.append(current);
                } else {
                    String previous = String.valueOf(builder.charAt(builder.length() - 1));
                    if (isSameButton(current, previous)) {
                        builder.append(" ");
                    }
                    builder.append(current);
                }
            } catch (IndexOutOfBoundsException ex) {

            }
        }
        return builder.toString();
    }

    private boolean isSameButton(String newText, String previousText) {
        return newText.contains(previousText) || previousText.contains(newText);
    }

}
