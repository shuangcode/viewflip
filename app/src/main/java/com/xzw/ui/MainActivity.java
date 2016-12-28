package com.xzw.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;
/**
 * 左右滑动demo
 * @author xzw
 *
 */
public class MainActivity extends Activity implements OnGestureListener {
	
	private static final String TAG = "MainActivity";
	
	private ViewFlipper viewFlipper;
	private GestureDetector detector; //手势检测

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
        detector = new GestureDetector(this);
        
        //往viewFlipper添加View
        viewFlipper.addView(getImageView(R.drawable.new_feature_1));
        viewFlipper.addView(getImageView(R.drawable.new_feature_2));
        viewFlipper.addView(getImageView(R.drawable.new_feature_3));
        viewFlipper.addView(getImageView(R.drawable.new_feature_4));
        viewFlipper.addView(getImageView(R.drawable.new_feature_5));
        viewFlipper.addView(getImageView(R.drawable.new_feature_6));
        
        //动画效果
    	leftInAnimation = AnimationUtils.loadAnimation(this, R.anim.left_in);
		leftOutAnimation = AnimationUtils.loadAnimation(this, R.anim.left_out);
		rightInAnimation = AnimationUtils.loadAnimation(this, R.anim.right_in);
		rightOutAnimation = AnimationUtils.loadAnimation(this, R.anim.right_out);
    }

    private ImageView getImageView(int id){
    	ImageView imageView = new ImageView(this);
    	imageView.setImageResource(id);
    	return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
     
    	return this.detector.onTouchEvent(event); //touch事件交给手势处理。
    }
    
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *
	 * @param e1 ？
	 * @param e2 ？
	 * @param velocityX
	 * @param velocityY
     * @return
     */
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.i(TAG, "e1="+e1.getX()+" e2="+e2.getX()+" e1-e2="+(e1.getX()-e2.getX()));
		if(e1.getX()-e2.getX()>120){
			viewFlipper.setInAnimation(leftInAnimation);
			viewFlipper.setOutAnimation(leftOutAnimation);
		    viewFlipper.showNext();//向左滑动
		    return true;
		}else if(e1.getX()-e2.getY()<-120){
			viewFlipper.setInAnimation(rightInAnimation);
			viewFlipper.setOutAnimation(rightOutAnimation);
			viewFlipper.showPrevious();//向右滑动
			return true;
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
}
