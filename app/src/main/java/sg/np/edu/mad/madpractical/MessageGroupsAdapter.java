package sg.np.edu.mad.madpractical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageGroupsAdapter extends RecyclerView.Adapter<MessageGroupViewHolder> {
    ArrayList<User> Ulist;
    Context c ;
    public MessageGroupsAdapter(ArrayList<User> Data, Context v){
        this.Ulist=Data;
        this.c=v;



    }
        @Override
    public int getItemViewType(int position){
        User u1 = Ulist.get(position);

        String name= u1.getName();
        int indicator = 1;

        if(Integer.valueOf(name.substring(name.length() - 1))==7){
            indicator=0;


        }

        return indicator;//ternary operation, if position%5==0 return 0, else return 1
    }
    @NonNull
    @Override
    public MessageGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if(viewType==1)
        item=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.groupmessagelayout,null,false);
        else
            item=LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.groupmessagelayout2,parent,false);


        return new MessageGroupViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageGroupViewHolder holder, int position) {
        User content=Ulist.get(position);
        holder.name.setText("Name"+content.getName());
        holder.desc.setText("Description "+content.getDescription());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(c);


                builder.setTitle("Profile");
                builder.setMessage("Name"+content.getName());
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent MainActivity  = new Intent(c,MainActivity.class);
                        MainActivity.putExtra("User",content);

                        c.startActivity(MainActivity);


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                builder.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return Ulist.size();
    }
}
