package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class s {
    public static Context ab;
    public static String abt = uJ();
    public static long abu = 0;

    @WorkerThread
    public static long by(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    @WorkerThread
    public static boolean d(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong("seq", j);
            return edit.commit();
        }
        return false;
    }

    public static void init(Context context) {
        ab = context;
    }

    public static String uF() {
        com.kwad.sdk.core.e.b.d("ReportIdManager", ">> updateSessionId");
        String uJ = uJ();
        abt = uJ;
        return uJ;
    }

    public static String uG() {
        return abt;
    }

    @WorkerThread
    public static long uH() {
        long by = by(ab);
        d(ab, 1 + by);
        return by;
    }

    public static long uI() {
        return abu;
    }

    public static String uJ() {
        return UUID.randomUUID().toString();
    }
}
