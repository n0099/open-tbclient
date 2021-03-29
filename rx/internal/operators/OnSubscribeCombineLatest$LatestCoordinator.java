package rx.internal.operators;

import h.f;
import h.j;
import h.k;
import h.o.a.a;
import h.o.d.j.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class OnSubscribeCombineLatest$LatestCoordinator<T, R> extends AtomicInteger implements f, k {
    public static final Object MISSING = new Object();
    public static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public final j<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final h.n.j<? extends R> combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public final d<Object> queue;
    public final AtomicLong requested;
    public final h.o.a.d<T, R>[] subscribers;

    public OnSubscribeCombineLatest$LatestCoordinator(j<? super R> jVar, h.n.j<? extends R> jVar2, int i, int i2, boolean z) {
        this.actual = jVar;
        this.combiner = jVar2;
        this.bufferSize = i2;
        this.delayError = z;
        Object[] objArr = new Object[i];
        this.latest = objArr;
        Arrays.fill(objArr, MISSING);
        this.subscribers = new h.o.a.d[i];
        this.queue = new d<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
    }

    public void cancel(Queue<?> queue) {
        queue.clear();
        for (h.o.a.d<T, R> dVar : this.subscribers) {
            dVar.unsubscribe();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, j<?> jVar, Queue<?> queue, boolean z3) {
        if (this.cancelled) {
            cancel(queue);
            return true;
        } else if (z) {
            if (z3) {
                if (z2) {
                    Throwable th = this.error.get();
                    if (th != null) {
                        jVar.onError(th);
                    } else {
                        jVar.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error.get();
            if (th2 != null) {
                cancel(queue);
                jVar.onError(th2);
                return true;
            } else if (z2) {
                jVar.onCompleted();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void combine(Object obj, int i) {
        boolean z;
        h.o.a.d<T, R> dVar = this.subscribers[i];
        synchronized (this) {
            int length = this.latest.length;
            Object obj2 = this.latest[i];
            int i2 = this.active;
            if (obj2 == MISSING) {
                i2++;
                this.active = i2;
            }
            int i3 = this.complete;
            if (obj == null) {
                i3++;
                this.complete = i3;
            } else {
                this.latest[i] = NotificationLite.e(obj);
            }
            boolean z2 = false;
            z = i2 == length;
            if (i3 == length || (obj == null && obj2 == MISSING)) {
                z2 = true;
            }
            if (z2) {
                this.done = true;
            } else if (obj != null && z) {
                this.queue.l(dVar, this.latest.clone());
            } else if (obj == null && this.error.get() != null && (obj2 == MISSING || !this.delayError)) {
                this.done = true;
            }
        }
        if (!z && obj != null) {
            dVar.b(1L);
        } else {
            drain();
        }
    }

    /* JADX DEBUG: Type inference failed for r1v13. Raw type applied. Possible types: R, ? super R */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
        if (r3 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
        if (r13 == Long.MAX_VALUE) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
        h.o.a.a.g(r10, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
        r12 = addAndGet(-r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
        if (r12 != 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        long j;
        if (getAndIncrement() != 0) {
            return;
        }
        d<Object> dVar = this.queue;
        j<? super R> jVar = this.actual;
        boolean z = this.delayError;
        AtomicLong atomicLong = this.requested;
        int i = 1;
        while (!checkTerminated(this.done, dVar.isEmpty(), jVar, dVar, z)) {
            long j2 = atomicLong.get();
            long j3 = 0;
            while (true) {
                if (j3 == j2) {
                    j = j3;
                    break;
                }
                boolean z2 = this.done;
                h.o.a.d dVar2 = (h.o.a.d) dVar.peek();
                boolean z3 = dVar2 == null;
                long j4 = j3;
                if (checkTerminated(z2, z3, jVar, dVar, z)) {
                    return;
                }
                if (z3) {
                    j = j4;
                    break;
                }
                dVar.poll();
                Object[] objArr = (Object[]) dVar.poll();
                if (objArr == null) {
                    this.cancelled = true;
                    cancel(dVar);
                    jVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                    return;
                }
                try {
                    jVar.onNext((R) this.combiner.call(objArr));
                    dVar2.b(1L);
                    j3 = j4 + 1;
                } catch (Throwable th) {
                    this.cancelled = true;
                    cancel(dVar);
                    jVar.onError(th);
                    return;
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.cancelled;
    }

    public void onError(Throwable th) {
        Throwable th2;
        Throwable th3;
        AtomicReference<Throwable> atomicReference = this.error;
        do {
            th2 = atomicReference.get();
            if (th2 == null) {
                th3 = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                th3 = new CompositeException(arrayList);
            } else {
                th3 = new CompositeException(Arrays.asList(th2, th));
            }
        } while (!atomicReference.compareAndSet(th2, th3));
    }

    @Override // h.f
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("n >= required but it was " + j);
        } else if (i != 0) {
            a.b(this.requested, j);
            drain();
        }
    }

    public void subscribe(h.d<? extends T>[] dVarArr) {
        h.o.a.d<T, R>[] dVarArr2 = this.subscribers;
        int length = dVarArr2.length;
        for (int i = 0; i < length; i++) {
            dVarArr2[i] = new h.o.a.d<>(this, i);
        }
        lazySet(0);
        this.actual.add(this);
        this.actual.setProducer(this);
        for (int i2 = 0; i2 < length && !this.cancelled; i2++) {
            dVarArr[i2].B(dVarArr2[i2]);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        if (getAndIncrement() == 0) {
            cancel(this.queue);
        }
    }
}
