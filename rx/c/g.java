package rx.c;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes2.dex */
public class g {
    private static final g kub = new g();

    public static rx.g cMG() {
        return a(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.g a(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.b(threadFactory);
    }

    public static rx.g cMH() {
        return b(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.g b(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.a(threadFactory);
    }

    public static rx.g cMI() {
        return c(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.g c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.f(threadFactory);
    }

    public rx.g cMJ() {
        return null;
    }

    public rx.g cMK() {
        return null;
    }

    public rx.g cML() {
        return null;
    }

    @Deprecated
    public rx.functions.a d(rx.functions.a aVar) {
        return aVar;
    }

    public static g cMM() {
        return kub;
    }
}
