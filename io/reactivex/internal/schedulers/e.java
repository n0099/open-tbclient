package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes9.dex */
public final class e extends v {
    private static final RxThreadFactory pHF = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory pHI;

    public e() {
        this(pHF);
    }

    public e(ThreadFactory threadFactory) {
        this.pHI = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c eCW() {
        return new f(this.pHI);
    }
}
