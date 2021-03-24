package f.a.x.i;

import f.a.o;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class e {
    public static void a(o<?> oVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                oVar.onError(terminate);
            } else {
                oVar.onComplete();
            }
        }
    }

    public static void b(g.d.c<?> cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                cVar.onError(terminate);
            } else {
                cVar.onComplete();
            }
        }
    }

    public static void c(o<?> oVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                oVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    public static void d(g.d.c<?> cVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(o<? super T> oVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            oVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    oVar.onError(terminate);
                } else {
                    oVar.onComplete();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(g.d.c<? super T> cVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    cVar.onError(terminate);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }
}
