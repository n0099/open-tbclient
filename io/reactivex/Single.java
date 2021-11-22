package io.reactivex;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
/* loaded from: classes2.dex */
public abstract class Single<T> implements SingleSource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Single() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new SingleAmb(null, iterable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> ambArray(SingleSource<? extends T>... singleSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, singleSourceArr)) == null) {
            if (singleSourceArr.length == 0) {
                return error(SingleInternalHelper.emptyThrower());
            }
            if (singleSourceArr.length == 1) {
                return wrap(singleSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new SingleAmb(singleSourceArr, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, iterable)) == null) ? concat(Flowable.fromIterable(iterable)) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArray(SingleSource<? extends T>... singleSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, singleSourceArr)) == null) ? RxJavaPlugins.onAssembly(new FlowableConcatMap(Flowable.fromArray(singleSourceArr), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY)) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, singleOnSubscribe)) == null) {
            ObjectHelper.requireNonNull(singleOnSubscribe, "source is null");
            return RxJavaPlugins.onAssembly(new SingleCreate(singleOnSubscribe));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "singleSupplier is null");
            return RxJavaPlugins.onAssembly(new SingleDefer(callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> equals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "first is null");
            ObjectHelper.requireNonNull(singleSource2, "second is null");
            return RxJavaPlugins.onAssembly(new SingleEquals(singleSource, singleSource2));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> error(Callable<? extends Throwable> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "errorSupplier is null");
            return RxJavaPlugins.onAssembly(new SingleError(callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromCallable(Callable<? extends T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "callable is null");
            return RxJavaPlugins.onAssembly(new SingleFromCallable(callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, future)) == null) ? toSingle(Flowable.fromFuture(future)) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromObservable(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "observableSource is null");
            return RxJavaPlugins.onAssembly(new ObservableSingleSingle(observableSource, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Single<T> fromPublisher(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "publisher is null");
            return RxJavaPlugins.onAssembly(new SingleFromPublisher(publisher));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> just(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, t)) == null) {
            ObjectHelper.requireNonNull(t, "value is null");
            return RxJavaPlugins.onAssembly(new SingleJust(t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, iterable)) == null) ? merge(Flowable.fromIterable(iterable)) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, iterable)) == null) ? mergeDelayError(Flowable.fromIterable(iterable)) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? RxJavaPlugins.onAssembly(SingleNever.INSTANCE) : (Single) invokeV.objValue;
    }

    private Single<T> timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, singleSource})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleTimeout(this, j, timeUnit, scheduler, singleSource));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Single<Long> timer(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65573, null, j, timeUnit)) == null) ? timer(j, timeUnit, Schedulers.computation()) : (Single) invokeJL.objValue;
    }

    public static <T> Single<T> toSingle(Flowable<T> flowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, flowable)) == null) ? RxJavaPlugins.onAssembly(new FlowableSingleSingle(flowable, null)) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> unsafeCreate(SingleSource<T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "onSubscribe is null");
            if (!(singleSource instanceof Single)) {
                return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(singleSource));
            }
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65577, null, callable, function, consumer)) == null) ? using(callable, function, consumer, true) : (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> wrap(SingleSource<T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source is null");
            if (singleSource instanceof Single) {
                return RxJavaPlugins.onAssembly((Single) singleSource);
            }
            return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(singleSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, iterable, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new SingleZipIterable(iterable, function));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> function, SingleSource<? extends T>... singleSourceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, function, singleSourceArr)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(singleSourceArr, "sources is null");
            if (singleSourceArr.length == 0) {
                return error(new NoSuchElementException());
            }
            return RxJavaPlugins.onAssembly(new SingleZipArray(singleSourceArr, function));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> ambWith(SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return ambArray(this, singleSource);
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull SingleConverter<T, ? extends R> singleConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, singleConverter)) == null) ? (R) ((SingleConverter) ObjectHelper.requireNonNull(singleConverter, "converter is null")).apply(this) : (R) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            return (T) blockingMultiObserver.blockingGet();
        }
        return (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? RxJavaPlugins.onAssembly(new SingleCache(this)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> cast(Class<? extends U> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return (Single<U>) map(Functions.castFunction(cls));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> singleTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, singleTransformer)) == null) ? wrap(((SingleTransformer) ObjectHelper.requireNonNull(singleTransformer, "transformer is null")).apply(this)) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, singleSource)) == null) ? concat(this, singleSource) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? contains(obj, ObjectHelper.equalsPredicate()) : (Single) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> delay(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) ? delay(j, timeUnit, Schedulers.computation(), false) : (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> delaySubscription(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(this, completableSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doAfterSuccess(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "doAfterSuccess is null");
            return RxJavaPlugins.onAssembly(new SingleDoAfterSuccess(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doAfterTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
            return RxJavaPlugins.onAssembly(new SingleDoAfterTerminate(this, action));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doFinally(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return RxJavaPlugins.onAssembly(new SingleDoFinally(this, action));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnDispose(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onDispose is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnDispose(this, action));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnError(Consumer<? super Throwable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onError is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnError(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnEvent(this, biConsumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnSubscribe(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> doOnSuccess(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSuccess is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnSuccess(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> filter(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new MaybeFilterSingle(this, predicate));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMap(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapCompletable(this, function));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapMaybe(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, function)) == null) ? toObservable().flatMap(function) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, function)) == null) ? toFlowable().flatMap(function) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapIterableFlowable(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapIterableObservable(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? RxJavaPlugins.onAssembly(new SingleHide(this)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> singleOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, singleOperator)) == null) {
            ObjectHelper.requireNonNull(singleOperator, "onLift is null");
            return RxJavaPlugins.onAssembly(new SingleLift(this, singleOperator));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> map(Function<? super T, ? extends R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleMap(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, singleSource)) == null) ? merge(this, singleSource) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Single<T> observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleObserveOn(this, scheduler));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorResumeNext(Single<? extends T> single) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, single)) == null) {
            ObjectHelper.requireNonNull(single, "resumeSingleInCaseOfError is null");
            return onErrorResumeNext(Functions.justFunction(single));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorReturn(Function<Throwable, ? extends T> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunction is null");
            return RxJavaPlugins.onAssembly(new SingleOnErrorReturn(this, function, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorReturnItem(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "value is null");
            return RxJavaPlugins.onAssembly(new SingleOnErrorReturn(this, null, t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Single<T> onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? RxJavaPlugins.onAssembly(new SingleDetach(this)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? toFlowable().repeat() : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, booleanSupplier)) == null) ? toFlowable().repeatUntil(booleanSupplier) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, function)) == null) ? toFlowable().repeatWhen(function) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? toSingle(toFlowable().retry()) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, function)) == null) ? toSingle(toFlowable().retryWhen(function)) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING) : (Disposable) invokeV.objValue;
    }

    public abstract void subscribeActual(@NonNull SingleObserver<? super T> singleObserver);

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Single<T> subscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleSubscribeOn(this, scheduler));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends SingleObserver<? super T>> E subscribeWith(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, e2)) == null) {
            subscribe(e2);
            return e2;
        }
        return (E) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> takeUntil(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return takeUntil(new CompletableToFlowable(completableSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            TestObserver<T> testObserver = new TestObserver<>();
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048644, this, j, timeUnit)) == null) ? timeout0(j, timeUnit, Schedulers.computation(), null) : (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super Single<T>, R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, function)) == null) {
            try {
                return (R) ((Function) ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (R) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable toCompletable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? RxJavaPlugins.onAssembly(new CompletableFromSingle(this)) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> toFlowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (this instanceof FuseToFlowable) {
                return ((FuseToFlowable) this).fuseToFlowable();
            }
            return RxJavaPlugins.onAssembly(new SingleToFlowable(this));
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? (Future) subscribeWith(new FutureSingleObserver()) : (Future) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> toMaybe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this instanceof FuseToMaybe) {
                return ((FuseToMaybe) this).fuseToMaybe();
            }
            return RxJavaPlugins.onAssembly(new MaybeFromSingle(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> toObservable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this instanceof FuseToObservable) {
                return ((FuseToObservable) this).fuseToObservable();
            }
            return RxJavaPlugins.onAssembly(new SingleToObservable(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    @Experimental
    public final Single<T> unsubscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleUnsubscribeOn(this, scheduler));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Single<R> zipWith(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048655, this, singleSource, biFunction)) == null) ? zip(this, singleSource, biFunction) : (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{future, Long.valueOf(j), timeUnit})) == null) ? toSingle(Flowable.fromFuture(future, j, timeUnit)) : (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, Flowable.bufferSize()));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, Flowable.bufferSize()));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Single<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleTimer(j, timeUnit, scheduler));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{callable, function, consumer, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
            ObjectHelper.requireNonNull(function, "singleFunction is null");
            ObjectHelper.requireNonNull(consumer, "disposer is null");
            return RxJavaPlugins.onAssembly(new SingleUsing(callable, function, consumer, z));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object obj, BiPredicate<Object, Object> biPredicate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, biPredicate)) == null) {
            ObjectHelper.requireNonNull(obj, "value is null");
            ObjectHelper.requireNonNull(biPredicate, "comparer is null");
            return RxJavaPlugins.onAssembly(new SingleContains(this, obj, biPredicate));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    @Experimental
    public final Single<T> delay(long j, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), timeUnit, Boolean.valueOf(z)})) == null) ? delay(j, timeUnit, Schedulers.computation(), z) : (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048622, this, j)) == null) ? toFlowable().repeat(j) : (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048626, this, j)) == null) ? toSingle(toFlowable().retry(j)) : (Single) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "onCallback is null");
            BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
            subscribe(biConsumerSingleObserver);
            return biConsumerSingleObserver;
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048645, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) ? timeout0(j, timeUnit, scheduler, null) : (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "error is null");
            return error(Functions.justCallable(th));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{future, Long.valueOf(j), timeUnit, scheduler})) == null) ? toSingle(Flowable.fromFuture(future, j, timeUnit, scheduler)) : (Single) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) ? delay(j, timeUnit, scheduler, false) : (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<T> delaySubscription(SingleSource<U> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithSingle(this, singleSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunctionInCaseOfError is null");
            return RxJavaPlugins.onAssembly(new SingleResumeNext(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, biPredicate)) == null) ? toSingle(toFlowable().retry(biPredicate)) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <E> Single<T> takeUntil(Publisher<E> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new SingleTakeUntil(this, publisher));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
            TestObserver<T> testObserver = new TestObserver<>();
            if (z) {
                testObserver.cancel();
            }
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeZ.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, singleSource})) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return timeout0(j, timeUnit, scheduler, singleSource);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, publisher)) == null) ? concat(publisher, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static <T> Single<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, future, scheduler)) == null) ? toSingle(Flowable.fromFuture(future, scheduler)) : (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMap(singleSource, Functions.identity()));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return mergeDelayError(Flowable.fromArray(singleSource, singleSource2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65587, null, singleSource, singleSource2, biFunction)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), singleSource, singleSource2);
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    @Experimental
    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleDelay(this, j, timeUnit, scheduler, z));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Single<T> retry(long j, Predicate<? super Throwable> predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048627, this, j, predicate)) == null) ? toSingle(toFlowable().retry(j, predicate)) : (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, publisher, i2)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapPublisher(publisher, SingleInternalHelper.toFlowable(), i2, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<T> delaySubscription(ObservableSource<U> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithObservable(this, observableSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> retry(Predicate<? super Throwable> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, predicate)) == null) ? toSingle(toFlowable().retry(predicate)) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, consumer)) == null) ? subscribe(consumer, Functions.ON_ERROR_MISSING) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E> Single<T> takeUntil(SingleSource<? extends E> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return takeUntil(new SingleToFlowable(singleSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> timeout(long j, TimeUnit timeUnit, SingleSource<? extends T> singleSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Long.valueOf(j), timeUnit, singleSource})) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return timeout0(j, timeUnit, Schedulers.computation(), singleSource);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return merge(Flowable.fromArray(singleSource, singleSource2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, consumer, consumer2)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSuccess is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
            subscribe(consumerSingleObserver);
            return consumerSingleObserver;
        }
        return (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, singleSource, singleSource2, singleSource3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return mergeDelayError(Flowable.fromArray(singleSource, singleSource2, singleSource3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65586, null, singleSource, singleSource2, singleSource3, function3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return zipArray(Functions.toFunction(function3), singleSource, singleSource2, singleSource3);
        }
        return (Single) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Single<T> delaySubscription(Publisher<U> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithPublisher(this, publisher));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return concat(Flowable.fromArray(singleSource, singleSource2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, singleSource, singleSource2, singleSource3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return merge(Flowable.fromArray(singleSource, singleSource2, singleSource3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single<T> delaySubscription(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) ? delaySubscription(j, timeUnit, Schedulers.computation()) : (Single) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Single<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) ? delaySubscription(Observable.timer(j, timeUnit, scheduler)) : (Single) invokeCommon.objValue;
    }

    @Override // io.reactivex.SingleSource
    @SchedulerSupport("none")
    public final void subscribe(SingleObserver<? super T> singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, singleObserver) == null) {
            ObjectHelper.requireNonNull(singleObserver, "subscriber is null");
            SingleObserver<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, singleObserver);
            ObjectHelper.requireNonNull(onSubscribe, "subscriber returned by the RxJavaPlugins hook is null");
            try {
                subscribeActual(onSubscribe);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, singleSource, singleSource2, singleSource3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return concat(Flowable.fromArray(singleSource, singleSource2, singleSource3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65568, null, singleSource, singleSource2, singleSource3, singleSource4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return mergeDelayError(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65585, null, singleSource, singleSource2, singleSource3, singleSource4, function4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return zipArray(Functions.toFunction(function4), singleSource, singleSource2, singleSource3, singleSource4);
        }
        return (Single) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65562, null, singleSource, singleSource2, singleSource3, singleSource4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return merge(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, singleSource, singleSource2, singleSource3, singleSource4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return concat(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65584, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, function5})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            return zipArray(Functions.toFunction(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, function6})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            return zipArray(Functions.toFunction(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65582, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, function7})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            ObjectHelper.requireNonNull(singleSource7, "source7 is null");
            return zipArray(Functions.toFunction(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, function8})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            ObjectHelper.requireNonNull(singleSource7, "source7 is null");
            ObjectHelper.requireNonNull(singleSource8, "source8 is null");
            return zipArray(Functions.toFunction(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, SingleSource<? extends T9> singleSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9, function9})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            ObjectHelper.requireNonNull(singleSource7, "source7 is null");
            ObjectHelper.requireNonNull(singleSource8, "source8 is null");
            ObjectHelper.requireNonNull(singleSource9, "source9 is null");
            return zipArray(Functions.toFunction(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
        }
        return (Single) invokeCommon.objValue;
    }
}
