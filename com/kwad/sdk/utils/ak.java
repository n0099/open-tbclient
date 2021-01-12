package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes4.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f10778a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f10778a.post(runnable);
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(f10778a, runnable);
        obtain.obj = obj;
        f10778a.sendMessageDelayed(obtain, j);
    }
}
