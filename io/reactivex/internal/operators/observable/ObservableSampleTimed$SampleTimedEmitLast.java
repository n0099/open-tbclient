package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.p;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSampleTimed$SampleTimedEmitLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    public static final long serialVersionUID = -7139995637533111443L;
    public final AtomicInteger wip;

    public ObservableSampleTimed$SampleTimedEmitLast(o<? super T> oVar, long j, TimeUnit timeUnit, p pVar) {
        super(oVar, j, timeUnit, pVar);
        this.wip = new AtomicInteger(1);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
    public void complete() {
        emit();
        if (this.wip.decrementAndGet() == 0) {
            this.actual.onComplete();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.wip.incrementAndGet() == 2) {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }
    }
}
