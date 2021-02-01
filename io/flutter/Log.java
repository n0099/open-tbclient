package io.flutter;

import androidx.annotation.NonNull;
/* loaded from: classes15.dex */
public class Log {
    private static int logLevel = 3;

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void v(@NonNull String str, @NonNull String str2) {
    }

    public static void v(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public static void i(@NonNull String str, @NonNull String str2) {
    }

    public static void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public static void d(@NonNull String str, @NonNull String str2) {
    }

    public static void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        android.util.Log.w(str, str2);
    }

    public static void w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        android.util.Log.w(str, str2, th);
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        android.util.Log.e(str, str2);
    }

    public static void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        android.util.Log.e(str, str2, th);
    }

    public static void wtf(@NonNull String str, @NonNull String str2) {
        android.util.Log.wtf(str, str2);
    }

    public static void wtf(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        android.util.Log.wtf(str, str2, th);
    }
}
