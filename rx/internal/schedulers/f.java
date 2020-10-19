package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes16.dex */
public final class f extends rx.g {
    private final ThreadFactory oOy;

    public f(ThreadFactory threadFactory) {
        this.oOy = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.oOy);
    }
}
