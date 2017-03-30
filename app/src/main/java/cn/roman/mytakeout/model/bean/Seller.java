package cn.roman.mytakeout.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class Seller implements Serializable{

    private int deliveryFee;
    private String distance;
    private String ensure;
    private int id;
    private String invoice;
    private String name;
    private String pic;
    private String recentVisit;
    private String sale;
    private String score;
    private int sendPrice;
    private String time;
    private List<?> activityList;

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getEnsure() {
        return ensure;
    }

    public void setEnsure(String ensure) {
        this.ensure = ensure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRecentVisit() {
        return recentVisit;
    }

    public void setRecentVisit(String recentVisit) {
        this.recentVisit = recentVisit;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(int sendPrice) {
        this.sendPrice = sendPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<?> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<?> activityList) {
        this.activityList = activityList;
    }
}
