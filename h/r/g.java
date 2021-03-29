package h.r;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f68004a = new g();

    public static h.g a() {
        return b(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static h.g b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new h.o.c.b(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static h.g c() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static h.g d(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new h.o.c.a(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static h.g e() {
        return f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static h.g f(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new h.o.c.f(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static g h() {
        return f68004a;
    }

    public h.g g() {
        return null;
    }

    public h.g i() {
        return null;
    }

    public h.g j() {
        return null;
    }

    @Deprecated
    public h.n.a k(h.n.a aVar) {
        return aVar;
    }
}
