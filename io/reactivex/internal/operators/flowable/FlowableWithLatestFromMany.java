package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super Object[], R> combiner;
    @Nullable
    public final Publisher<?>[] otherArray;
    @Nullable
    public final Iterable<? extends Publisher<?>> otherIterable;

    /* loaded from: classes8.dex */
    public final class SingletonArrayFunc implements Function<T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FlowableWithLatestFromMany this$0;

        public SingletonArrayFunc(FlowableWithLatestFromMany flowableWithLatestFromMany) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowableWithLatestFromMany};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flowableWithLatestFromMany;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
                return (R) ObjectHelper.requireNonNull(this.this$0.combiner.apply(new Object[]{t}), "The combiner returned a null value");
            }
            return (R) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1577321883966341961L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public final Function<? super Object[], R> combiner;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final AtomicLong requested;
        public final AtomicReference<Subscription> s;
        public final WithLatestInnerSubscriber[] subscribers;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.combiner = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i];
            for (int i4 = 0; i4 < i; i4++) {
                withLatestInnerSubscriberArr[i4] = new WithLatestInnerSubscriber(this, i4);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new AtomicReferenceArray<>(i);
            this.s = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this.s);
                for (WithLatestInnerSubscriber withLatestInnerSubscriber : this.subscribers) {
                    withLatestInnerSubscriber.dispose();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.done) {
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onComplete(this.actual, this, this.error);
            }
        }

        public void cancelAllBut(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
                for (int i2 = 0; i2 < withLatestInnerSubscriberArr.length; i2++) {
                    if (i2 != i) {
                        withLatestInnerSubscriberArr[i2].dispose();
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && !tryOnNext(t) && !this.done) {
                this.s.get().request(1L);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subscription) == null) {
                SubscriptionHelper.deferredSetOnce(this.s, this.requested, subscription);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
                SubscriptionHelper.deferredRequest(this.s, this.requested, j);
            }
        }

        public void innerComplete(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && !z) {
                this.done = true;
                SubscriptionHelper.cancel(this.s);
                cancelAllBut(i);
                HalfSerializer.onComplete(this.actual, this, this.error);
            }
        }

        public void innerError(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, th) == null) {
                this.done = true;
                SubscriptionHelper.cancel(this.s);
                cancelAllBut(i);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        public void innerNext(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, obj) == null) {
                this.values.set(i, obj);
            }
        }

        public void subscribe(Publisher<?>[] publisherArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, publisherArr, i) == null) {
                WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
                AtomicReference<Subscription> atomicReference = this.s;
                for (int i2 = 0; i2 < i && !SubscriptionHelper.isCancelled(atomicReference.get()); i2++) {
                    publisherArr[i2].subscribe(withLatestInnerSubscriberArr[i2]);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, t)) == null) {
                if (this.done) {
                    return false;
                }
                AtomicReferenceArray<Object> atomicReferenceArray = this.values;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[length + 1];
                objArr[0] = t;
                int i = 0;
                while (i < length) {
                    Object obj = atomicReferenceArray.get(i);
                    if (obj == null) {
                        return false;
                    }
                    i++;
                    objArr[i] = obj;
                }
                try {
                    HalfSerializer.onNext(this.actual, ObjectHelper.requireNonNull(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3256684027868224024L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromSubscriber<?, ?> parent;

        public WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {withLatestFromSubscriber, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = withLatestFromSubscriber;
            this.index = i;
        }

        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.parent.innerComplete(this.index, this.hasValue);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.innerError(this.index, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                if (!this.hasValue) {
                    this.hasValue = true;
                }
                this.parent.innerNext(this.index, obj);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, iterable, function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableWithLatestFromMany(@NonNull Flowable<T> flowable, @NonNull Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, publisherArr, function};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.otherArray = publisherArr;
        this.otherIterable = null;
        this.combiner = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            Publisher<?>[] publisherArr = this.otherArray;
            if (publisherArr == null) {
                publisherArr = new Publisher[8];
                try {
                    length = 0;
                    for (Publisher<?> publisher : this.otherIterable) {
                        if (length == publisherArr.length) {
                            publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (length >> 1) + length);
                        }
                        int i = length + 1;
                        publisherArr[length] = publisher;
                        length = i;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            } else {
                length = publisherArr.length;
            }
            if (length == 0) {
                new FlowableMap(this.source, new SingletonArrayFunc(this)).subscribeActual(subscriber);
                return;
            }
            WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.combiner, length);
            subscriber.onSubscribe(withLatestFromSubscriber);
            withLatestFromSubscriber.subscribe(publisherArr, length);
            this.source.subscribe((FlowableSubscriber) withLatestFromSubscriber);
        }
    }
}
