package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes2.dex */
public final class f extends rx.g {
    private final ThreadFactory agF;

    public f(ThreadFactory threadFactory) {
        this.agF = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.agF);
    }
}
