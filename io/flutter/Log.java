package io.flutter;
/* loaded from: classes9.dex */
public class Log {
    private static int logLevel = 3;

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void v(String str, String str2) {
    }

    public static void v(String str, String str2, Throwable th) {
    }

    public static void i(String str, String str2) {
    }

    public static void i(String str, String str2, Throwable th) {
    }

    public static void d(String str, String str2) {
    }

    public static void d(String str, String str2, Throwable th) {
    }

    public static void w(String str, String str2) {
        android.util.Log.w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        android.util.Log.w(str, str2, th);
    }

    public static void e(String str, String str2) {
        android.util.Log.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        android.util.Log.e(str, str2, th);
    }

    public static void wtf(String str, String str2) {
        android.util.Log.wtf(str, str2);
    }

    public static void wtf(String str, String str2, Throwable th) {
        android.util.Log.wtf(str, str2, th);
    }
}
