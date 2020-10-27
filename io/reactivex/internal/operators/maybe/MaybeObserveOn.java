package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public final class MaybeObserveOn<T> extends a<T, T> {
    final v scheduler;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new ObserveOnMaybeObserver(mVar, this.scheduler));
    }

    /* loaded from: classes17.dex */
    static final class ObserveOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final m<? super T> actual;
        Throwable error;
        final v scheduler;
        T value;

        ObserveOnMaybeObserver(m<? super T> mVar, v vVar) {
            this.actual = mVar;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.value = t;
            DisposableHelper.replace(this, this.scheduler.H(this));
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.H(this));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.H(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.value = null;
                this.actual.onSuccess(t);
                return;
            }
            this.actual.onComplete();
        }
    }
}
