package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.baidu.tieba.h2b;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    h2b<Void> subscribe(Context context, String str, String str2);

    h2b<Void> turnOff(Context context, String str);

    h2b<Void> turnOn(Context context, String str);

    h2b<Void> unsubscribe(Context context, String str, String str2);
}
