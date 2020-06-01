package phm.example.retrofit2_study1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClickActivity extends AppCompatActivity {
    private TextView c_title,c_director,c_release_date,c_description,c_producer,c_rt_score;
    private String title,director,release_date,description,producer,rt_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        director=intent.getStringExtra("director");
        release_date="("+intent.getStringExtra("release_date")+")";
        description = intent.getStringExtra("description");
        producer=intent.getStringExtra("producer");
        rt_score="★"+intent.getStringExtra("rt_score");

        c_title=(TextView)findViewById(R.id.c_title);
        c_director=(TextView)findViewById(R.id.c_director);
        c_release_date=(TextView)findViewById(R.id.c_release_date);
        c_description=(TextView)findViewById(R.id.c_description);
        c_producer=(TextView)findViewById(R.id.c_producer);
        c_rt_score=(TextView)findViewById(R.id.c_rt_score);

        c_title.setText(title);
        c_director.setText(director);
        c_release_date.setText(release_date);
        c_description.setText(description);
        c_producer.setText(producer);
        c_rt_score.setText(rt_score);

        Log.d("타이틀", release_date);


    }
}
