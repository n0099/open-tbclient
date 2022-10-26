package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableAmb extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Publisher[] sources;
    public final Iterable sourcesIterable;

    /* loaded from: classes8.dex */
    public final class AmbCoordinator implements Subscription {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public final AmbInnerSubscriber[] subscribers;
        public final AtomicInteger winner;

        public AmbCoordinator(Subscriber subscriber, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.winner = new AtomicInteger();
            this.actual = subscriber;
            this.subscribers = new AmbInnerSubscriber[i];
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerSubscriber ambInnerSubscriber : this.subscribers) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && SubscriptionHelper.validate(j)) {
                int i = this.winner.get();
                if (i > 0) {
                    this.subscribers[i - 1].request(j);
                } else if (i == 0) {
                    for (AmbInnerSubscriber ambInnerSubscriber : this.subscribers) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        public void subscribe(Publisher[] publisherArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, publisherArr) == null) {
                AmbInnerSubscriber[] ambInnerSubscriberArr = this.subscribers;
                int length = ambInnerSubscriberArr.length;
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    ambInnerSubscriberArr[i] = new AmbInnerSubscriber(this, i2, this.actual);
                    i = i2;
                }
                this.winner.lazySet(0);
                this.actual.onSubscribe(this);
                for (int i3 = 0; i3 < length && this.winner.get() == 0; i3++) {
                    publisherArr[i3].subscribe(ambInnerSubscriberArr[i3]);
                }
            }
        }

        public boolean win(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = 0;
                if (this.winner.get() != 0 || !this.winner.compareAndSet(0, i)) {
                    return false;
                }
                AmbInnerSubscriber[] ambInnerSubscriberArr = this.subscribers;
                int length = ambInnerSubscriberArr.length;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    if (i3 != i) {
                        ambInnerSubscriberArr[i2].cancel();
                    }
                    i2 = i3;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class AmbInnerSubscriber extends AtomicReference implements FlowableSubscriber, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1185974347409665484L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public final int index;
        public final AtomicLong missedRequested;
        public final AmbCoordinator parent;
        public boolean won;

        public AmbInnerSubscriber(AmbCoordinator ambCoordinator, int i, Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ambCoordinator, Integer.valueOf(i), subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.missedRequested = new AtomicLong();
            this.parent = ambCoordinator;
            this.index = i;
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.won) {
                    this.actual.onComplete();
                } else if (this.parent.win(this.index)) {
                    this.won = true;
                    this.actual.onComplete();
                } else {
                    ((Subscription) get()).cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.won) {
                    this.actual.onError(th);
                } else if (this.parent.win(this.index)) {
                    this.won = true;
                    this.actual.onError(th);
                } else {
                    ((Subscription) get()).cancel();
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                if (this.won) {
                    this.actual.onNext(obj);
                } else if (this.parent.win(this.index)) {
                    this.won = true;
                    this.actual.onNext(obj);
                } else {
                    ((Subscription) get()).cancel();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
            }
        }
    }

    public FlowableAmb(Publisher[] publisherArr, Iterable iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisherArr, iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            Publisher[] publisherArr = this.sources;
            if (publisherArr == null) {
                publisherArr = new Publisher[8];
                try {
                    length = 0;
                    for (Publisher publisher : this.sourcesIterable) {
                        if (publisher == null) {
                            EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                            return;
                        }
                        if (length == publisherArr.length) {
                            Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                            System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                            publisherArr = publisherArr2;
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
                EmptySubscription.complete(subscriber);
            } else if (length == 1) {
                publisherArr[0].subscribe(subscriber);
            } else {
                new AmbCoordinator(subscriber, length).subscribe(publisherArr);
            }
        }
    }
}
