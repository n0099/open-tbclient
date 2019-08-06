package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes2.dex */
public final class a {
    public static long a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, x(j2, j)));
        return j2;
    }

    public static long w(long j, long j2) {
        long j3 = j * j2;
        if (((j | j2) >>> 31) != 0 && j2 != 0 && j3 / j2 != j) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public static long x(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public static <T> void a(AtomicLong atomicLong, Queue<T> queue, rx.j<? super T> jVar) {
        a(atomicLong, queue, jVar, UtilityFunctions.cQr());
    }

    public static <T> boolean a(AtomicLong atomicLong, long j, Queue<T> queue, rx.j<? super T> jVar) {
        return a(atomicLong, j, queue, jVar, UtilityFunctions.cQr());
    }

    public static <T, R> void a(AtomicLong atomicLong, Queue<T> queue, rx.j<? super R> jVar, rx.functions.f<? super T, ? extends R> fVar) {
        long j;
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j, j | Long.MIN_VALUE));
        if (j != 0) {
            b(atomicLong, queue, jVar, fVar);
        }
    }

    public static <T, R> boolean a(AtomicLong atomicLong, long j, Queue<T> queue, rx.j<? super R> jVar, rx.functions.f<? super T, ? extends R> fVar) {
        long j2;
        long j3;
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
        if (j == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        }
        do {
            j2 = atomicLong.get();
            j3 = Long.MIN_VALUE & j2;
        } while (!atomicLong.compareAndSet(j2, x(Long.MAX_VALUE & j2, j) | j3));
        if (j2 != Long.MIN_VALUE) {
            return j3 == 0;
        }
        b(atomicLong, queue, jVar, fVar);
        return false;
    }

    /* JADX DEBUG: Type inference failed for r0v11. Raw type applied. Possible types: R, ? super R */
    /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: R, ? super R */
    static <T, R> void b(AtomicLong atomicLong, Queue<T> queue, rx.j<? super R> jVar, rx.functions.f<? super T, ? extends R> fVar) {
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
        long j2 = j;
        long j3 = Long.MIN_VALUE;
        while (true) {
            if (j3 != j2) {
                if (!jVar.isUnsubscribed()) {
                    Object poll2 = queue.poll();
                    if (poll2 == null) {
                        jVar.onCompleted();
                        return;
                    } else {
                        jVar.onNext((R) fVar.call(poll2));
                        j3++;
                    }
                } else {
                    return;
                }
            } else {
                if (j3 == j2) {
                    if (!jVar.isUnsubscribed()) {
                        if (queue.isEmpty()) {
                            jVar.onCompleted();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                j2 = atomicLong.get();
                if (j2 == j3) {
                    long addAndGet = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                    if (addAndGet == Long.MIN_VALUE) {
                        return;
                    }
                    j2 = addAndGet;
                    j3 = Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static long b(AtomicLong atomicLong, long j) {
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

    public static boolean eQ(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
        return j != 0;
    }
}
