package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes6.dex */
public final class f extends rx.g {
    private final ThreadFactory aRV;

    public f(ThreadFactory threadFactory) {
        this.aRV = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.aRV);
    }
}
