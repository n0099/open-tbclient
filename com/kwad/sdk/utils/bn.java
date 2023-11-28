package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;
/* loaded from: classes10.dex */
public final class bn {
    public static final Handler aPs = new Handler(Looper.getMainLooper());
    public static long ld = 400;

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, ld);
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator != null && am.aq(context, "android.permission.VIBRATE") == 0) {
            vibrator.cancel();
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        aPs.postDelayed(runnable, j);
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(aPs, runnable);
        obtain.obj = null;
        aPs.sendMessageDelayed(obtain, j);
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j) {
        if (vibrator != null) {
            try {
                if (am.aq(context, "android.permission.VIBRATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                    } else {
                        vibrator.vibrate(j);
                    }
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    public static void b(Runnable runnable) {
        aPs.postAtFrontOfQueue(runnable);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean gt(String str) {
        if (!TextUtils.isEmpty(str) && !str.contains(" ") && URLUtil.isNetworkUrl(str)) {
            return false;
        }
        return true;
    }

    public static void postOnUiThread(Runnable runnable) {
        aPs.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            aPs.post(runnable);
        }
    }

    public static String s(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            if (TextUtils.isEmpty(stackTraceString)) {
                return th.toString();
            }
            return stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void c(Runnable runnable) {
        aPs.removeCallbacks(runnable);
    }
}
