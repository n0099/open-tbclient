package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes7.dex */
public final class f extends rx.g {
    private final ThreadFactory ozj;

    public f(ThreadFactory threadFactory) {
        this.ozj = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.ozj);
    }
}
