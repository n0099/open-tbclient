package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes18.dex */
public class FCMPushHelper {
    public static void clearToken(Context context) {
        h.m106a(context, d.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        h.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return h.m108a(context, d.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = h.a(context)) == null) {
            return;
        }
        a2.onNotificationMessageArrived(context, h.a(str));
    }

    public static void notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = h.a(context)) == null) {
            return;
        }
        a2.onReceivePassThroughMessage(context, h.a(str));
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(h.b(d.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        h.a(context, d.ASSEMBLE_PUSH_FCM, str);
    }
}
