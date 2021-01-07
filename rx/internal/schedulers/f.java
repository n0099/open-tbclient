package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes15.dex */
public final class f extends rx.g {
    private final ThreadFactory qkT;

    public f(ThreadFactory threadFactory) {
        this.qkT = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.qkT);
    }
}
