package cn.roman.mytakeout.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.roman.mytakeout.ui.activity.BusinessActivity;
import cn.roman.mytakeout.ui.base.BaseFragment;

/**
 * Created by Administrator on 2017/3/30.
 */

public class BusinessVpAdapter extends FragmentPagerAdapter {
    private BusinessActivity mBusinessActivity;
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private String[] mTabName;

    public BusinessVpAdapter(FragmentManager fm) {
        super(fm);
    }

    public BusinessVpAdapter(FragmentManager fm, BusinessActivity businessActivity,
                             List<BaseFragment> fragmentList, String[] tabName) {
        super(fm);
        mBusinessActivity = businessActivity;
        mFragmentList = fragmentList;
        mTabName = tabName;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabName[position];
    }
}
