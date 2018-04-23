package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by LLT on 2018/4/22.
 */

public class Utility {

    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean handleProvinceResponse(String response){
        try{
            if (TextUtils.isEmpty(response) == false){
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); ++i){
                    JSONObject jsonObject = array.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(jsonObject.getString("name"));
                    province.setProvinceCode(jsonObject.getInt("id"));
                    province.save();
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId){
        try{
            if (TextUtils.isEmpty(response) == false){
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); ++i){
                    JSONObject jsonObject = array.getJSONObject(i);
                    City city = new City();
                    city.setCityName(jsonObject.getString("name"));
                    city.setCityCode(jsonObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityId){
        try{
            if (TextUtils.isEmpty(response) == false){
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); ++i){
                    JSONObject jsonObject = array.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(jsonObject.getString("name"));
                    county.setWeatherId(jsonObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
