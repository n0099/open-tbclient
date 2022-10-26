package io.reactivex.plugins;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class RxJavaPlugins {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Consumer errorHandler;
    public static volatile boolean failNonBlockingScheduler;
    public static volatile boolean lockdown;
    public static volatile BooleanSupplier onBeforeBlocking;
    public static volatile Function onCompletableAssembly;
    public static volatile BiFunction onCompletableSubscribe;
    public static volatile Function onComputationHandler;
    public static volatile Function onConnectableFlowableAssembly;
    public static volatile Function onConnectableObservableAssembly;
    public static volatile Function onFlowableAssembly;
    public static volatile BiFunction onFlowableSubscribe;
    public static volatile Function onInitComputationHandler;
    public static volatile Function onInitIoHandler;
    public static volatile Function onInitNewThreadHandler;
    public static volatile Function onInitSingleHandler;
    public static volatile Function onIoHandler;
    public static volatile Function onMaybeAssembly;
    public static volatile BiFunction onMaybeSubscribe;
    public static volatile Function onNewThreadHandler;
    public static volatile Function onObservableAssembly;
    public static volatile BiFunction onObservableSubscribe;
    public static volatile Function onParallelAssembly;
    public static volatile Function onScheduleHandler;
    public static volatile Function onSingleAssembly;
    public static volatile Function onSingleHandler;
    public static volatile BiFunction onSingleSubscribe;
    public transient /* synthetic */ FieldHolder $fh;

    public RxJavaPlugins() {
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

    public static Function getComputationSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return onComputationHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Consumer getErrorHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return errorHandler;
        }
        return (Consumer) invokeV.objValue;
    }

    public static Function getInitComputationSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return onInitComputationHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getInitIoSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return onInitIoHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getInitNewThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return onInitNewThreadHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getInitSingleSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return onInitSingleHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getIoSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return onIoHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getNewThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return onNewThreadHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static BooleanSupplier getOnBeforeBlocking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return onBeforeBlocking;
        }
        return (BooleanSupplier) invokeV.objValue;
    }

    public static Function getOnCompletableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return onCompletableAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static BiFunction getOnCompletableSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return onCompletableSubscribe;
        }
        return (BiFunction) invokeV.objValue;
    }

    public static Function getOnConnectableFlowableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return onConnectableFlowableAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getOnConnectableObservableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return onConnectableObservableAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getOnFlowableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return onFlowableAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static BiFunction getOnFlowableSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return onFlowableSubscribe;
        }
        return (BiFunction) invokeV.objValue;
    }

    public static Function getOnMaybeAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return onMaybeAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static BiFunction getOnMaybeSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return onMaybeSubscribe;
        }
        return (BiFunction) invokeV.objValue;
    }

    public static Function getOnObservableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return onObservableAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static BiFunction getOnObservableSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return onObservableSubscribe;
        }
        return (BiFunction) invokeV.objValue;
    }

    public static Function getOnParallelAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return onParallelAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getOnSingleAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return onSingleAssembly;
        }
        return (Function) invokeV.objValue;
    }

    public static BiFunction getOnSingleSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return onSingleSubscribe;
        }
        return (BiFunction) invokeV.objValue;
    }

    public static Function getScheduleHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return onScheduleHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static Function getSingleSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return onSingleHandler;
        }
        return (Function) invokeV.objValue;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) {
            return failNonBlockingScheduler;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLockdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return lockdown;
        }
        return invokeV.booleanValue;
    }

    public static void lockdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, null) == null) {
            lockdown = true;
        }
    }

    public static boolean onBeforeBlocking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            BooleanSupplier booleanSupplier = onBeforeBlocking;
            if (booleanSupplier != null) {
                try {
                    return booleanSupplier.getAsBoolean();
                } catch (Throwable th) {
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void unlock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65624, null) == null) {
            lockdown = false;
        }
    }

    public static Object apply(BiFunction biFunction, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, biFunction, obj, obj2)) == null) {
            try {
                return biFunction.apply(obj, obj2);
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return invokeLLL.objValue;
    }

    public static Object apply(Function function, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, function, obj)) == null) {
            try {
                return function.apply(obj);
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return invokeLL.objValue;
    }

    public static Scheduler applyRequireNonNull(Function function, Callable callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, function, callable)) == null) {
            return (Scheduler) ObjectHelper.requireNonNull(apply(function, callable), "Scheduler Callable result can't be null");
        }
        return (Scheduler) invokeLL.objValue;
    }

    public static CompletableObserver onSubscribe(Completable completable, CompletableObserver completableObserver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, completable, completableObserver)) == null) {
            BiFunction biFunction = onCompletableSubscribe;
            if (biFunction != null) {
                return (CompletableObserver) apply(biFunction, completable, completableObserver);
            }
            return completableObserver;
        }
        return (CompletableObserver) invokeLL.objValue;
    }

    public static Scheduler callRequireNonNull(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, callable)) == null) {
            try {
                return (Scheduler) ObjectHelper.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler createComputationScheduler(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadFactory)) == null) {
            return new ComputationScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler createIoScheduler(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, threadFactory)) == null) {
            return new IoScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadFactory)) == null) {
            return new NewThreadScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler createSingleScheduler(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadFactory)) == null) {
            return new SingleScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler initComputationScheduler(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function function = onInitComputationHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler initIoScheduler(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function function = onInitIoHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler initNewThreadScheduler(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function function = onInitNewThreadHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler initSingleScheduler(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function function = onInitSingleHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Completable onAssembly(Completable completable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, completable)) == null) {
            Function function = onCompletableAssembly;
            if (function != null) {
                return (Completable) apply(function, completable);
            }
            return completable;
        }
        return (Completable) invokeL.objValue;
    }

    public static Scheduler onComputationScheduler(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, scheduler)) == null) {
            Function function = onComputationHandler;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler onIoScheduler(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, scheduler)) == null) {
            Function function = onIoHandler;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Scheduler onNewThreadScheduler(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, scheduler)) == null) {
            Function function = onNewThreadHandler;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static Runnable onSchedule(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            Function function = onScheduleHandler;
            if (function == null) {
                return runnable;
            }
            return (Runnable) apply(function, runnable);
        }
        return (Runnable) invokeL.objValue;
    }

    public static Scheduler onSingleScheduler(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, scheduler)) == null) {
            Function function = onSingleHandler;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static void setComputationSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, null, function) == null) {
            if (!lockdown) {
                onComputationHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setErrorHandler(Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65599, null, consumer) == null) {
            if (!lockdown) {
                errorHandler = consumer;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setFailOnNonBlockingScheduler(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65600, null, z) == null) {
            if (!lockdown) {
                failNonBlockingScheduler = z;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitComputationSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65601, null, function) == null) {
            if (!lockdown) {
                onInitComputationHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitIoSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, null, function) == null) {
            if (!lockdown) {
                onInitIoHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitNewThreadSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, null, function) == null) {
            if (!lockdown) {
                onInitNewThreadHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitSingleSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, null, function) == null) {
            if (!lockdown) {
                onInitSingleHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setIoSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65605, null, function) == null) {
            if (!lockdown) {
                onIoHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setNewThreadSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, null, function) == null) {
            if (!lockdown) {
                onNewThreadHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnBeforeBlocking(BooleanSupplier booleanSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65607, null, booleanSupplier) == null) {
            if (!lockdown) {
                onBeforeBlocking = booleanSupplier;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnCompletableAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, null, function) == null) {
            if (!lockdown) {
                onCompletableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnCompletableSubscribe(BiFunction biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, biFunction) == null) {
            if (!lockdown) {
                onCompletableSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnConnectableFlowableAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, null, function) == null) {
            if (!lockdown) {
                onConnectableFlowableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnConnectableObservableAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, function) == null) {
            if (!lockdown) {
                onConnectableObservableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnFlowableAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, null, function) == null) {
            if (!lockdown) {
                onFlowableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnFlowableSubscribe(BiFunction biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65613, null, biFunction) == null) {
            if (!lockdown) {
                onFlowableSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnMaybeAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65614, null, function) == null) {
            if (!lockdown) {
                onMaybeAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnMaybeSubscribe(BiFunction biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65615, null, biFunction) == null) {
            if (!lockdown) {
                onMaybeSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnObservableAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, null, function) == null) {
            if (!lockdown) {
                onObservableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnObservableSubscribe(BiFunction biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65617, null, biFunction) == null) {
            if (!lockdown) {
                onObservableSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnParallelAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65618, null, function) == null) {
            if (!lockdown) {
                onParallelAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnSingleAssembly(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65619, null, function) == null) {
            if (!lockdown) {
                onSingleAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnSingleSubscribe(BiFunction biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65620, null, biFunction) == null) {
            if (!lockdown) {
                onSingleSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setScheduleHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65621, null, function) == null) {
            if (!lockdown) {
                onScheduleHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setSingleSchedulerHandler(Function function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65622, null, function) == null) {
            if (!lockdown) {
                onSingleHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void uncaught(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65623, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static boolean isBug(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, th)) == null) {
            if ((th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, th) == null) {
            Consumer consumer = errorHandler;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            } else if (!isBug(th)) {
                th = new UndeliverableException(th);
            }
            if (consumer != null) {
                try {
                    consumer.accept(th);
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    uncaught(th2);
                }
            }
            th.printStackTrace();
            uncaught(th);
        }
    }

    public static Flowable onAssembly(Flowable flowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, flowable)) == null) {
            Function function = onFlowableAssembly;
            if (function != null) {
                return (Flowable) apply(function, flowable);
            }
            return flowable;
        }
        return (Flowable) invokeL.objValue;
    }

    public static Maybe onAssembly(Maybe maybe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, maybe)) == null) {
            Function function = onMaybeAssembly;
            if (function != null) {
                return (Maybe) apply(function, maybe);
            }
            return maybe;
        }
        return (Maybe) invokeL.objValue;
    }

    public static Observable onAssembly(Observable observable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, observable)) == null) {
            Function function = onObservableAssembly;
            if (function != null) {
                return (Observable) apply(function, observable);
            }
            return observable;
        }
        return (Observable) invokeL.objValue;
    }

    public static Single onAssembly(Single single) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, single)) == null) {
            Function function = onSingleAssembly;
            if (function != null) {
                return (Single) apply(function, single);
            }
            return single;
        }
        return (Single) invokeL.objValue;
    }

    public static ConnectableFlowable onAssembly(ConnectableFlowable connectableFlowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, connectableFlowable)) == null) {
            Function function = onConnectableFlowableAssembly;
            if (function != null) {
                return (ConnectableFlowable) apply(function, connectableFlowable);
            }
            return connectableFlowable;
        }
        return (ConnectableFlowable) invokeL.objValue;
    }

    public static ConnectableObservable onAssembly(ConnectableObservable connectableObservable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, connectableObservable)) == null) {
            Function function = onConnectableObservableAssembly;
            if (function != null) {
                return (ConnectableObservable) apply(function, connectableObservable);
            }
            return connectableObservable;
        }
        return (ConnectableObservable) invokeL.objValue;
    }

    public static ParallelFlowable onAssembly(ParallelFlowable parallelFlowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, parallelFlowable)) == null) {
            Function function = onParallelAssembly;
            if (function != null) {
                return (ParallelFlowable) apply(function, parallelFlowable);
            }
            return parallelFlowable;
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    public static MaybeObserver onSubscribe(Maybe maybe, MaybeObserver maybeObserver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, null, maybe, maybeObserver)) == null) {
            BiFunction biFunction = onMaybeSubscribe;
            if (biFunction != null) {
                return (MaybeObserver) apply(biFunction, maybe, maybeObserver);
            }
            return maybeObserver;
        }
        return (MaybeObserver) invokeLL.objValue;
    }

    public static Observer onSubscribe(Observable observable, Observer observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65594, null, observable, observer)) == null) {
            BiFunction biFunction = onObservableSubscribe;
            if (biFunction != null) {
                return (Observer) apply(biFunction, observable, observer);
            }
            return observer;
        }
        return (Observer) invokeLL.objValue;
    }

    public static SingleObserver onSubscribe(Single single, SingleObserver singleObserver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, single, singleObserver)) == null) {
            BiFunction biFunction = onSingleSubscribe;
            if (biFunction != null) {
                return (SingleObserver) apply(biFunction, single, singleObserver);
            }
            return singleObserver;
        }
        return (SingleObserver) invokeLL.objValue;
    }

    public static Subscriber onSubscribe(Flowable flowable, Subscriber subscriber) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65596, null, flowable, subscriber)) == null) {
            BiFunction biFunction = onFlowableSubscribe;
            if (biFunction != null) {
                return (Subscriber) apply(biFunction, flowable, subscriber);
            }
            return subscriber;
        }
        return (Subscriber) invokeLL.objValue;
    }

    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, null) == null) {
            setErrorHandler(null);
            setScheduleHandler(null);
            setComputationSchedulerHandler(null);
            setInitComputationSchedulerHandler(null);
            setIoSchedulerHandler(null);
            setInitIoSchedulerHandler(null);
            setSingleSchedulerHandler(null);
            setInitSingleSchedulerHandler(null);
            setNewThreadSchedulerHandler(null);
            setInitNewThreadSchedulerHandler(null);
            setOnFlowableAssembly(null);
            setOnFlowableSubscribe(null);
            setOnObservableAssembly(null);
            setOnObservableSubscribe(null);
            setOnSingleAssembly(null);
            setOnSingleSubscribe(null);
            setOnCompletableAssembly(null);
            setOnCompletableSubscribe(null);
            setOnConnectableFlowableAssembly(null);
            setOnConnectableObservableAssembly(null);
            setOnMaybeAssembly(null);
            setOnMaybeSubscribe(null);
            setOnParallelAssembly(null);
            setFailOnNonBlockingScheduler(false);
            setOnBeforeBlocking(null);
        }
    }
}
