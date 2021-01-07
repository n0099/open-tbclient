package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes5.dex */
public final class e extends v {
    private static final RxThreadFactory qkQ = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory qkT;

    public e() {
        this(qkQ);
    }

    public e(ThreadFactory threadFactory) {
        this.qkT = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eLI() {
        return new f(this.qkT);
    }
}
