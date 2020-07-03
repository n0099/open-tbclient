package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory nMw = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory bAJ;

    public e() {
        this(nMw);
    }

    public e(ThreadFactory threadFactory) {
        this.bAJ = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dPr() {
        return new f(this.bAJ);
    }
}
