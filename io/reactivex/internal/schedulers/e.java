package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes5.dex */
public final class e extends v {
    private static final RxThreadFactory qqT = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory qqW;

    public e() {
        this(qqT);
    }

    public e(ThreadFactory threadFactory) {
        this.qqW = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eKq() {
        return new f(this.qqW);
    }
}
