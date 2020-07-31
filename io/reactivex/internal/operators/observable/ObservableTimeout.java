package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.f;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimeout<T, U, V> extends io.reactivex.internal.operators.observable.a<T, T> {
    final t<U> firstTimeoutIndicator;
    final h<? super T, ? extends t<V>> itemTimeoutIndicator;
    final t<? extends T> other;

    /* loaded from: classes7.dex */
    interface a {
        void innerError(Throwable th);

        void timeout(long j);
    }

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        if (this.other == null) {
            this.source.subscribe(new TimeoutObserver(new io.reactivex.observers.b(uVar), this.firstTimeoutIndicator, this.itemTimeoutIndicator));
        } else {
            this.source.subscribe(new TimeoutOtherObserver(uVar, this.firstTimeoutIndicator, this.itemTimeoutIndicator, this.other));
        }
    }

    /* loaded from: classes7.dex */
    static final class TimeoutObserver<T, U, V> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, a, u<T> {
        private static final long serialVersionUID = 2672739326310051084L;
        final u<? super T> actual;
        final t<U> firstTimeoutIndicator;
        volatile long index;
        final h<? super T, ? extends t<V>> itemTimeoutIndicator;
        io.reactivex.disposables.b s;

        TimeoutObserver(u<? super T> uVar, t<U> tVar, h<? super T, ? extends t<V>> hVar) {
            this.actual = uVar;
            this.firstTimeoutIndicator = tVar;
            this.itemTimeoutIndicator = hVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                u<? super T> uVar = this.actual;
                t<U> tVar = this.firstTimeoutIndicator;
                if (tVar != null) {
                    b bVar2 = new b(this, 0L);
                    if (compareAndSet(null, bVar2)) {
                        uVar.onSubscribe(this);
                        tVar.subscribe(bVar2);
                        return;
                    }
                    return;
                }
                uVar.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            long j = 1 + this.index;
            this.index = j;
            this.actual.onNext(t);
            io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                t tVar = (t) io.reactivex.internal.functions.a.k(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                b bVar2 = new b(this, j);
                if (compareAndSet(bVar, bVar2)) {
                    tVar.subscribe(bVar2);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void timeout(long j) {
            if (j == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    static final class b<T, U, V> extends io.reactivex.observers.a<Object> {
        boolean done;
        final long index;
        final a nUz;

        b(a aVar, long j) {
            this.nUz = aVar;
            this.index = j;
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            if (!this.done) {
                this.done = true;
                dispose();
                this.nUz.timeout(this.index);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.nUz.innerError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.nUz.timeout(this.index);
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class TimeoutOtherObserver<T, U, V> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, a, u<T> {
        private static final long serialVersionUID = -1957813281749686898L;
        final u<? super T> actual;
        final f<T> arbiter;
        boolean done;
        final t<U> firstTimeoutIndicator;
        volatile long index;
        final h<? super T, ? extends t<V>> itemTimeoutIndicator;
        final t<? extends T> other;
        io.reactivex.disposables.b s;

        TimeoutOtherObserver(u<? super T> uVar, t<U> tVar, h<? super T, ? extends t<V>> hVar, t<? extends T> tVar2) {
            this.actual = uVar;
            this.firstTimeoutIndicator = tVar;
            this.itemTimeoutIndicator = hVar;
            this.other = tVar2;
            this.arbiter = new f<>(uVar, this, 8);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.arbiter.d(bVar);
                u<? super T> uVar = this.actual;
                t<U> tVar = this.firstTimeoutIndicator;
                if (tVar != null) {
                    b bVar2 = new b(this, 0L);
                    if (compareAndSet(null, bVar2)) {
                        uVar.onSubscribe(this.arbiter);
                        tVar.subscribe(bVar2);
                        return;
                    }
                    return;
                }
                uVar.onSubscribe(this.arbiter);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                long j = 1 + this.index;
                this.index = j;
                if (this.arbiter.a((f<T>) t, this.s)) {
                    io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    try {
                        t tVar = (t) io.reactivex.internal.functions.a.k(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                        b bVar2 = new b(this, j);
                        if (compareAndSet(bVar, bVar2)) {
                            tVar.subscribe(bVar2);
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.K(th);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.a(th, this.s);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                dispose();
                this.arbiter.e(this.s);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (DisposableHelper.dispose(this)) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void timeout(long j) {
            if (j == this.index) {
                dispose();
                this.other.subscribe(new io.reactivex.internal.observers.b(this.arbiter));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void innerError(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }
    }
}
