package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f13446a = 4;
    private static AbstractC1222a pYE;

    public static void a(int i) {
        f13446a = i;
    }

    public static boolean a() {
        return f13446a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 != null && f13446a <= 2) {
            Log.v(str, str2);
        }
    }

    public static void a(String str) {
        b("DownloaderLogger", str);
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? "Downloader-" + str : "DownloaderLogger";
    }

    public static void b(String str, String str2) {
        if (str2 != null && f13446a <= 3) {
            Log.d(b(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (str2 != null) {
            if (f13446a <= 4) {
                Log.i(b(str), str2);
            }
            if (pYE != null) {
                pYE.a(b(str), str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            if (f13446a <= 5) {
                Log.w(b(str), str2);
            }
            if (pYE != null) {
                pYE.c(b(str), str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            if (f13446a <= 6) {
                Log.e(b(str), str2);
            }
            if (pYE != null) {
                pYE.b(b(str), str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 != null || th != null) {
            if (f13446a <= 6) {
                Log.e(b(str), str2, th);
            }
            if (pYE != null) {
                pYE.a(b(str), str2, th);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1222a {
        public void a(String str, String str2) {
        }

        public void a(String str, String str2, Throwable th) {
        }

        public void b(String str, String str2) {
        }

        public void c(String str, String str2) {
        }
    }
}
