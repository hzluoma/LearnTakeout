package cn.roman.mytakeout.ui.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import static android.view.View.inflate;

/**
 * Created by Administrator on 2017/3/22.
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment {

    protected Context mContext;
    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        mRootView = View.inflate(mContext, getLayoutId(), null);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    //留给子类实现的方法  初始化View 初始化数据  展示信息 设置监听
    protected abstract void initView();

    protected abstract void initData();

    public abstract void showMessage(String Message);

    public abstract void setListener();

    //获取资源ID并解析赋给根布局
    protected abstract int getLayoutId();

}
