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
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDetach;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableHide;
import io.reactivex.internal.operators.completable.CompletableLift;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
/* loaded from: classes3.dex */
public abstract class Completable implements CompletableSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Completable() {
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
    public static Completable amb(Iterable<? extends CompletableSource> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new CompletableAmb(null, iterable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable ambArray(CompletableSource... completableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, completableSourceArr)) == null) {
            ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
            if (completableSourceArr.length == 0) {
                return complete();
            }
            if (completableSourceArr.length == 1) {
                return wrap(completableSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new CompletableAmb(completableSourceArr, null));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable complete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? RxJavaPlugins.onAssembly(CompletableEmpty.INSTANCE) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable concat(Iterable<? extends CompletableSource> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new CompletableConcatIterable(iterable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable concatArray(CompletableSource... completableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, completableSourceArr)) == null) {
            ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
            if (completableSourceArr.length == 0) {
                return complete();
            }
            if (completableSourceArr.length == 1) {
                return wrap(completableSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new CompletableConcatArray(completableSourceArr));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable create(CompletableOnSubscribe completableOnSubscribe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, completableOnSubscribe)) == null) {
            ObjectHelper.requireNonNull(completableOnSubscribe, "source is null");
            return RxJavaPlugins.onAssembly(new CompletableCreate(completableOnSubscribe));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable defer(Callable<? extends CompletableSource> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "completableSupplier");
            return RxJavaPlugins.onAssembly(new CompletableDefer(callable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{consumer, consumer2, action, action2, action3, action4})) == null) {
            ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ObjectHelper.requireNonNull(action2, "onTerminate is null");
            ObjectHelper.requireNonNull(action3, "onAfterTerminate is null");
            ObjectHelper.requireNonNull(action4, "onDispose is null");
            return RxJavaPlugins.onAssembly(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable error(Callable<? extends Throwable> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "errorSupplier is null");
            return RxJavaPlugins.onAssembly(new CompletableErrorSupplier(callable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromAction(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, action)) == null) {
            ObjectHelper.requireNonNull(action, "run is null");
            return RxJavaPlugins.onAssembly(new CompletableFromAction(action));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromCallable(Callable<?> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "callable is null");
            return RxJavaPlugins.onAssembly(new CompletableFromCallable(callable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromFuture(Future<?> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, future)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return fromAction(Functions.futureAction(future));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromObservable(ObservableSource<T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "observable is null");
            return RxJavaPlugins.onAssembly(new CompletableFromObservable(observableSource));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Completable fromPublisher(Publisher<T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "publisher is null");
            return RxJavaPlugins.onAssembly(new CompletableFromPublisher(publisher));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromRunnable(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            return RxJavaPlugins.onAssembly(new CompletableFromRunnable(runnable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromSingle(SingleSource<T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "single is null");
            return RxJavaPlugins.onAssembly(new CompletableFromSingle(singleSource));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable merge(Iterable<? extends CompletableSource> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new CompletableMergeIterable(iterable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable merge0(Publisher<? extends CompletableSource> publisher, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{publisher, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new CompletableMerge(publisher, i2, z));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeArray(CompletableSource... completableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, completableSourceArr)) == null) {
            ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
            if (completableSourceArr.length == 0) {
                return complete();
            }
            if (completableSourceArr.length == 1) {
                return wrap(completableSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new CompletableMergeArray(completableSourceArr));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeArrayDelayError(CompletableSource... completableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, completableSourceArr)) == null) {
            ObjectHelper.requireNonNull(completableSourceArr, "sources is null");
            return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorArray(completableSourceArr));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeDelayError(Iterable<? extends CompletableSource> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new CompletableMergeDelayErrorIterable(iterable));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? RxJavaPlugins.onAssembly(CompletableNever.INSTANCE) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    private Completable timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, completableSource})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new CompletableTimeout(this, j, timeUnit, scheduler, completableSource));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Completable timer(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65567, null, j, timeUnit)) == null) ? timer(j, timeUnit, Schedulers.computation()) : (Completable) invokeJL.objValue;
    }

    public static NullPointerException toNpe(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, th)) == null) {
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            return nullPointerException;
        }
        return (NullPointerException) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable unsafeCreate(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "source is null");
            if (!(completableSource instanceof Completable)) {
                return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(completableSource));
            }
            throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65571, null, callable, function, consumer)) == null) ? using(callable, function, consumer, true) : (Completable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable wrap(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "source is null");
            if (completableSource instanceof Completable) {
                return RxJavaPlugins.onAssembly((Completable) completableSource);
            }
            return RxJavaPlugins.onAssembly(new CompletableFromUnsafeSource(completableSource));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ambWith(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return ambArray(this, completableSource);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> andThen(ObservableSource<T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "next is null");
            return RxJavaPlugins.onAssembly(new ObservableDelaySubscriptionOther(observableSource, toObservable()));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull CompletableConverter<? extends R> completableConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, completableConverter)) == null) ? (R) ((CompletableConverter) ObjectHelper.requireNonNull(completableConverter, "converter is null")).apply(this) : (R) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingAwait() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            blockingMultiObserver.blockingGet();
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            return blockingMultiObserver.blockingGetError();
        }
        return (Throwable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? RxJavaPlugins.onAssembly(new CompletableCache(this)) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable compose(CompletableTransformer completableTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, completableTransformer)) == null) ? wrap(((CompletableTransformer) ObjectHelper.requireNonNull(completableTransformer, "transformer is null")).apply(this)) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatWith(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return concatArray(this, completableSource);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable delay(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048590, this, j, timeUnit)) == null) ? delay(j, timeUnit, Schedulers.computation(), false) : (Completable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doAfterTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, action)) == null) {
            Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
            Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
            Action action2 = Functions.EMPTY_ACTION;
            return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action, action2);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doFinally(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return RxJavaPlugins.onAssembly(new CompletableDoFinally(this, action));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnComplete(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, action)) == null) {
            Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
            Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
            Action action2 = Functions.EMPTY_ACTION;
            return doOnLifecycle(emptyConsumer, emptyConsumer2, action, action2, action2, action2);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnDispose(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, action)) == null) {
            Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
            Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
            Action action2 = Functions.EMPTY_ACTION;
            return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action2, action2, action);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnError(Consumer<? super Throwable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, consumer)) == null) {
            Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnLifecycle(emptyConsumer, consumer, action, action, action, action);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnEvent(Consumer<? super Throwable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onEvent is null");
            return RxJavaPlugins.onAssembly(new CompletableDoOnEvent(this, consumer));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnSubscribe(Consumer<? super Disposable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, consumer)) == null) {
            Consumer<? super Throwable> emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnLifecycle(consumer, emptyConsumer, action, action, action, action);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, action)) == null) {
            Consumer<? super Disposable> emptyConsumer = Functions.emptyConsumer();
            Consumer<? super Throwable> emptyConsumer2 = Functions.emptyConsumer();
            Action action2 = Functions.EMPTY_ACTION;
            return doOnLifecycle(emptyConsumer, emptyConsumer2, action2, action, action2, action2);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? RxJavaPlugins.onAssembly(new CompletableHide(this)) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable lift(CompletableOperator completableOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, completableOperator)) == null) {
            ObjectHelper.requireNonNull(completableOperator, "onLift is null");
            return RxJavaPlugins.onAssembly(new CompletableLift(this, completableOperator));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable mergeWith(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return mergeArray(this, completableSource);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new CompletableObserveOn(this, scheduler));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? onErrorComplete(Functions.alwaysTrue()) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "errorMapper is null");
            return RxJavaPlugins.onAssembly(new CompletableResumeNext(this, function));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? RxJavaPlugins.onAssembly(new CompletableDetach(this)) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? fromPublisher(toFlowable().repeat()) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeatUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, booleanSupplier)) == null) ? fromPublisher(toFlowable().repeatUntil(booleanSupplier)) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, function)) == null) ? fromPublisher(toFlowable().repeatWhen(function)) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? fromPublisher(toFlowable().retry()) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, function)) == null) ? fromPublisher(toFlowable().retryWhen(function)) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable startWith(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return concatArray(completableSource, this);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
            subscribe(emptyCompletableObserver);
            return emptyCompletableObserver;
        }
        return (Disposable) invokeV.objValue;
    }

    public abstract void subscribeActual(CompletableObserver completableObserver);

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable subscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new CompletableSubscribeOn(this, scheduler));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends CompletableObserver> E subscribeWith(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, e2)) == null) {
            subscribe(e2);
            return e2;
        }
        return (E) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            TestObserver<Void> testObserver = new TestObserver<>();
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048631, this, j, timeUnit)) == null) ? timeout0(j, timeUnit, Schedulers.computation(), null) : (Completable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> U to(Function<? super Completable, U> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, function)) == null) {
            try {
                return (U) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (U) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> toFlowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this instanceof FuseToFlowable) {
                return ((FuseToFlowable) this).fuseToFlowable();
            }
            return RxJavaPlugins.onAssembly(new CompletableToFlowable(this));
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Maybe<T> toMaybe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (this instanceof FuseToMaybe) {
                return ((FuseToMaybe) this).fuseToMaybe();
            }
            return RxJavaPlugins.onAssembly(new MaybeFromCompletable(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> toObservable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this instanceof FuseToObservable) {
                return ((FuseToObservable) this).fuseToObservable();
            }
            return RxJavaPlugins.onAssembly(new CompletableToObservable(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> toSingle(Callable<? extends T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "completionValueSupplier is null");
            return RxJavaPlugins.onAssembly(new CompletableToSingle(this, callable, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> toSingleDefault(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "completionValue is null");
            return RxJavaPlugins.onAssembly(new CompletableToSingle(this, null, t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable unsubscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new CompletableDisposeOn(this, scheduler));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Completable timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65568, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new CompletableTimer(j, timeUnit, scheduler));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{callable, function, consumer, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
            ObjectHelper.requireNonNull(function, "completableFunction is null");
            ObjectHelper.requireNonNull(consumer, "disposer is null");
            return RxJavaPlugins.onAssembly(new CompletableUsing(callable, function, consumer, z));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) ? delay(j, timeUnit, scheduler, false) : (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorComplete(Predicate<? super Throwable> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new CompletableOnErrorComplete(this, predicate));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j)) == null) ? fromPublisher(toFlowable().repeat(j)) : (Completable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, biPredicate)) == null) ? fromPublisher(toFlowable().retry(biPredicate)) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable timeout(long j, TimeUnit timeUnit, CompletableSource completableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Long.valueOf(j), timeUnit, completableSource})) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return timeout0(j, timeUnit, Schedulers.computation(), completableSource);
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable concat(Publisher<? extends CompletableSource> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, publisher)) == null) ? concat(publisher, 2) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "error is null");
            return RxJavaPlugins.onAssembly(new CompletableError(th));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Completable merge(Publisher<? extends CompletableSource> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, publisher)) == null) ? merge0(publisher, Integer.MAX_VALUE, false) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, publisher)) == null) ? merge0(publisher, Integer.MAX_VALUE, true) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> andThen(Publisher<T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "next is null");
            return RxJavaPlugins.onAssembly(new FlowableDelaySubscriptionOther(publisher, toFlowable()));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new CompletableDelay(this, j, timeUnit, scheduler, z));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048614, this, j)) == null) ? fromPublisher(toFlowable().retry(j)) : (Completable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> startWith(Observable<T> observable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, observable)) == null) {
            ObjectHelper.requireNonNull(observable, "other is null");
            return observable.concatWith(toObservable());
        }
        return (Observable) invokeL.objValue;
    }

    @Override // io.reactivex.CompletableSource
    @SchedulerSupport("none")
    public final void subscribe(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, completableObserver) == null) {
            ObjectHelper.requireNonNull(completableObserver, "s is null");
            try {
                subscribeActual(RxJavaPlugins.onSubscribe(this, completableObserver));
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
                throw toNpe(th);
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
            TestObserver<Void> testObserver = new TestObserver<>();
            if (z) {
                testObserver.cancel();
            }
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable concat(Publisher<? extends CompletableSource> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, publisher, i2)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new CompletableConcat(publisher, i2));
        }
        return (Completable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable merge(Publisher<? extends CompletableSource> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, publisher, i2)) == null) ? merge0(publisher, i2, false) : (Completable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, publisher, i2)) == null) ? merge0(publisher, i2, true) : (Completable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, timeUnit)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            return blockingMultiObserver.blockingAwait(j, timeUnit);
        }
        return invokeJL.booleanValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, timeUnit)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            return blockingMultiObserver.blockingGetError(j, timeUnit);
        }
        return (Throwable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable retry(long j, Predicate<? super Throwable> predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048615, this, j, predicate)) == null) ? fromPublisher(toFlowable().retry(j, predicate)) : (Completable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) ? timeout0(j, timeUnit, scheduler, null) : (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> andThen(SingleSource<T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "next is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(singleSource, this));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(Predicate<? super Throwable> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, predicate)) == null) ? fromPublisher(toFlowable().retry(predicate)) : (Completable) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: org.reactivestreams.Publisher<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> startWith(Publisher<T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return toFlowable().startWith((Publisher) publisher);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, completableSource})) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return timeout0(j, timeUnit, scheduler, completableSource);
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Maybe<T> andThen(MaybeSource<T> maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "next is null");
            return RxJavaPlugins.onAssembly(new MaybeDelayWithCompletable(maybeSource, this));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable andThen(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, completableSource)) == null) ? concatWith(completableSource) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, action, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
            subscribe(callbackCompletableObserver);
            return callbackCompletableObserver;
        }
        return (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onComplete is null");
            CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
            subscribe(callbackCompletableObserver);
            return callbackCompletableObserver;
        }
        return (Disposable) invokeL.objValue;
    }
}
