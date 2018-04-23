package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LLT on 2018/4/22.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String WeatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }
}
