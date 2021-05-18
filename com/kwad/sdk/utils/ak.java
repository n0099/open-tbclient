package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f34105a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f34105a.post(runnable);
        }
    }
}
