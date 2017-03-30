package cn.roman.mytakeout.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.roman.mytakeout.R;
import cn.roman.mytakeout.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.rv_home)
    RecyclerView mRvHome;
    @BindView(R.id.home_tv_address)
    TextView mHomeTvAddress;
    @BindView(R.id.ll_title_search)
    LinearLayout mLlTitleSearch;
    @BindView(R.id.ll_title_container)
    LinearLayout mLlTitleContainer;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showMessage(String Message) {

    }

    @Override
    public void setListener() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

}
