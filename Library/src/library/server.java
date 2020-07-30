/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author HP
 */
public class server{
    static Socket s;
    static ServerSocket ss;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message="10";
    static boolean status=false;

 
    public void doInBackground() throws InterruptedException {
     
       try
        {
            ss=new ServerSocket(5000);
            while(true && status)
            {
                s=ss.accept();
                isr=new InputStreamReader(s.getInputStream());
                br=new BufferedReader(isr);
                //System.out.println("message:"+message);
                message=br.readLine();
                //message="100";
                break;
               
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
    }