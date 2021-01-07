package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f13447a = 4;
    private static AbstractC1263a qam;

    public static void a(int i) {
        f13447a = i;
    }

    public static boolean a() {
        return f13447a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 != null && f13447a <= 2) {
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
        if (str2 != null && f13447a <= 3) {
            Log.d(b(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (str2 != null) {
            if (f13447a <= 4) {
                Log.i(b(str), str2);
            }
            if (qam != null) {
                qam.a(b(str), str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            if (f13447a <= 5) {
                Log.w(b(str), str2);
            }
            if (qam != null) {
                qam.c(b(str), str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            if (f13447a <= 6) {
                Log.e(b(str), str2);
            }
            if (qam != null) {
                qam.b(b(str), str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 != null || th != null) {
            if (f13447a <= 6) {
                Log.e(b(str), str2, th);
            }
            if (qam != null) {
                qam.a(b(str), str2, th);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1263a {
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
