package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function<? super T, ? extends Publisher<? extends U>> mapper;
    public final int maxConcurrency;
    public final Publisher<T> source;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i2, int i3) {
        this.source = publisher;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i2;
        this.bufferSize = i3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableFlatMap.subscribe(subscriber, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
