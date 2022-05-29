package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBhandler db = new DBhandler(MainActivity.this);


        Intent receivingEnd = getIntent();
        User u7 = (User) receivingEnd.getSerializableExtra("User");
        User u1 =db.getUsers().get(u7.getId());

        TextView v = findViewById(R.id.textView2);
        TextView username = findViewById(R.id.username);

        v.setText("Description "+u1.getDescription());
        username.setText("Name"+u1.getName());
        Button button = findViewById(R.id.button6);
        Button Msgbutton = findViewById(R.id.button5);
        Log.e( "OnClick: ", String.valueOf(u1.getFollowed()));
        if (u1.getFollowed() == false) {
            button.setText("Follow");
        } else {
            button.setText("Unfollow");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u2 = new User();


                u2=OnClick(button,u1);//Changes status of button
                Log.e("Uid",Integer.toString(u2.getId()));
                Boolean state1 = u1.getFollowed();
                Boolean state2 = u2.getFollowed();
                User u3 =db.getUsers().get(0);
                Boolean state3 = u3.getFollowed();

                db.onUpdate(u2);
                String status="";
                if (u2.getFollowed() == false) {
                    status="Unfollowed";
                } else {
                    status="Followed";
                }
                Toast toast=Toast.makeText(getApplicationContext(),status,Toast.LENGTH_SHORT);
                toast.show();

            }
        });
        Msgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MessageGroup = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(MessageGroup);

            }
        });
        Log.e( "OnClick:end ", String.valueOf(u1.getFollowed()));
    }
    public User OnClick(Button button,User u1){

        boolean followstatus = u1.getFollowed();
        if (followstatus == false) {
            button.setText("Unfollow");
            u1.setFollowed(true);
        } else {
            button.setText("Follow");
            u1.setFollowed(false);
        }

        return u1;
    }


}