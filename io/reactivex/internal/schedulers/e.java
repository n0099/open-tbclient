package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes17.dex */
public final class e extends v {
    private static final RxThreadFactory pPm = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory pPp;

    public e() {
        this(pPm);
    }

    public e(ThreadFactory threadFactory) {
        this.pPp = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eAA() {
        return new f(this.pPp);
    }
}
