package com.xzw.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by daniel.xiao on 2016/12/28.
 * 弹幕动画
 */

public class ThirdActivity extends Activity {

    public static final String TAG = "ThirdActivity";
    private int mWidth;
    private View mGiftView;
    private ViewGroup mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        mRootView = (ViewGroup) findViewById(android.R.id.content);
        initItem();
        startAnimation();
    }

    private void initItem() {
        mGiftView = LayoutInflater.from(this).inflate(R.layout.gift_item, null);
        ((TextView) mGiftView.findViewById(R.id.tv_danmu)).setText("I am a gift to you");
        measureView(mGiftView);
        mWidth = mGiftView.getMeasuredWidth();
        Log.i(TAG, "width" + mWidth);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        mRootView.addView(mGiftView, layoutParams);
    }

    private void startAnimation(){
        TranslateAnimation translateAnimation = new TranslateAnimation(-mWidth, 0, 0,0);
        translateAnimation.setDuration(800);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setStartOffset(1000);
        alphaAnimation.setDuration(800);
        alphaAnimation.setAnimationListener(new OnAnimationListener(){

            @Override
            public void onAnimationEnd(Animation animation) {
                mRootView.removeView(mGiftView);
            }
        });
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        mGiftView.startAnimation(animationSet);
    }

    private void measureView(View child) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();
        if(lp == null){
            lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int childMeasureWidth = ViewGroup.getChildMeasureSpec(0, 0, lp.width);
        int childMeasureHeight;
        if(lp.height > 0){
            childMeasureHeight = View.MeasureSpec.makeMeasureSpec(lp.height, View.MeasureSpec.EXACTLY);
        } else {
            childMeasureHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        //将宽和高设置给child
        child.measure(childMeasureWidth, childMeasureHeight);
    }
}
