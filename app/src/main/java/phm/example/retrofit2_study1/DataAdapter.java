package phm.example.retrofit2_study1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Card> film;
    private String num;
    private Context context;

    public DataAdapter mAdapter;

    public DataAdapter(Context context, ArrayList<Card> film) {
        this.film = film;
        this.context = context;

    }

    public void onClickName(int position) {
        Card item = film.get(position);

        Intent intent = new Intent(context, ClickActivity.class);
        intent.putExtra("title", item.getName());
        intent.putExtra("director", item.getArtistName());
        intent.putExtra("release_date", item.getText());

        intent.putExtra("description", item.getName());
        intent.putExtra("producer", item.getArtistName());
        intent.putExtra("rt_score", item.getText());

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
        viewHolder.tv_title.setText(num+film.get(i).getName());
        viewHolder.tv_director.setText(film.get(i).getArtistName());
        viewHolder.tv_release_date.setText(film.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return film.size();
    }
////
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_title,tv_director,tv_release_date;
        private CardView cardView;
        public ViewHolder(View view,DataAdapter recyclerViewAdapter) {
            super(view);
            mAdapter=recyclerViewAdapter;
            tv_title = (TextView)view.findViewById(R.id.tv_title);
            tv_director = (TextView)view.findViewById(R.id.tv_director);
            tv_release_date = (TextView)view.findViewById(R.id.tv_release_date);

            cardView=(CardView)view.findViewById(R.id.card);

            cardView.setOnClickListener(this);

        }
        public void onClick(View view) {
            int position = getAdapterPosition();
            mAdapter.onClickName(position);
        }
    }

}