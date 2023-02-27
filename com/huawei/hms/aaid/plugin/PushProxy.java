package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.baidu.tieba.ega;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    ega<Void> subscribe(Context context, String str, String str2);

    ega<Void> turnOff(Context context, String str);

    ega<Void> turnOn(Context context, String str);

    ega<Void> unsubscribe(Context context, String str, String str2);
}
