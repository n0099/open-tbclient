package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTimer extends k<Long> {
    final long delay;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.k
    protected void b(m<? super Long> mVar) {
        TimerDisposable timerDisposable = new TimerDisposable(mVar);
        mVar.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.b(timerDisposable, this.delay, this.unit));
    }

    /* loaded from: classes7.dex */
    static final class TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final m<? super Long> actual;

        TimerDisposable(m<? super Long> mVar) {
            this.actual = mVar;
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
