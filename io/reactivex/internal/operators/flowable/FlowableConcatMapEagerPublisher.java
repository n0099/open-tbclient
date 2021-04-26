package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    public final ErrorMode errorMode;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public final Publisher<T> source;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
        this.source = publisher;
        this.mapper = function;
        this.maxConcurrency = i2;
        this.prefetch = i3;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
