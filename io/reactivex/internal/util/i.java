package io.reactivex.internal.util;

import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes25.dex */
public final class i {
    public static <T> io.reactivex.internal.a.g<T> Ox(int i) {
        return i < 0 ? new io.reactivex.internal.queue.a(-i) : new SpscArrayQueue(i);
    }

    public static void a(org.a.d dVar, int i) {
        dVar.request(i < 0 ? Long.MAX_VALUE : i);
    }

    public static <T> boolean a(long j, org.a.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, io.reactivex.c.e eVar) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, b.M(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 == Long.MIN_VALUE) {
            b(j | Long.MIN_VALUE, cVar, queue, atomicLong, eVar);
            return true;
        }
        return false;
    }

    static boolean a(io.reactivex.c.e eVar) {
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            return true;
        }
    }

    static <T> boolean b(long j, org.a.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, io.reactivex.c.e eVar) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (a(eVar)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(obj);
                j2++;
            } else if (a(eVar)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    j = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((j & Long.MAX_VALUE) == 0) {
                        return false;
                    }
                    j2 = j & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> void a(org.a.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, io.reactivex.c.e eVar) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            cVar.onComplete();
        } else if (!b(atomicLong.get(), cVar, queue, atomicLong, eVar)) {
            do {
                j = atomicLong.get();
                if ((j & Long.MIN_VALUE) == 0) {
                    j2 = j | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j2));
            if (j != 0) {
                b(j2, cVar, queue, atomicLong, eVar);
            }
        }
    }
}
