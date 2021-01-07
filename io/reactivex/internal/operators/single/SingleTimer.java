package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class SingleTimer extends w<Long> {
    final long delay;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.w
    protected void b(y<? super Long> yVar) {
        TimerDisposable timerDisposable = new TimerDisposable(yVar);
        yVar.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.b(timerDisposable, this.delay, this.unit));
    }

    /* loaded from: classes5.dex */
    static final class TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final y<? super Long> actual;

        TimerDisposable(y<? super Long> yVar) {
            this.actual = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.actual.onSuccess(0L);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        void setFuture(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }
}
