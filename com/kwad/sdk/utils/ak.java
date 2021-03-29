package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes6.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36719a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f36719a.post(runnable);
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(f36719a, runnable);
        obtain.obj = obj;
        f36719a.sendMessageDelayed(obtain, j);
    }
}
