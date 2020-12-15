package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes12.dex */
public final class f extends rx.g {
    private final ThreadFactory pHI;

    public f(ThreadFactory threadFactory) {
        this.pHI = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.pHI);
    }
}
