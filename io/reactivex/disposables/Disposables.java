package io.reactivex.disposables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class Disposables {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Disposables() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static Disposable disposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return EmptyDisposable.INSTANCE;
        }
        return (Disposable) invokeV.objValue;
    }

    public static Disposable empty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return fromRunnable(Functions.EMPTY_RUNNABLE);
        }
        return (Disposable) invokeV.objValue;
    }

    public static Disposable fromAction(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, action)) == null) {
            ObjectHelper.requireNonNull(action, "run is null");
            return new ActionDisposable(action);
        }
        return (Disposable) invokeL.objValue;
    }

    public static Disposable fromFuture(Future future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, future)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return fromFuture(future, true);
        }
        return (Disposable) invokeL.objValue;
    }

    public static Disposable fromRunnable(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            return new RunnableDisposable(runnable);
        }
        return (Disposable) invokeL.objValue;
    }

    public static Disposable fromSubscription(Subscription subscription) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, subscription)) == null) {
            ObjectHelper.requireNonNull(subscription, "subscription is null");
            return new SubscriptionDisposable(subscription);
        }
        return (Disposable) invokeL.objValue;
    }

    public static Disposable fromFuture(Future future, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, future, z)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return new FutureDisposable(future, z);
        }
        return (Disposable) invokeLZ.objValue;
    }
}
