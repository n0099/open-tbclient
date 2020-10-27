package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes17.dex */
public final class e extends v {
    private static final RxThreadFactory pFS = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory pFV;

    public e() {
        this(pFS);
    }

    public e(ThreadFactory threadFactory) {
        this.pFV = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c ewL() {
        return new f(this.pFV);
    }
}
