package io.reactivex.internal.operators.flowable;

import f.b.p;
import g.d.c;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class FlowableSampleTimed$SampleTimedNoLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    public static final long serialVersionUID = -7139995637533111443L;

    public FlowableSampleTimed$SampleTimedNoLast(c<? super T> cVar, long j, TimeUnit timeUnit, p pVar) {
        super(cVar, j, timeUnit, pVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
    public void complete() {
        this.actual.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}
