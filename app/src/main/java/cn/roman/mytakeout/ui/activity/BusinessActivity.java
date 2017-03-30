package cn.roman.mytakeout.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.roman.mytakeout.MyApplication;
import cn.roman.mytakeout.R;
import cn.roman.mytakeout.model.bean.Seller;
import cn.roman.mytakeout.presenter.activity.BusinessActivityPresenter;
import cn.roman.mytakeout.ui.adapter.BusinessVpAdapter;
import cn.roman.mytakeout.ui.base.BaseFragment;
import cn.roman.mytakeout.ui.fragment.BusinessFragment;
import cn.roman.mytakeout.ui.fragment.CommentFragment;
import cn.roman.mytakeout.ui.fragment.GoodsFragment;
import cn.roman.mytakeout.utils.Constants;

import static cn.roman.mytakeout.R.mipmap.b;
import static cn.roman.mytakeout.R.mipmap.c;

public class BusinessActivity extends AppCompatActivity {

    @BindView(R.id.ib_back)
    ImageButton mIbBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.ib_menu)
    ImageButton mIbMenu;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.bottomSheetLayout)
    BottomSheetLayout mBottomSheetLayout;
    @BindView(R.id.imgCart)
    ImageView mImgCart;
    @BindView(R.id.tvSelectNum)
    TextView mTvSelectNum;
    @BindView(R.id.tvCountPrice)
    TextView mTvCountPrice;
    @BindView(R.id.tvDeliveryFee)
    TextView mTvDeliveryFee;
    @BindView(R.id.tvSendPrice)
    TextView mTvSendPrice;
    @BindView(R.id.tvSubmit)
    TextView mTvSubmit;
    @BindView(R.id.bottom)
    LinearLayout mBottom;
    @BindView(R.id.fl_Container)
    FrameLayout mFlContainer;

    public Seller mSeller;
    public boolean mHasCache;
    private String[] mTabNames = {"商品","评论","商家"};
    private BusinessVpAdapter mBusinessVpAdapter;
    public BusinessActivityPresenter mBusinessActivityPresenter;
    private MyApplication mMyApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        mSeller = (Seller) bundle.getSerializable("seller");
        mHasCache = bundle.getBoolean(Constants.HASCACHE);
        //设置标题信息
        mTvTitle.setText(mSeller.getName());
        mTvDeliveryFee.setText("另需配送费￥" + mSeller.getSendPrice());
        mTvSendPrice.setText("￥"+mSeller.getDeliveryFee()+"元起送");

        //创建顶部tab
        createTab();

        //设置viewpaer的数据
        //创建viewpager的fragment
        createFragment();
        mBusinessVpAdapter = new BusinessVpAdapter(getSupportFragmentManager(),
                this, mFragmentList, mTabNames);
        mVp.setAdapter(mBusinessVpAdapter);

        //将TabLayout和ViewPager绑定
        mTabs.setupWithViewPager(mVp);

        mBusinessActivityPresenter = new BusinessActivityPresenter(this);

        mMyApplication = (MyApplication) this.getApplication();

        //viewPager滑动监听
        mVp.addOnPageChangeListener(new MyPageChangeListener());
    }

    public List<BaseFragment> mFragmentList = new ArrayList<>();
    private void createFragment() {
        GoodsFragment goodsFragment = new GoodsFragment();
        CommentFragment commentFragment = new CommentFragment();
        BusinessFragment businessFragment = new BusinessFragment();
        mFragmentList.add(goodsFragment);
        mFragmentList.add(commentFragment);
        mFragmentList.add(businessFragment);
    }

    private void createTab() {
        for (int i = 0; i < mTabNames.length; i++) {
            mTabs.addTab(mTabs.newTab().setText(mTabNames[i]));
        }
    }

    class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                mBottom.setVisibility(View.VISIBLE);
            } else {
                mBottom.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
