package phm.example.retrofit2_study1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Card> card;
    private String num;
    private Context context;
    private Uri uri;

    public DataAdapter mAdapter;

    public DataAdapter(Context context, ArrayList<Card> card) {
        this.card = card;
        this.context = context;

    }

    public void onClickName(int position) {
        Card item = card.get(position);

        Intent intent = new Intent(context, ClickActivity.class);
        intent.putExtra("name", item.getName());
        intent.putExtra("text", item.getText());
        intent.putExtra("img", item.getImage());

        context.startActivity(intent);

    }


    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);

        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        num=(i+1)+". ";
        viewHolder.Rname.setText(num+card.get(i).getName());
        Glide.with(context).load(Uri.parse(card.get(i).getCropImage())).into(viewHolder.RCImg);

    }

    @Override
    public int getItemCount() {
        return card.size();
    }
////
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView Rname;
        private ImageView RCImg;
        private CardView cardView;

        public ViewHolder(View view,DataAdapter recyclerViewAdapter) {
            super(view);
            mAdapter=recyclerViewAdapter;

            Rname = (TextView)view.findViewById(R.id.RcardName);
            RCImg=(ImageView)view.findViewById(R.id.RcardCropImg);

            cardView=(CardView)view.findViewById(R.id.card);
            cardView.setOnClickListener(this);

        }
        public void onClick(View view) {
            int position = getAdapterPosition();
            mAdapter.onClickName(position);
        }
    }

}