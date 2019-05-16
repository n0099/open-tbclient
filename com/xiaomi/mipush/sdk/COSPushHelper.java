package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public class COSPushHelper {
    private static volatile boolean a = false;
    private static long b = 0;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            if (b <= 0 || b + ReportUserInfoModel.TIME_INTERVAL <= elapsedRealtime) {
                b = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return a;
    }

    public static boolean hasNetwork(Context context) {
        return i.a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager c = g.a(context).c(f.ASSEMBLE_PUSH_COS);
        if (c != null) {
            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH :  register cos when network change!");
            c.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        i.a(context, f.ASSEMBLE_PUSH_COS, str);
    }
}
