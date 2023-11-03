package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.baidu.tieba.m7c;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    m7c<Void> subscribe(Context context, String str, String str2);

    m7c<Void> turnOff(Context context, String str);

    m7c<Void> turnOn(Context context, String str);

    m7c<Void> unsubscribe(Context context, String str, String str2);
}
