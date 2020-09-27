package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.Random;
import android.widget.Toast;

public class sixthActivity extends AppCompatActivity {
    public int count =0;
    private int presCounter =0;
    private int maxPresCounter = 5;
    String keys[] ={"U","S","M","O","E"};
    private String textAnswer = "MOUSE";
    TextView textScreen, textQuestion,textTitle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keys = shuffleArray(keys);
        for(String key:keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }
        maxPresCounter = 5;


    }
    private String[] shuffleArray(String[] arr)
    {
        Random rnd = new Random();
        for(int i = arr.length-1;i>0;i--)
        {
            int index = rnd.nextInt(i+1);
            String a = arr[index];
            arr[index]=arr[i];
            arr[i] = a;
        }
        return arr;

    }

    public void addView(LinearLayout viewParent,final String text,final EditText editText)
    {    LinearLayout.LayoutParams LinearLayoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT );
        LinearLayoutParams.rightMargin = 15;
        final TextView textView = new TextView(this);
        textView.setLayoutParams(LinearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textScreen = (TextView) findViewById(R.id.textScreen);
        textTitle = (TextView) findViewById(R.id.textTitle);

        textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    //textView.startAnimation(bigsmallforth);
                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;

                    if (presCounter == maxPresCounter)
                        doValidate();
                }
            }
        });
        viewParent.addView(textView);
    }


    private void doValidate() {
        presCounter = 0;

        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(textAnswer)) {
            Toast.makeText(sixthActivity.this, "Correct", Toast.LENGTH_SHORT).show();


            Intent a = new Intent(sixthActivity.this,lastActivity.class);
            startActivity(a);

            editText.setText("");
        } else {
            Toast.makeText(sixthActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }

    }


}


