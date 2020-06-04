package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory nqJ = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory bvS;

    public e() {
        this(nqJ);
    }

    public e(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dKL() {
        return new f(this.bvS);
    }
}
