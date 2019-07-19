package sg.edu.rp.soi.p10_ps_solution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    Button btnAdd;
    EditText etTitle, etYear, etGenre, etRated, etDateWatched, etTheatre, etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnAdd = findViewById(R.id.buttonAdd);
        etTitle = findViewById(R.id.editTextTitle);
        etYear = findViewById(R.id.editTextYear);
        etGenre = findViewById(R.id.editTextGenre);
        etRated = findViewById(R.id.editTextRated);
        etDateWatched = findViewById(R.id.editTextWatched);
        etTheatre = findViewById(R.id.editTextTheatre);
        etDescription = findViewById(R.id.editTextDesc);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddToMain = new Intent(ThirdActivity.this, MainActivity.class);

                intentAddToMain.putExtra("title", etTitle.getText().toString());
                intentAddToMain.putExtra("year", etYear.getText().toString());
                intentAddToMain.putExtra("rated", etRated.getText().toString());
                intentAddToMain.putExtra("genre", etGenre.getText().toString());
                intentAddToMain.putExtra("watched", etDateWatched.getText().toString());
                intentAddToMain.putExtra("theatre", etTheatre.getText().toString());
                intentAddToMain.putExtra("description", etDescription.getText().toString());

                startActivity(intentAddToMain);
            }
        });
    }
}
