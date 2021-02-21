package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.d;
@d
/* loaded from: classes6.dex */
public class RealtimeSinceBootClock implements b {
    private static final RealtimeSinceBootClock pzY = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @d
    public static RealtimeSinceBootClock get() {
        return pzY;
    }

    @Override // com.facebook.common.time.b
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
