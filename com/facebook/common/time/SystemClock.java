package com.facebook.common.time;
/* loaded from: classes6.dex */
public class SystemClock implements Clock {
    public static final SystemClock INSTANCE = new SystemClock();

    public static SystemClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.Clock
    public long now() {
        return System.currentTimeMillis();
    }
}
