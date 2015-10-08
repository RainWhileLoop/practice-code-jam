package com.rwl.codejam.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rainwhileloop
 */
public class FileReaderUtils {

    public static void read(String pathFile, FileReaderCallback callback) {
        BufferedReader br = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(pathFile);
            br = new BufferedReader(fileReader);
            callback.doing(br);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileReaderUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
