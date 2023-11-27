package Backend;

// Import
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail {

    // It's much cool this way so why not
    // Check if the email is valid
    public Boolean mail(String email, String code) {
        String to = email.trim(); // to address. It can be any like gmail, hotmail etc.
        final String from = "gwnbankofficial@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "hfng wmyc uyhm ovvm"; // password for from mail address. 
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
        });
        
        try {
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Verify to create a GWN BANK account");
                
            // Email message

            
            String htmlCode = "<h3>To verify your email address, please use the following One Time Password (OTP):</h3><h4>Verification Code: " + code + "</h4><p>Do not share this OTP with anyone. GWN BANK takes your account security very seriously. GWN BANK Customer Service will never ask you to disclose or verify your GWN BANK password, OTP, credit card, or banking account number. If you receive a suspicious email with a link to update your account information, do not click on the link-instead, report the email to GWN BANK for investigation<br></p><br/>Thank you, <br/>GWN BANK Team";
            
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(htmlCode, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            
            message.setContent(multipart);
            
            Transport.send(message);
        
        } catch (MessagingException e) {
            Throwable cause = e.getCause();

            if (cause instanceof SendFailedException) {
                // Handle SendFailedException
                SendFailedException sendFailedException = (SendFailedException) cause;
                Address[] invalidAddresses = sendFailedException.getInvalidAddresses();

                if (invalidAddresses != null && invalidAddresses.length > 0) {
                    System.out.println("Invalid email address(es):");

                    for (Address invalidAddress : invalidAddresses) {
                        System.out.println(invalidAddress);
                    }
                } else {
                    System.out.println("Unknown send failure. Check the nested exceptions.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Unknown messaging exception. Check the nested exceptions.");
                e.printStackTrace();
            }
            
            return false;
        } 
        return true;
    }

    
    // Send an email after registration
    public Boolean registered(String email, String accountNumber, String accountPassword) {
        String to = email; // to address. It can be any like gmail, hotmail etc.
        final String from = "gwnbankofficial@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "hfng wmyc uyhm ovvm"; // password for from mail address. 
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
        });
        
        try {
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("You're all set with GWB BANK");

            String accNum = accountNumber;
            String accPass = accountPassword;
                
            String msg = "Please log in using your account number and account password see it below.<br><br>";
            String msgTwo = "Account Number: " + accNum + "<br>" + "Account Password: " + accPass + "<br><br>";
            String msgThree = "Thank you for signing up. As a registration bonus we gave you PHP 20,000 as thanks for trusting our application.<br><br>";
            String msgFour = "Thank you, <br>GWN BANK Team";  

            String fullMsg = msg + msgTwo + msgThree + msgFour;

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(fullMsg, "text/html");
                
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            
            Transport.send(message);
        
        } catch (MessagingException e) {
            Throwable cause = e.getCause();

            if (cause instanceof SendFailedException) {
                // Handle SendFailedException
                SendFailedException sendFailedException = (SendFailedException) cause;
                Address[] invalidAddresses = sendFailedException.getInvalidAddresses();

                if (invalidAddresses != null && invalidAddresses.length > 0) {
                    System.out.println("Invalid email address(es):");

                    for (Address invalidAddress : invalidAddresses) {
                        System.out.println(invalidAddress);
                    }
                } else {
                    System.out.println("Unknown send failure. Check the nested exceptions.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Unknown messaging exception. Check the nested exceptions.");
                e.printStackTrace();
            }
            
            return false;
        } 
        return true;
    }

    public Boolean sent(String email, String accountNumber, double ammount, String name, double bal) {
        String to = email; // to address. It can be any like gmail, hotmail etc.
        final String from = "gwnbankofficial@gmail.com@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "hfng wmyc uyhm ovvm";  // password for from mail address. 
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
        });
        
        try {
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Fund transfered");

            String accNum = accountNumber;
            double amm = ammount;
            String senderName = name;
            double newBalance = bal;
                
            String htmlCode = "<html>You have received PHP " + amm + " from " + senderName + " Your new balance is " + newBalance + "<br/><br/>You're in good hands with GWN BANK.<br/>Thank you,<br/>GWN BANK Team" + "</html>";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(htmlCode, "text/html");
                
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            
            Transport.send(message);
        
        } catch (MessagingException e) {
            System.out.println("Invalid Email Address");
            return false;
        } 
        return true;
    }

    public void forgotPass(String email, String userPassword, String accountNumber) {
        String to = email; // to address. It can be any like gmail, hotmail etc.
        final String from = "gwnbankofficial@gmail.com@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "hfng wmyc uyhm ovvm"; // password for from mail address. 
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
        });
        
        try {
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Forgot Password");
                
            String htmlCode = "<html><h3>A request has been recieved to change the password for you GWN BANK account.</h3><br/><br/>Your password is: " +  userPassword + "<br/><br/>Thank you,<br/>GWN BANK Team" + "</html>";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(htmlCode, "text/html");
                
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            
            Transport.send(message);
        
        } catch (MessagingException e) {
            System.out.println("Invalid Email Address");
        } 
    }
    
}
