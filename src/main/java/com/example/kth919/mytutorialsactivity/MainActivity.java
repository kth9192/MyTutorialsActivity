package com.example.kth919.mytutorialsactivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.kth919.mytutorialsactivity.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getName();
    public static final String PREF_USER_FIRST_TIME = "user_first_time";

    private ActivityMainBinding activityMainBinding;

    private int tmpPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setExitTransition(new Explode());

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        boolean isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, TutorialActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        if (isUserFirstTime)
            startActivity(introIntent);

    }
}