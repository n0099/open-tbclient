package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes4.dex */
public final class e extends v {
    private static final RxThreadFactory mWb = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory aME;

    public e() {
        this(mWb);
    }

    public e(ThreadFactory threadFactory) {
        this.aME = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dDP() {
        return new f(this.aME);
    }
}
