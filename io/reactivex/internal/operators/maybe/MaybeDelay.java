package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class MaybeDelay<T> extends a<T, T> {
    final long delay;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new DelayMaybeObserver(mVar, this.delay, this.unit, this.scheduler));
    }

    /* loaded from: classes25.dex */
    static final class DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final m<? super T> actual;
        final long delay;
        Throwable error;
        final v scheduler;
        final TimeUnit unit;
        T value;

        DelayMaybeObserver(m<? super T> mVar, long j, TimeUnit timeUnit, v vVar) {
            this.actual = mVar;
            this.delay = j;
            this.unit = timeUnit;
            this.scheduler = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
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
            schedule();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.error = th;
            schedule();
        }

        @Override // io.reactivex.m
        public void onComplete() {
            schedule();
        }

        void schedule() {
            DisposableHelper.replace(this, this.scheduler.b(this, this.delay, this.unit));
        }
    }
}
