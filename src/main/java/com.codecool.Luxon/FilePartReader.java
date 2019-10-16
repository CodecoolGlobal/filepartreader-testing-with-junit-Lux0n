package com.codecool.Luxon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(){

    }

    public void setup(String filePath, int fromLine, int toLine){
        if(toLine <  fromLine || fromLine < 1){
            throw new IllegalArgumentException("no good argument");
        }
        else{
            this.filePath = filePath;
            this.fromLine = fromLine - 1;
            this.toLine = toLine - 1;
        }
    }

    public String read(){
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }

    public String readLines(){
        String[] splitText = read().split("\n");
        int i = 0;
        String content = "";
        for(String line: splitText){
            if(i >= fromLine && i <= toLine){
                content += line + "\n";
            }
            i++;
        }
        return content;
    }
}
