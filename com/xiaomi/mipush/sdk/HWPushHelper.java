package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HWPushHelper {
    private static boolean a = false;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static boolean hasNetwork(Context context) {
        return i.a(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        String a2 = i.a(f.ASSEMBLE_PUSH_HUAWEI);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        String a3 = i.a(context, a2);
        String a4 = ap.a(context).a(be.UPLOAD_HUAWEI_TOKEN);
        return (TextUtils.isEmpty(a3) || TextUtils.isEmpty(a4) || !"synced".equals(a4)) ? false : true;
    }

    public static boolean isUserOpenHmsPush() {
        return MiPushClient.getOpenHmsPush();
    }

    public static boolean needConnect() {
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        r0 = r3.getString("pushMsg");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has("pushMsg")) {
                            break;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        PushMessageReceiver b = i.b(context);
        if (b != null) {
            b.onNotificationMessageClicked(context, i.a(str2));
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        }
        PushMessageReceiver b = i.b(context);
        if (b != null) {
            b.onReceivePassThroughMessage(context, i.a(str2));
        }
    }

    public static void registerHuaWeiAssemblePush(Context context) {
        AbstractPushManager c = g.a(context).c(f.ASSEMBLE_PUSH_HUAWEI);
        if (c != null) {
            c.register();
        }
    }

    public static void reportError(String str, int i) {
        i.a(str, i);
    }

    public static synchronized void setConnectTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (HWPushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z) {
        a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1L)) > 172800000;
        }
        return z;
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        boolean z;
        synchronized (HWPushHelper.class) {
            z = Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1L)) > 5000;
        }
        return z;
    }

    public static void uploadToken(Context context, String str) {
        i.a(context, f.ASSEMBLE_PUSH_HUAWEI, str);
    }
}
