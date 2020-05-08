package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.k;
import io.reactivex.q;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableIntervalRange extends q<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final v scheduler;
    final long start;
    final TimeUnit unit;

    @Override // io.reactivex.q
    public void a(u<? super Long> uVar) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(uVar, this.start, this.end);
        uVar.onSubscribe(intervalRangeObserver);
        v vVar = this.scheduler;
        if (vVar instanceof k) {
            v.c dCC = vVar.dCC();
            intervalRangeObserver.setResource(dCC);
            dCC.b(intervalRangeObserver, this.initialDelay, this.period, this.unit);
            return;
        }
        intervalRangeObserver.setResource(vVar.a(intervalRangeObserver, this.initialDelay, this.period, this.unit));
    }

    /* loaded from: classes7.dex */
    static final class IntervalRangeObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        final u<? super Long> actual;
        long count;
        final long end;

        IntervalRangeObserver(u<? super Long> uVar, long j, long j2) {
            this.actual = uVar;
            this.count = j;
            this.end = j2;
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
            if (!isDisposed()) {
                long j = this.count;
                this.actual.onNext(Long.valueOf(j));
                if (j == this.end) {
                    DisposableHelper.dispose(this);
                    this.actual.onComplete();
                    return;
                }
                this.count = j + 1;
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }
}
