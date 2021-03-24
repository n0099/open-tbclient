package io.reactivex.internal.operators.flowable;

import g.d.b;
import g.d.c;
/* loaded from: classes7.dex */
public final class FlowableSamplePublisher$SampleMainNoLast<T> extends FlowableSamplePublisher$SamplePublisherSubscriber<T> {
    public static final long serialVersionUID = -3029755663834015785L;

    public FlowableSamplePublisher$SampleMainNoLast(c<? super T> cVar, b<?> bVar) {
        super(cVar, bVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
    public void completeMain() {
        this.actual.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
    public void completeOther() {
        this.actual.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber
    public void run() {
        emit();
    }
}
