package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
@DoNotStrip
/* loaded from: classes7.dex */
public class RealtimeSinceBootClock implements MonotonicClock {
    public static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
