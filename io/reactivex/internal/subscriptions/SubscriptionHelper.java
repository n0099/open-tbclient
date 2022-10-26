package io.reactivex.internal.subscriptions;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class SubscriptionHelper implements Subscription {
    public static final /* synthetic */ SubscriptionHelper[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SubscriptionHelper CANCELLED;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1976081874, "Lio/reactivex/internal/subscriptions/SubscriptionHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1976081874, "Lio/reactivex/internal/subscriptions/SubscriptionHelper;");
                return;
            }
        }
        SubscriptionHelper subscriptionHelper = new SubscriptionHelper("CANCELLED", 0);
        CANCELLED = subscriptionHelper;
        $VALUES = new SubscriptionHelper[]{subscriptionHelper};
    }

    public static void reportSubscriptionSet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
        }
    }

    public static SubscriptionHelper[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return (SubscriptionHelper[]) $VALUES.clone();
        }
        return (SubscriptionHelper[]) invokeV.objValue;
    }

    public SubscriptionHelper(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean cancel(AtomicReference atomicReference) {
        InterceptResult invokeL;
        Subscription subscription;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, atomicReference)) == null) {
            Subscription subscription2 = (Subscription) atomicReference.get();
            SubscriptionHelper subscriptionHelper = CANCELLED;
            if (subscription2 != subscriptionHelper && (subscription = (Subscription) atomicReference.getAndSet(subscriptionHelper)) != CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isCancelled(Subscription subscription) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, subscription)) == null) {
            if (subscription == CANCELLED) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void reportMoreProduced(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            RxJavaPlugins.onError(new ProtocolViolationException("More produced than requested: " + j));
        }
    }

    public static SubscriptionHelper valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            return (SubscriptionHelper) Enum.valueOf(SubscriptionHelper.class, str);
        }
        return (SubscriptionHelper) invokeL.objValue;
    }

    public static void deferredRequest(AtomicReference atomicReference, AtomicLong atomicLong, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{atomicReference, atomicLong, Long.valueOf(j)}) == null) {
            Subscription subscription = (Subscription) atomicReference.get();
            if (subscription != null) {
                subscription.request(j);
            } else if (validate(j)) {
                BackpressureHelper.add(atomicLong, j);
                Subscription subscription2 = (Subscription) atomicReference.get();
                if (subscription2 != null) {
                    long andSet = atomicLong.getAndSet(0L);
                    if (andSet != 0) {
                        subscription2.request(andSet);
                    }
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference atomicReference, AtomicLong atomicLong, Subscription subscription) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReference, atomicLong, subscription)) == null) {
            if (setOnce(atomicReference, subscription)) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription.request(andSet);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean setOnce(AtomicReference atomicReference, Subscription subscription, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{atomicReference, subscription, Long.valueOf(j)})) == null) {
            if (setOnce(atomicReference, subscription)) {
                subscription.request(j);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean replace(AtomicReference atomicReference, Subscription subscription) {
        Subscription subscription2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, atomicReference, subscription)) == null) {
            do {
                subscription2 = (Subscription) atomicReference.get();
                if (subscription2 == CANCELLED) {
                    if (subscription != null) {
                        subscription.cancel();
                        return false;
                    }
                    return false;
                }
            } while (!atomicReference.compareAndSet(subscription2, subscription));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean set(AtomicReference atomicReference, Subscription subscription) {
        Subscription subscription2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, atomicReference, subscription)) == null) {
            do {
                subscription2 = (Subscription) atomicReference.get();
                if (subscription2 == CANCELLED) {
                    if (subscription != null) {
                        subscription.cancel();
                        return false;
                    }
                    return false;
                }
            } while (!atomicReference.compareAndSet(subscription2, subscription));
            if (subscription2 != null) {
                subscription2.cancel();
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean setOnce(AtomicReference atomicReference, Subscription subscription) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, atomicReference, subscription)) == null) {
            ObjectHelper.requireNonNull(subscription, "s is null");
            if (!atomicReference.compareAndSet(null, subscription)) {
                subscription.cancel();
                if (atomicReference.get() != CANCELLED) {
                    reportSubscriptionSet();
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, subscription, subscription2)) == null) {
            if (subscription2 == null) {
                RxJavaPlugins.onError(new NullPointerException("next is null"));
                return false;
            } else if (subscription != null) {
                subscription2.cancel();
                reportSubscriptionSet();
                return false;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean validate(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65548, null, j)) == null) {
            if (j <= 0) {
                RxJavaPlugins.onError(new IllegalArgumentException("n > 0 required but it was " + j));
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }
}
