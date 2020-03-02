package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory nyT = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory aRW;

    public e() {
        this(nyT);
    }

    public e(ThreadFactory threadFactory) {
        this.aRW = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dJh() {
        return new f(this.aRW);
    }
}
