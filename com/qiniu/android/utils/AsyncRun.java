package com.qiniu.android.utils;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes5.dex */
public final class AsyncRun {
    public static void I(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
