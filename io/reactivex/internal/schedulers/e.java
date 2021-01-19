package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes5.dex */
public final class e extends v {
    private static final RxThreadFactory qgp = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory qgs;

    public e() {
        this(qgp);
    }

    public e(ThreadFactory threadFactory) {
        this.qgs = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eHS() {
        return new f(this.qgs);
    }
}
