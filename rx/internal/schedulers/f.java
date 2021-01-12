package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes14.dex */
public final class f extends rx.g {
    private final ThreadFactory qgr;

    public f(ThreadFactory threadFactory) {
        this.qgr = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.qgr);
    }
}
