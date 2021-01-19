package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes14.dex */
public final class f extends rx.g {
    private final ThreadFactory qgs;

    public f(ThreadFactory threadFactory) {
        this.qgs = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.qgs);
    }
}
