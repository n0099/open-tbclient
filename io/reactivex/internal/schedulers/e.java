package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes25.dex */
public final class e extends v {
    private static final RxThreadFactory ozg = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory ozj;

    public e() {
        this(ozg);
    }

    public e(ThreadFactory threadFactory) {
        this.ozj = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eja() {
        return new f(this.ozj);
    }
}
