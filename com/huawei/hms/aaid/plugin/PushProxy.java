package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.baidu.tieba.i0b;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    i0b<Void> subscribe(Context context, String str, String str2);

    i0b<Void> turnOff(Context context, String str);

    i0b<Void> turnOn(Context context, String str);

    i0b<Void> unsubscribe(Context context, String str, String str2);
}
