package com.example.harisabtu;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button popup;
    Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        popup=findViewById(R.id.button2);
        mDialog=new Dialog(this);


            }
            public void showpopup(View v) {
                Button selesai;
                mDialog.setContentView(R.layout.popup);
                selesai=(Button)findViewById(R.id.buttons);

                mDialog.show();
            }



    public void popup (View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Next")) {
            Intent intent = new Intent(this, poppup.class);
            startActivity(intent);
        }
    }

    public void third_layout(View view) {
            String button_text;
            button_text = ((Button) view).getText().toString();
            if (button_text.equals("Selesai")) {
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
            }
    }
}

