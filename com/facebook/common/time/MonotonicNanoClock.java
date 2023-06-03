package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public interface MonotonicNanoClock {
    @DoNotStrip
    long nowNanos();
}
