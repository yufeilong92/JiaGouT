package com.example.dell.myapplication;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication2
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2019/2/15 20:45
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public class HttpHelpr implements IhttpProcessor {
    private static IhttpProcessor mHttpProcesso = null;

    private static volatile HttpHelpr _singleton;
    private Context mContext;

    private Map<String, Object> mParams;

    private HttpHelpr(Context context) {
        this.mContext = context;
        mParams = new HashMap<>();
    }

    public static HttpHelpr get_Instance(Context context) {
        if (_singleton == null) {
            synchronized (HttpHelpr.class) {
                if (_singleton == null) {
                    _singleton = new HttpHelpr(context);
                }
            }
        }
        return _singleton;
    }

    public static void init(IhttpProcessor ihttpProcessor) {
        mHttpProcesso = ihttpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        mHttpProcesso.post(url, mParams, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        mHttpProcesso.get(url, mParams, callback);
    }
}
