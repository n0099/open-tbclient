package io.reactivex.internal.subscribers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<Subscription> s;
    public T value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FutureSubscriber() {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new AtomicReference<>();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            do {
                subscription = this.s.get();
                if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                    return false;
                }
            } while (!this.s.compareAndSet(subscription, subscriptionHelper));
            if (subscription != null) {
                subscription.cancel();
            }
            countDown();
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getCount() != 0) {
                BlockingHelper.verifyNonBlocking();
                await();
            }
            if (!isCancelled()) {
                Throwable th = this.error;
                if (th == null) {
                    return this.value;
                }
                throw new ExecutionException(th);
            }
            throw new CancellationException();
        }
        return (T) invokeV.objValue;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SubscriptionHelper.isCancelled(this.s.get()) : invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getCount() == 0 : invokeV.booleanValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.value == null) {
                onError(new NoSuchElementException("The source is empty"));
                return;
            }
            do {
                subscription = this.s.get();
                if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                    return;
                }
            } while (!this.s.compareAndSet(subscription, this));
            countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            do {
                subscription = this.s.get();
                if (subscription != this && subscription != SubscriptionHelper.CANCELLED) {
                    this.error = th;
                } else {
                    RxJavaPlugins.onError(th);
                    return;
                }
            } while (!this.s.compareAndSet(subscription, this));
            countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            if (this.value != null) {
                this.s.get().cancel();
                onError(new IndexOutOfBoundsException("More than one element received"));
                return;
            }
            this.value = t;
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, subscription) == null) {
            SubscriptionHelper.setOnce(this.s, subscription, Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, timeUnit)) == null) {
            if (getCount() != 0) {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    throw new TimeoutException();
                }
            }
            if (!isCancelled()) {
                Throwable th = this.error;
                if (th == null) {
                    return this.value;
                }
                throw new ExecutionException(th);
            }
            throw new CancellationException();
        }
        return (T) invokeJL.objValue;
    }
}
