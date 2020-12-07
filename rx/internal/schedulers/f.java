package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes12.dex */
public final class f extends rx.g {
    private final ThreadFactory pHG;

    public f(ThreadFactory threadFactory) {
        this.pHG = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.pHG);
    }
}
