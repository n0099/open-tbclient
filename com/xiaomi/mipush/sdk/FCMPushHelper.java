package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes3.dex */
public class FCMPushHelper {
    public static void clearToken(Context context) {
        i.a(context, f.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return i.b(context, f.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush();
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        PushMessageReceiver b;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (b = i.b(context)) == null) {
            return;
        }
        b.onReceiveMessage(context, i.a(str));
    }

    public static void notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        PushMessageReceiver b;
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (b = i.b(context)) == null) {
            return;
        }
        b.onReceivePassThroughMessage(context, i.a(str));
    }

    public static void reportFCMMessageDelete() {
        MiTinyDataClient.upload(i.b(f.ASSEMBLE_PUSH_FCM), "fcm", 1L, "some fcm messages was deleted ");
    }

    public static void uploadToken(Context context, String str) {
        i.a(context, f.ASSEMBLE_PUSH_FCM, str);
    }
}
