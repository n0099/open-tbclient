package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.coloros.mcssdk.mode.CommandMessage;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
/* loaded from: classes6.dex */
class ak {
    public static HashMap<String, String> a(Context context, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("appToken", d.m80a(context).b());
            hashMap.put("regId", MiPushClient.getRegId(context));
            hashMap.put("appId", d.m80a(context).m81a());
            hashMap.put("regResource", d.m80a(context).e());
            if (!com.xiaomi.push.l.d()) {
                String g = com.xiaomi.push.i.g(context);
                if (!TextUtils.isEmpty(g)) {
                    hashMap.put("imeiMd5", com.xiaomi.push.ay.a(g));
                }
            }
            hashMap.put("isMIUI", String.valueOf(com.xiaomi.push.l.m478a()));
            hashMap.put("miuiVersion", com.xiaomi.push.l.m475a());
            hashMap.put("devId", com.xiaomi.push.i.a(context, true));
            hashMap.put("model", Build.MODEL);
            hashMap.put(PushClientConstants.TAG_PKG_NAME, context.getPackageName());
            hashMap.put(CommandMessage.SDK_VERSION, "3_6_19");
            hashMap.put("androidVersion", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            hashMap.put("andId", com.xiaomi.push.i.e(context));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("clientInterfaceId", str);
            }
        } catch (Throwable th) {
        }
        return hashMap;
    }
}
