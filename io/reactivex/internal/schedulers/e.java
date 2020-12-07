package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes9.dex */
public final class e extends v {
    private static final RxThreadFactory pHD = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory pHG;

    public e() {
        this(pHD);
    }

    public e(ThreadFactory threadFactory) {
        this.pHG = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eCV() {
        return new f(this.pHG);
    }
}
