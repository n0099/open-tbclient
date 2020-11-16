package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableSampleWithObservable<T> extends io.reactivex.internal.operators.observable.a<T, T> {
    final t<?> other;
    final boolean pPc;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        io.reactivex.observers.b bVar = new io.reactivex.observers.b(uVar);
        if (this.pPc) {
            this.source.subscribe(new SampleMainEmitLast(bVar, this.other));
        } else {
            this.source.subscribe(new SampleMainNoLast(bVar, this.other));
        }
    }

    /* loaded from: classes5.dex */
    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -3517602651313910099L;
        final u<? super T> actual;
        final AtomicReference<io.reactivex.disposables.b> other = new AtomicReference<>();
        io.reactivex.disposables.b s;
        final t<?> sampler;

        abstract void completeMain();

        abstract void completeOther();

        abstract void run();

        SampleMainObserver(u<? super T> uVar, t<?> tVar) {
            this.actual = uVar;
            this.sampler = tVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new a(this));
                }
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completeMain();
        }

        boolean setOther(io.reactivex.disposables.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        public void error(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        public void complete() {
            this.s.dispose();
            completeOther();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class a<T> implements u<Object> {
        final SampleMainObserver<T> pQa;

        a(SampleMainObserver<T> sampleMainObserver) {
            this.pQa = sampleMainObserver;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.pQa.setOther(bVar);
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            this.pQa.run();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.pQa.error(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.pQa.complete();
        }
    }

    /* loaded from: classes5.dex */
    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(u<? super T> uVar, t<?> tVar) {
            super(uVar, tVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            emit();
        }
    }

    /* loaded from: classes5.dex */
    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(u<? super T> uVar, t<?> tVar) {
            super(uVar, tVar);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }
}
