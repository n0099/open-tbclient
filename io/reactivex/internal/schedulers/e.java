package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory mUw = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory bos;

    public e() {
        this(mUw);
    }

    public e(ThreadFactory threadFactory) {
        this.bos = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dCD() {
        return new f(this.bos);
    }
}
