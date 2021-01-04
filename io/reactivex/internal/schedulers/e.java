package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes3.dex */
public final class e extends v {
    private static final RxThreadFactory qji = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory qjl;

    public e() {
        this(qji);
    }

    public e(ThreadFactory threadFactory) {
        this.qjl = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eLe() {
        return new f(this.qjl);
    }
}
