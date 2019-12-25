package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes4.dex */
public final class f extends rx.g {
    private final ThreadFactory aME;

    public f(ThreadFactory threadFactory) {
        this.aME = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.aME);
    }
}
