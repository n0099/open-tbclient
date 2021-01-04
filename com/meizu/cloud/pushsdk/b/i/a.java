package com.meizu.cloud.pushsdk.b.i;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.b.a.e;
import com.meizu.cloud.pushsdk.b.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
/* loaded from: classes6.dex */
public final class a {
    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public static void a(k kVar, com.meizu.cloud.pushsdk.b.a.b bVar) {
        if (bVar.f() == e.OK_HTTP_RESPONSE || kVar == null || kVar.b() == null) {
            return;
        }
        try {
            if (kVar.b().a() != null) {
                try {
                    kVar.b().a().close();
                    if (MinSdkChecker.isSupportNotificationChannel()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (Exception e) {
                    com.meizu.cloud.pushsdk.b.a.a.a("Unable to close source data");
                    if (MinSdkChecker.isSupportNotificationChannel()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            }
        } catch (Throwable th) {
            if (MinSdkChecker.isSupportNotificationChannel()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }
}
