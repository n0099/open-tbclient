package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes6.dex */
public final class e extends v {
    private static final RxThreadFactory qrv = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory qry;

    public e() {
        this(qrv);
    }

    public e(ThreadFactory threadFactory) {
        this.qry = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eJY() {
        return new f(this.qry);
    }
}
