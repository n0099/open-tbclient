package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.d;
@d
/* loaded from: classes2.dex */
public class RealtimeSinceBootClock {
    private static final RealtimeSinceBootClock kac = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @d
    public static RealtimeSinceBootClock get() {
        return kac;
    }

    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
