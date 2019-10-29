package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.coloros.mcssdk.mode.CommandMessage;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
class al {
    public static HashMap<String, String> a(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("appToken", d.a(context).d());
            hashMap.put("regId", MiPushClient.getRegId(context));
            hashMap.put("appId", d.a(context).c());
            hashMap.put("regResource", d.a(context).g());
            if (!com.xiaomi.channel.commonutils.android.f.g()) {
                String f = com.xiaomi.channel.commonutils.android.d.f(context);
                if (!TextUtils.isEmpty(f)) {
                    hashMap.put("imeiMd5", com.xiaomi.channel.commonutils.string.d.a(f));
                }
            }
            hashMap.put("isMIUI", String.valueOf(com.xiaomi.channel.commonutils.android.f.a()));
            hashMap.put("miuiVersion", com.xiaomi.channel.commonutils.android.f.d());
            hashMap.put("devId", com.xiaomi.channel.commonutils.android.d.a(context, true));
            hashMap.put("model", Build.MODEL);
            hashMap.put(PushClientConstants.TAG_PKG_NAME, context.getPackageName());
            hashMap.put(CommandMessage.SDK_VERSION, "3_6_9");
            hashMap.put("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            hashMap.put("andId", com.xiaomi.channel.commonutils.android.d.d(context));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("clientInterfaceId", str);
            }
        } catch (Throwable th) {
        }
        return hashMap;
    }
}
