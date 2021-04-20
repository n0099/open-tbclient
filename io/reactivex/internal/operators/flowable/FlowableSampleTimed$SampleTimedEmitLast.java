package io.reactivex.internal.operators.flowable;

import f.b.p;
import g.d.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableSampleTimed$SampleTimedEmitLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    public static final long serialVersionUID = -7139995637533111443L;
    public final AtomicInteger wip;

    public FlowableSampleTimed$SampleTimedEmitLast(c<? super T> cVar, long j, TimeUnit timeUnit, p pVar) {
        super(cVar, j, timeUnit, pVar);
        this.wip = new AtomicInteger(1);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
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
