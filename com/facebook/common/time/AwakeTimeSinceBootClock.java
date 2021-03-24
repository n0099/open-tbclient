package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
@DoNotStrip
/* loaded from: classes6.dex */
public class AwakeTimeSinceBootClock implements MonotonicClock {
    @DoNotStrip
    public static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    @DoNotStrip
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.MonotonicClock
    @DoNotStrip
    public long now() {
        return android.os.SystemClock.uptimeMillis();
    }
}
