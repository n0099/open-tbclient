package io.reactivex.subjects;

import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class UnicastSubject<T> extends b<T> {
    final AtomicReference<u<? super T>> actual;
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    Throwable error;
    final AtomicBoolean once;
    boolean pJA;
    final BasicIntQueueDisposable<T> pJV;
    final AtomicReference<Runnable> pJy;
    final io.reactivex.internal.queue.a<T> queue;

    public static <T> UnicastSubject<T> eDC() {
        return new UnicastSubject<>(eCR(), true);
    }

    public static <T> UnicastSubject<T> d(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    UnicastSubject(int i, boolean z) {
        this.queue = new io.reactivex.internal.queue.a<>(io.reactivex.internal.functions.a.cb(i, "capacityHint"));
        this.pJy = new AtomicReference<>();
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.pJV = new UnicastQueueDisposable();
    }

    UnicastSubject(int i, Runnable runnable, boolean z) {
        this.queue = new io.reactivex.internal.queue.a<>(io.reactivex.internal.functions.a.cb(i, "capacityHint"));
        this.pJy = new AtomicReference<>(io.reactivex.internal.functions.a.m(runnable, "onTerminate"));
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.pJV = new UnicastQueueDisposable();
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            uVar.onSubscribe(this.pJV);
            this.actual.lazySet(uVar);
            if (this.disposed) {
                this.actual.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), uVar);
    }

    void doTerminate() {
        Runnable runnable = this.pJy.get();
        if (runnable != null && this.pJy.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.done || this.disposed) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        io.reactivex.internal.functions.a.m(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done && !this.disposed) {
            this.queue.offer(t);
            drain();
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.m(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done || this.disposed) {
            io.reactivex.d.a.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // io.reactivex.u
    public void onComplete() {
        if (!this.done && !this.disposed) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    void c(u<? super T> uVar) {
        io.reactivex.internal.queue.a<T> aVar = this.queue;
        boolean z = !this.delayError;
        boolean z2 = true;
        int i = 1;
        while (!this.disposed) {
            boolean z3 = this.done;
            Object obj = (T) this.queue.poll();
            boolean z4 = obj == null;
            if (z3) {
                if (z && z2) {
                    if (a(aVar, uVar)) {
                        return;
                    }
                    z2 = false;
                }
                if (z4) {
                    e(uVar);
                    return;
                }
            }
            if (!z4) {
                uVar.onNext(obj);
            } else {
                i = this.pJV.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
        this.actual.lazySet(null);
        aVar.clear();
    }

    void d(u<? super T> uVar) {
        int i = 1;
        io.reactivex.internal.queue.a<T> aVar = this.queue;
        boolean z = !this.delayError;
        while (!this.disposed) {
            boolean z2 = this.done;
            if (!z || !z2 || !a(aVar, uVar)) {
                uVar.onNext(null);
                if (z2) {
                    e(uVar);
                    return;
                }
                i = this.pJV.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.actual.lazySet(null);
        aVar.clear();
    }

    void e(u<? super T> uVar) {
        this.actual.lazySet(null);
        Throwable th = this.error;
        if (th != null) {
            uVar.onError(th);
        } else {
            uVar.onComplete();
        }
    }

    boolean a(f<T> fVar, u<? super T> uVar) {
        Throwable th = this.error;
        if (th != null) {
            this.actual.lazySet(null);
            fVar.clear();
            uVar.onError(th);
            return true;
        }
        return false;
    }

    void drain() {
        if (this.pJV.getAndIncrement() == 0) {
            u<? super T> uVar = this.actual.get();
            int i = 1;
            while (uVar == null) {
                int addAndGet = this.pJV.addAndGet(-i);
                if (addAndGet != 0) {
                    uVar = this.actual.get();
                    i = addAndGet;
                } else {
                    return;
                }
            }
            if (this.pJA) {
                d(uVar);
            } else {
                c(uVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.pJA = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() throws Exception {
            return UnicastSubject.this.queue.poll();
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return UnicastSubject.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            UnicastSubject.this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!UnicastSubject.this.disposed) {
                UnicastSubject.this.disposed = true;
                UnicastSubject.this.doTerminate();
                UnicastSubject.this.actual.lazySet(null);
                if (UnicastSubject.this.pJV.getAndIncrement() == 0) {
                    UnicastSubject.this.actual.lazySet(null);
                    UnicastSubject.this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return UnicastSubject.this.disposed;
        }
    }
}
