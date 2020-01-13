package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class MaybeUnsubscribeOn<T> extends a<T, T> {
    final v scheduler;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new UnsubscribeOnMaybeObserver(mVar, this.scheduler));
    }

    /* loaded from: classes5.dex */
    static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final m<? super T> actual;
        io.reactivex.disposables.b ds;
        final v scheduler;

        UnsubscribeOnMaybeObserver(m<? super T> mVar, v vVar) {
            this.actual = mVar;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b andSet = getAndSet(DisposableHelper.DISPOSED);
            if (andSet != DisposableHelper.DISPOSED) {
                this.ds = andSet;
                this.scheduler.C(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
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
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
