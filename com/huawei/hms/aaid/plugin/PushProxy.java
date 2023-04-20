package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.baidu.tieba.mwa;
import com.huawei.hms.common.ApiException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    mwa<Void> subscribe(Context context, String str, String str2);

    mwa<Void> turnOff(Context context, String str);

    mwa<Void> turnOn(Context context, String str);

    mwa<Void> unsubscribe(Context context, String str, String str2);
}
