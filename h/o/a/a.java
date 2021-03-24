package h.o.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes7.dex */
public final class a {
    public static long a(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public static long b(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, a(j2, j)));
        return j2;
    }

    public static long c(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) == 0 || j2 == 0 || j3 / j2 == j) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    /* JADX DEBUG: Type inference failed for r10v3. Raw type applied. Possible types: R, ? super R */
    /* JADX DEBUG: Type inference failed for r8v3. Raw type applied. Possible types: R, ? super R */
    public static <T, R> void d(AtomicLong atomicLong, Queue<T> queue, h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
        long j = atomicLong.get();
        if (j == Long.MAX_VALUE) {
            while (!jVar.isUnsubscribed()) {
                Object poll = queue.poll();
                if (poll == null) {
                    jVar.onCompleted();
                    return;
                }
                jVar.onNext((R) fVar.call(poll));
            }
            return;
        }
        do {
            long j2 = Long.MIN_VALUE;
            while (true) {
                if (j2 != j) {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    Object poll2 = queue.poll();
                    if (poll2 == null) {
                        jVar.onCompleted();
                        return;
                    } else {
                        jVar.onNext((R) fVar.call(poll2));
                        j2++;
                    }
                } else {
                    if (j2 == j) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        if (queue.isEmpty()) {
                            jVar.onCompleted();
                            return;
                        }
                    }
                    j = atomicLong.get();
                    if (j == j2) {
                        j = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    }
                }
            }
        } while (j != Long.MIN_VALUE);
    }

    public static <T> boolean e(AtomicLong atomicLong, long j, Queue<T> queue, h.j<? super T> jVar) {
        return f(atomicLong, j, queue, jVar, UtilityFunctions.b());
    }

    public static <T, R> boolean f(AtomicLong atomicLong, long j, Queue<T> queue, h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
        long j2;
        long j3;
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        } else if (j == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        } else {
            while (true) {
                j2 = atomicLong.get();
                j3 = j2 & Long.MIN_VALUE;
                if (atomicLong.compareAndSet(j2, a(Long.MAX_VALUE & j2, j) | j3)) {
                    break;
                }
            }
            if (j2 != Long.MIN_VALUE) {
                return j3 == 0;
            }
            d(atomicLong, queue, jVar, fVar);
            return false;
        }
    }

    public static long g(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException("More produced than requested: " + j3);
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static boolean h(long j) {
        if (j >= 0) {
            return j != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }
}
