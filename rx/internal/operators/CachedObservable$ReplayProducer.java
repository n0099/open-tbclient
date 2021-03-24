package rx.internal.operators;

import h.f;
import h.j;
import h.k;
import h.o.a.b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class CachedObservable$ReplayProducer<T> extends AtomicLong implements f, k {
    public static final long serialVersionUID = -2557562030197141021L;
    public final j<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public boolean emitting;
    public int index;
    public boolean missed;
    public final b<T> state;

    public CachedObservable$ReplayProducer(j<? super T> jVar, b<T> bVar) {
        this.child = jVar;
        this.state = bVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return get() < 0;
    }

    public long produced(long j) {
        return addAndGet(-j);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void replay() {
        synchronized (this) {
            if (this.emitting) {
                this.missed = true;
                return;
            }
            this.emitting = true;
            try {
                if (get() < 0) {
                    return;
                }
                this.state.a();
                throw null;
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    @Override // h.f
    public void request(long j) {
        long j2;
        long j3;
        do {
            j2 = get();
            if (j2 < 0) {
                return;
            }
            j3 = j2 + j;
            if (j3 < 0) {
                j3 = Long.MAX_VALUE;
            }
        } while (!compareAndSet(j2, j3));
        replay();
    }

    @Override // h.k
    public void unsubscribe() {
        if (get() < 0 || getAndSet(-1L) < 0) {
            return;
        }
        this.state.c(this);
        throw null;
    }
}
