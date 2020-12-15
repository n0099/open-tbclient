package rx.c;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes12.dex */
public class g {
    private static final g pVy = new g();

    public static rx.g eGD() {
        return c(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.g c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.b(threadFactory);
    }

    public static rx.g eGE() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.g d(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.a(threadFactory);
    }

    public static rx.g eGF() {
        return e(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.g e(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.f(threadFactory);
    }

    public rx.g eGG() {
        return null;
    }

    public rx.g eGH() {
        return null;
    }

    public rx.g eGI() {
        return null;
    }

    @Deprecated
    public rx.functions.a d(rx.functions.a aVar) {
        return aVar;
    }

    public static g eGJ() {
        return pVy;
    }
}
