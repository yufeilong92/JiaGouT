package com.example.dell.myapplication;

import java.util.Map;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication2
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2019/2/15 20:42
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
public interface IhttpProcessor {
    void post(String url, Map<String, Object> params, ICallback callback);

    void get(String url, Map<String, Object> params, ICallback callback);

}
