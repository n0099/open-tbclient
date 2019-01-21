package rx.c;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes2.dex */
public class g {
    private static final g iSj = new g();

    public static rx.g cgv() {
        return a(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.g a(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.b(threadFactory);
    }

    public static rx.g cgw() {
        return b(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.g b(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.a(threadFactory);
    }

    public static rx.g cgx() {
        return c(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.g c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.f(threadFactory);
    }

    public rx.g cgy() {
        return null;
    }

    public rx.g cgz() {
        return null;
    }

    public rx.g cgA() {
        return null;
    }

    @Deprecated
    public rx.functions.a b(rx.functions.a aVar) {
        return aVar;
    }

    public static g cgB() {
        return iSj;
    }
}
