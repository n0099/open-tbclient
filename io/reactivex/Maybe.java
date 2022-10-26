package io.reactivex;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
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
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.maybe.MaybeAmb;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeContains;
import io.reactivex.internal.operators.maybe.MaybeCount;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDefer;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDetach;
import io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.internal.operators.maybe.MaybeEmpty;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeError;
import io.reactivex.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.internal.operators.maybe.MaybeFilter;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeFromAction;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.maybe.MaybeHide;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeJust;
import io.reactivex.internal.operators.maybe.MaybeLift;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeNever;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeToSingle;
import io.reactivex.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
/* loaded from: classes8.dex */
public abstract class Maybe implements MaybeSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void subscribeActual(MaybeObserver maybeObserver);

    public Maybe() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe empty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return RxJavaPlugins.onAssembly(MaybeEmpty.INSTANCE);
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return RxJavaPlugins.onAssembly(MaybeNever.INSTANCE);
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingGet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            return blockingMultiObserver.blockingGet();
        }
        return invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeCache(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeCount(this));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeHide(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ignoreElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeIgnoreElementCompletable(this));
        }
        return (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeIsEmptySingle(this));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onErrorComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return onErrorComplete(Functions.alwaysTrue());
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeDetach(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return repeat(Long.MAX_VALUE);
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return retry(Long.MAX_VALUE, Functions.alwaysTrue());
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
        }
        return (Disposable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            TestObserver testObserver = new TestObserver();
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable toFlowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this instanceof FuseToFlowable) {
                return ((FuseToFlowable) this).fuseToFlowable();
            }
            return RxJavaPlugins.onAssembly(new MaybeToFlowable(this));
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable toObservable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (this instanceof FuseToObservable) {
                return ((FuseToObservable) this).fuseToObservable();
            }
            return RxJavaPlugins.onAssembly(new MaybeToObservable(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toSingle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return RxJavaPlugins.onAssembly(new MaybeToSingle(this, null));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe amb(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new MaybeAmb(null, iterable));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new MaybeConcatIterable(iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatArrayEager(MaybeSource... maybeSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, maybeSourceArr)) == null) {
            return Flowable.fromArray(maybeSourceArr).concatMapEager(MaybeToPublisher.instance());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatDelayError(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return Flowable.fromIterable(iterable).concatMapDelayError(MaybeToPublisher.instance());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatEager(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, iterable)) == null) {
            return Flowable.fromIterable(iterable).concatMapEager(MaybeToPublisher.instance());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe create(MaybeOnSubscribe maybeOnSubscribe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, maybeOnSubscribe)) == null) {
            ObjectHelper.requireNonNull(maybeOnSubscribe, "onSubscribe is null");
            return RxJavaPlugins.onAssembly(new MaybeCreate(maybeOnSubscribe));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe defer(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "maybeSupplier is null");
            return RxJavaPlugins.onAssembly(new MaybeDefer(callable));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "exception is null");
            return RxJavaPlugins.onAssembly(new MaybeError(th));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromAction(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, action)) == null) {
            ObjectHelper.requireNonNull(action, "run is null");
            return RxJavaPlugins.onAssembly(new MaybeFromAction(action));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromCallable(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "callable is null");
            return RxJavaPlugins.onAssembly(new MaybeFromCallable(callable));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromCompletable(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "completableSource is null");
            return RxJavaPlugins.onAssembly(new MaybeFromCompletable(completableSource));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromFuture(Future future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, future)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return RxJavaPlugins.onAssembly(new MaybeFromFuture(future, 0L, null));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromRunnable(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "run is null");
            return RxJavaPlugins.onAssembly(new MaybeFromRunnable(runnable));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromSingle(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "singleSource is null");
            return RxJavaPlugins.onAssembly(new MaybeFromSingle(singleSource));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe just(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return RxJavaPlugins.onAssembly(new MaybeJust(obj));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, iterable)) == null) {
            return merge(Flowable.fromIterable(iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeArrayDelayError(MaybeSource... maybeSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, maybeSourceArr)) == null) {
            if (maybeSourceArr.length == 0) {
                return Flowable.empty();
            }
            return Flowable.fromArray(maybeSourceArr).flatMap(MaybeToPublisher.instance(), true, maybeSourceArr.length);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, iterable)) == null) {
            return Flowable.fromIterable(iterable).flatMap(MaybeToPublisher.instance(), true);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe unsafeCreate(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, maybeSource)) == null) {
            if (!(maybeSource instanceof Maybe)) {
                ObjectHelper.requireNonNull(maybeSource, "onSubscribe is null");
                return RxJavaPlugins.onAssembly(new MaybeUnsafeCreate(maybeSource));
            }
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe wrap(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, maybeSource)) == null) {
            if (maybeSource instanceof Maybe) {
                return RxJavaPlugins.onAssembly((Maybe) maybeSource);
            }
            ObjectHelper.requireNonNull(maybeSource, "onSubscribe is null");
            return RxJavaPlugins.onAssembly(new MaybeUnsafeCreate(maybeSource));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe ambWith(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return ambArray(this, maybeSource);
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object as(MaybeConverter maybeConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, maybeConverter)) == null) {
            return ((MaybeConverter) ObjectHelper.requireNonNull(maybeConverter, "converter is null")).apply(this);
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingGet(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "defaultValue is null");
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            subscribe(blockingMultiObserver);
            return blockingMultiObserver.blockingGet(obj);
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe cast(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return map(Functions.castFunction(cls));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe compose(MaybeTransformer maybeTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, maybeTransformer)) == null) {
            return wrap(((MaybeTransformer) ObjectHelper.requireNonNull(maybeTransformer, "transformer is null")).apply(this));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe concatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatten(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable concatWith(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return concat(this, maybeSource);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return RxJavaPlugins.onAssembly(new MaybeContains(this, obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe defaultIfEmpty(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return switchIfEmpty(just(obj));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe delay(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "delayIndicator is null");
            return RxJavaPlugins.onAssembly(new MaybeDelayOtherPublisher(this, publisher));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe delaySubscription(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "subscriptionIndicator is null");
            return RxJavaPlugins.onAssembly(new MaybeDelaySubscriptionOtherPublisher(this, publisher));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doAfterSuccess(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "doAfterSuccess is null");
            return RxJavaPlugins.onAssembly(new MaybeDoAfterSuccess(this, consumer));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doFinally(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return RxJavaPlugins.onAssembly(new MaybeDoFinally(this, action));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doOnEvent(BiConsumer biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
            return RxJavaPlugins.onAssembly(new MaybeDoOnEvent(this, biConsumer));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe filter(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new MaybeFilter(this, predicate));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe flatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatten(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapCompletable(this, function));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMapObservable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, function)) == null) {
            return toObservable().flatMap(function);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable flatMapPublisher(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, function)) == null) {
            return toFlowable().flatMap(function);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single flatMapSingle(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapSingle(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe flatMapSingleElement(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapSingleElement(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable flattenAsFlowable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapIterableFlowable(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flattenAsObservable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapIterableObservable(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe lift(MaybeOperator maybeOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, maybeOperator)) == null) {
            ObjectHelper.requireNonNull(maybeOperator, "onLift is null");
            return RxJavaPlugins.onAssembly(new MaybeLift(this, maybeOperator));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe map(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new MaybeMap(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable mergeWith(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return merge(this, maybeSource);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new MaybeObserveOn(this, scheduler));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe ofType(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return filter(Functions.isInstanceOf(cls)).cast(cls);
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onErrorComplete(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new MaybeOnErrorComplete(this, predicate));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onErrorResumeNext(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "next is null");
            return onErrorResumeNext(Functions.justFunction(maybeSource));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onErrorReturn(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "valueSupplier is null");
            return RxJavaPlugins.onAssembly(new MaybeOnErrorReturn(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onErrorReturnItem(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return onErrorReturn(Functions.justFunction(obj));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onExceptionResumeNext(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "next is null");
            return RxJavaPlugins.onAssembly(new MaybeOnErrorNext(this, Functions.justFunction(maybeSource), false));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable repeat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048631, this, j)) == null) {
            return toFlowable().repeat(j);
        }
        return (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable repeatUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, booleanSupplier)) == null) {
            return toFlowable().repeatUntil(booleanSupplier);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable repeatWhen(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, function)) == null) {
            return toFlowable().repeatWhen(function);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retry(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048635, this, j)) == null) {
            return retry(j, Functions.alwaysTrue());
        }
        return (Maybe) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retryUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, booleanSupplier)) == null) {
            ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
            return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retryWhen(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, function)) == null) {
            return toFlowable().retryWhen(function).singleElement();
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, consumer)) == null) {
            return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe subscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new MaybeSubscribeOn(this, scheduler));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final MaybeObserver subscribeWith(MaybeObserver maybeObserver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, maybeObserver)) == null) {
            subscribe(maybeObserver);
            return maybeObserver;
        }
        return (MaybeObserver) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe switchIfEmpty(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmpty(this, maybeSource));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe takeUntil(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new MaybeTakeUntilMaybe(this, maybeSource));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver test(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048654, this, z)) == null) {
            TestObserver testObserver = new TestObserver();
            if (z) {
                testObserver.cancel();
            }
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe timeout(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "timeoutIndicator is null");
            return RxJavaPlugins.onAssembly(new MaybeTimeoutMaybe(this, maybeSource, null));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object to(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, function)) == null) {
            try {
                return ((Function) ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toSingle(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "defaultValue is null");
            return RxJavaPlugins.onAssembly(new MaybeToSingle(this, obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe unsubscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new MaybeUnsubscribeOn(this, scheduler));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe ambArray(MaybeSource... maybeSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, maybeSourceArr)) == null) {
            if (maybeSourceArr.length == 0) {
                return empty();
            }
            if (maybeSourceArr.length == 1) {
                return wrap(maybeSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new MaybeAmb(maybeSourceArr, null));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatArray(MaybeSource... maybeSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, maybeSourceArr)) == null) {
            ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
            if (maybeSourceArr.length == 0) {
                return Flowable.empty();
            }
            if (maybeSourceArr.length == 1) {
                return RxJavaPlugins.onAssembly(new MaybeToFlowable(maybeSourceArr[0]));
            }
            return RxJavaPlugins.onAssembly(new MaybeConcatArray(maybeSourceArr));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatArrayDelayError(MaybeSource... maybeSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, maybeSourceArr)) == null) {
            if (maybeSourceArr.length == 0) {
                return Flowable.empty();
            }
            if (maybeSourceArr.length == 1) {
                return RxJavaPlugins.onAssembly(new MaybeToFlowable(maybeSourceArr[0]));
            }
            return RxJavaPlugins.onAssembly(new MaybeConcatArrayDelayError(maybeSourceArr));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeArray(MaybeSource... maybeSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, maybeSourceArr)) == null) {
            ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
            if (maybeSourceArr.length == 0) {
                return Flowable.empty();
            }
            if (maybeSourceArr.length == 1) {
                return RxJavaPlugins.onAssembly(new MaybeToFlowable(maybeSourceArr[0]));
            }
            return RxJavaPlugins.onAssembly(new MaybeMergeArray(maybeSourceArr));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doAfterTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, action)) == null) {
            return RxJavaPlugins.onAssembly(new MaybePeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, (Action) ObjectHelper.requireNonNull(action, "onAfterTerminate is null"), Functions.EMPTY_ACTION));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doOnComplete(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, action)) == null) {
            Action action2 = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new MaybePeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), (Action) ObjectHelper.requireNonNull(action, "onComplete is null"), action2, action2));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doOnDispose(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, action)) == null) {
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Consumer emptyConsumer3 = Functions.emptyConsumer();
            Action action2 = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new MaybePeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, (Action) ObjectHelper.requireNonNull(action, "onDispose is null")));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doOnError(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, consumer)) == null) {
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new MaybePeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), (Consumer) ObjectHelper.requireNonNull(consumer, "onError is null"), action, action, action));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doOnSubscribe(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, consumer)) == null) {
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new MaybePeek(this, (Consumer) ObjectHelper.requireNonNull(consumer, "onSubscribe is null"), emptyConsumer, emptyConsumer2, action, action, action));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe doOnSuccess(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, consumer)) == null) {
            Consumer emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new MaybePeek(this, Functions.emptyConsumer(), (Consumer) ObjectHelper.requireNonNull(consumer, "onSubscribe is null"), emptyConsumer, action, action, action));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(MaybeSource maybeSource, MaybeSource maybeSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, maybeSource, maybeSource2)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            return concatArray(maybeSource, maybeSource2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(MaybeSource maybeSource, MaybeSource maybeSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, maybeSource, maybeSource2)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            return mergeArray(maybeSource, maybeSource2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(MaybeSource maybeSource, MaybeSource maybeSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, maybeSource, maybeSource2)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            return mergeArrayDelayError(maybeSource, maybeSource2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single sequenceEqual(MaybeSource maybeSource, MaybeSource maybeSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, maybeSource, maybeSource2)) == null) {
            return sequenceEqual(maybeSource, maybeSource2, ObjectHelper.equalsPredicate());
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Maybe timer(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65583, null, j, timeUnit)) == null) {
            return timer(j, timeUnit, Schedulers.computation());
        }
        return (Maybe) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(Iterable iterable, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65597, null, iterable, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new MaybeZipIterable(iterable, function));
        }
        return (Maybe) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zipArray(Function function, MaybeSource... maybeSourceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, function, maybeSourceArr)) == null) {
            ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
            if (maybeSourceArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "zipper is null");
            return RxJavaPlugins.onAssembly(new MaybeZipArray(maybeSourceArr, function));
        }
        return (Maybe) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe delay(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048588, this, j, timeUnit)) == null) {
            return delay(j, timeUnit, Schedulers.computation());
        }
        return (Maybe) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe delaySubscription(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048591, this, j, timeUnit)) == null) {
            return delaySubscription(j, timeUnit, Schedulers.computation());
        }
        return (Maybe) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe flatMap(Function function, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, function, biFunction)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapBiSelector(this, function, biFunction));
        }
        return (Maybe) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retry(long j, Predicate predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048636, this, j, predicate)) == null) {
            return toFlowable().retry(j, predicate).singleElement();
        }
        return (Maybe) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer, Consumer consumer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, consumer, consumer2)) == null) {
            return subscribe(consumer, consumer2, Functions.EMPTY_ACTION);
        }
        return (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048655, this, j, timeUnit)) == null) {
            return timeout(j, timeUnit, Schedulers.computation());
        }
        return (Maybe) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe zipWith(MaybeSource maybeSource, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048669, this, maybeSource, biFunction)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return zip(this, maybeSource, biFunction);
        }
        return (Maybe) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, maybeSource, maybeSource2, maybeSource3)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            return concatArray(maybeSource, maybeSource2, maybeSource3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe fromFuture(Future future, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{future, Long.valueOf(j), timeUnit})) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new MaybeFromFuture(future, j, timeUnit));
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, maybeSource, maybeSource2, maybeSource3)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            return mergeArray(maybeSource, maybeSource2, maybeSource3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65575, null, maybeSource, maybeSource2, maybeSource3)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Maybe timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65584, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new MaybeTimer(Math.max(0L, j), timeUnit, scheduler));
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new MaybeDelay(this, Math.max(0L, j), timeUnit, scheduler));
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Maybe timeout(long j, TimeUnit timeUnit, MaybeSource maybeSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{Long.valueOf(j), timeUnit, maybeSource})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return timeout(j, timeUnit, Schedulers.computation(), maybeSource);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, maybeSource, maybeSource2, maybeSource3, maybeSource4)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            return concatArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65567, null, maybeSource, maybeSource2, maybeSource3, maybeSource4)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            return mergeArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65576, null, maybeSource, maybeSource2, maybeSource3, maybeSource4)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3, maybeSource4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe using(Callable callable, Function function, Consumer consumer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65587, null, new Object[]{callable, function, consumer, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
            ObjectHelper.requireNonNull(function, "sourceSupplier is null");
            ObjectHelper.requireNonNull(consumer, "disposer is null");
            return RxJavaPlugins.onAssembly(new MaybeUsing(callable, function, consumer, z));
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, Function3 function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65595, null, maybeSource, maybeSource2, maybeSource3, function3)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            return zipArray(Functions.toFunction(function3), maybeSource, maybeSource2, maybeSource3);
        }
        return (Maybe) invokeLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe timeout(long j, TimeUnit timeUnit, Scheduler scheduler, MaybeSource maybeSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, maybeSource})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "fallback is null");
            return timeout(timer(j, timeUnit, scheduler), maybeSource);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, publisher)) == null) {
            return concat(publisher, 2);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatDelayError(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, publisher)) == null) {
            return Flowable.fromPublisher(publisher).concatMapDelayError(MaybeToPublisher.instance());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatEager(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, publisher)) == null) {
            return Flowable.fromPublisher(publisher).concatMapEager(MaybeToPublisher.instance());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe error(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "errorSupplier is null");
            return RxJavaPlugins.onAssembly(new MaybeErrorCallable(callable));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, publisher)) == null) {
            return merge(publisher, Integer.MAX_VALUE);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, publisher)) == null) {
            return mergeDelayError(publisher, Integer.MAX_VALUE);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe onErrorResumeNext(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunction is null");
            return RxJavaPlugins.onAssembly(new MaybeOnErrorNext(this, function, true));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retry(BiPredicate biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, biPredicate)) == null) {
            return toFlowable().retry(biPredicate).singleElement();
        }
        return (Maybe) invokeL.objValue;
    }

    @Override // io.reactivex.MaybeSource
    @SchedulerSupport("none")
    public final void subscribe(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, maybeObserver) == null) {
            ObjectHelper.requireNonNull(maybeObserver, "observer is null");
            MaybeObserver onSubscribe = RxJavaPlugins.onSubscribe(this, maybeObserver);
            ObjectHelper.requireNonNull(onSubscribe, "observer returned by the RxJavaPlugins hook is null");
            try {
                subscribeActual(onSubscribe);
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single switchIfEmpty(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmptySingle(this, singleSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe takeUntil(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new MaybeTakeUntilPublisher(this, publisher));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe timeout(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "timeoutIndicator is null");
            return RxJavaPlugins.onAssembly(new MaybeTimeoutPublisher(this, publisher, null));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(Publisher publisher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, publisher, i)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapPublisher(publisher, MaybeToPublisher.instance(), i, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(Publisher publisher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65570, null, publisher, i)) == null) {
            ObjectHelper.requireNonNull(publisher, "source is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(publisher, MaybeToPublisher.instance(), false, i, 1));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(Publisher publisher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, publisher, i)) == null) {
            ObjectHelper.requireNonNull(publisher, "source is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(publisher, MaybeToPublisher.instance(), true, i, 1));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe timeout(MaybeSource maybeSource, MaybeSource maybeSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048660, this, maybeSource, maybeSource2)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "timeoutIndicator is null");
            ObjectHelper.requireNonNull(maybeSource2, "fallback is null");
            return RxJavaPlugins.onAssembly(new MaybeTimeoutMaybe(this, maybeSource, maybeSource2));
        }
        return (Maybe) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe merge(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatten(maybeSource, Functions.identity()));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe retry(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, predicate)) == null) {
            return retry(Long.MAX_VALUE, predicate);
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single sequenceEqual(MaybeSource maybeSource, MaybeSource maybeSource2, BiPredicate biPredicate) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65582, null, maybeSource, maybeSource2, biPredicate)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
            return RxJavaPlugins.onAssembly(new MaybeEqualSingle(maybeSource, maybeSource2, biPredicate));
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe using(Callable callable, Function function, Consumer consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65586, null, callable, function, consumer)) == null) {
            return using(callable, function, consumer, true);
        }
        return (Maybe) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, BiFunction biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65596, null, maybeSource, maybeSource2, biFunction)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), maybeSource, maybeSource2);
        }
        return (Maybe) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return delaySubscription(Flowable.timer(j, timeUnit, scheduler));
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe flatMap(Function function, Function function2, Callable callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, function, function2, callable)) == null) {
            ObjectHelper.requireNonNull(function, "onSuccessMapper is null");
            ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
            ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
            return RxJavaPlugins.onAssembly(new MaybeFlatMapNotification(this, function, function2, callable));
        }
        return (Maybe) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer, Consumer consumer2, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048644, this, consumer, consumer2, action)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSuccess is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            return (Disposable) subscribeWith(new MaybeCallbackObserver(consumer, consumer2, action));
        }
        return (Disposable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Maybe timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048657, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return timeout(timer(j, timeUnit, scheduler));
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4, MaybeSource maybeSource5, MaybeSource maybeSource6, MaybeSource maybeSource7, MaybeSource maybeSource8, MaybeSource maybeSource9, Function9 function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65589, null, new Object[]{maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9, function9})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
            ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
            ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
            ObjectHelper.requireNonNull(maybeSource8, "source8 is null");
            ObjectHelper.requireNonNull(maybeSource9, "source9 is null");
            return zipArray(Functions.toFunction(function9), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4, MaybeSource maybeSource5, MaybeSource maybeSource6, MaybeSource maybeSource7, MaybeSource maybeSource8, Function8 function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65590, null, new Object[]{maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, function8})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
            ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
            ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
            ObjectHelper.requireNonNull(maybeSource8, "source8 is null");
            return zipArray(Functions.toFunction(function8), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4, MaybeSource maybeSource5, MaybeSource maybeSource6, MaybeSource maybeSource7, Function7 function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65591, null, new Object[]{maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, function7})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
            ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
            ObjectHelper.requireNonNull(maybeSource7, "source7 is null");
            return zipArray(Functions.toFunction(function7), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4, MaybeSource maybeSource5, MaybeSource maybeSource6, Function6 function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65592, null, new Object[]{maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, function6})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
            ObjectHelper.requireNonNull(maybeSource6, "source6 is null");
            return zipArray(Functions.toFunction(function6), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4, MaybeSource maybeSource5, Function5 function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65593, null, new Object[]{maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, function5})) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            ObjectHelper.requireNonNull(maybeSource5, "source5 is null");
            return zipArray(Functions.toFunction(function5), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5);
        }
        return (Maybe) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Maybe zip(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3, MaybeSource maybeSource4, Function4 function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65594, null, maybeSource, maybeSource2, maybeSource3, maybeSource4, function4)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "source1 is null");
            ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
            ObjectHelper.requireNonNull(maybeSource3, "source3 is null");
            ObjectHelper.requireNonNull(maybeSource4, "source4 is null");
            return zipArray(Functions.toFunction(function4), maybeSource, maybeSource2, maybeSource3, maybeSource4);
        }
        return (Maybe) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe timeout(Publisher publisher, MaybeSource maybeSource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048662, this, publisher, maybeSource)) == null) {
            ObjectHelper.requireNonNull(publisher, "timeoutIndicator is null");
            ObjectHelper.requireNonNull(maybeSource, "fallback is null");
            return RxJavaPlugins.onAssembly(new MaybeTimeoutPublisher(this, publisher, maybeSource));
        }
        return (Maybe) invokeLL.objValue;
    }
}
