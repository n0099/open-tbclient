package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f7829a = 4;
    private static AbstractC1242a qhf;

    public static void a(int i) {
        f7829a = i;
    }

    public static boolean a() {
        return f7829a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 != null && f7829a <= 2) {
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
        if (str2 != null && f7829a <= 3) {
            Log.d(b(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (str2 != null) {
            if (f7829a <= 4) {
                Log.i(b(str), str2);
            }
            if (qhf != null) {
                qhf.a(b(str), str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            if (f7829a <= 5) {
                Log.w(b(str), str2);
            }
            if (qhf != null) {
                qhf.c(b(str), str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            if (f7829a <= 6) {
                Log.e(b(str), str2);
            }
            if (qhf != null) {
                qhf.b(b(str), str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 != null || th != null) {
            if (f7829a <= 6) {
                Log.e(b(str), str2, th);
            }
            if (qhf != null) {
                qhf.a(b(str), str2, th);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC1242a {
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
