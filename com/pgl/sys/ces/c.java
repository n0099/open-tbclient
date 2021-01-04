package com.pgl.sys.ces;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.security.MessageDigest;
import java.util.Calendar;
/* loaded from: classes4.dex */
public final class c {
    public static String a() {
        try {
            Context applicationContext = b.a().f11696b != null ? b.a().f11696b : com.pgl.sys.ces.a.a.eEy().getApplicationContext();
            return com.pgl.a.b.a.a(MessageDigest.getInstance("SHA1").digest(applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
        } catch (Throwable th) {
            return "0000000000000000000000000000000000000000";
        }
    }

    public static String a(String str) {
        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        b.a();
        String b2 = b.b();
        try {
            return com.pgl.a.b.a.a((byte[]) a.meta(601, null, (str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + b2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + b.c() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + timeInMillis).getBytes()));
        } catch (Throwable th) {
            return "";
        }
    }
}
