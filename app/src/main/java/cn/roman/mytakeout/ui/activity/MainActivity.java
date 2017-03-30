package cn.roman.mytakeout.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.roman.mytakeout.R;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_fragment_container)
    FrameLayout mMainFragmentContainer;
    @BindView(R.id.main_bottom_switcher_container)
    LinearLayout mMainBottomSwitcherContainer;
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        createFragment();
    }

    private void createFragment() {

    }
}
