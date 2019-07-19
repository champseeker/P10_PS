package sg.edu.rp.soi.p10_ps_solution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ImageView ivRating;
    TextView tvTitle, tvInfo, tvDesc, tvWatchedOn, tvCinema;
    RatingBar ratingBar;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ivRating = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.textViewTitle);
        tvInfo = findViewById(R.id.textViewInfo);
        tvDesc = findViewById(R.id.textViewDesc);
        tvWatchedOn = findViewById(R.id.textViewWatched);
        tvCinema = findViewById(R.id.textViewTheatre);
        ratingBar = findViewById(R.id.ratingBar);
        btnDelete = findViewById(R.id.buttonDelete);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String rating = intentReceived.getStringExtra("rated");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("description");
        String watchedOn = intentReceived.getStringExtra("watched_on");
        String theatre = intentReceived.getStringExtra("in_theatre");

        tvTitle.setText(title);
        tvInfo.setText(year + " - " + genre);
        tvDesc.setText(description);
        tvWatchedOn.setText("Watched on: " + watchedOn);
        tvCinema.setText("In theatre: " + theatre);

        if(rating.equals("g")) {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if(rating.equals("pg13")) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if(rating.equals("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if(rating.equals("m18")) {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if(rating.equals("r21")) {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDelete = new Intent(SecondActivity.this, MainActivity.class);
                String titleDelete = tvTitle.getText().toString();
                intentDelete.putExtra("titleDelete", titleDelete);
                startActivity(intentDelete);
            }
        });
    }
}
