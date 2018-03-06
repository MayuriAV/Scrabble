package Model;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordList {

    //holds all the available words used for challenges and AI playing

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    final private ArrayList<String> wordList = new ArrayList<>();

    public WordList() {
        try{
             
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/entries?autoReconnect=true&useSSL=false","Vishnupriya","UmaRam");
                        pst=con.prepareStatement("select * from entries where word=?");
             
           }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }//end constructor

    public boolean challenge(String word) {
        try {
            pst.setString(1, word);
            
            rs=pst.executeQuery();
            if(rs.next())
            {
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
            // return wordList.stream().anyMatch((currentWord) -> (word.equalsIgnoreCase(currentWord)));
       
    }//end Challenge

    //return size of wordlist
    public int size() {
        return wordList.size();
    }//end size()

    //get word at index
    public String get(int index) {
        return wordList.get(index);
    }//end get()

    
    public void disp(String word)
    {
    //    System.out.println("WooHoo");
    }

} //end WordList
