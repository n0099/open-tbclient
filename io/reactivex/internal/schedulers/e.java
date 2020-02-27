package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory nyR = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory aRV;

    public e() {
        this(nyR);
    }

    public e(ThreadFactory threadFactory) {
        this.aRV = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dJf() {
        return new f(this.aRV);
    }
}
