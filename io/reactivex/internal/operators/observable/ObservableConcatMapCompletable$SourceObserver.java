package io.reactivex.internal.operators.observable;

import f.a.c;
import f.a.o;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import f.a.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatMapCompletable$SourceObserver<T> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = 6893587405571511048L;
    public volatile boolean active;
    public final f.a.b actual;
    public final int bufferSize;
    public volatile boolean disposed;
    public volatile boolean done;
    public final InnerObserver inner;
    public final h<? super T, ? extends c> mapper;
    public f<T> queue;
    public b s;
    public int sourceMode;

    /* loaded from: classes7.dex */
    public static final class InnerObserver extends AtomicReference<b> implements f.a.b {
        public static final long serialVersionUID = -5987419458390772447L;
        public final f.a.b actual;
        public final ObservableConcatMapCompletable$SourceObserver<?> parent;

        public InnerObserver(f.a.b bVar, ObservableConcatMapCompletable$SourceObserver<?> observableConcatMapCompletable$SourceObserver) {
            this.actual = bVar;
            this.parent = observableConcatMapCompletable$SourceObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.a.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // f.a.b
        public void onError(Throwable th) {
            this.parent.dispose();
            this.actual.onError(th);
        }

        @Override // f.a.b
        public void onSubscribe(b bVar) {
            DisposableHelper.set(this, bVar);
        }
    }

    public ObservableConcatMapCompletable$SourceObserver(f.a.b bVar, h<? super T, ? extends c> hVar, int i) {
        this.actual = bVar;
        this.mapper = hVar;
        this.bufferSize = i;
        this.inner = new InnerObserver(bVar, this);
    }

    @Override // f.a.t.b
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
                            c apply = this.mapper.apply(poll);
                            a.b(apply, "The mapper returned a null CompletableSource");
                            c cVar = apply;
                            this.active = true;
                            cVar.a(this.inner);
                        } catch (Throwable th) {
                            f.a.u.a.a(th);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    f.a.u.a.a(th2);
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

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.disposed;
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.done) {
            f.a.a0.a.f(th);
            return;
        }
        this.done = true;
        dispose();
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 0) {
            this.queue.offer(t);
        }
        drain();
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            if (bVar instanceof f.a.x.c.b) {
                f.a.x.c.b bVar2 = (f.a.x.c.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.actual.onSubscribe(this);
                    return;
                }
            }
            this.queue = new f.a.x.f.a(this.bufferSize);
            this.actual.onSubscribe(this);
        }
    }
}
