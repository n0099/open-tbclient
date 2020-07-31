package com.qiniu.android.utils;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public final class AsyncRun {
    public static void H(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
