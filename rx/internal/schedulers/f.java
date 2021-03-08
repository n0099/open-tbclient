package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.g;
/* loaded from: classes4.dex */
public final class f extends rx.g {
    private final ThreadFactory qry;

    public f(ThreadFactory threadFactory) {
        this.qry = threadFactory;
    }

    @Override // rx.g
    public g.a createWorker() {
        return new g(this.qry);
    }
}
