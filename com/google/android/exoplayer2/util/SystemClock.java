package com.google.android.exoplayer2.util;

import android.os.Handler;
/* loaded from: classes9.dex */
public final class SystemClock implements Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void postDelayed(Handler handler, Runnable runnable, long j) {
        handler.postDelayed(runnable, j);
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }
}
