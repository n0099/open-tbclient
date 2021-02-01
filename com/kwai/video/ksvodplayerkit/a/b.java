package com.kwai.video.ksvodplayerkit.a;

import android.util.Log;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f11040a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11041b = true;

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f11041b && f11040a != null) {
            try {
                f11040a.a(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (f11041b && f11040a != null) {
            try {
                f11040a.c(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (f11041b && f11040a != null) {
            try {
                f11040a.b(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (f11041b && f11040a != null) {
            try {
                f11040a.d(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (f11041b && f11040a != null) {
            try {
                f11040a.e(str, str2, th);
            } catch (Exception e) {
                Log.e("ksvodplayer", Log.getStackTraceString(e));
            }
        }
    }
}
