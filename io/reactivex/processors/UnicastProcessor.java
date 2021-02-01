package io.reactivex.processors;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public final class UnicastProcessor<T> extends a<T> {
    final AtomicReference<c<? super T>> actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final AtomicBoolean once;
    final AtomicReference<Runnable> qso;
    final BasicIntQueueSubscription<T> qsp;
    boolean qsq;
    final io.reactivex.internal.queue.a<T> queue;
    final AtomicLong requested;

    public static <T> UnicastProcessor<T> eKJ() {
        return new UnicastProcessor<>(eKe());
    }

    public static <T> UnicastProcessor<T> Sq(int i) {
        return new UnicastProcessor<>(i);
    }

    public static <T> UnicastProcessor<T> c(int i, Runnable runnable) {
        io.reactivex.internal.functions.a.m(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    UnicastProcessor(int i) {
        this(i, null, true);
    }

    UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.queue = new io.reactivex.internal.queue.a<>(io.reactivex.internal.functions.a.cl(i, "capacityHint"));
        this.qso = new AtomicReference<>(runnable);
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.qsp = new UnicastQueueSubscription();
        this.requested = new AtomicLong();
    }

    void doTerminate() {
        Runnable runnable = this.qso.get();
        if (runnable != null && this.qso.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    void c(c<? super T> cVar) {
        long j;
        int i = 1;
        io.reactivex.internal.queue.a<T> aVar = this.queue;
        boolean z = !this.delayError;
        while (true) {
            int i2 = i;
            long j2 = this.requested.get();
            long j3 = 0;
            while (true) {
                j = j3;
                if (j2 == j) {
                    break;
                }
                boolean z2 = this.done;
                T poll = aVar.poll();
                boolean z3 = poll == null;
                if (!a(z, z2, z3, cVar, aVar)) {
                    if (z3) {
                        break;
                    }
                    cVar.onNext(poll);
                    j3 = 1 + j;
                } else {
                    return;
                }
            }
            if (j2 != j || !a(z, this.done, aVar.isEmpty(), cVar, aVar)) {
                if (j != 0 && j2 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j);
                }
                i = this.qsp.addAndGet(-i2);
                if (i == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    void d(c<? super T> cVar) {
        int i = 1;
        io.reactivex.internal.queue.a<T> aVar = this.queue;
        boolean z = !this.delayError;
        while (!this.cancelled) {
            boolean z2 = this.done;
            if (z && z2 && this.error != null) {
                aVar.clear();
                this.actual.lazySet(null);
                cVar.onError(this.error);
                return;
            }
            cVar.onNext(null);
            if (z2) {
                this.actual.lazySet(null);
                Throwable th = this.error;
                if (th != null) {
                    cVar.onError(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            i = this.qsp.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        aVar.clear();
        this.actual.lazySet(null);
    }

    void drain() {
        if (this.qsp.getAndIncrement() == 0) {
            int i = 1;
            c<? super T> cVar = this.actual.get();
            while (cVar == null) {
                i = this.qsp.addAndGet(-i);
                if (i != 0) {
                    cVar = this.actual.get();
                } else {
                    return;
                }
            }
            if (this.qsq) {
                d(cVar);
            } else {
                c(cVar);
            }
        }
    }

    boolean a(boolean z, boolean z2, boolean z3, c<? super T> cVar, io.reactivex.internal.queue.a<T> aVar) {
        if (this.cancelled) {
            aVar.clear();
            this.actual.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.error != null) {
                aVar.clear();
                this.actual.lazySet(null);
                cVar.onError(this.error);
                return true;
            } else if (z3) {
                Throwable th = this.error;
                this.actual.lazySet(null);
                if (th != null) {
                    cVar.onError(th);
                    return true;
                }
                cVar.onComplete();
                return true;
            }
        }
        return false;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (this.done || this.cancelled) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        io.reactivex.internal.functions.a.m(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.cancelled) {
            this.queue.offer(t);
            drain();
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.m(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.cancelled) {
            io.reactivex.d.a.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.a.c
    public void onComplete() {
        if (!this.done && !this.cancelled) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            cVar.onSubscribe(this.qsp);
            this.actual.set(cVar);
            if (this.cancelled) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
    }

    /* loaded from: classes5.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return UnicastProcessor.this.queue.poll();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return UnicastProcessor.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            UnicastProcessor.this.queue.clear();
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.qsq = true;
                return 2;
            }
            return 0;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(UnicastProcessor.this.requested, j);
                UnicastProcessor.this.drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!UnicastProcessor.this.cancelled) {
                UnicastProcessor.this.cancelled = true;
                UnicastProcessor.this.doTerminate();
                if (!UnicastProcessor.this.qsq && UnicastProcessor.this.qsp.getAndIncrement() == 0) {
                    UnicastProcessor.this.queue.clear();
                    UnicastProcessor.this.actual.lazySet(null);
                }
            }
        }
    }
}
