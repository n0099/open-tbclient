package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes17.dex */
public final class ObservableUnsubscribeOn<T> extends a<T, T> {
    final v scheduler;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        this.source.subscribe(new UnsubscribeObserver(uVar, this.scheduler));
    }

    /* loaded from: classes17.dex */
    static final class UnsubscribeObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 1015244841293359600L;
        final u<? super T> actual;
        io.reactivex.disposables.b s;
        final v scheduler;

        UnsubscribeObserver(u<? super T> uVar, v vVar) {
            this.actual = uVar;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!get()) {
                this.actual.onNext(t);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.e.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.H(new a());
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        /* loaded from: classes17.dex */
        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.s.dispose();
            }
        }
    }
}
