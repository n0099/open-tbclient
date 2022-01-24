package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class a {
    public static int a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static AbstractC2206a f59930b;

    /* renamed from: com.ss.android.socialbase.downloader.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC2206a {
        public void a(String str, String str2) {
        }

        public void a(String str, String str2, Throwable th) {
        }

        public void b(String str, String str2) {
        }

        public void c(String str, String str2) {
        }

        public void d(String str, String str2) {
        }

        public void e(String str, String str2) {
        }
    }

    public static void a(int i2) {
        a = i2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 4) {
            b(str);
        }
        AbstractC2206a abstractC2206a = f59930b;
        if (abstractC2206a != null) {
            abstractC2206a.c(b(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 5) {
            b(str);
        }
        AbstractC2206a abstractC2206a = f59930b;
        if (abstractC2206a != null) {
            abstractC2206a.e(b(str), str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 6) {
            b(str);
        }
        AbstractC2206a abstractC2206a = f59930b;
        if (abstractC2206a != null) {
            abstractC2206a.d(b(str), str2);
        }
    }

    public static boolean a() {
        return a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        int i2 = a;
        AbstractC2206a abstractC2206a = f59930b;
        if (abstractC2206a != null) {
            abstractC2206a.a(b(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 3) {
            b(str);
        }
        AbstractC2206a abstractC2206a = f59930b;
        if (abstractC2206a != null) {
            abstractC2206a.b(b(str), str2);
        }
    }

    public static void c(String str) {
        d("DownloaderLogger", str);
    }

    public static void a(String str) {
        b("DownloaderLogger", str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (a <= 6) {
            b(str);
        }
        AbstractC2206a abstractC2206a = f59930b;
        if (abstractC2206a != null) {
            abstractC2206a.a(b(str), str2, th);
        }
    }
}
