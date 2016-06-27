package pl.digitalzombielab.androidviewmorphing;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.wnafee.vector.compat.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Animatable animatable = null;
    boolean staticAndroidView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        animatable = null;
        RadioButton rb = (RadioButton) findViewById(R.id.androidLogoRB);
        rb.setChecked(true);
    }

    public void onClickImage(View view) {
        if (!staticAndroidView && !animatable.isRunning()) {
            animatable.start();
        }
    }

    public void onClickSelect(View view) {
        if((animatable!=null&&!animatable.isRunning()) || animatable==null) {
            staticAndroidView = false;
            switch (view.getId()) {
                case R.id.androidLogoRB:
                    imageView.setImageResource(R.drawable.ic_android_black_24dp);
                    staticAndroidView = true;
                    break;
                case R.id.arrowToDoneRB:
                    animatable = (Animatable) ResourcesCompat.getDrawable
                            (getApplicationContext(), R.drawable.animvectordrawable);
                    imageView.setImageDrawable((Drawable) animatable);
                    break;
                case R.id.solarSystemRB:
                    animatable = (Animatable) ResourcesCompat.getDrawable
                            (getApplicationContext(), R.drawable.animvectorsolarsystem);
                    imageView.setImageDrawable((Drawable) animatable);
                    break;
                case R.id.androidAnimRB:
                    animatable = (Animatable) ResourcesCompat.getDrawable
                            (getApplicationContext(), R.drawable.vectalign_animated_vector_drawable_start_to_end);
                    imageView.setImageDrawable((Drawable) animatable);
                    break;
            }
        }

    }
}
