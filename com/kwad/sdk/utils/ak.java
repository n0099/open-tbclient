package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes5.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f11077a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f11077a.post(runnable);
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(f11077a, runnable);
        obtain.obj = obj;
        f11077a.sendMessageDelayed(obtain, j);
    }
}
