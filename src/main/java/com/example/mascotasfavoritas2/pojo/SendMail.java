package com.example.mascotasfavoritas2.pojo;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail extends AsyncTask <Void, Void, Void>{


    @Override
    protected Void doInBackground(Void... voids) {

        String to = "cuenta.chorra@hotmail.com";
        String from = "cuenta.chorra@hotmail.com";
        String host = "smtp.office365.com";

        // create some properties and get the default Session
        Properties props = new Properties();
        props.put("mail.smtp.host", host);

        Session session = Session.getInstance(props, null);

        try {
            // create a message
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("JavaMail APIs Test");
            msg.setSentDate(new Date());
            // If the desired charset is known, you can use
            // setText(text, charset)
            msg.setText("Texto del mensaje");

            Transport.send(msg);
        } catch (MessagingException mex) {
            Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");

            mex.printStackTrace();
            Exception ex = mex;
            do {
                if (ex instanceof SendFailedException) {
                    SendFailedException sfex = (SendFailedException)ex;
                    Address[] invalid = sfex.getInvalidAddresses();
                    if (invalid != null) {
                        Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
                        for (int i = 0; i < invalid.length; i++) {
                            Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
                            Log.d("Mascotas: ", "         " + invalid[i]);
                        }
                    }
                    Address[] validUnsent = sfex.getValidUnsentAddresses();
                    if (validUnsent != null) {
                        Log.d("Mascotas: ", "    ** ValidUnsent Addresses");
                        for (int i = 0; i < validUnsent.length; i++)
                            Log.d("Mascotas: ", "         "+validUnsent[i]);
                    }
                    Address[] validSent = sfex.getValidSentAddresses();
                    if (validSent != null) {
                        Log.d("Mascotas: ", "    ** ValidSent Addresses");
                        for (int i = 0; i < validSent.length; i++)
                            Log.d("Mascotas: ", "         "+validSent[i]);
                    }
                }
                if (ex instanceof MessagingException)
                    ex = ((MessagingException)ex).getNextException();
                else
                    ex = null;
            } while (ex != null);
        }
        return null;
    }
}