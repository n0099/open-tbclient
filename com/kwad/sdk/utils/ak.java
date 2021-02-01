package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f10780a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f10780a.post(runnable);
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Message obtain = Message.obtain(f10780a, runnable);
        obtain.obj = obj;
        f10780a.sendMessageDelayed(obtain, j);
    }
}
