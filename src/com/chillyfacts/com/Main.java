package com.chillyfacts.com;


import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String input_file="C:\\TestTesseract\\OcrNfe.png";
        String output_file="C:\\TestTesseract\\OcrNfe.Output";
        String tesseract_install_path="C:\\Users\\Ramon.Silva\\Documents\\OCR\\tesseract-ocr-setup-3.02.02\\tesseract";
        String[] command =
                {
                        "cmd",
                };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\"");
            stdin.close();
            p.waitFor();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(ReadFile.read_a_file(output_file+".txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
