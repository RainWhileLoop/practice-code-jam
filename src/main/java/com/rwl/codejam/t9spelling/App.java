package com.rwl.codejam.t9spelling;

import com.rwl.codejam.t9spelling.algorithm.Speller;
import com.rwl.codejam.utils.FileReaderUtils;

/**
 *
 * @author rainwhileloop
 */
public class App {

    public static void main(String[] args) {
        String path = "src/main/resources/C-small-practice.in";
        FileReaderUtils.read(path, new Speller());
    }
}
