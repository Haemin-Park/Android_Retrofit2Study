package phm.example.retrofit2_study1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ClickActivity extends AppCompatActivity {
    private TextView c_name, c_text;
    private String name, text, img;
    private ImageView c_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        text = intent.getStringExtra("text");
        img = intent.getStringExtra("img");

        c_name=(TextView)findViewById(R.id.cardName);
        c_text=(TextView)findViewById(R.id.cardText);
        c_img=(ImageView) findViewById(R.id.cardImg);

        c_name.setText(name);
        c_text.setText(Html.fromHtml(text));

        Glide.with(this).load(img).into(c_img);


    }
}
