package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class FlowableTakePublisher<T> extends Flowable<T> {
    public final long limit;
    public final Publisher<T> source;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.source = publisher;
        this.limit = j;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.limit));
    }
}
