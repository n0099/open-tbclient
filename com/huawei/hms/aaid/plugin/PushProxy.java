package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.baidu.tieba.ewa;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    ewa<Void> subscribe(Context context, String str, String str2);

    ewa<Void> turnOff(Context context, String str);

    ewa<Void> turnOn(Context context, String str);

    ewa<Void> unsubscribe(Context context, String str, String str2);
}
