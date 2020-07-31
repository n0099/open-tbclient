package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.d;
@d
/* loaded from: classes12.dex */
public class RealtimeSinceBootClock implements b {
    private static final RealtimeSinceBootClock mRw = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @d
    public static RealtimeSinceBootClock get() {
        return mRw;
    }

    @Override // com.facebook.common.time.b
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
