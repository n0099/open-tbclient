package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CompletableTimer extends a {
    final long delay;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        TimerDisposable timerDisposable = new TimerDisposable(cVar);
        cVar.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.b(timerDisposable, this.delay, this.unit));
    }

    /* loaded from: classes9.dex */
    static final class TimerDisposable extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final c actual;

        TimerDisposable(c cVar) {
            this.actual = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void setFuture(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }
}
