package io.reactivex.android.plugins;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
/* loaded from: classes8.dex */
public final class RxAndroidPlugins {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    public static volatile Function<Scheduler, Scheduler> onMainThreadHandler;
    public transient /* synthetic */ FieldHolder $fh;

    public RxAndroidPlugins() {
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
        throw new AssertionError("No instances.");
    }

    public static <T, R> R apply(Function<T, R> function, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, function, t)) == null) {
            try {
                return function.apply(t);
            } catch (Throwable th) {
                throw Exceptions.propagate(th);
            }
        }
        return (R) invokeLL.objValue;
    }

    public static Scheduler applyRequireNonNull(Function<Callable<Scheduler>, Scheduler> function, Callable<Scheduler> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, function, callable)) == null) {
            Scheduler scheduler = (Scheduler) apply(function, callable);
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        }
        return (Scheduler) invokeLL.objValue;
    }

    public static Scheduler callRequireNonNull(Callable<Scheduler> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) {
            try {
                Scheduler call = callable.call();
                if (call != null) {
                    return call;
                }
                throw new NullPointerException("Scheduler Callable returned null");
            } catch (Throwable th) {
                throw Exceptions.propagate(th);
            }
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? onInitMainThreadHandler : (Function) invokeV.objValue;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? onMainThreadHandler : (Function) invokeV.objValue;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, callable)) == null) {
            if (callable != null) {
                Function<Callable<Scheduler>, Scheduler> function = onInitMainThreadHandler;
                if (function == null) {
                    return callRequireNonNull(callable);
                }
                return applyRequireNonNull(function, callable);
            }
            throw new NullPointerException("scheduler == null");
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, scheduler)) == null) {
            if (scheduler != null) {
                Function<Scheduler, Scheduler> function = onMainThreadHandler;
                return function == null ? scheduler : (Scheduler) apply(function, scheduler);
            }
            throw new NullPointerException("scheduler == null");
        }
        return (Scheduler) invokeL.objValue;
    }

    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            setInitMainThreadSchedulerHandler(null);
            setMainThreadSchedulerHandler(null);
        }
    }

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, function) == null) {
            onInitMainThreadHandler = function;
        }
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, function) == null) {
            onMainThreadHandler = function;
        }
    }
}
