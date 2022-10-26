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
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class AsyncProcessor extends FlowableProcessor {
    public static /* synthetic */ Interceptable $ic;
    public static final AsyncSubscription[] EMPTY;
    public static final AsyncSubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference subscribers;
    public Object value;

    /* loaded from: classes8.dex */
    public final class AsyncSubscription extends DeferredScalarSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5629876084736248016L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AsyncProcessor parent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncSubscription(Subscriber subscriber, AsyncProcessor asyncProcessor) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, asyncProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !isCancelled()) {
                this.actual.onComplete();
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.subscribers = new AtomicReference(EMPTY);
    }

    @CheckReturnValue
    public static AsyncProcessor create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new AsyncProcessor();
        }
        return (AsyncProcessor) invokeV.objValue;
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

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.subscribers.get() == TERMINATED) {
                return this.value;
            }
            return null;
        }
        return invokeV.objValue;
    }

    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object value = getValue();
            return value != null ? new Object[]{value} : new Object[0];
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.subscribers.get() == TERMINATED && this.error == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (((AsyncSubscription[]) this.subscribers.get()).length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.subscribers.get() == TERMINATED && this.error != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.subscribers.get() == TERMINATED && this.value != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean add(AsyncSubscription asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, asyncSubscription)) == null) {
            do {
                asyncSubscriptionArr = (AsyncSubscription[]) this.subscribers.get();
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

    public Object[] getValues(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            Object value = getValue();
            if (value == null) {
                if (objArr.length != 0) {
                    objArr[0] = null;
                }
                return objArr;
            }
            if (objArr.length == 0) {
                objArr = Arrays.copyOf(objArr, 1);
            }
            objArr[0] = value;
            if (objArr.length != 1) {
                objArr[1] = null;
            }
            return objArr;
        }
        return (Object[]) invokeL.objValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.subscribers.get() == TERMINATED) {
                return;
            }
            this.value = obj;
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

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Object obj = this.subscribers.get();
            Object obj2 = TERMINATED;
            if (obj == obj2) {
                return;
            }
            Object obj3 = this.value;
            AsyncSubscription[] asyncSubscriptionArr = (AsyncSubscription[]) this.subscribers.getAndSet(obj2);
            int i = 0;
            if (obj3 == null) {
                int length = asyncSubscriptionArr.length;
                while (i < length) {
                    asyncSubscriptionArr[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = asyncSubscriptionArr.length;
            while (i < length2) {
                asyncSubscriptionArr[i].complete(obj3);
                i++;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            Object obj = this.subscribers.get();
            Object obj2 = TERMINATED;
            if (obj == obj2) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.value = null;
            this.error = th;
            for (AsyncSubscription asyncSubscription : (AsyncSubscription[]) this.subscribers.getAndSet(obj2)) {
                asyncSubscription.onError(th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, subscriber) == null) {
            AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
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
            Object obj = this.value;
            if (obj != null) {
                asyncSubscription.complete(obj);
            } else {
                asyncSubscription.onComplete();
            }
        }
    }

    public void remove(AsyncSubscription asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, asyncSubscription) == null) {
            do {
                asyncSubscriptionArr = (AsyncSubscription[]) this.subscribers.get();
                int length = asyncSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncSubscriptionArr[i2] == asyncSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    asyncSubscriptionArr2 = EMPTY;
                } else {
                    AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[length - 1];
                    System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i);
                    System.arraycopy(asyncSubscriptionArr, i + 1, asyncSubscriptionArr3, i, (length - i) - 1);
                    asyncSubscriptionArr2 = asyncSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
        }
    }
}
