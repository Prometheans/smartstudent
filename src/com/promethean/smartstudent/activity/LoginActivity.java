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
import android.widget.LinearLayout;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_login);

	}

	@Override
	protected void onResume() {

		super.onResume();

		LinearLayout container = (LinearLayout) findViewById(R.id.llContainer);

		ObjectAnimator fadeIn = ObjectAnimator.ofFloat(container, "alpha", 0f, 1f);
		fadeIn.setDuration(Const.FADE_IN_DELAY);

		final AnimatorSet mAnimationSet = new AnimatorSet();
		mAnimationSet.play(fadeIn);

		mAnimationSet.start();

	}
}
