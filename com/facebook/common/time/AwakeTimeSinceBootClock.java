package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.d;
@d
/* loaded from: classes2.dex */
public class AwakeTimeSinceBootClock {
    @d
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @d
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @d
    public long now() {
        return SystemClock.uptimeMillis();
    }
}
