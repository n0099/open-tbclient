package rx.c;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes5.dex */
public class g {
    private static final g nSH = new g();

    public static rx.g dNN() {
        return c(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.g c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.b(threadFactory);
    }

    public static rx.g dNO() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.g d(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.a(threadFactory);
    }

    public static rx.g dNP() {
        return e(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.g e(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.f(threadFactory);
    }

    public rx.g dNQ() {
        return null;
    }

    public rx.g dNR() {
        return null;
    }

    public rx.g dNS() {
        return null;
    }

    @Deprecated
    public rx.functions.a d(rx.functions.a aVar) {
        return aVar;
    }

    public static g dNT() {
        return nSH;
    }
}
