package com.pgl.sys.ces;

import android.content.Context;
import java.security.MessageDigest;
import java.util.Calendar;
/* loaded from: classes6.dex */
public final class c {
    public static String a() {
        try {
            Context applicationContext = b.a().f37995b != null ? b.a().f37995b : d.m.b.b.a.a.d().getApplicationContext();
            return d.m.a.b.a.a(MessageDigest.getInstance("SHA1").digest(applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
        } catch (Throwable unused) {
            return "0000000000000000000000000000000000000000";
        }
    }

    public static String a(String str) {
        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        b.a();
        String b2 = b.b();
        String c2 = b.c();
        try {
            return d.m.a.b.a.a((byte[]) a.meta(601, null, (str + "_" + b2 + "_" + c2 + "_" + timeInMillis).getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }
}
