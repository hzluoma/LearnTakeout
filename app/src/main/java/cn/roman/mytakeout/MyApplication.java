package cn.roman.mytakeout;

import android.app.Application;

import java.util.concurrent.CopyOnWriteArrayList;

import cn.roman.mytakeout.model.bean.CacheSelectedInfo;

/**
 * Takeout
 * Created by Jayson on 2016/11/16
 * You are so cool
 */
public class MyApplication extends Application {
    //?
    private CopyOnWriteArrayList<CacheSelectedInfo> mCacheSelectedInfos = new CopyOnWriteArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 根据商铺id查询缓存
     * @param sellerId
     */
    public int queryCacheSelectedInfoBySellerId(int sellerId){
        int count = 0;
        int size = mCacheSelectedInfos.size();
        for (int i = 0; i < size; i++) {
            CacheSelectedInfo cacheSelectedInfo = mCacheSelectedInfos.get(i);
            if (cacheSelectedInfo.getSellerId() == sellerId){
                count += cacheSelectedInfo.getCount();
            }
        }
        return count;
    }

}
