package com.qiniu.android.utils;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public final class AsyncRun {
    public static void B(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
