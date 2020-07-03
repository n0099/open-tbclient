package rx.c;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes6.dex */
public class g {
    private static final g ohj = new g();

    public static rx.g dVq() {
        return c(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.g c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.b(threadFactory);
    }

    public static rx.g dVr() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.g d(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.a(threadFactory);
    }

    public static rx.g dVs() {
        return e(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.g e(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.f(threadFactory);
    }

    public rx.g dVt() {
        return null;
    }

    public rx.g dVu() {
        return null;
    }

    public rx.g dVv() {
        return null;
    }

    @Deprecated
    public rx.functions.a d(rx.functions.a aVar) {
        return aVar;
    }

    public static g dVw() {
        return ohj;
    }
}
