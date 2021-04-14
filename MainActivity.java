package com.example.harisabtu;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    
    EditText textPersonName, textPassword;
    Button huhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        textPersonName = findViewById(R.id.edittext1);
        textPassword = findViewById(R.id.edittext2);
        huhi = findViewById(R.id.tombol);

        huhi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String button_text;
                button_text = ((Button) view).getText().toString();
                final String Name = textPersonName.getText().toString();
                final String word = textPassword.getText().toString();
                if (textPersonName.length() == 0) {
                    textPersonName.requestFocus();
                    textPersonName.setError("FIELD CANNOT BE EMPTY");
                } else if (textPassword.length() == 0) {
                    textPassword.requestFocus();
                    textPassword.setError("PASSWORD CANNOT BE EMPTY");
                } else if (textPersonName.length() > 0 || textPassword.length() > 0 || button_text.equals("Submit")){
                    Toast.makeText(getApplicationContext(), "Registrasi Berhasil!",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(i);
                    }
            }


        });
    }

}

