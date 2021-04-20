package com.kwai.video.ksvodplayerkit.a;

import android.util.Log;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f37516a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f37517b = true;

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a aVar;
        if (f37517b && (aVar = f37516a) != null) {
            try {
                aVar.a(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        a aVar;
        if (f37517b && (aVar = f37516a) != null) {
            try {
                aVar.c(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void c(String str, String str2) {
        c(str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        a aVar;
        if (f37517b && (aVar = f37516a) != null) {
            try {
                aVar.b(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        a aVar;
        if (f37517b && (aVar = f37516a) != null) {
            try {
                aVar.d(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        a aVar;
        if (f37517b && (aVar = f37516a) != null) {
            try {
                aVar.e(str, str2, th);
            } catch (Exception e2) {
                Log.e("ksvodplayer", Log.getStackTraceString(e2));
            }
        }
    }
}
