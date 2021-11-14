package com.example.mysecuredchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class MainActivity<DatabaseReference> extends AppCompatActivity {

    private EditText editText;
    private ListView listView;

    //private DatabaseReference databaseReference = (DatabaseReference) FirebaseDatabase.getInstance().getReference("Message");   //Linking to the root
    private DatabaseReference databaseReference;


    private String StringMessage;
    private byte encrptionKey[] = {9, 115, 51, 86, 105, 4, -31, -23, -68, 88, 17, 20, 3, -105, 119, -53};
    private Cipher cipher,decipher;
    private SecretKey secretKeyspec;
    private EditText message; //Object link
    private ListView chat;
    private SecretKeySpec key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.editTextTextMultiLine3);
        chat = findViewById(R.id.ListView);

        databaseReference = (DatabaseReference) FirebaseDatabase.getInstance().getReference("Message");

        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        try {
            decipher = cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        key = new SecretKeySpec(encrptionKey, "AES");

        databaseReference.
    }
    public abstract void sendButton(View view);
    {

    }
}