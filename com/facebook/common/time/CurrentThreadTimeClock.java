package com.facebook.common.time;
/* loaded from: classes9.dex */
public class CurrentThreadTimeClock implements Clock {
    @Override // com.facebook.common.time.Clock
    public long now() {
        return android.os.SystemClock.currentThreadTimeMillis();
    }
}
