package com.rwl.codejam.t9spelling;

import com.rwl.codejam.t9spelling.algorithm.Speller;
import com.rwl.codejam.utils.FileReaderUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rainwhileloop
 */
public class App {

    public static void main(String[] args) {
        String path = "src/main/resources/C-small-practice.in";
        try {
            FileReaderUtils.readEachLine(path, new Speller());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
