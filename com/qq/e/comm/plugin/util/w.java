package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f12895a;

    private static Handler a() {
        if (f12895a == null) {
            f12895a = new Handler(Looper.getMainLooper());
        }
        return f12895a;
    }

    public static final void a(Object obj) {
        a().removeCallbacksAndMessages(obj);
    }

    public static final boolean a(Runnable runnable) {
        return a().post(runnable);
    }

    public static final boolean a(Runnable runnable, long j) {
        return a().postDelayed(runnable, j);
    }

    public static final boolean b(Runnable runnable) {
        return a().postAtFrontOfQueue(runnable);
    }

    public static final void c(Runnable runnable) {
        a().removeCallbacks(runnable);
    }
}
