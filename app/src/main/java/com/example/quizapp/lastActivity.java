
package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class lastActivity extends AppCompatActivity {
    TextView textScreen, textQuestion, textTitle, textBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(lastActivity.this,MainActivity.class);
                startActivity(c);

            }
        });
    }
}
