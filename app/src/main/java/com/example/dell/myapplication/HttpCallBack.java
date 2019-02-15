package com.example.dell.myapplication;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication2
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2019/2/15 20:29
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public abstract class HttpCallBack<Result> implements ICallback {
    @Override
    public void Success(String success) {
        Gson gson = new Gson();
        Class<?> clz = anylsisClasInfon(this);
        Result objResult = (Result) gson.fromJson(success, clz);
        onSuccess(objResult);
    }

    public abstract void onSuccess(Result objResult);


    public static Class<?> anylsisClasInfon(Object o) {
        Type type = o.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<?>) params[0];
    }
}
