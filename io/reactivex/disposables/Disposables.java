package io.reactivex.disposables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class Disposables {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Disposables() {
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

    @NonNull
    public static Disposable disposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? EmptyDisposable.INSTANCE : (Disposable) invokeV.objValue;
    }

    @NonNull
    public static Disposable empty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? fromRunnable(Functions.EMPTY_RUNNABLE) : (Disposable) invokeV.objValue;
    }

    @NonNull
    public static Disposable fromAction(@NonNull Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, action)) == null) {
            ObjectHelper.requireNonNull(action, "run is null");
            return new ActionDisposable(action);
        }
        return (Disposable) invokeL.objValue;
    }

    @NonNull
    public static Disposable fromFuture(@NonNull Future<?> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, future)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return fromFuture(future, true);
        }
        return (Disposable) invokeL.objValue;
    }

    @NonNull
    public static Disposable fromRunnable(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            return new RunnableDisposable(runnable);
        }
        return (Disposable) invokeL.objValue;
    }

    @NonNull
    public static Disposable fromSubscription(@NonNull Subscription subscription) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, subscription)) == null) {
            ObjectHelper.requireNonNull(subscription, "subscription is null");
            return new SubscriptionDisposable(subscription);
        }
        return (Disposable) invokeL.objValue;
    }

    @NonNull
    public static Disposable fromFuture(@NonNull Future<?> future, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, future, z)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return new FutureDisposable(future, z);
        }
        return (Disposable) invokeLZ.objValue;
    }
}
