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
    public static volatile Function onInitMainThreadHandler;
    public static volatile Function onMainThreadHandler;
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

    public static Function getInitMainThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return onInitMainThreadHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getOnMainThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return onMainThreadHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            setInitMainThreadSchedulerHandler(null);
            setMainThreadSchedulerHandler(null);
        }
    }

    public static Object apply(Function function, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, function, obj)) == null) {
            try {
                return function.apply(obj);
            } catch (Throwable th) {
                throw Exceptions.propagate(th);
            }
        }
        return invokeLL.objValue;
    }

    public static Scheduler applyRequireNonNull(Function function, Callable callable) {
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

    public static Scheduler callRequireNonNull(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) {
            try {
                Scheduler scheduler = (Scheduler) callable.call();
                if (scheduler != null) {
                    return scheduler;
                }
                throw new NullPointerException("Scheduler Callable returned null");
            } catch (Throwable th) {
                throw Exceptions.propagate(th);
            }
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler initMainThreadScheduler(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, callable)) == null) {
            if (callable != null) {
                Function function = onInitMainThreadHandler;
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
                Function function = onMainThreadHandler;
                if (function == null) {
                    return scheduler;
                }
                return (Scheduler) apply(function, scheduler);
            }
            throw new NullPointerException("scheduler == null");
        }
        return (Scheduler) invokeL.objValue;
    }

    public static void setInitMainThreadSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, function) == null) {
            onInitMainThreadHandler = function;
        }
    }

    public static void setMainThreadSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, function) == null) {
            onMainThreadHandler = function;
        }
    }
}
