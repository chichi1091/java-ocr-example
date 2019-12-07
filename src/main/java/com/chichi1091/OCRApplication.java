package com.chichi1091;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.nio.file.Paths;

public class OCRApplication {
    public static void main(String[] args) {
        try {
//            final String path = "src/main/resources/images/sample2.png";
            final String path = "src/main/resources/pdf/sample2.pdf";
            File imageFile = Paths.get(path).toFile();

            ITesseract instance = new Tesseract();
            final String tessdataPath = "src/main/resources/tessdata";
            instance.setDatapath(Paths.get(tessdataPath).toAbsolutePath().toString());
//            instance.setLanguage("jpn");        // 横書き
            instance.setLanguage("jpn_vert");   // 縦書き

            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch(TesseractException ex) {
            ex.printStackTrace();
        }
    }
}
