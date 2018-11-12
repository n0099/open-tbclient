package rx.c;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes2.dex */
public class g {
    private static final g iGK = new g();

    public static rx.g ccU() {
        return a(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static rx.g a(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.b(threadFactory);
    }

    public static rx.g ccV() {
        return b(new RxThreadFactory("RxIoScheduler-"));
    }

    public static rx.g b(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.a(threadFactory);
    }

    public static rx.g ccW() {
        return c(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static rx.g c(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory == null");
        }
        return new rx.internal.schedulers.f(threadFactory);
    }

    public rx.g ccX() {
        return null;
    }

    public rx.g ccY() {
        return null;
    }

    public rx.g ccZ() {
        return null;
    }

    @Deprecated
    public rx.functions.a b(rx.functions.a aVar) {
        return aVar;
    }

    public static g cda() {
        return iGK;
    }
}
