package sg.np.edu.mad.madpractical;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MessageGroupViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView desc;
    View container;
    public MessageGroupViewHolder(View item){
        super(item);//Minimally required
        name=item.findViewById(R.id.Name);
        desc=item.findViewById(R.id.textView4);
        container=item.findViewById(R.id.imageView3);


    }
}
