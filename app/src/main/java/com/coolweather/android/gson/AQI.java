package com.coolweather.android.gson;

/**
 * Created by LLT on 2018/4/22.
 */

public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
