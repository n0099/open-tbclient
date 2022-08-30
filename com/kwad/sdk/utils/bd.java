package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import java.io.Closeable;
/* loaded from: classes7.dex */
public final class bd {
    public static final Handler apf = new Handler(Looper.getMainLooper());
    public static long gO = 400;

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        if (vibrator == null || aj.Y(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(gO, -1));
        } else {
            vibrator.vibrate(gO);
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(apf, runnable);
        obtain.obj = null;
        apf.sendMessageDelayed(obtain, j);
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || aj.Y(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(Runnable runnable) {
        apf.removeCallbacks(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            apf.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        apf.postDelayed(runnable, j);
    }
}
