package cn.roman.mytakeout.presenter.activity;

import cn.roman.mytakeout.ui.activity.BusinessActivity;
import cn.roman.mytakeout.ui.fragment.GoodsFragment;

/**
 * Created by Administrator on 2017/3/30.
 */

public class BusinessActivityPresenter {

    private final GoodsFragment mGoodsFragment;
    private BusinessActivity mBusinesssActivity;

    public BusinessActivityPresenter(BusinessActivity businessActivity) {
        mBusinesssActivity = businessActivity;
        mGoodsFragment = (GoodsFragment) mBusinesssActivity.mFragmentList.get(0);
    }


}
