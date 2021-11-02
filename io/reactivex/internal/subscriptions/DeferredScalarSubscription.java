package io.reactivex.internal.subscriptions;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.Nullable;
import org.reactivestreams.Subscriber;
/* loaded from: classes3.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
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
    public final Subscriber<? super T> actual;
    public T value;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber};
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

    public final void complete(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            int i2 = get();
            while (i2 != 8) {
                if ((i2 & (-3)) != 0) {
                    return;
                }
                if (i2 == 2) {
                    lazySet(3);
                    Subscriber<? super T> subscriber = this.actual;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                this.value = t;
                if (compareAndSet(0, 1)) {
                    return;
                }
                i2 = get();
                if (i2 == 4) {
                    this.value = null;
                    return;
                }
            }
            this.value = t;
            lazySet(16);
            Subscriber<? super T> subscriber2 = this.actual;
            subscriber2.onNext(t);
            if (get() != 4) {
                subscriber2.onComplete();
            }
        }
    }

    public final boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? get() == 4 : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? get() != 16 : invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public final T poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (get() == 16) {
                lazySet(32);
                T t = this.value;
                this.value = null;
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && SubscriptionHelper.validate(j)) {
            do {
                int i2 = get();
                if ((i2 & (-2)) != 0) {
                    return;
                }
                if (i2 == 1) {
                    if (!compareAndSet(1, 3) || (t = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    Subscriber<? super T> subscriber = this.actual;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if ((i2 & 2) != 0) {
                lazySet(8);
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final boolean tryCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getAndSet(4) != 4 : invokeV.booleanValue;
    }
}
