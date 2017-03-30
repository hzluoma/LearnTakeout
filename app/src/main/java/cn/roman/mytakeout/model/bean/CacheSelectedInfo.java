package cn.roman.mytakeout.model.bean;

/**
 * Takeout
 * Created by Jayson on 2016/11/16
 * You are so cool
 */
public class CacheSelectedInfo {
    private int sellerId;
    private int typeId;
    private int goodId;
    private int count;

    public CacheSelectedInfo(int sellerId, int typeId, int goodId, int count) {
        this.sellerId = sellerId;
        this.typeId = typeId;
        this.goodId = goodId;
        this.count = count;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
