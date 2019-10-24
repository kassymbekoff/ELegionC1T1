package kz.kassymbekoff.elegion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String MESSAGE = "message";
    private String baseUrl = "https://www.google.com/search?q=";
    private String message;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent searchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(baseUrl + message));
            startActivity(searchIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        message = intent.getStringExtra(MESSAGE);

        TextView msgTV = findViewById(R.id.msgTV);
        msgTV.setText(message);

        Button searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(onClickListener);
    }
}
