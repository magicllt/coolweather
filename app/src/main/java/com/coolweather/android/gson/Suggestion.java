package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LLT on 2018/4/22.
 */

public class Suggestion {

    @SerializedName("comf")
    public Text comfort;

    @SerializedName("cw")
    public Text carWash;

    @SerializedName("sport")
    public Text sport;

    public class Text{
        @SerializedName("txt")
        public String info;
    }

}
