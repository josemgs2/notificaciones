package com.example.mascotasfavoritas2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    Button btComentario;
    EditText etContactoNombre;
    EditText etContactoCorreo;
    EditText etContactoComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Incluimos toolbar con posibilidad de subir a activity padre
        Toolbar miActionBar = (Toolbar) findViewById(R.id.contactoActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtenemos elementos de la vista que necesitaremos
        btComentario = (Button) findViewById(R.id.btComentario);
        etContactoNombre = findViewById(R.id.etContactoNombre);
        etContactoCorreo = findViewById(R.id.etContactoCorreo);
        etContactoComentario = findViewById(R.id.etContactoComentario);

        btComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Comprobamos que no haya ningún campo vacío
                if (!etContactoNombre.getText().toString().isEmpty() && !etContactoCorreo.getText().toString().isEmpty() &&
                        !etContactoComentario.getText().toString().isEmpty()) {

                    // Creamos el texto del asunto del correo
                    StringBuilder asunto = new StringBuilder("Petagram - Mensaje de usuario " + etContactoNombre.getText().toString() +
                            " <" + etContactoCorreo.getText().toString() + ">");

                    // Llamamos a la clase interna EnviaMailAsincrono, encargada de enviar el correo en segundo plano
                    new EnviaMailAsincrono().execute(new String[]{asunto.toString(), etContactoComentario.getText().toString()});

                } else {
                    // No se puede enviar porque no están todos los campos introducidos
                    Toast.makeText(Contacto.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    // Clase para enviar el mensaje con JavaMail como tarea en segundo plano
    private class EnviaMailAsincrono extends AsyncTask<String[], Void, String> {

        @Override
        protected void onPreExecute() {
            // Informamos al usuario que se está enviando el mensaje
            Toast.makeText(Contacto.this, "Enviando mensaje...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(String[]... strings) {

            String asunto = strings[0][0];
            String mensaje = strings[0][1];

            try {

                // Creación y configuración clase Session
                Properties props = new Properties();

                // Nombre del host del correo, smtp.gmail.com
                props.setProperty("mail.smtp.host", "smtp.gmail.com");

                // TLS si está disponible
                props.setProperty("mail.smtp.starttls.enable", "true");

                // Puerto de gmail para envío de correos
                props.setProperty("mail.smtp.port", "587");

                // Nombre del usuario
                // TODO indicar aquí el nombre de usuario de la cuenta de correo desde la que se enviará el correo. Dirección de correo de gmail.
                props.setProperty("mail.smtp.user", "usuario@gmail.com");


                // Se requiere usuario y password para conectar
                props.setProperty("mail.smtp.auth", "true");

                // Obtenemos la instancia de Session con este Properties
                Session session = Session.getDefaultInstance(props);

                // Información extra, se puede comentar una vez funcione
                // session.setDebug(true);
                // Fin creación y configuración clase Session

                // Construcción mensaje

                // Instanciamos clase MimeMessage para pasar datos
                MimeMessage message = new MimeMessage(session);

                // Indicamos el remitente del correo (FROM)
                // Se comenta porque Gmail no utiliza este from en el encabezado, lo cambia por el de la cuenta utilizada para conectar con el servidor
                // message.setFrom(new InternetAddress("carles.garcia4@hotmail.com"));

                // Destinatario
                // El destinatario es el desarrollador, la opción se utiliza para enviar mensaje al desarrollador
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("carles.garcia4@hotmail.com"));

                // Subject
                message.setSubject(asunto);

                // Cuerpo del mensaje
                message.setText(mensaje);
                // Fin construcción mensaje

                // Envío mensaje

                // Obtenemos instancia de clase Transport con protocolo smtp
                Transport t = session.getTransport("smtp");

                // Establecemos conexión
                // TODO Introducir aquí usuario y password de Gmail
                t.connect("usuario@gmail.com", "password");

                // Enviamos mensaje
                t.sendMessage(message, message.getAllRecipients());

                // Cerramos la conexión
                t.close();
                // Fin envío mensaje

            } catch (AuthenticationFailedException auth) {
                Log.e("Petagram: ", "Error de autenticación: " + auth.getMessage());
                return "Error de autenticación";

            } catch (Exception e) {
                Log.e("Petagram: ", "Error al enviar el mensaje: " + e.getMessage());
                return "Mensaje no enviado, error inesperado";
            }

            return "Mensaje enviado";
        }

        @Override
        protected void onPostExecute(String resultado) {
            Toast.makeText(Contacto.this, resultado, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        Intent myintent;
        switch (id) {
            case R.id.mnSiguiente:
                myintent = new Intent(this, MascotasFavoritas.class);
                startActivity(myintent);
                return false;

            case R.id.AcercaDe:
                myintent = new Intent(this, AcercaDe.class);
                startActivity(myintent);
                return false;

            case R.id.Contacto:
                myintent = new Intent(this, Contacto.class);
                startActivity(myintent);
                return false;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
