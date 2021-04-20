package f.b.x.i;

import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class i {
    public static <T> f.b.x.c.f<T> a(int i) {
        if (i < 0) {
            return new f.b.x.f.a(-i);
        }
        return new SpscArrayQueue(i);
    }

    public static boolean b(f.b.w.e eVar) {
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            f.b.u.a.a(th);
            return true;
        }
    }

    public static <T> void c(g.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, f.b.w.e eVar) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            cVar.onComplete();
        } else if (d(atomicLong.get(), cVar, queue, atomicLong, eVar)) {
        } else {
            do {
                j = atomicLong.get();
                if ((j & Long.MIN_VALUE) != 0) {
                    return;
                }
                j2 = j | Long.MIN_VALUE;
            } while (!atomicLong.compareAndSet(j, j2));
            if (j != 0) {
                d(j2, cVar, queue, atomicLong, eVar);
            }
        }
    }

    public static <T> boolean d(long j, g.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, f.b.w.e eVar) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (b(eVar)) {
                    return true;
                }
                Object obj = (T) queue.poll();
                if (obj == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(obj);
                j2++;
            } else if (b(eVar)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean e(long j, g.d.c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, f.b.w.e eVar) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, b.c(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 == Long.MIN_VALUE) {
            d(j | Long.MIN_VALUE, cVar, queue, atomicLong, eVar);
            return true;
        }
        return false;
    }

    public static void f(g.d.d dVar, int i) {
        dVar.request(i < 0 ? Long.MAX_VALUE : i);
    }
}
