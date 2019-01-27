/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.irona;

//import java.awt.Container;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static my.irona.IronaUI.recording;

import oracle.jrockit.jfr.Recording;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Durgesh
 */


public class GlobalKeyListenerExample extends Thread implements NativeKeyListener {
 FileWriter fw = null;
 BufferedWriter bw = null;
PrintWriter out = null;

    public void run(){
        listenKeys();
    }
    public void listenKeys(){
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
    }
   public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    
        if(recording ==1){
            try {
                //exception handling left as an exercise for the reader
                fw = new FileWriter(IronaUI.keypath,true);
                
            } catch (IOException ex) {
                Logger.getLogger(GlobalKeyListenerExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            //out.println(e.getKeyText(e.getKeyCode())); --------------------------------------------
            out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            out.close();
        }
        else{
            
             if(out != null)
                 out.close();
            try {
                if(bw != null)
                bw.close();
            } catch (IOException ex) {
            //exception handling left as an exercise for the reader
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException ex) {
                //exception handling left as an exercise for the reader
            }
        
        }   
    
        
        
        

        if (NativeKeyEvent.VC_ESCAPE == e.getKeyCode()) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(GlobalKeyListenerExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    if(recording ==1){
            try {
                //exception handling left as an exercise for the reader
                fw = new FileWriter(IronaUI.keypath,true);
                
            } catch (IOException ex) {
                Logger.getLogger(GlobalKeyListenerExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            //out.println(e.getKeyText(e.getKeyCode())); --------------------------------------------
            out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            out.close();
        }
        else{
            
             if(out != null)
                 out.close();
            try {
                if(bw != null)
                bw.close();
            } catch (IOException ex) {
            //exception handling left as an exercise for the reader
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException ex) {
                //exception handling left as an exercise for the reader
            }
        
        }   
        
    
    
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
   
         if(recording ==1){
            try {
                //exception handling left as an exercise for the reader
                fw = new FileWriter(IronaUI.keypath,true);
                
            } catch (IOException ex) {
                Logger.getLogger(GlobalKeyListenerExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            //out.println(e.getKeyText(e.getKeyCode())); --------------------------------------------
            out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            out.close();
        }
        else{
            
             if(out != null)
                 out.close();
            try {
                if(bw != null)
                bw.close();
            } catch (IOException ex) {
            //exception handling left as an exercise for the reader
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException ex) {
                //exception handling left as an exercise for the reader
            }
        
        }   
        
   
        
        
        
        
        
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
    }
}