package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class SingleTimeout<T> extends w<T> {
    final aa<? extends T> other;
    final v scheduler;
    final aa<T> source;
    final long timeout;
    final TimeUnit unit;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(yVar, this.other);
        yVar.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.task, this.scheduler.b(timeoutMainObserver, this.timeout, this.unit));
        this.source.a(timeoutMainObserver);
    }

    /* loaded from: classes25.dex */
    static final class TimeoutMainObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T>, Runnable {
        private static final long serialVersionUID = 37497744973048446L;
        final y<? super T> actual;
        final TimeoutFallbackObserver<T> fallback;
        aa<? extends T> other;
        final AtomicReference<io.reactivex.disposables.b> task = new AtomicReference<>();

        /* loaded from: classes25.dex */
        static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements y<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final y<? super T> actual;

            TimeoutFallbackObserver(y<? super T> yVar) {
                this.actual = yVar;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(T t) {
                this.actual.onSuccess(t);
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.actual.onError(th);
            }
        }

        TimeoutMainObserver(y<? super T> yVar, aa<? extends T> aaVar) {
            this.actual = yVar;
            this.other = aaVar;
            if (aaVar != null) {
                this.fallback = new TimeoutFallbackObserver<>(yVar);
            } else {
                this.fallback = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.disposables.b bVar = get();
            if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, DisposableHelper.DISPOSED)) {
                if (bVar != null) {
                    bVar.dispose();
                }
                aa<? extends T> aaVar = this.other;
                if (aaVar == null) {
                    this.actual.onError(new TimeoutException());
                    return;
                }
                this.other = null;
                aaVar.a(this.fallback);
            }
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, DisposableHelper.DISPOSED)) {
                DisposableHelper.dispose(this.task);
                this.actual.onSuccess(t);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            io.reactivex.disposables.b bVar = get();
            if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, DisposableHelper.DISPOSED)) {
                DisposableHelper.dispose(this.task);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            if (this.fallback != null) {
                DisposableHelper.dispose(this.fallback);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}
