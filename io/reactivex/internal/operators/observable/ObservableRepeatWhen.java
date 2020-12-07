package io.reactivex.internal.operators.observable;

import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.q;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ObservableRepeatWhen<T> extends a<T, T> {
    final h<? super q<Object>, ? extends t<?>> pFN;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        io.reactivex.subjects.b<T> eDB = PublishSubject.eDA().eDB();
        try {
            t tVar = (t) io.reactivex.internal.functions.a.m(this.pFN.apply(eDB), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(uVar, eDB, this.source);
            uVar.onSubscribe(repeatWhenObserver);
            tVar.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            EmptyDisposable.error(th, uVar);
        }
    }

    /* loaded from: classes9.dex */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final u<? super T> actual;
        final io.reactivex.subjects.b<Object> signaller;
        final t<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final AtomicThrowable error = new AtomicThrowable();
        final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        final AtomicReference<io.reactivex.disposables.b> d = new AtomicReference<>();

        RepeatWhenObserver(u<? super T> uVar, io.reactivex.subjects.b<Object> bVar, t<T> tVar) {
            this.actual = uVar;
            this.signaller = bVar;
            this.source = tVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.d, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            e.a(this.actual, t, this, this.error);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.inner);
            e.a((u<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.d.get());
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.d);
            DisposableHelper.dispose(this.inner);
        }

        void innerNext() {
            subscribeNext();
        }

        void innerError(Throwable th) {
            DisposableHelper.dispose(this.d);
            e.a((u<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerComplete() {
            DisposableHelper.dispose(this.d);
            e.a(this.actual, this, this.error);
        }

        void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        final class InnerRepeatObserver extends AtomicReference<io.reactivex.disposables.b> implements u<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            @Override // io.reactivex.u
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.u
            public void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            @Override // io.reactivex.u
            public void onError(Throwable th) {
                RepeatWhenObserver.this.innerError(th);
            }

            @Override // io.reactivex.u
            public void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }
        }
    }
}
