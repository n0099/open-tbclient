package io.reactivex.processors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class PublishProcessor<T> extends FlowableProcessor<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final PublishSubscription[] EMPTY;
    public static final PublishSubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<PublishSubscription<T>[]> subscribers;

    /* loaded from: classes10.dex */
    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3562861878281475070L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public final PublishProcessor<T> parent;

        public PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, publishProcessor};
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
            this.parent = publishProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.remove(this);
        }

        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
        }

        public boolean isFull() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() == 0 : invokeV.booleanValue;
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || get() == Long.MIN_VALUE) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                if (get() != Long.MIN_VALUE) {
                    this.actual.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                long j = get();
                if (j == Long.MIN_VALUE) {
                    return;
                }
                if (j != 0) {
                    this.actual.onNext(t);
                    BackpressureHelper.producedCancel(this, 1L);
                    return;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(404808055, "Lio/reactivex/processors/PublishProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(404808055, "Lio/reactivex/processors/PublishProcessor;");
                return;
            }
        }
        TERMINATED = new PublishSubscription[0];
        EMPTY = new PublishSubscription[0];
    }

    public PublishProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    @CheckReturnValue
    public static <T> PublishProcessor<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new PublishProcessor<>() : (PublishProcessor) invokeV.objValue;
    }

    public boolean add(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription<T>[] publishSubscriptionArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, publishSubscription)) == null) {
            do {
                publishSubscriptionArr = this.subscribers.get();
                if (publishSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = publishSubscriptionArr.length;
                publishSubscriptionArr2 = new PublishSubscription[length + 1];
                System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
                publishSubscriptionArr2[length] = publishSubscription;
            } while (!this.subscribers.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.subscribers.get() == TERMINATED) {
                return this.error;
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.subscribers.get() == TERMINATED && this.error == null : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.subscribers.get().length != 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.subscribers.get() == TERMINATED && this.error != null : invokeV.booleanValue;
    }

    @Experimental
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return true;
            }
            PublishSubscription<T>[] publishSubscriptionArr = this.subscribers.get();
            for (PublishSubscription<T> publishSubscription : publishSubscriptionArr) {
                if (publishSubscription.isFull()) {
                    return false;
                }
            }
            for (PublishSubscription<T> publishSubscription2 : publishSubscriptionArr) {
                publishSubscription2.onNext(t);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PublishSubscription<T>[] publishSubscriptionArr = this.subscribers.get();
            PublishSubscription<T>[] publishSubscriptionArr2 = TERMINATED;
            if (publishSubscriptionArr == publishSubscriptionArr2) {
                return;
            }
            for (PublishSubscription<T> publishSubscription : this.subscribers.getAndSet(publishSubscriptionArr2)) {
                publishSubscription.onComplete();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            PublishSubscription<T>[] publishSubscriptionArr = this.subscribers.get();
            PublishSubscription<T>[] publishSubscriptionArr2 = TERMINATED;
            if (publishSubscriptionArr == publishSubscriptionArr2) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            for (PublishSubscription<T> publishSubscription : this.subscribers.getAndSet(publishSubscriptionArr2)) {
                publishSubscription.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.subscribers.get() == TERMINATED) {
                return;
            }
            for (PublishSubscription<T> publishSubscription : this.subscribers.get()) {
                publishSubscription.onNext(t);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, subscription) == null) {
            if (this.subscribers.get() == TERMINATED) {
                subscription.cancel();
            } else {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.PublishProcessor$PublishSubscription<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, publishSubscription) == null) {
            do {
                publishSubscriptionArr = this.subscribers.get();
                if (publishSubscriptionArr == TERMINATED || publishSubscriptionArr == EMPTY) {
                    return;
                }
                int length = publishSubscriptionArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (publishSubscriptionArr[i3] == publishSubscription) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    publishSubscriptionArr2 = EMPTY;
                } else {
                    PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[length - 1];
                    System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i2);
                    System.arraycopy(publishSubscriptionArr, i2 + 1, publishSubscriptionArr3, i2, (length - i2) - 1);
                    publishSubscriptionArr2 = publishSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, subscriber) == null) {
            PublishSubscription<T> publishSubscription = new PublishSubscription<>(subscriber, this);
            subscriber.onSubscribe(publishSubscription);
            if (add(publishSubscription)) {
                if (publishSubscription.isCancelled()) {
                    remove(publishSubscription);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }
}
