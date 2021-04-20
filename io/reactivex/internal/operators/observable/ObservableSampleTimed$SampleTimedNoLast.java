package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.p;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class ObservableSampleTimed$SampleTimedNoLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    public static final long serialVersionUID = -7139995637533111443L;

    public ObservableSampleTimed$SampleTimedNoLast(o<? super T> oVar, long j, TimeUnit timeUnit, p pVar) {
        super(oVar, j, timeUnit, pVar);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
    public void complete() {
        this.actual.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
