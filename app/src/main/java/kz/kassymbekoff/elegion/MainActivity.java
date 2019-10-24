package kz.kassymbekoff.elegion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText msgET;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isValidateMsg()){
                Toast.makeText(MainActivity.this, msgET.getText().toString(), Toast.LENGTH_LONG).show();
                sendMessage();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterBtn = findViewById(R.id.enterBtn);
        msgET  = findViewById(R.id.msgET);

        enterBtn.setOnClickListener(onClickListener);
    }

    private boolean isValidateMsg(){
        return !TextUtils.isEmpty(msgET.getText().toString().trim());
    }

    private void sendMessage(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(SecondActivity.MESSAGE, msgET.getText().toString());
        startActivity(intent);
    }
}
