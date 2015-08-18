package cn.sluk3r.extractComments;

import cn.sluk3r.extractComments.scan.FileScan;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by wangxichun on 2015/8/18.
 */
public class Main {
    FileScan fileScan;

    public Main() {
        fileScan = new FileScan();
        fileScan.setDeleteCommentPrefix(true);
    }


    public static void main(String[] args) throws IOException {
        String recordFilePath = args[0];
        String parentPath = args[1];

        Main main = new Main();
        main.driver(recordFilePath, parentPath);
    }

    public void driver(String recordFilePath, String parentPath) throws IOException {
        FileReader reader = new FileReader(new File(recordFilePath));
        BufferedReader lineReader = new BufferedReader(reader);

        String filePath = null;
        while((filePath = lineReader.readLine()) != null ) {
            File srcFile = new File(filePath);
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(processSingleFile(srcFile, parentPath) + "\n\n");
        }
    }


    private String processSingleFile(File file, String parentPath) throws IOException {
        fileScan.addPatterns(Pattern.compile("//wxc (.*)"));

        List<String> comments = fileScan.extractComments(file);

        String filePath = file.getAbsolutePath();
        StringBuilder content = new StringBuilder(filePath.replace(parentPath, "") + "\n");

        int i = 1;
        for(String c: comments) {
            content.append(String.format("%s. %s\n", i++, c));
        }
        return content.toString();
    }
}
