package com.promethean.smartstudent.activity;

import com.promethean.smartstudent.R;
import com.promethean.smartstudent.utils.Const;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_splash);
		
		new Handler().postDelayed((new Runnable() {

			@Override
			public void run() {
				
				ImageView icon = (ImageView) findViewById(R.id.ivIcon);

				ObjectAnimator fadeOut = ObjectAnimator.ofFloat(icon, "alpha",  1f, 0f);
				fadeOut.setDuration(Const.FADE_OUT_DELAY);				

				final AnimatorSet mAnimationSet = new AnimatorSet();
				mAnimationSet.play(fadeOut);

				mAnimationSet.addListener(new AnimatorListenerAdapter() {
				    @Override
				    public void onAnimationEnd(Animator animation) {
				        super.onAnimationEnd(animation);
				        
				        startActivity(new Intent(SplashActivity.this,
								 LoginActivity.class));
								 finish();
				    }
				});
				mAnimationSet.start();	
						 
			}
		}), Const.SPLASH_DELAY);
	}
}
