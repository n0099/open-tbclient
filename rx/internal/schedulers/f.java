package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes6.dex */
public final class f extends rx.g {
    private final ThreadFactory nVk;

    public f(ThreadFactory threadFactory) {
        this.nVk = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.nVk);
    }
}
