package cn.roman.mytakeout.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.roman.mytakeout.MyApplication;
import cn.roman.mytakeout.R;
import cn.roman.mytakeout.model.bean.Seller;
import cn.roman.mytakeout.ui.activity.BusinessActivity;
import cn.roman.mytakeout.ui.activity.MainActivity;
import cn.roman.mytakeout.utils.Constants;

import static cn.roman.mytakeout.R.mipmap.h;

/**
 * Created by Administrator on 2017/3/28.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter {

    Context mContext;
    private final MainActivity mMainActiity;
    private final MyApplication mApplication;
    private List<Seller> mSellerList = new ArrayList<>();
    private final int TYPE_TITLE = 0;
    private final int TYPE_SELLER = 1;

    public HomeRecyclerAdapter(Context context, MainActivity mainActiity) {
        mContext = context;
        mMainActiity = (MainActivity) mContext;
        mApplication = (MyApplication) mMainActiity.getApplication();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TYPE_TITLE:
                View titleView = layoutInflater.inflate(R.layout.item_title, parent, false);
                //TitleHolder
                return new TitleHolder(titleView);
            case TYPE_SELLER:
                View sellerView = layoutInflater.inflate(R.layout.item_seller, parent, false);
                //SellerHolder
                return new SellerHolder(sellerView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                TitleHolder holder1 = (TitleHolder) holder;
                holder1.initSliderLayout();
                break;
            default:
                if (mSellerList.size() > 0) {
                    //每个店铺的数据
                    Seller seller = mSellerList.get(position - 1);
                    //holder
                    SellerHolder sellerHolder = (SellerHolder) holder;

                }
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SellerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvCount)
        TextView mTvCount;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.ratingBar)
        RatingBar mRatingBar;

        public SellerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setSeller(final Seller seller) {
            int count = mApplication.queryCacheSelectedInfoBySellerId(seller.getId());
            if (count > 0) {
                mTvCount.setVisibility(View.VISIBLE);
                mTvCount.setText(count + "");
            } else {
                mTvCount.setVisibility(View.INVISIBLE);
                mTvCount.setText(count + "");
            }

            //设置商家的名字
            mTvTitle.setText(seller.getName());
            //给每个item添加点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**
                     * 跳转到BusiniessActivity,
                     * 并将商铺的数据传过去
                     */
                    Intent intent = new Intent(mContext, BusinessActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("seller", seller);
                    int count = mApplication.queryCacheSelectedInfoBySellerId(seller.getId());
                    if (count > 0) {
                        bundle.putBoolean(Constants.HASCACHE, true);
                    } else {
                        bundle.putBoolean(Constants.HASCACHE, false);
                    }
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            });
        }

    }


    class TitleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.slider)
        SliderLayout mSlider;

        public TitleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //TODO 这些不用写
        public void initSliderLayout() {
            HashMap<String, String> url_maps = new HashMap<String, String>();
            url_maps.put("Hannibal", "http://static2.hypable" +
                    ".com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
            url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
            url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
            url_maps.put("Game of Thrones", "http://images.boomsbeat" +
                    ".com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

            for (String name : url_maps.keySet()) {
                TextSliderView textSliderView = new TextSliderView(mSlider.getContext());
                // initialize a SliderLayout
                textSliderView
                        .description(name)
                        .image(url_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);
//                    .setOnSliderClickListener(this);

                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle().putString("extra", name);

                mSlider.addSlider(textSliderView);
            }
            mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mSlider.setCustomAnimation(new DescriptionAnimation());
            mSlider.setDuration(4000);
        }

    }

}
