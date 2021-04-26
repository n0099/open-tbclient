package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {
    public final boolean delayError;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public final ParallelFlowable<T> source;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        this.source = parallelFlowable;
        this.mapper = function;
        this.delayError = z;
        this.maxConcurrency = i2;
        this.prefetch = i3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                subscriberArr2[i2] = FlowableFlatMap.subscribe(subscriberArr[i2], this.mapper, this.delayError, this.maxConcurrency, this.prefetch);
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
