package com.vovatkach2427gmail.gamepoint;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;

public class WelcomeAct extends AppCompatActivity {
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvWelcome=(TextView)findViewById(R.id.tvWelcome);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Interpolator interpolator=new AccelerateInterpolator();
        ObjectAnimator animator=ObjectAnimator.ofFloat(tvWelcome, View.ALPHA,0.0f,1.0f);
        animator.setDuration(5000);
        animator.setInterpolator(interpolator);
        tvWelcome.setVisibility(View.VISIBLE);
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent=new Intent(WelcomeAct.this,MainMenu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_left,R.anim.out_right);
            }
        });
    }
}
