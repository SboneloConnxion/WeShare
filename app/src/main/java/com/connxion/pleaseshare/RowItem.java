package com.connxion.pleaseshare;

/**
 * Created by Sbonelo Sthole on 2017/08/26.
 */

public class RowItem {
    private String sendOptions;
    private int icons;
    private String count_str;

    public RowItem (String sendOptions, int icons, String count_str){
        this.sendOptions = sendOptions;
        this.icons = icons;
        this.count_str = count_str;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }

    public int getIcons() {
        return icons;
    }

    public void setSendOptions(String sendOptions) {
        this.sendOptions = sendOptions;
    }

    public void setCount_str(String count_str) {
        this.count_str = count_str;
    }

    public String getSendOptions() {
        return sendOptions;
    }



    public String getCount_str() {
        return count_str;
    }
}
