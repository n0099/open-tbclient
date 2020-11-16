package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes5.dex */
public final class e extends v {
    private static final RxThreadFactory pQP = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory pQS;

    public e() {
        this(pQP);
    }

    public e(ThreadFactory threadFactory) {
        this.pQS = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eAB() {
        return new f(this.pQS);
    }
}
