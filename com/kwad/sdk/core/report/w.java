package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;
/* loaded from: classes10.dex */
public final class w {
    public static String awV = DM();
    public static long awW = 0;
    public static Context awX;

    public static String DI() {
        com.kwad.sdk.core.e.c.d("ReportIdManager", ">> updateSessionId");
        String DM = DM();
        awV = DM;
        return DM;
    }

    public static String DJ() {
        return awV;
    }

    @WorkerThread
    public static long DK() {
        long bg = bg(awX);
        b(awX, 1 + bg);
        return bg;
    }

    public static long DL() {
        return awW;
    }

    public static String DM() {
        return UUID.randomUUID().toString();
    }

    @WorkerThread
    public static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong("seq", j);
        return edit.commit();
    }

    @WorkerThread
    public static long bg(Context context) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) != null) {
            return sharedPreferences.getLong("seq", 1L);
        }
        return 0L;
    }

    public static void init(Context context) {
        awX = context;
    }
}
