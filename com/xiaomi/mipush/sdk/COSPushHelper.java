package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
/* loaded from: classes7.dex */
public class COSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    public static long f40427a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static volatile boolean f41a = false;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f40427a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f40427a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f41a;
    }

    public static boolean hasNetwork(Context context) {
        return i.m117a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m55a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f41a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        i.a(context, e.ASSEMBLE_PUSH_COS, str);
    }
}
