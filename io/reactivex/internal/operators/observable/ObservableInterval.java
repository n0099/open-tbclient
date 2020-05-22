package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.k;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableInterval extends q<Long> {
    final long initialDelay;
    final long period;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super Long> uVar) {
        IntervalObserver intervalObserver = new IntervalObserver(uVar);
        uVar.onSubscribe(intervalObserver);
        v vVar = this.scheduler;
        if (vVar instanceof k) {
            v.c dKx = vVar.dKx();
            intervalObserver.setResource(dKx);
            dKx.b(intervalObserver, this.initialDelay, this.period, this.unit);
            return;
        }
        intervalObserver.setResource(vVar.a(intervalObserver, this.initialDelay, this.period, this.unit));
    }

    /* loaded from: classes7.dex */
    static final class IntervalObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        final u<? super Long> actual;
        long count;

        IntervalObserver(u<? super Long> uVar) {
            this.actual = uVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                u<? super Long> uVar = this.actual;
                long j = this.count;
                this.count = 1 + j;
                uVar.onNext(Long.valueOf(j));
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }
}
