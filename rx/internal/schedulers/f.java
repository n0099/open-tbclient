package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes15.dex */
public final class f extends rx.g {
    private final ThreadFactory qjl;

    public f(ThreadFactory threadFactory) {
        this.qjl = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.qjl);
    }
}
