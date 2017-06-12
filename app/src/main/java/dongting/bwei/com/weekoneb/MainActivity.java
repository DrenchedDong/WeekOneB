package dongting.bwei.com.weekoneb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv=(TextView) findViewById(R.id.tv);

        RotateAnimation rotateAnimation =new RotateAnimation(0,360f,RELATIVE_TO_SELF,RELATIVE_TO_SELF);
        rotateAnimation.setDuration(2000);

        tv.setAnimation(rotateAnimation);
        rotateAnimation.start();

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
