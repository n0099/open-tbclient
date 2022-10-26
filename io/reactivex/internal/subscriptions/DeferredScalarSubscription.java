package io.reactivex.internal.subscriptions;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public class DeferredScalarSubscription extends BasicIntQueueSubscription {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANCELLED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2151279923272604993L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Subscriber actual;
    public Object value;

    public DeferredScalarSubscription(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = subscriber;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if ((i & 2) != 0) {
                lazySet(8);
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            set(4);
            this.value = null;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lazySet(32);
            this.value = null;
        }
    }

    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (get() == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (get() != 16) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final Object poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (get() != 16) {
                return null;
            }
            lazySet(32);
            Object obj = this.value;
            this.value = null;
            return obj;
        }
        return invokeV.objValue;
    }

    public final boolean tryCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getAndSet(4) != 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void complete(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            int i = get();
            while (i != 8) {
                if ((i & (-3)) != 0) {
                    return;
                }
                if (i == 2) {
                    lazySet(3);
                    Subscriber subscriber = this.actual;
                    subscriber.onNext(obj);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                this.value = obj;
                if (compareAndSet(0, 1)) {
                    return;
                }
                i = get();
                if (i == 4) {
                    this.value = null;
                    return;
                }
            }
            this.value = obj;
            lazySet(16);
            Subscriber subscriber2 = this.actual;
            subscriber2.onNext(obj);
            if (get() != 4) {
                subscriber2.onComplete();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && SubscriptionHelper.validate(j)) {
            do {
                int i = get();
                if ((i & (-2)) != 0) {
                    return;
                }
                if (i == 1) {
                    if (compareAndSet(1, 3) && (obj = this.value) != null) {
                        this.value = null;
                        Subscriber subscriber = this.actual;
                        subscriber.onNext(obj);
                        if (get() != 4) {
                            subscriber.onComplete();
                            return;
                        }
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
