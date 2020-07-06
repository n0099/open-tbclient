package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.a<T, T> {
    final v scheduler;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(mVar);
        mVar.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.scheduler.J(new a(subscribeOnMaybeObserver, this.source)));
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements Runnable {
        final m<? super T> nLp;
        final o<T> source;

        a(m<? super T> mVar, o<T> oVar) {
            this.nLp = mVar;
            this.source = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this.nLp);
        }
    }

    /* loaded from: classes7.dex */
    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 8571289934935992137L;
        final m<? super T> actual;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnMaybeObserver(m<? super T> mVar) {
            this.actual = mVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
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
