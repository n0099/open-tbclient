package com.kwai.video.ksvodplayerkit.a;

import android.util.Log;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f11337a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11338b = true;

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f11338b && f11337a != null) {
            try {
                f11337a.a(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (f11338b && f11337a != null) {
            try {
                f11337a.c(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (f11338b && f11337a != null) {
            try {
                f11337a.b(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (f11338b && f11337a != null) {
            try {
                f11337a.d(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (f11338b && f11337a != null) {
            try {
                f11337a.e(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }
}
