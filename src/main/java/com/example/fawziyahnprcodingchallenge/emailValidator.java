package com.example.fawziyahnprcodingchallenge;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.ArrayList;
/*
FAWZIYAH ALEBIOSU
This algorithm takes in a file with text. Goes through all of it and determines ife ach line item is a valid email address
Next, it sorts all the valid email addresses by domains. Finally, it prints the sorted version of the emails to the input file at the bottom
*/
public class emailValidator 

{
    public HashMap<String, String> allEmails;
    private  String path = new String();
   
    public emailValidator(String path){
        setPath(path);;
        this.allEmails = new HashMap<>();
      
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }

    public void parseFileForInput(emailValidator sortingObject){
        // grabs every item in the input file until it sees the end text
        File fileObj;
    try {
        fileObj = new File(sortingObject.getPath());
        Scanner scannerObj = new Scanner(fileObj);
        
        while(scannerObj.hasNextLine()){
            String currentEmail = scannerObj.nextLine();

            //for each email, call validate method on it
            if(isEmailValid(currentEmail) && !currentEmail.equals("end")){
                String domainEnding = extractEmailEnding(currentEmail);
                sortingObject.allEmails.put(currentEmail, domainEnding);

            }
            else if(currentEmail.equals("end")){
                scannerObj.close();
                break;
            }
        }
        scannerObj.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
    
    
    public static String extractEmailEnding(String emailAddress){
        String result = "";
        for(int i = 0; i < emailAddress.length();i++){
            if(emailAddress.charAt(i) == '@'){
                result= emailAddress.substring(i+1, emailAddress.length());
                return result;
            }
        }
        return result;
    }
    
    public static boolean isEmailValid(String emailAddress){
        //only 1 @ symbol
        boolean seenAnAtSignBefore = false;
        for(int i = 0; i < emailAddress.length();i++){
            if(emailAddress.charAt(i) == '@' && seenAnAtSignBefore == true){
                return false;
            }
            else if(emailAddress.charAt(i) == '@'&& seenAnAtSignBefore != true){
                seenAnAtSignBefore = true;
            }
            else if(emailAddress.charAt(i) == '"'){
                //only need to check for 1 quotation mark
                return false;
            }
        }
        if(seenAnAtSignBefore== false){
            return false;
        }

        return true;
    }
    public static void returnSortedOutput(List<String> emailEndings, emailValidator sortingObj){

        File log = new File(sortingObj.getPath());
        try{
        if(log.length()== 0){
            System.err.println("input file is empty");
           
        }
        else{
        PrintWriter out = new PrintWriter(new FileWriter(log, true));
        
        out.append(".............sorted and validated emails after this..........." + "\n");
        for(String email: emailEndings){
            for (Entry<String, String> entry : sortingObj.allEmails.entrySet()) {
                if (entry.getValue().equals(email)) {
                    out.append(entry.getKey()+ "\n");
        }
    }
}
        out.close();
}
        }
        catch(IOException e){
            System.err.println("COULD NOT LOG!!");
        }
    }
    public static void run(emailValidator sortingObject){
        sortingObject.parseFileForInput(sortingObject);
        List<String> emailEndings = new ArrayList<String>(sortingObject.allEmails.values());
        Collections.sort(emailEndings);
        returnSortedOutput(emailEndings, sortingObject);

    }
   
}
