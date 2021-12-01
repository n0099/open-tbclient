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
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final AsyncSubscription[] EMPTY;
    public static final AsyncSubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<AsyncSubscription<T>[]> subscribers;
    public T value;

    /* loaded from: classes3.dex */
    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5629876084736248016L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AsyncProcessor<T> parent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, asyncProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && super.tryCancel()) {
                this.parent.remove(this);
            }
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (isCancelled()) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.actual.onError(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755966364, "Lio/reactivex/processors/AsyncProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755966364, "Lio/reactivex/processors/AsyncProcessor;");
                return;
            }
        }
        EMPTY = new AsyncSubscription[0];
        TERMINATED = new AsyncSubscription[0];
    }

    public AsyncProcessor() {
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
    @NonNull
    public static <T> AsyncProcessor<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new AsyncProcessor<>() : (AsyncProcessor) invokeV.objValue;
    }

    public boolean add(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription<T>[] asyncSubscriptionArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, asyncSubscription)) == null) {
            do {
                asyncSubscriptionArr = this.subscribers.get();
                if (asyncSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = asyncSubscriptionArr.length;
                asyncSubscriptionArr2 = new AsyncSubscription[length + 1];
                System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
                asyncSubscriptionArr2[length] = asyncSubscription;
            } while (!this.subscribers.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
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

    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.subscribers.get() == TERMINATED) {
                return this.value;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            T value = getValue();
            return value != null ? new Object[]{value} : new Object[0];
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.subscribers.get() == TERMINATED && this.error == null : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.subscribers.get().length != 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.subscribers.get() == TERMINATED && this.error != null : invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.subscribers.get() == TERMINATED && this.value != null : invokeV.booleanValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AsyncSubscription<T>[] asyncSubscriptionArr = this.subscribers.get();
            AsyncSubscription<T>[] asyncSubscriptionArr2 = TERMINATED;
            if (asyncSubscriptionArr == asyncSubscriptionArr2) {
                return;
            }
            T t = this.value;
            AsyncSubscription<T>[] andSet = this.subscribers.getAndSet(asyncSubscriptionArr2);
            int i2 = 0;
            if (t == null) {
                int length = andSet.length;
                while (i2 < length) {
                    andSet[i2].onComplete();
                    i2++;
                }
                return;
            }
            int length2 = andSet.length;
            while (i2 < length2) {
                andSet[i2].complete(t);
                i2++;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            AsyncSubscription<T>[] asyncSubscriptionArr = this.subscribers.get();
            AsyncSubscription<T>[] asyncSubscriptionArr2 = TERMINATED;
            if (asyncSubscriptionArr == asyncSubscriptionArr2) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.value = null;
            this.error = th;
            for (AsyncSubscription<T> asyncSubscription : this.subscribers.getAndSet(asyncSubscriptionArr2)) {
                asyncSubscription.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.subscribers.get() == TERMINATED) {
                return;
            }
            this.value = t;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, subscription) == null) {
            if (this.subscribers.get() == TERMINATED) {
                subscription.cancel();
            } else {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.AsyncProcessor$AsyncSubscription<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, asyncSubscription) == null) {
            do {
                asyncSubscriptionArr = this.subscribers.get();
                int length = asyncSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (asyncSubscriptionArr[i3] == asyncSubscription) {
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
                    asyncSubscriptionArr2 = EMPTY;
                } else {
                    AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[length - 1];
                    System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i2);
                    System.arraycopy(asyncSubscriptionArr, i2 + 1, asyncSubscriptionArr3, i2, (length - i2) - 1);
                    asyncSubscriptionArr2 = asyncSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, subscriber) == null) {
            AsyncSubscription<T> asyncSubscription = new AsyncSubscription<>(subscriber, this);
            subscriber.onSubscribe(asyncSubscription);
            if (add(asyncSubscription)) {
                if (asyncSubscription.isCancelled()) {
                    remove(asyncSubscription);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                asyncSubscription.complete(t);
            } else {
                asyncSubscription.onComplete();
            }
        }
    }

    public T[] getValues(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
            T value = getValue();
            if (value == null) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length == 0) {
                tArr = (T[]) Arrays.copyOf(tArr, 1);
            }
            tArr[0] = value;
            if (tArr.length != 1) {
                tArr[1] = null;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }
}
