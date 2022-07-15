package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
/* loaded from: classes5.dex */
public final class az {
    public static long a = 400;
    public static final Handler b = new Handler(Looper.getMainLooper());

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        if (vibrator == null || ag.a(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(a, -1));
        } else {
            vibrator.vibrate(a);
        }
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            b.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j) {
        b.postDelayed(runnable, j);
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(b, runnable);
        obtain.obj = null;
        b.sendMessageDelayed(obtain, j);
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || ag.a(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    public static void b(Runnable runnable) {
        b.removeCallbacks(runnable);
    }
}
