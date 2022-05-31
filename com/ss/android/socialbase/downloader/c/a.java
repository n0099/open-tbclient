package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes7.dex */
public class a {
    public static int a = 4;
    public static AbstractC0602a b;

    /* renamed from: com.ss.android.socialbase.downloader.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC0602a {
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

    public static void a(int i) {
        a = i;
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
            Log.i(b(str), str2);
        }
        AbstractC0602a abstractC0602a = b;
        if (abstractC0602a != null) {
            abstractC0602a.c(b(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 5) {
            Log.w(b(str), str2);
        }
        AbstractC0602a abstractC0602a = b;
        if (abstractC0602a != null) {
            abstractC0602a.e(b(str), str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 6) {
            Log.e(b(str), str2);
        }
        AbstractC0602a abstractC0602a = b;
        if (abstractC0602a != null) {
            abstractC0602a.d(b(str), str2);
        }
    }

    public static boolean a() {
        return a <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 2) {
            Log.v(str, str2);
        }
        AbstractC0602a abstractC0602a = b;
        if (abstractC0602a != null) {
            abstractC0602a.a(b(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (a <= 3) {
            Log.d(b(str), str2);
        }
        AbstractC0602a abstractC0602a = b;
        if (abstractC0602a != null) {
            abstractC0602a.b(b(str), str2);
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
            Log.e(b(str), str2, th);
        }
        AbstractC0602a abstractC0602a = b;
        if (abstractC0602a != null) {
            abstractC0602a.a(b(str), str2, th);
        }
    }
}
