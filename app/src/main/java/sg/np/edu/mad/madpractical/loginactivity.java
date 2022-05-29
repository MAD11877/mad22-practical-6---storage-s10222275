package sg.np.edu.mad.madpractical;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class loginactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://madpractical-c57ec-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Users");

        EditText Username = findViewById(R.id.GetName);
        EditText Password = findViewById(R.id.GetPassword);


        // Reading the number of messages in the database (path: messages/testing)
        ((Button)findViewById(R.id.buttonLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                Log.e("Onclick","ture");
                myRef.child("mad").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get data from data base
                        String correctpassword = dataSnapshot.child("password").getValue().toString();
                        String correctusername = dataSnapshot.child("username").getValue().toString();
                        Log.e("username",correctusername);
                        if(username.equals(correctusername) &  password.equals(correctpassword)){
                            Intent gotoact = new Intent(loginactivity.this, ListActivity.class);
                            startActivity(gotoact);

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });
            }
        });
    }
}