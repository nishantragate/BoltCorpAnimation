package com.boltcorp.boltcorpanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    //Vars
    Animation boltAnim, textAnim;
    LinearLayout boltIcon;
    LinearLayout corpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        boltAnim = AnimationUtils.loadAnimation(this, R.anim.bolt_icon_animation);
        textAnim = AnimationUtils.loadAnimation(this, R.anim.text_animation);

        boltIcon = findViewById(R.id.bolt_icon);
        corpText = findViewById(R.id.boltcorp_text);

        boltIcon.setAnimation(boltAnim);
        corpText.setAnimation(textAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
