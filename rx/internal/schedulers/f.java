package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes5.dex */
public final class f extends rx.g {
    private final ThreadFactory opi;

    public f(ThreadFactory threadFactory) {
        this.opi = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.opi);
    }
}
