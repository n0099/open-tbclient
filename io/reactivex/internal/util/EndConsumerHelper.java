package io.reactivex.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes5.dex */
public final class EndConsumerHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EndConsumerHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static String composeMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
        }
        return (String) invokeL.objValue;
    }

    public static void reportDoubleSubscription(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cls) == null) {
            RxJavaPlugins.onError(new ProtocolViolationException(composeMessage(cls.getName())));
        }
    }

    public static boolean setOnce(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, atomicReference, disposable, cls)) == null) {
            ObjectHelper.requireNonNull(disposable, "next is null");
            if (atomicReference.compareAndSet(null, disposable)) {
                return true;
            }
            disposable.dispose();
            if (atomicReference.get() != DisposableHelper.DISPOSED) {
                reportDoubleSubscription(cls);
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean validate(Disposable disposable, Disposable disposable2, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, disposable, disposable2, cls)) == null) {
            ObjectHelper.requireNonNull(disposable2, "next is null");
            if (disposable != null) {
                disposable2.dispose();
                if (disposable != DisposableHelper.DISPOSED) {
                    reportDoubleSubscription(cls);
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, subscription, subscription2, cls)) == null) {
            ObjectHelper.requireNonNull(subscription2, "next is null");
            if (subscription != null) {
                subscription2.cancel();
                if (subscription != SubscriptionHelper.CANCELLED) {
                    reportDoubleSubscription(cls);
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicReference, subscription, cls)) == null) {
            ObjectHelper.requireNonNull(subscription, "next is null");
            if (atomicReference.compareAndSet(null, subscription)) {
                return true;
            }
            subscription.cancel();
            if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
                reportDoubleSubscription(cls);
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
