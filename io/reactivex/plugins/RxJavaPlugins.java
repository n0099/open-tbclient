package io.reactivex.plugins;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
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
/* loaded from: classes3.dex */
public final class RxJavaPlugins {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static volatile Consumer<? super Throwable> errorHandler;
    public static volatile boolean failNonBlockingScheduler;
    public static volatile boolean lockdown;
    @Nullable
    public static volatile BooleanSupplier onBeforeBlocking;
    @Nullable
    public static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
    @Nullable
    public static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> onCompletableSubscribe;
    @Nullable
    public static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
    @Nullable
    public static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> onConnectableFlowableAssembly;
    @Nullable
    public static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> onConnectableObservableAssembly;
    @Nullable
    public static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
    @Nullable
    public static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> onFlowableSubscribe;
    @Nullable
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
    @Nullable
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
    @Nullable
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
    @Nullable
    public static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
    @Nullable
    public static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
    @Nullable
    public static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
    @Nullable
    public static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> onMaybeSubscribe;
    @Nullable
    public static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
    @Nullable
    public static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
    @Nullable
    public static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
    @Nullable
    public static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> onParallelAssembly;
    @Nullable
    public static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
    @Nullable
    public static volatile Function<? super Single, ? extends Single> onSingleAssembly;
    @Nullable
    public static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
    @Nullable
    public static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;
    public transient /* synthetic */ FieldHolder $fh;

    public RxJavaPlugins() {
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
    public static <T, R> R apply(@NonNull Function<T, R> function, @NonNull T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, function, t)) == null) {
            try {
                return function.apply(t);
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (R) invokeLL.objValue;
    }

    @NonNull
    public static Scheduler applyRequireNonNull(@NonNull Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, function, callable)) == null) ? (Scheduler) ObjectHelper.requireNonNull(apply(function, callable), "Scheduler Callable result can't be null") : (Scheduler) invokeLL.objValue;
    }

    @NonNull
    public static Scheduler callRequireNonNull(@NonNull Callable<Scheduler> callable) {
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

    @NonNull
    public static Scheduler createComputationScheduler(@NonNull ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, threadFactory)) == null) ? new ComputationScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null")) : (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler createIoScheduler(@NonNull ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, threadFactory)) == null) ? new IoScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null")) : (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler createNewThreadScheduler(@NonNull ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadFactory)) == null) ? new NewThreadScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null")) : (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler createSingleScheduler(@NonNull ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadFactory)) == null) ? new SingleScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null")) : (Scheduler) invokeL.objValue;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? onComputationHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Consumer<? super Throwable> getErrorHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? errorHandler : (Consumer) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? onInitComputationHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? onInitIoHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? onInitNewThreadHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? onInitSingleHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? onIoHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? onNewThreadHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static BooleanSupplier getOnBeforeBlocking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? onBeforeBlocking : (BooleanSupplier) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? onCompletableAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? onCompletableSubscribe : (BiFunction) invokeV.objValue;
    }

    @Nullable
    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? onConnectableFlowableAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? onConnectableObservableAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? onFlowableAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? onFlowableSubscribe : (BiFunction) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? onMaybeAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? onMaybeSubscribe : (BiFunction) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? onObservableAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? onObservableSubscribe : (BiFunction) invokeV.objValue;
    }

    @Beta
    @Nullable
    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? onParallelAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? onSingleAssembly : (Function) invokeV.objValue;
    }

    @Nullable
    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? onSingleSubscribe : (BiFunction) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? onScheduleHandler : (Function) invokeV.objValue;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? onSingleHandler : (Function) invokeV.objValue;
    }

    @NonNull
    public static Scheduler initComputationScheduler(@NonNull Callable<Scheduler> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitComputationHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler initIoScheduler(@NonNull Callable<Scheduler> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitIoHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler initNewThreadScheduler(@NonNull Callable<Scheduler> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitNewThreadHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler initSingleScheduler(@NonNull Callable<Scheduler> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
            Function<? super Callable<Scheduler>, ? extends Scheduler> function = onInitSingleHandler;
            if (function == null) {
                return callRequireNonNull(callable);
            }
            return applyRequireNonNull(function, callable);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static boolean isBug(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, th)) == null) ? (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException) : invokeL.booleanValue;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? failNonBlockingScheduler : invokeV.booleanValue;
    }

    public static boolean isLockdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? lockdown : invokeV.booleanValue;
    }

    public static void lockdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, null) == null) {
            lockdown = true;
        }
    }

    @NonNull
    public static <T> Maybe<T> onAssembly(@NonNull Maybe<T> maybe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, maybe)) == null) {
            Function<? super Maybe, ? extends Maybe> function = onMaybeAssembly;
            return function != null ? (Maybe) apply(function, maybe) : maybe;
        }
        return (Maybe) invokeL.objValue;
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

    @NonNull
    public static Scheduler onComputationScheduler(@NonNull Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, scheduler)) == null) {
            Function<? super Scheduler, ? extends Scheduler> function = onComputationHandler;
            return function == null ? scheduler : (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    public static void onError(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, null, th) == null) {
            Consumer<? super Throwable> consumer = errorHandler;
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

    @NonNull
    public static Scheduler onIoScheduler(@NonNull Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, scheduler)) == null) {
            Function<? super Scheduler, ? extends Scheduler> function = onIoHandler;
            return function == null ? scheduler : (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Scheduler onNewThreadScheduler(@NonNull Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, scheduler)) == null) {
            Function<? super Scheduler, ? extends Scheduler> function = onNewThreadHandler;
            return function == null ? scheduler : (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static Runnable onSchedule(@NonNull Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            Function<? super Runnable, ? extends Runnable> function = onScheduleHandler;
            return function == null ? runnable : (Runnable) apply(function, runnable);
        }
        return (Runnable) invokeL.objValue;
    }

    @NonNull
    public static Scheduler onSingleScheduler(@NonNull Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, scheduler)) == null) {
            Function<? super Scheduler, ? extends Scheduler> function = onSingleHandler;
            return function == null ? scheduler : (Scheduler) apply(function, scheduler);
        }
        return (Scheduler) invokeL.objValue;
    }

    @NonNull
    public static <T> Subscriber<? super T> onSubscribe(@NonNull Flowable<T> flowable, @NonNull Subscriber<? super T> subscriber) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65596, null, flowable, subscriber)) == null) {
            BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = onFlowableSubscribe;
            return biFunction != null ? (Subscriber) apply(biFunction, flowable, subscriber) : subscriber;
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

    public static void setComputationSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, null, function) == null) {
            if (!lockdown) {
                onComputationHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setErrorHandler(@Nullable Consumer<? super Throwable> consumer) {
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

    public static void setInitComputationSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65601, null, function) == null) {
            if (!lockdown) {
                onInitComputationHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitIoSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, null, function) == null) {
            if (!lockdown) {
                onInitIoHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitNewThreadSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, null, function) == null) {
            if (!lockdown) {
                onInitNewThreadHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setInitSingleSchedulerHandler(@Nullable Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65604, null, function) == null) {
            if (!lockdown) {
                onInitSingleHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setIoSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65605, null, function) == null) {
            if (!lockdown) {
                onIoHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setNewThreadSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65606, null, function) == null) {
            if (!lockdown) {
                onNewThreadHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnBeforeBlocking(@Nullable BooleanSupplier booleanSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65607, null, booleanSupplier) == null) {
            if (!lockdown) {
                onBeforeBlocking = booleanSupplier;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnCompletableAssembly(@Nullable Function<? super Completable, ? extends Completable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, null, function) == null) {
            if (!lockdown) {
                onCompletableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnCompletableSubscribe(@Nullable BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, biFunction) == null) {
            if (!lockdown) {
                onCompletableSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnConnectableFlowableAssembly(@Nullable Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, null, function) == null) {
            if (!lockdown) {
                onConnectableFlowableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnConnectableObservableAssembly(@Nullable Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, null, function) == null) {
            if (!lockdown) {
                onConnectableObservableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnFlowableAssembly(@Nullable Function<? super Flowable, ? extends Flowable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65612, null, function) == null) {
            if (!lockdown) {
                onFlowableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnFlowableSubscribe(@Nullable BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65613, null, biFunction) == null) {
            if (!lockdown) {
                onFlowableSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnMaybeAssembly(@Nullable Function<? super Maybe, ? extends Maybe> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65614, null, function) == null) {
            if (!lockdown) {
                onMaybeAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnMaybeSubscribe(@Nullable BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65615, null, biFunction) == null) {
            if (!lockdown) {
                onMaybeSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnObservableAssembly(@Nullable Function<? super Observable, ? extends Observable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, null, function) == null) {
            if (!lockdown) {
                onObservableAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnObservableSubscribe(@Nullable BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65617, null, biFunction) == null) {
            if (!lockdown) {
                onObservableSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    @Beta
    public static void setOnParallelAssembly(@Nullable Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65618, null, function) == null) {
            if (!lockdown) {
                onParallelAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnSingleAssembly(@Nullable Function<? super Single, ? extends Single> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65619, null, function) == null) {
            if (!lockdown) {
                onSingleAssembly = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setOnSingleSubscribe(@Nullable BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65620, null, biFunction) == null) {
            if (!lockdown) {
                onSingleSubscribe = biFunction;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setScheduleHandler(@Nullable Function<? super Runnable, ? extends Runnable> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65621, null, function) == null) {
            if (!lockdown) {
                onScheduleHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void setSingleSchedulerHandler(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65622, null, function) == null) {
            if (!lockdown) {
                onSingleHandler = function;
                return;
            }
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
    }

    public static void uncaught(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65623, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static void unlock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65624, null) == null) {
            lockdown = false;
        }
    }

    @NonNull
    public static <T, U, R> R apply(@NonNull BiFunction<T, U, R> biFunction, @NonNull T t, @NonNull U u) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, biFunction, t, u)) == null) {
            try {
                return biFunction.apply(t, u);
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (R) invokeLLL.objValue;
    }

    @NonNull
    public static <T> Flowable<T> onAssembly(@NonNull Flowable<T> flowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, flowable)) == null) {
            Function<? super Flowable, ? extends Flowable> function = onFlowableAssembly;
            return function != null ? (Flowable) apply(function, flowable) : flowable;
        }
        return (Flowable) invokeL.objValue;
    }

    @NonNull
    public static <T> Observer<? super T> onSubscribe(@NonNull Observable<T> observable, @NonNull Observer<? super T> observer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65594, null, observable, observer)) == null) {
            BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = onObservableSubscribe;
            return biFunction != null ? (Observer) apply(biFunction, observable, observer) : observer;
        }
        return (Observer) invokeLL.objValue;
    }

    @NonNull
    public static <T> ConnectableFlowable<T> onAssembly(@NonNull ConnectableFlowable<T> connectableFlowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, connectableFlowable)) == null) {
            Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = onConnectableFlowableAssembly;
            return function != null ? (ConnectableFlowable) apply(function, connectableFlowable) : connectableFlowable;
        }
        return (ConnectableFlowable) invokeL.objValue;
    }

    @NonNull
    public static <T> SingleObserver<? super T> onSubscribe(@NonNull Single<T> single, @NonNull SingleObserver<? super T> singleObserver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, single, singleObserver)) == null) {
            BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = onSingleSubscribe;
            return biFunction != null ? (SingleObserver) apply(biFunction, single, singleObserver) : singleObserver;
        }
        return (SingleObserver) invokeLL.objValue;
    }

    @NonNull
    public static <T> Observable<T> onAssembly(@NonNull Observable<T> observable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, observable)) == null) {
            Function<? super Observable, ? extends Observable> function = onObservableAssembly;
            return function != null ? (Observable) apply(function, observable) : observable;
        }
        return (Observable) invokeL.objValue;
    }

    @NonNull
    public static CompletableObserver onSubscribe(@NonNull Completable completable, @NonNull CompletableObserver completableObserver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, completable, completableObserver)) == null) {
            BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = onCompletableSubscribe;
            return biFunction != null ? (CompletableObserver) apply(biFunction, completable, completableObserver) : completableObserver;
        }
        return (CompletableObserver) invokeLL.objValue;
    }

    @NonNull
    public static <T> ConnectableObservable<T> onAssembly(@NonNull ConnectableObservable<T> connectableObservable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, connectableObservable)) == null) {
            Function<? super ConnectableObservable, ? extends ConnectableObservable> function = onConnectableObservableAssembly;
            return function != null ? (ConnectableObservable) apply(function, connectableObservable) : connectableObservable;
        }
        return (ConnectableObservable) invokeL.objValue;
    }

    @NonNull
    public static <T> MaybeObserver<? super T> onSubscribe(@NonNull Maybe<T> maybe, @NonNull MaybeObserver<? super T> maybeObserver) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, null, maybe, maybeObserver)) == null) {
            BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = onMaybeSubscribe;
            return biFunction != null ? (MaybeObserver) apply(biFunction, maybe, maybeObserver) : maybeObserver;
        }
        return (MaybeObserver) invokeLL.objValue;
    }

    @NonNull
    public static <T> Single<T> onAssembly(@NonNull Single<T> single) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, single)) == null) {
            Function<? super Single, ? extends Single> function = onSingleAssembly;
            return function != null ? (Single) apply(function, single) : single;
        }
        return (Single) invokeL.objValue;
    }

    @NonNull
    public static Completable onAssembly(@NonNull Completable completable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, completable)) == null) {
            Function<? super Completable, ? extends Completable> function = onCompletableAssembly;
            return function != null ? (Completable) apply(function, completable) : completable;
        }
        return (Completable) invokeL.objValue;
    }

    @Beta
    @NonNull
    public static <T> ParallelFlowable<T> onAssembly(@NonNull ParallelFlowable<T> parallelFlowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, parallelFlowable)) == null) {
            Function<? super ParallelFlowable, ? extends ParallelFlowable> function = onParallelAssembly;
            return function != null ? (ParallelFlowable) apply(function, parallelFlowable) : parallelFlowable;
        }
        return (ParallelFlowable) invokeL.objValue;
    }
}
