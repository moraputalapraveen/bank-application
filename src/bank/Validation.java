
package bank;

import javax.swing.*;
import java.sql.*;

public class Validation extends javax.swing.JFrame {
    
    boolean Valid(String name1, String surename1, String mobile1, String gender1,String password1,String cpassword1,String dob1, String mail1, String address1,boolean checkbox1)
    {
        if(name1.length()==0)
        {
            JOptionPane.showMessageDialog(this, "Name sholud not be empty");
            return false;
        }
        else if(surename1.length()==0)
        {
            JOptionPane.showMessageDialog(this,"Name sholud not be empty");
            return false;
        }
        else if(mobile1.length()!=10)
        {
            JOptionPane.showMessageDialog(this,"Phone Number is Incorrect");
            return false;
        }
        else if (gender1.equals("No selection"))
        {
           JOptionPane.showMessageDialog(this,"Please Select Gender");
           return false;
        }
         if(true)
        {
                char ch;
               int x=0,y=0,z=0,p=0;
               if(password1.length()>=8)
                   p=1;
                for(int i=0;i < password1.length();i++) 
                {
                    ch = password1.charAt(i);
                    if( Character.isDigit(ch))
                    {
                        x=1;
                    }
                    else if (Character.isUpperCase(ch)) 
                    {
                        y=1;
                    } else if (Character.isLowerCase(ch))
                    {
                        z=1;
                   }
                   
                }
                if(x==0 || y==0 || z==0 || p==0)
                {
                     JOptionPane.showMessageDialog(this,"Password  Should Contain \n *ALEAST 8 CHARACTERS \n *ATLEAST ONE CAPTITAL LETTER \n *ATLEAST ONE SMALL LETTER \n *ATLEAST ONE NUMBER");
                return false;
                }
        }
         if(!password1.equals(cpassword1))
        {
            JOptionPane.showMessageDialog(this,"password does not match");
            return false;
        }
         if(dob1.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"please enter Date Of Birth");
            return false;
        }
      
        if(true)
        {
            boolean ans = mail1.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
            if(!ans)
            {
                JOptionPane.showMessageDialog(this,"Please enter valid email address");
                return false;
            }
            Connection conn= DBconn.Dbconn();
            String a1="select mail from accountdetails where mail=?";
            try{
            PreparedStatement p1=conn.prepareStatement(a1);
            p1.setString(1,mail1);
            ResultSet rs=p1.executeQuery();
            if(rs.next())
            {
               JOptionPane.showMessageDialog(this,"This mail is already registerd"); 
               return false;
            }
            
            }catch(SQLException e)
            {
                System.out.println("error");
            }
        }
        if(address1.length()<7)
        {
        JOptionPane.showMessageDialog(this,"Address is too small");
        return false;
        }
        if(!checkbox1) {
           
                  JOptionPane.showMessageDialog(this, "agree terms and condition");
                  return false;
        }
               
        else
        return true;
        
        
    }}
            
    
    
    
    
