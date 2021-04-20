package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
import f.b.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatMap$SourceObserver<T, U> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = 8828587559905699186L;
    public volatile boolean active;
    public final o<? super U> actual;
    public final int bufferSize;
    public volatile boolean disposed;
    public volatile boolean done;
    public int fusionMode;
    public final InnerObserver<U> inner;
    public final h<? super T, ? extends n<? extends U>> mapper;
    public f<T> queue;
    public b s;

    /* loaded from: classes7.dex */
    public static final class InnerObserver<U> extends AtomicReference<b> implements o<U> {
        public static final long serialVersionUID = -7449079488798789337L;
        public final o<? super U> actual;
        public final ObservableConcatMap$SourceObserver<?, ?> parent;

        public InnerObserver(o<? super U> oVar, ObservableConcatMap$SourceObserver<?, ?> observableConcatMap$SourceObserver) {
            this.actual = oVar;
            this.parent = observableConcatMap$SourceObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.b.o
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // f.b.o
        public void onError(Throwable th) {
            this.parent.dispose();
            this.actual.onError(th);
        }

        @Override // f.b.o
        public void onNext(U u) {
            this.actual.onNext(u);
        }

        @Override // f.b.o
        public void onSubscribe(b bVar) {
            DisposableHelper.set(this, bVar);
        }
    }

    public ObservableConcatMap$SourceObserver(o<? super U> oVar, h<? super T, ? extends n<? extends U>> hVar, int i) {
        this.actual = oVar;
        this.mapper = hVar;
        this.bufferSize = i;
        this.inner = new InnerObserver<>(oVar, this);
    }

    @Override // f.b.t.b
    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        this.s.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!this.disposed) {
            if (!this.active) {
                boolean z = this.done;
                try {
                    T poll = this.queue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        this.disposed = true;
                        this.actual.onComplete();
                        return;
                    } else if (!z2) {
                        try {
                            n<? extends U> apply = this.mapper.apply(poll);
                            a.b(apply, "The mapper returned a null ObservableSource");
                            n<? extends U> nVar = apply;
                            this.active = true;
                            nVar.subscribe(this.inner);
                        } catch (Throwable th) {
                            f.b.u.a.a(th);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    f.b.u.a.a(th2);
                    dispose();
                    this.queue.clear();
                    this.actual.onError(th2);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.queue.clear();
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.done) {
            f.b.a0.a.f(th);
            return;
        }
        this.done = true;
        dispose();
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.fusionMode == 0) {
            this.queue.offer(t);
        }
        drain();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            if (bVar instanceof f.b.x.c.b) {
                f.b.x.c.b bVar2 = (f.b.x.c.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.actual.onSubscribe(this);
                    return;
                }
            }
            this.queue = new f.b.x.f.a(this.bufferSize);
            this.actual.onSubscribe(this);
        }
    }
}
