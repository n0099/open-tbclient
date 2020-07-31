package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleObserveOn<T> extends w<T> {
    final v scheduler;
    final aa<T> source;

    @Override // io.reactivex.w
    protected void b(y<? super T> yVar) {
        this.source.a(new ObserveOnSingleObserver(yVar, this.scheduler));
    }

    /* loaded from: classes7.dex */
    static final class ObserveOnSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T>, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final y<? super T> actual;
        Throwable error;
        final v scheduler;
        T value;

        ObserveOnSingleObserver(y<? super T> yVar, v vVar) {
            this.actual = yVar;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.value = t;
            DisposableHelper.replace(this, this.scheduler.I(this));
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.I(this));
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onSuccess((T) this.value);
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
    }
}
