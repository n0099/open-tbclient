package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public final Callable<? extends R> onCompleteSupplier;
    public final Function<? super Throwable, ? extends R> onErrorMapper;
    public final Function<? super T, ? extends R> onNextMapper;

    /* loaded from: classes7.dex */
    public static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        public static final long serialVersionUID = 2757120512858778108L;
        public final Callable<? extends R> onCompleteSupplier;
        public final Function<? super Throwable, ? extends R> onErrorMapper;
        public final Function<? super T, ? extends R> onNextMapper;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
            super(subscriber);
            this.onNextMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                complete(ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                complete(ObjectHelper.requireNonNull(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Object requireNonNull = ObjectHelper.requireNonNull(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.actual.onNext(requireNonNull);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }
    }

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
        super(flowable);
        this.onNextMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new MapNotificationSubscriber(subscriber, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }
}
