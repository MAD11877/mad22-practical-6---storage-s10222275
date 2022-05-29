package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Button group1 = findViewById(R.id.button2);
        Button group2 = findViewById(R.id.button3);
        group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                fts.replace(R.id.fragment, new group() );
                fts.commit();

            }
        });
        group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
                fts.replace(R.id.fragment, new Group2() );
                fts.commit();

            }
        });
    }



}



