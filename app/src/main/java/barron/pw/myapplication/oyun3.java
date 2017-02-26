package barron.pw.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.angle;
import static android.R.attr.pivotX;
import static android.R.attr.pivotY;
import static barron.pw.myapplication.R.id.imageView;

public class oyun3 extends Activity {
    int   img_two_CurrentX;
    int   img_one_CurrentX;
    int a=360;
    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun3);

        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions =   View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);

        img1=(ImageView) findViewById(R.id.image_rotate);
        img2=(ImageView) findViewById(R.id.image_rotate2);

//       ObjectAnimator tw=ObjectAnimator.ofFloat(img2,
//                "rotation", 0f, 360f);
//        tw.setDuration(6000);
//        tw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                img_one_CurrentX=(int)img2.getY();
//
//            }
//        });
//        tw.start();



        final ImageView imageview = (ImageView)findViewById(R.id.image_rotate2);
        RotateAnimation rotate = new RotateAnimation(0, -360, Animation.RELATIVE_TO_SELF,
                0f,  Animation.RELATIVE_TO_SELF, 3f);
        rotate.setDuration(1500);
       ;
        rotate.setRepeatCount(Animation.INFINITE);
        imageview.startAnimation(rotate);

        FrameLayout o3= (FrameLayout)findViewById(R.id.activity_oyun3);
        ImageView elmas = (ImageView)findViewById(R.id.imageView7);

        Rect R1=new Rect(imageview.getLeft(), imageview.getTop(),imageview.getRight(),imageview.getBottom());
        imageview.getHitRect(R1);

        Rect R2=new Rect(elmas.getLeft(),elmas.getTop(),elmas.getRight(),elmas.getBottom());
        elmas.getHitRect(R2);

        if (Rect.intersects(R1, R2)) {

            Toast.makeText(getApplication(), "Intersected!", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(getApplicationContext(), "Not Intersected!", Toast.LENGTH_SHORT).show();
        }
        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

if(a==360){
    //ImageView imageview = (ImageView)findViewById(R.id.image_rotate2);
    ImageView elmas = (ImageView)findViewById(R.id.imageView7);

    RotateAnimation rotate = new RotateAnimation(0, -360, Animation.RELATIVE_TO_SELF,
            0f,  Animation.RELATIVE_TO_SELF, 3f);
    rotate.setDuration(1500);
    ;
    rotate.setRepeatCount(Animation.INFINITE);
   // imageview.startAnimation(rotate);
    Rect R1=new Rect(imageview.getLeft(), imageview.getTop(),imageview.getRight(),imageview.getBottom());
    imageview.getHitRect(R1);

    Rect R2=new Rect(elmas.getLeft(),elmas.getTop(),elmas.getRight(),elmas.getBottom());
    elmas.getHitRect(R2);

    if (Rect.intersects(R1, R2)) {

        Toast.makeText(getApplication(), "Intersected!", Toast.LENGTH_SHORT).show();
    } else {

        Toast.makeText(getApplicationContext(), "Not Intersected!", Toast.LENGTH_SHORT).show();
    }
    a=-360;
}  else{

    ImageView elmas = (ImageView)findViewById(R.id.imageView7);
    RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
            0f,  Animation.RELATIVE_TO_SELF, 3f);
    rotate.setDuration(1500);
    ;
    rotate.setRepeatCount(Animation.INFINITE);

   // imageview.startAnimation(rotate);
    Rect R1=new Rect(imageview.getLeft(), imageview.getTop(),imageview.getRight(),imageview.getBottom());
    //imageview.getHitRect(R1);

    Rect R2=new Rect(elmas.getLeft(),elmas.getTop(),elmas.getRight(),elmas.getBottom());
    //elmas.getHitRect(R2);

    if (Rect.intersects(R1, R2)) {

        Toast.makeText(getApplication(), "Intersected!", Toast.LENGTH_SHORT).show();
    } else {

        Toast.makeText(getApplicationContext(), "Not Intersected!", Toast.LENGTH_SHORT).show();
    }

    imageview.getX();
    a=360;

}

            }
        });
//
//        ObjectAnimator tw_One= ObjectAnimator.ofFloat(img1,
//                "translationX",0, 550f);
//        tw_One.setDuration(6000);
//        tw_One.setTarget(img1);
//        tw_One.start();
//        tw_One.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                img_two_CurrentX=(int)img1.getY();
//
//                if(img_one_CurrentX==img_two_CurrentX ){
//                    Toast.makeText(getApplicationContext(), "Collision", Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }
}
