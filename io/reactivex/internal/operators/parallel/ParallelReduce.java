package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class ParallelReduce<T, R> extends ParallelFlowable<R> {
    public final Callable<R> initialSupplier;
    public final BiFunction<R, ? super T, R> reducer;
    public final ParallelFlowable<? extends T> source;

    /* loaded from: classes7.dex */
    public static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        public static final long serialVersionUID = 8200530050639449080L;
        public R accumulator;
        public boolean done;
        public final BiFunction<R, ? super T, R> reducer;

        public ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r, BiFunction<R, ? super T, R> biFunction) {
            super(subscriber);
            this.accumulator = r;
            this.reducer = biFunction;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            R r = this.accumulator;
            this.accumulator = null;
            complete(r);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.accumulator = null;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.accumulator = (R) ObjectHelper.requireNonNull(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public ParallelReduce(ParallelFlowable<? extends T> parallelFlowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = parallelFlowable;
        this.initialSupplier = callable;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    public void reportError(Subscriber<?>[] subscriberArr, Throwable th) {
        for (Subscriber<?> subscriber : subscriberArr) {
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super Object>[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    subscriberArr2[i2] = new ParallelReduceSubscriber(subscriberArr[i2], ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value"), this.reducer);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    reportError(subscriberArr, th);
                    return;
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
