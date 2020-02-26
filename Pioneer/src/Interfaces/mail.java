/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;




/**
 *
 * @author alaka
 */
public class mail {
    public static void sendMail(String recepient, String Body) throws Exception{
        
            System.err.println("ekteb message");
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.transport.protocol", "smtp");
            properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
            
       //     String myAccountEmail = "fadhel.shel@gmail.com";
         //   String password = "alfadhel321";
           String myAccountEmail = "myriammnasser@gmail.com";
           String password = "Meriem29";
            
           Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myAccountEmail, password);
                }
                
            });
            Message message = prepareMessage(session,myAccountEmail,recepient);

            Transport.send(message);
            System.err.println("Message envoyé");
        
    }         

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(myAccountEmail));
            message.setSubject("hello");
            message.setText("bonjour tt le monde");
            return message;
            
            
        } catch (Exception ex) {
            Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null; 
    }
       
}
