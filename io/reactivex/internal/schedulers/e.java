package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes5.dex */
public final class e extends v {
    private static final RxThreadFactory qqt = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory qqw;

    public e() {
        this(qqt);
    }

    public e(ThreadFactory threadFactory) {
        this.qqw = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eKi() {
        return new f(this.qqw);
    }
}
