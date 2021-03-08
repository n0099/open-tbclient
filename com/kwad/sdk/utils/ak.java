package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f7117a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f7117a.post(runnable);
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(f7117a, runnable);
        obtain.obj = obj;
        f7117a.sendMessageDelayed(obtain, j);
    }
}
