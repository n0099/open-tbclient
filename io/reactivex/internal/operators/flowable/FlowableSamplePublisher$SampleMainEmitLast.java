package io.reactivex.internal.operators.flowable;

import g.d.b;
import g.d.c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableSamplePublisher$SampleMainEmitLast<T> extends FlowableSamplePublisher$SamplePublisherSubscriber<T> {
    public static final long serialVersionUID = -3029755663834015785L;
    public volatile boolean done;
    public final AtomicInteger wip;

    public FlowableSamplePublisher$SampleMainEmitLast(c<? super T> cVar, b<?> bVar) {
        super(cVar, bVar);
        this.wip = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
    public void completeMain() {
        this.done = true;
        if (this.wip.getAndIncrement() == 0) {
            emit();
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
    public void completeOther() {
        this.done = true;
        if (this.wip.getAndIncrement() == 0) {
            emit();
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
    public void run() {
        if (this.wip.getAndIncrement() == 0) {
            do {
                boolean z = this.done;
                emit();
                if (z) {
                    this.actual.onComplete();
                    return;
                }
            } while (this.wip.decrementAndGet() != 0);
        }
    }
}
