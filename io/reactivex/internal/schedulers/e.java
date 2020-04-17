package io.reactivex.internal.schedulers;

import io.reactivex.v;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes7.dex */
public final class e extends v {
    private static final RxThreadFactory mUt = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory bon;

    public e() {
        this(mUt);
    }

    public e(ThreadFactory threadFactory) {
        this.bon = threadFactory;
    }

    @Override // io.reactivex.v
    public v.c dCG() {
        return new f(this.bon);
    }
}
