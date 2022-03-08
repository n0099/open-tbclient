package com.google.android.exoplayer2.util;

import android.os.Handler;
/* loaded from: classes7.dex */
public interface Clock {
    public static final Clock DEFAULT = new SystemClock();

    long elapsedRealtime();

    void postDelayed(Handler handler, Runnable runnable, long j2);

    void sleep(long j2);
}
