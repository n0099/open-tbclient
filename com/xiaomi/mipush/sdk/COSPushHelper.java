package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
/* loaded from: classes12.dex */
public class COSPushHelper {

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f24a = false;

    /* renamed from: a  reason: collision with root package name */
    private static long f4733a = 0;

    public static void convertMessage(Intent intent) {
        h.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            if (f4733a <= 0 || f4733a + 300000 <= elapsedRealtime) {
                f4733a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f24a;
    }

    public static boolean hasNetwork(Context context) {
        return h.m114a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = e.a(context).a(d.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f24a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        h.a(context, d.ASSEMBLE_PUSH_COS, str);
    }
}
