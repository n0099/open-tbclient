package io.reactivex.internal.util;

import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class e {
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(org.b.c<? super T> cVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
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

    public static void a(org.b.c<?> cVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        io.reactivex.e.a.onError(th);
    }

    public static void a(org.b.c<?> cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                cVar.onError(terminate);
            } else {
                cVar.onComplete();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(u<? super T> uVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            uVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    uVar.onError(terminate);
                } else {
                    uVar.onComplete();
                }
            }
        }
    }

    public static void a(u<?> uVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                uVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        io.reactivex.e.a.onError(th);
    }

    public static void a(u<?> uVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                uVar.onError(terminate);
            } else {
                uVar.onComplete();
            }
        }
    }
}
