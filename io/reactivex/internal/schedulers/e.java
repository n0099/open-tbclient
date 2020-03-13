package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory nze = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory aRX;

    public e() {
        this(nze);
    }

    public e(ThreadFactory threadFactory) {
        this.aRX = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dJi() {
        return new f(this.aRX);
    }
}
