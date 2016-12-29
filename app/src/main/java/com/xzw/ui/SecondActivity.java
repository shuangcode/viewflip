package com.xzw.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * ���һ���demo
 * @author xzw
 *
 */
public class SecondActivity extends Activity {
	
	private static final String TAG = "MainActivity";
	
	private ViewFlipper viewFlipper;

	Animation leftInAnimation;
	Animation leftOutAnimation;
	Animation rightInAnimation;
	Animation rightOutAnimation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);

        //��viewFlipper���View
        viewFlipper.addView(getImageView(R.drawable.new_feature_1));
        viewFlipper.addView(getImageView(R.drawable.new_feature_2));
        viewFlipper.addView(getImageView(R.drawable.new_feature_3));
        viewFlipper.addView(getImageView(R.drawable.new_feature_4));
        viewFlipper.addView(getImageView(R.drawable.new_feature_5));
        viewFlipper.addView(getImageView(R.drawable.new_feature_6));
        
        //����Ч��
    	leftInAnimation = AnimationUtils.loadAnimation(this, R.anim.left_in);
		leftOutAnimation = AnimationUtils.loadAnimation(this, R.anim.left_out);
		rightInAnimation = AnimationUtils.loadAnimation(this, R.anim.right_in);
		rightOutAnimation = AnimationUtils.loadAnimation(this, R.anim.right_out);

        viewFlipper.setInAnimation(leftInAnimation);
        viewFlipper.setOutAnimation(leftOutAnimation);
		viewFlipper.setFlipInterval(800); // ���û������
        //�Զ�
		viewFlipper.startFlipping();

    }

    private ImageView getImageView(int id){
    	ImageView imageView = new ImageView(this);
    	imageView.setImageResource(id);
    	return imageView;
    }

}
