package com.example.dell.myapplication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication2
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2019/2/15 20:51
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public class VolleryHlep implements IhttpProcessor {

    private final RequestQueue mRequestQueue;

    public VolleryHlep(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                callback.Success(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.Error(volleyError.getMessage().trim());
            }
        });
        mRequestQueue.add(stringRequest);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(StringRequest.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                callback.Success(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.Error(volleyError.getMessage());
            }
        });
        mRequestQueue.add(request);
    }
}
