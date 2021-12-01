package io.reactivex;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
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
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
/* loaded from: classes3.dex */
public abstract class Observable<T> implements ObservableSource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: io.reactivex.Observable$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-683060482, "Lio/reactivex/Observable$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-683060482, "Lio/reactivex/Observable$1;");
                    return;
                }
            }
            int[] iArr = new int[BackpressureStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureStrategy = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Observable() {
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
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableAmb(null, iterable));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, observableSourceArr)) == null) {
            ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
            int length = observableSourceArr.length;
            if (length == 0) {
                return empty();
            }
            if (length == 1) {
                return wrap(observableSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new ObservableAmb(observableSourceArr, null));
        }
        return (Observable) invokeL.objValue;
    }

    public static int bufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Flowable.bufferSize() : invokeV.intValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i2, ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, function, i2, observableSourceArr)) == null) ? combineLatest(observableSourceArr, function, i2) : (Observable) invokeLIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, observableSourceArr, function)) == null) ? combineLatestDelayError(observableSourceArr, function, bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return fromIterable(iterable).concatMapDelayError(Functions.identity(), bufferSize(), false);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, observableSourceArr)) == null) {
            if (observableSourceArr.length == 0) {
                return empty();
            }
            if (observableSourceArr.length == 1) {
                return wrap(observableSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(fromArray(observableSourceArr), Functions.identity(), bufferSize(), ErrorMode.BOUNDARY));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, observableSourceArr)) == null) {
            if (observableSourceArr.length == 0) {
                return empty();
            }
            if (observableSourceArr.length == 1) {
                return wrap(observableSourceArr[0]);
            }
            return concatDelayError(fromArray(observableSourceArr));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, observableSourceArr)) == null) ? concatArrayEager(bufferSize(), bufferSize(), observableSourceArr) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return concatDelayError(fromIterable(iterable));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, observableSource)) == null) ? concatEager(observableSource, bufferSize(), bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, observableOnSubscribe)) == null) {
            ObjectHelper.requireNonNull(observableOnSubscribe, "source is null");
            return RxJavaPlugins.onAssembly(new ObservableCreate(observableOnSubscribe));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "supplier is null");
            return RxJavaPlugins.onAssembly(new ObservableDefer(callable));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65577, this, consumer, consumer2, action, action2)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
            return RxJavaPlugins.onAssembly(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> empty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "errorSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableError(callable));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromArray(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, tArr)) == null) {
            ObjectHelper.requireNonNull(tArr, "items is null");
            if (tArr.length == 0) {
                return empty();
            }
            if (tArr.length == 1) {
                return just(tArr[0]);
            }
            return RxJavaPlugins.onAssembly(new ObservableFromArray(tArr));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "supplier is null");
            return RxJavaPlugins.onAssembly(new ObservableFromCallable(callable));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, future)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, 0L, null));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "source is null");
            return RxJavaPlugins.onAssembly(new ObservableFromIterable(iterable));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "publisher is null");
            return RxJavaPlugins.onAssembly(new ObservableFromPublisher(publisher));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "generator  is null");
            return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> interval(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65594, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? interval(j2, j3, timeUnit, Schedulers.computation()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65598, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), timeUnit})) == null) ? intervalRange(j2, j3, j4, j5, timeUnit, Schedulers.computation()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, t)) == null) {
            ObjectHelper.requireNonNull(t, "The item is null");
            return RxJavaPlugins.onAssembly(new ObservableJust(t));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65617, null, iterable, i2, i3)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), false, i2, i3) : (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArray(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65618, null, i2, i3, observableSourceArr)) == null) ? fromArray(observableSourceArr).flatMap(Functions.identity(), false, i2, i3) : (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArrayDelayError(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65620, null, i2, i3, observableSourceArr)) == null) ? fromArray(observableSourceArr).flatMap(Functions.identity(), true, i2, i3) : (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65627, null, iterable)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), true) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) ? RxJavaPlugins.onAssembly(ObservableNever.INSTANCE) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable<Integer> range(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65631, null, i2, i3)) == null) {
            if (i3 < 0) {
                throw new IllegalArgumentException("count >= 0 required but it was " + i3);
            } else if (i3 == 0) {
                return empty();
            } else {
                if (i3 == 1) {
                    return just(Integer.valueOf(i2));
                }
                if (i2 + (i3 - 1) <= 2147483647L) {
                    return RxJavaPlugins.onAssembly(new ObservableRange(i2, i3));
                }
                throw new IllegalArgumentException("Integer overflow");
            }
        }
        return (Observable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable<Long> rangeLong(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65632, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("count >= 0 required but it was " + j3);
            } else if (i2 == 0) {
                return empty();
            } else {
                if (j3 == 1) {
                    return just(Long.valueOf(j2));
                }
                long j4 = (j3 - 1) + j2;
                if (j2 > 0 && j4 < 0) {
                    throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                }
                return RxJavaPlugins.onAssembly(new ObservableRangeLong(j2, j3));
            }
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65633, null, observableSource, observableSource2)) == null) ? sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), bufferSize()) : (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65638, null, observableSource, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i2, false));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65639, null, observableSource)) == null) ? switchOnNextDelayError(observableSource, bufferSize()) : (Observable) invokeL.objValue;
    }

    private Observable<T> timeout0(long j2, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65641, this, new Object[]{Long.valueOf(j2), timeUnit, observableSource, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableTimeoutTimed(this, j2, timeUnit, scheduler, observableSource));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> timer(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65643, null, j2, timeUnit)) == null) ? timer(j2, timeUnit, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65645, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source is null");
            ObjectHelper.requireNonNull(observableSource, "onSubscribe is null");
            if (!(observableSource instanceof Observable)) {
                return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(observableSource));
            }
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65646, null, callable, function, consumer)) == null) ? using(callable, function, consumer, true) : (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65648, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source is null");
            if (observableSource instanceof Observable) {
                return RxJavaPlugins.onAssembly((Observable) observableSource);
            }
            return RxJavaPlugins.onAssembly(new ObservableFromUnsafeSource(observableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65660, null, iterable, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableZip(null, iterable, function, bufferSize(), false));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i2, ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65661, null, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2), observableSourceArr})) == null) {
            if (observableSourceArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableZip(observableSourceArr, null, function, i2, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65662, null, new Object[]{iterable, function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableZip(null, iterable, function, i2, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableAllSingle(this, predicate));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return ambArray(this, observableSource);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableAnySingle(this, predicate));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull ObservableConverter<T, ? extends R> observableConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, observableConverter)) == null) ? (R) ((ObservableConverter) ObjectHelper.requireNonNull(observableConverter, "converter is null")).apply(this) : (R) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
            subscribe(blockingFirstObserver);
            T blockingGet = blockingFirstObserver.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, consumer) == null) {
            Iterator<T> it = blockingIterable().iterator();
            while (it.hasNext()) {
                try {
                    consumer.accept(it.next());
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Disposable) it).dispose();
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? blockingIterable(bufferSize()) : (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
            subscribe(blockingLastObserver);
            T blockingGet = blockingLastObserver.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new BlockingObservableLatest(this) : (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, t)) == null) ? new BlockingObservableMostRecent(this, t) : (Iterable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new BlockingObservableNext(this) : (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            T blockingGet = singleElement().blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ObservableBlockingSubscribe.subscribe(this);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<List<T>> buffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? buffer(i2, i2) : (Observable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? ObservableCache.from(this) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> cacheWithInitialCapacity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) ? ObservableCache.from(this, i2) : (Observable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> cast(Class<U> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return (Observable<U>) map(Functions.castFunction(cls));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, callable, biConsumer)) == null) {
            ObjectHelper.requireNonNull(callable, "initialValueSupplier is null");
            ObjectHelper.requireNonNull(biConsumer, "collector is null");
            return RxJavaPlugins.onAssembly(new ObservableCollectSingle(this, callable, biConsumer));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, u, biConsumer)) == null) {
            ObjectHelper.requireNonNull(u, "initialValue is null");
            return collect(Functions.justCallable(u), biConsumer);
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, observableTransformer)) == null) ? wrap(((ObservableTransformer) ObjectHelper.requireNonNull(observableTransformer, "composer is null")).apply(this)) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, function)) == null) ? concatMap(function, 2) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, function)) == null) ? concatMapCompletable(function, 2) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, function)) == null) ? concatMapCompletableDelayError(function, true, 2) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, function)) == null) ? concatMapDelayError(function, bufferSize(), true) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, function)) == null) ? concatMapEager(function, Integer.MAX_VALUE, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048634, this, function, z)) == null) ? concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z) : (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, function)) == null) ? concatMapMaybe(function, 2) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, function)) == null) ? concatMapMaybeDelayError(function, true, 2) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, function)) == null) ? concatMapSingle(function, 2) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, function)) == null) ? concatMapSingleDelayError(function, true, 2) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return concat(this, observableSource);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "element is null");
            return any(Functions.equalsWith(obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Long> count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableCountSingle(this)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "debounceSelector is null");
            return RxJavaPlugins.onAssembly(new ObservableDebounce(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> defaultIfEmpty(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "defaultItem is null");
            return switchIfEmpty(just(t));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "itemDelay is null");
            return (Observable<T>) flatMap(ObservableInternalHelper.itemDelay(function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableDelaySubscriptionOther(this, observableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T2> Observable<T2> dematerialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableDematerialize(this)) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? distinct(Functions.identity(), Functions.createHashSet()) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinctUntilChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? distinctUntilChanged(Functions.identity()) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
            return RxJavaPlugins.onAssembly(new ObservableDoAfterNext(this, consumer));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doAfterTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doFinally(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return RxJavaPlugins.onAssembly(new ObservableDoFinally(this, action));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnComplete(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, action)) == null) ? doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnDispose(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, action)) == null) ? doOnLifecycle(Functions.emptyConsumer(), action) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, consumer)) == null) {
            Consumer<? super T> emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnEach(emptyConsumer, consumer, action, action);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048681, this, consumer, action)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
            ObjectHelper.requireNonNull(action, "onDispose is null");
            return RxJavaPlugins.onAssembly(new ObservableDoOnLifecycle(this, consumer, action));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, consumer)) == null) {
            Consumer<? super Throwable> emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnEach(consumer, emptyConsumer, action, action);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, consumer)) == null) ? doOnLifecycle(consumer, Functions.EMPTY_ACTION) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onTerminate is null");
            return doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> elementAt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048685, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableElementAtMaybe(this, j2));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
        }
        return (Maybe) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> elementAtOrError(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048687, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j2, null));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
        }
        return (Single) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> filter(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048688, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableFilter(this, predicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> first(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, t)) == null) ? elementAt(0L, t) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> firstElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? elementAt(0L) : (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> firstOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? elementAtOrError(0L) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, function)) == null) ? flatMap((Function) function, false) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, function)) == null) ? flatMapCompletable(function, false) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048706, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableFlattenIterable(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, function)) == null) ? flatMapMaybe(function, false) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048710, this, function)) == null) ? flatMapSingle(function, false) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEach(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048712, this, consumer)) == null) ? subscribe(consumer) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, predicate)) == null) ? forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048716, this, function)) == null) ? (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.identity(), false, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048721, this, observableSource, function, function2, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            ObjectHelper.requireNonNull(function, "leftEnd is null");
            ObjectHelper.requireNonNull(function2, "rightEnd is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return RxJavaPlugins.onAssembly(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableHide(this)) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ignoreElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableIgnoreElementsCompletable(this)) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? all(Functions.alwaysFalse()) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048725, this, observableSource, function, function2, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            ObjectHelper.requireNonNull(function, "leftEnd is null");
            ObjectHelper.requireNonNull(function2, "rightEnd is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return RxJavaPlugins.onAssembly(new ObservableJoin(this, observableSource, function, function2, biFunction));
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> last(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048726, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> lastElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableLastMaybe(this)) : (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> lastOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableLastSingle(this, null)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048729, this, observableOperator)) == null) {
            ObjectHelper.requireNonNull(observableOperator, "onLift is null");
            return RxJavaPlugins.onAssembly(new ObservableLift(this, observableOperator));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048730, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableMap(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Notification<T>> materialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableMaterialize(this)) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048734, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return merge(this, observableSource);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048736, this, scheduler)) == null) ? observeOn(scheduler, false, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> ofType(Class<U> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048739, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return filter(Functions.isInstanceOf(cls)).cast(cls);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048741, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunction is null");
            return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, function, false));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048742, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "valueSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableOnErrorReturn(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorReturnItem(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048743, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "item is null");
            return onErrorReturn(Functions.justFunction(t));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048744, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "next is null");
            return RxJavaPlugins.onAssembly(new ObservableOnErrorNext(this, Functions.justFunction(observableSource), true));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableDetach(this)) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> publish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? ObservablePublish.create(this) : (ConnectableObservable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048748, this, biFunction)) == null) {
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new ObservableReduceMaybe(this, biFunction));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048750, this, callable, biFunction)) == null) {
            ObjectHelper.requireNonNull(callable, "seedSupplier is null");
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new ObservableReduceWithSingle(this, callable, biFunction));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? repeat(Long.MAX_VALUE) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, booleanSupplier)) == null) {
            ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
            return RxJavaPlugins.onAssembly(new ObservableRepeatUntil(this, booleanSupplier));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048754, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "handler is null");
            return RxJavaPlugins.onAssembly(new ObservableRepeatWhen(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> replay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? ObservableReplay.createFrom(this) : (ConnectableObservable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? retry(Long.MAX_VALUE, Functions.alwaysTrue()) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048776, this, booleanSupplier)) == null) {
            ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
            return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048777, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "handler is null");
            return RxJavaPlugins.onAssembly(new ObservableRetryWhen(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, observer) == null) {
            ObjectHelper.requireNonNull(observer, "s is null");
            if (observer instanceof SafeObserver) {
                subscribe(observer);
            } else {
                subscribe(new SafeObserver(observer));
            }
        }
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> sample(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048779, this, j2, timeUnit)) == null) ? sample(j2, timeUnit, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048785, this, biFunction)) == null) {
            ObjectHelper.requireNonNull(biFunction, "accumulator is null");
            return RxJavaPlugins.onAssembly(new ObservableScan(this, biFunction));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048787, this, callable, biFunction)) == null) {
            ObjectHelper.requireNonNull(callable, "seedSupplier is null");
            ObjectHelper.requireNonNull(biFunction, "accumulator is null");
            return RxJavaPlugins.onAssembly(new ObservableScanSeed(this, callable, biFunction));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> serialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableSerialized(this)) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> share() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) ? publish().refCount() : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> single(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048790, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe<T> singleElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableSingleMaybe(this)) : (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> singleOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, null)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skip(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048793, this, j2)) == null) {
            if (j2 <= 0) {
                return RxJavaPlugins.onAssembly(this);
            }
            return RxJavaPlugins.onAssembly(new ObservableSkip(this, j2));
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skipLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048796, this, i2)) == null) {
            if (i2 >= 0) {
                if (i2 == 0) {
                    return RxJavaPlugins.onAssembly(this);
                }
                return RxJavaPlugins.onAssembly(new ObservableSkipLast(this, i2));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        return (Observable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048802, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableSkipUntil(this, observableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048803, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableSkipWhile(this, predicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> sorted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) ? toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity()) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048807, this, iterable)) == null) ? concatArray(fromIterable(iterable), this) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWithArray(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048809, this, tArr)) == null) {
            Observable fromArray = fromArray(tArr);
            if (fromArray == empty()) {
                return RxJavaPlugins.onAssembly(this);
            }
            return concatArray(fromArray, this);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) ? subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer()) : (Disposable) invokeV.objValue;
    }

    public abstract void subscribeActual(Observer<? super T> observer);

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048817, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableSubscribeOn(this, scheduler));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends Observer<? super T>> E subscribeWith(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048818, this, e2)) == null) {
            subscribe(e2);
            return e2;
        }
        return (E) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048819, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchIfEmpty(this, observableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048820, this, function)) == null) ? switchMap(function, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048822, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMapCompletable(this, function, false));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048823, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMapCompletable(this, function, true));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048824, this, function)) == null) ? switchMapDelayError(function, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048826, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMapMaybe(this, function, false));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048827, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMapMaybe(this, function, true));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> Observable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048828, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMapSingle(this, function, false));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> Observable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048829, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMapSingle(this, function, true));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> take(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048830, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableTake(this, j2));
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048833, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
            } else if (i2 == 0) {
                return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this));
            } else {
                if (i2 == 1) {
                    return RxJavaPlugins.onAssembly(new ObservableTakeLastOne(this));
                }
                return RxJavaPlugins.onAssembly(new ObservableTakeLast(this, i2));
            }
        }
        return (Observable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048842, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableTakeUntil(this, observableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048844, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableTakeWhile(this, predicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048845, this)) == null) {
            TestObserver<T> testObserver = new TestObserver<>();
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleFirst(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048847, this, j2, timeUnit)) == null) ? throttleFirst(j2, timeUnit, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048849, this, j2, timeUnit)) == null) ? sample(j2, timeUnit) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> throttleWithTimeout(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048851, this, j2, timeUnit)) == null) ? debounce(j2, timeUnit) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) ? timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation()) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048863, this, function)) == null) ? timeout0(null, function, null) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) ? timestamp(TimeUnit.MILLISECONDS, Schedulers.computation()) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R to(Function<? super Observable<T>, R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048869, this, function)) == null) {
            try {
                return (R) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (R) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048870, this, backpressureStrategy)) == null) {
            FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
            int i2 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[backpressureStrategy.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return flowableFromObservable.onBackpressureBuffer();
                        }
                        return RxJavaPlugins.onAssembly(new FlowableOnBackpressureError(flowableFromObservable));
                    }
                    return flowableFromObservable;
                }
                return flowableFromObservable.onBackpressureLatest();
            }
            return flowableFromObservable.onBackpressureDrop();
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future<T> toFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048871, this)) == null) ? (Future) subscribeWith(new FutureObserver()) : (Future) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048872, this)) == null) ? toList(16) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048875, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            return (Single<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048878, this, function)) == null) ? (Single<Map<K, Collection<T>>>) toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction()) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048882, this)) == null) ? toSortedList(Functions.naturalOrder()) : (Single) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048886, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableUnsubscribeOn(this, scheduler));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048887, this, j2)) == null) ? window(j2, j2, bufferSize()) : (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048909, this, observableSource, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            ObjectHelper.requireNonNull(biFunction, "combiner is null");
            return RxJavaPlugins.onAssembly(new ObservableWithLatestFrom(this, biFunction, observableSource));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048915, this, iterable, biFunction)) == null) {
            ObjectHelper.requireNonNull(iterable, "other is null");
            ObjectHelper.requireNonNull(biFunction, "zipper is null");
            return RxJavaPlugins.onAssembly(new ObservableZipIterable(this, iterable, biFunction));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, iterable, function)) == null) ? combineLatest(iterable, function, bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i2, ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65553, null, function, i2, observableSourceArr)) == null) ? combineLatestDelayError(observableSourceArr, function, i2) : (Observable) invokeLIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatArrayEager(int i2, int i3, ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65566, null, i2, i3, observableSourceArr)) == null) ? fromArray(observableSourceArr).concatMapEagerDelayError(Functions.identity(), i2, i3, false) : (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65572, null, observableSource, i2, i3)) == null) {
            ObjectHelper.requireNonNull(Integer.valueOf(i2), "maxConcurrency is null");
            ObjectHelper.requireNonNull(Integer.valueOf(i3), "prefetch is null");
            return wrap(observableSource).concatMapEager(Functions.identity(), i2, i3);
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> interval(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65595, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, j2), Math.max(0L, j3), timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65599, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), timeUnit, scheduler})) == null) {
            int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("count >= 0 required but it was " + j3);
            } else if (i2 == 0) {
                return empty().delay(j4, timeUnit, scheduler);
            } else {
                long j6 = j2 + (j3 - 1);
                if (j2 > 0 && j6 < 0) {
                    throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                }
                ObjectHelper.requireNonNull(timeUnit, "unit is null");
                ObjectHelper.requireNonNull(scheduler, "scheduler is null");
                return RxJavaPlugins.onAssembly(new ObservableIntervalRange(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, scheduler));
            }
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, iterable)) == null) ? fromIterable(iterable).flatMap(Functions.identity()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65619, null, observableSourceArr)) == null) ? fromArray(observableSourceArr).flatMap(Functions.identity(), observableSourceArr.length) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, observableSourceArr)) == null) ? fromArray(observableSourceArr).flatMap(Functions.identity(), true, observableSourceArr.length) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65629, null, iterable, i2, i3)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), true, i2, i3) : (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65635, null, observableSource, observableSource2, biPredicate)) == null) ? sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize()) : (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65640, null, observableSource, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i2, true));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> timer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65644, null, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableTimer(Math.max(j2, 0L), timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65647, null, new Object[]{callable, function, consumer, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
            ObjectHelper.requireNonNull(function, "sourceSupplier is null");
            ObjectHelper.requireNonNull(consumer, "disposer is null");
            return RxJavaPlugins.onAssembly(new ObservableUsing(callable, function, consumer, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return new BlockingObservableIterable(this, i2);
        }
        return (Iterable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, consumer) == null) {
            ObservableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<List<T>> buffer(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) ? (Observable<List<T>>) buffer(i2, i3, ArrayListSupplier.asCallable()) : (Observable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048623, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048625, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "capacityHint");
            return RxJavaPlugins.onAssembly(new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i2));
        }
        return (Completable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, function, z)) == null) ? concatMapCompletableDelayError(function, z, 2) : (Completable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{function, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048632, this, function, i2, i3)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i2, i3));
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{function, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2, i3));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048638, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i2));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, function, z)) == null) ? concatMapMaybeDelayError(function, z, 2) : (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048643, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i2));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048645, this, function, z)) == null) ? concatMapSingleDelayError(function, z, 2) : (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, function)) == null) ? distinct(function, Functions.createHashSet()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048701, this, function, z)) == null) ? flatMap(function, z, Integer.MAX_VALUE) : (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048705, this, function, z)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletableCompletable(this, function, z));
        }
        return (Completable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048709, this, function, z)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableFlatMapMaybe(this, function, z));
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048711, this, function, z)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new ObservableFlatMapSingle(this, function, z));
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048714, this, predicate, consumer)) == null) ? forEachWhile(predicate, consumer, Functions.EMPTY_ACTION) : (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048720, this, function, z)) == null) ? (Observable<GroupedObservable<K, T>>) groupBy(function, Functions.identity(), z, bufferSize()) : (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler scheduler, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048737, this, scheduler, z)) == null) ? observeOn(scheduler, z, bufferSize()) : (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048746, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            return RxJavaPlugins.onAssembly(new ObservablePublishSelector(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> repeat(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048752, this, j2)) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 >= 0) {
                if (i2 == 0) {
                    return empty();
                }
                return RxJavaPlugins.onAssembly(new ObservableRepeat(this, j2));
            }
            throw new IllegalArgumentException("times >= 0 required but it was " + j2);
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048755, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), function);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048774, this, biPredicate)) == null) {
            ObjectHelper.requireNonNull(biPredicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableRetryBiPredicate(this, biPredicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> sample(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048782, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? sample(j2, timeUnit, Schedulers.computation(), z) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> sorted(Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048805, this, comparator)) == null) {
            ObjectHelper.requireNonNull(comparator, "sortFunction is null");
            return toList().toObservable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048806, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return concatArray(observableSource, this);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048811, this, consumer)) == null) ? subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer()) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048821, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i2, false));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048825, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i2, true));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleFirst(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048848, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableThrottleFirstTimed(this, j2, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleLast(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048850, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? sample(j2, timeUnit, scheduler) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> throttleWithTimeout(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048852, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? debounce(j2, timeUnit, scheduler) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048854, this, scheduler)) == null) ? timeInterval(TimeUnit.MILLISECONDS, scheduler) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048864, this, function, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return timeout0(null, function, observableSource);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048866, this, scheduler)) == null) ? timestamp(TimeUnit.MILLISECONDS, scheduler) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048873, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "capacityHint");
            return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, i2));
        }
        return (Single) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048884, this, comparator)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            return (Single<List<T>>) toList().map(Functions.listSorter(comparator));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048888, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? window(j2, j3, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, iterable, function, i2)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, iterable, function, i2 << 1, false));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65557, null, observableSourceArr, function, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(function, "combiner is null");
            if (observableSourceArr.length == 0) {
                return empty();
            }
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i2 << 1, true));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, observableSource)) == null) ? concat(observableSource, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, observableSource)) == null) ? concatDelayError(observableSource, bufferSize(), true) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "e is null");
            return error(Functions.justCallable(th));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65584, null, new Object[]{future, Long.valueOf(j2), timeUnit})) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, j2, timeUnit));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65601, null, t, t2)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            return fromArray(t, t2);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65616, null, iterable, i2)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), i2) : (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65628, null, iterable, i2)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), true, i2) : (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65636, null, observableSource, observableSource2, biPredicate, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i2));
        }
        return (Single) invokeLLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingSingle(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, t)) == null) ? single(t).blockingGet() : (T) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, consumer, consumer2) == null) {
            ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(int i2, int i3, Callable<U> callable) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048599, this, i2, i3, callable)) == null) {
            ObjectHelper.verifyPositive(i2, "count");
            ObjectHelper.verifyPositive(i3, FreeSpaceBox.TYPE);
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBuffer(this, i2, i3, callable));
        }
        return (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048636, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return (Observable<U>) concatMap(ObservableInternalHelper.flatMapIntoIterable(function), i2);
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Observable<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatWithSingle(this, singleSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> debounce(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048653, this, j2, timeUnit)) == null) ? debounce(j2, timeUnit, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delay(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048657, this, j2, timeUnit)) == null) ? delay(j2, timeUnit, Schedulers.computation(), false) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delaySubscription(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048663, this, j2, timeUnit)) == null) ? delaySubscription(j2, timeUnit, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048669, this, function, callable)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableDistinct(this, function, callable));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<T> elementAt(long j2, T t) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048686, this, j2, t)) == null) {
            if (j2 >= 0) {
                ObjectHelper.requireNonNull(t, "defaultItem is null");
                return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j2, t));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048702, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? flatMap(function, z, i2, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048707, this, function, biFunction)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return (Observable<V>) flatMap(ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048715, this, predicate, consumer, action)) == null) {
            ObjectHelper.requireNonNull(predicate, "onNext is null");
            ObjectHelper.requireNonNull(consumer, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
            subscribe(forEachWhileObserver);
            return forEachWhileObserver;
        }
        return (Disposable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048717, this, function, function2)) == null) ? groupBy(function, function2, false, bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Observable<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048735, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableMergeWithSingle(this, singleSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> observeOn(Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048738, this, new Object[]{scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, scheduler, z, i2));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048740, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "next is null");
            return onErrorResumeNext(Functions.justFunction(observableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048749, this, r, biFunction)) == null) {
            ObjectHelper.requireNonNull(r, "seed is null");
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new ObservableReduceSeedSingle(this, r, biFunction));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> sample(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048780, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j2, timeUnit, scheduler, false));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048786, this, r, biFunction)) == null) {
            ObjectHelper.requireNonNull(r, "seed is null");
            return scanWith(Functions.justCallable(r), biFunction);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> skip(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048794, this, j2, timeUnit)) == null) ? skipUntil(timer(j2, timeUnit)) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048812, this, consumer, consumer2)) == null) ? subscribe(consumer, consumer2, Functions.EMPTY_ACTION, Functions.emptyConsumer()) : (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> take(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048831, this, j2, timeUnit)) == null) ? takeUntil(timer(j2, timeUnit)) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048843, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableTakeUntilPredicate(this, predicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<T> test(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048846, this, z)) == null) {
            TestObserver<T> testObserver = new TestObserver<>();
            if (z) {
                testObserver.dispose();
            }
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048855, this, timeUnit)) == null) ? timeInterval(timeUnit, Schedulers.computation()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048867, this, timeUnit)) == null) ? timestamp(timeUnit, Schedulers.computation()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048876, this, function, function2)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            return (Single<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, long j3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048889, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)})) == null) {
            ObjectHelper.verifyPositive(j2, "count");
            ObjectHelper.verifyPositive(j3, FreeSpaceBox.TYPE);
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindow(this, j2, j3, i2));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, observableSource, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i2, ErrorMode.IMMEDIATE));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{observableSource, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i2, "prefetch is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, Integer.MAX_VALUE, bufferSize()));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, Integer.MAX_VALUE, bufferSize()));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65637, null, observableSource)) == null) ? switchOnNext(observableSource, bufferSize()) : (Observable) invokeL.objValue;
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65642, this, observableSource, function, observableSource2)) == null) {
            ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
            return RxJavaPlugins.onAssembly(new ObservableTimeout(this, observableSource, function, observableSource2));
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65659, null, observableSource, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableToList(observableSource, 16).flatMap(ObservableInternalHelper.zipIterable(function)));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, consumer, consumer2, action) == null) {
            ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
        }
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> debounce(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, j2, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> delay(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048660, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? delay(j2, timeUnit, Schedulers.computation(), z) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> delaySubscription(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048664, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? delaySubscription(timer(j2, timeUnit, scheduler)) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, biPredicate)) == null) {
            ObjectHelper.requireNonNull(biPredicate, "comparer is null");
            return RxJavaPlugins.onAssembly(new ObservableDistinctUntilChanged(this, Functions.identity(), biPredicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048703, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, function, z, i2, i3));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048718, this, function, function2, z)) == null) ? groupBy(function, function2, z, bufferSize()) : (Observable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048756, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i2), function);
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048772, this, j2)) == null) ? retry(j2, Functions.alwaysTrue()) : (Observable) invokeJ.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skip(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048795, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? skipUntil(timer(j2, timeUnit, scheduler)) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> skipLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048797, this, j2, timeUnit)) == null) ? skipLast(j2, timeUnit, Schedulers.trampoline(), false, bufferSize()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> startWith(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048808, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "item is null");
            return concatArray(just(t), this);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048813, this, consumer, consumer2, action)) == null) ? subscribe(consumer, consumer2, action, Functions.emptyConsumer()) : (Disposable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> take(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048832, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? takeUntil(timer(j2, timeUnit, scheduler)) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048856, this, timeUnit, scheduler)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableTimeInterval(this, timeUnit, scheduler));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> timeout(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048857, this, j2, timeUnit)) == null) ? timeout0(j2, timeUnit, null, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048868, this, timeUnit, scheduler)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return (Observable<Timed<T>>) map(Functions.timestampWith(timeUnit, scheduler));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048874, this, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048885, this, comparator, i2)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            return (Single<List<T>>) toList(i2).map(Functions.listSorter(comparator));
        }
        return (Single) invokeLI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.Observable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048908, this, observableSource, observableSource2, function3)) == null) {
            ObjectHelper.requireNonNull(observableSource, "o1 is null");
            ObjectHelper.requireNonNull(observableSource2, "o2 is null");
            ObjectHelper.requireNonNull(function3, "combiner is null");
            return withLatestFrom(new ObservableSource[]{observableSource, observableSource2}, Functions.toFunction(function3));
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048912, this, observableSource, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return zip(this, observableSource, biFunction);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, iterable)) == null) ? concatEager(iterable, bufferSize(), bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, callable, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "generator  is null");
            return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable<Long> interval(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65596, null, j2, timeUnit)) == null) ? interval(j2, j2, timeUnit, Schedulers.computation()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingFirst(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
            subscribe(blockingFirstObserver);
            T blockingGet = blockingFirstObserver.blockingGet();
            return blockingGet != null ? blockingGet : t;
        }
        return (T) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final T blockingLast(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, t)) == null) {
            BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
            subscribe(blockingLastObserver);
            T blockingGet = blockingLastObserver.blockingGet();
            return blockingGet != null ? blockingGet : t;
        }
        return (T) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, observer) == null) {
            ObservableBlockingSubscribe.subscribe(this, observer);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Observable<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatWithMaybe(this, maybeSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> delay(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? delay(j2, timeUnit, scheduler, false) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048719, this, new Object[]{function, function2, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableGroupBy(this, function, function2, i2, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Observable<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048733, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableMergeWithMaybe(this, maybeSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(long j2, Predicate<? super Throwable> predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048773, this, j2, predicate)) == null) {
            if (j2 >= 0) {
                ObjectHelper.requireNonNull(predicate, "predicate is null");
                return RxJavaPlugins.onAssembly(new ObservableRetryPredicate(this, j2, predicate));
            }
            throw new IllegalArgumentException("times >= 0 required but it was " + j2);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> skipLast(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048801, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? skipLast(j2, timeUnit, Schedulers.trampoline(), z, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048814, this, consumer, consumer2, action, consumer3)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
            LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
            subscribe(lambdaObserver);
            return lambdaObserver;
        }
        return (Disposable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048834, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? takeLast(j2, j3, timeUnit, Schedulers.trampoline(), false, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> timeout(long j2, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048858, this, new Object[]{Long.valueOf(j2), timeUnit, observableSource})) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return timeout0(j2, timeUnit, observableSource, Schedulers.computation());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048879, this, function, function2)) == null) ? toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction()) : (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65574, null, iterable, i2, i3)) == null) {
            ObjectHelper.requireNonNull(Integer.valueOf(i2), "maxConcurrency is null");
            ObjectHelper.requireNonNull(Integer.valueOf(i3), "prefetch is null");
            return fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), i2, i3, false);
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65585, null, new Object[]{future, Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return fromFuture(future, j2, timeUnit).subscribeOn(scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static Observable<Long> interval(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65597, null, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? interval(j2, j2, timeUnit, scheduler) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65602, null, t, t2, t3)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            return fromArray(t, t2, t3);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65611, null, observableSource, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, i2, bufferSize()));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65623, null, observableSource, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, i2, bufferSize()));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> delay(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048659, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableDelay(this, j2, timeUnit, scheduler, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "consumer is null");
            return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> sample(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048781, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j2, timeUnit, scheduler, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skipLast(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048798, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? skipLast(j2, timeUnit, scheduler, false, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048835, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) ? takeLast(j2, j3, timeUnit, scheduler, false, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.concurrent.Callable<? extends java.util.Map<K, V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048877, this, function, function2, callable)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.requireNonNull(callable, "mapSupplier is null");
            return (Single<Map<K, V>>) collect(callable, Functions.toMapKeyValueSelector(function, function2));
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single<List<T>> toSortedList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048883, this, i2)) == null) ? toSortedList(Functions.naturalOrder(), i2) : (Single) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048913, this, observableSource, biFunction, z)) == null) ? zip(this, observableSource, biFunction, z) : (Observable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, observableSourceArr, function)) == null) ? combineLatest(observableSourceArr, function, bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, observableSource, observableSource2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return concatArray(observableSource, observableSource2);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65591, null, callable, biConsumer, consumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "generator  is null");
            return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(int i2, Callable<U> callable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i2, callable)) == null) ? buffer(i2, i2, callable) : (Observable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Observable<T> concatWith(@NonNull CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatWithCompletable(this, completableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    @Experimental
    public final Observable<T> mergeWith(@NonNull CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048732, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableMergeWithCompletable(this, completableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048757, this, new Object[]{function, Integer.valueOf(i2), Long.valueOf(j2), timeUnit})) == null) ? replay(function, i2, j2, timeUnit, Schedulers.computation()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skipLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048799, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) ? skipLast(j2, timeUnit, scheduler, z, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048836, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableTakeLastTimed(this, j2, j3, timeUnit, scheduler, i2, z));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> timeout(long j2, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048860, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, observableSource})) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return timeout0(j2, timeUnit, observableSource, scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048890, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? window(j2, j3, timeUnit, Schedulers.computation(), bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048914, this, new Object[]{observableSource, biFunction, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? zip(this, observableSource, biFunction, z, i2) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, observableSourceArr, function, i2)) == null) {
            ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
            if (observableSourceArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i2 << 1, false));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, iterable, function)) == null) ? combineLatestDelayError(iterable, function, bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65634, null, observableSource, observableSource2, i2)) == null) ? sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), i2) : (Single) invokeLLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? (Observable<List<T>>) buffer(j2, j3, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048758, this, new Object[]{function, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i2, j2, timeUnit, scheduler), function);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048775, this, predicate)) == null) ? retry(Long.MAX_VALUE, predicate) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> skipLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048800, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableSkipLastTimed(this, j2, timeUnit, scheduler, i2 << 1, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.concurrent.Callable<? extends java.util.Map<K, java.util.Collection<V>>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048881, this, function, function2, callable, function3)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.requireNonNull(callable, "mapSupplier is null");
            ObjectHelper.requireNonNull(function3, "collectionFactory is null");
            return (Single<Map<K, Collection<V>>>) collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
        }
        return (Single) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048891, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) ? window(j2, j3, timeUnit, scheduler, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65555, null, iterable, function, i2)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, iterable, function, i2 << 1, true));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65586, null, future, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return fromFuture(future).subscribeOn(scheduler);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, callable, biFunction)) == null) ? generate(callable, biFunction, Functions.emptyConsumer()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65612, null, observableSource, observableSource2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), false, 2);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65624, null, observableSource, observableSource2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return fromArray(observableSource, observableSource2).flatMap(Functions.identity(), true, 2);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65656, null, observableSource, observableSource2, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) ? (Observable<List<T>>) buffer(j2, j3, timeUnit, scheduler, ArrayListSupplier.asCallable()) : (Observable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048661, this, observableSource, function)) == null) ? delaySubscription(observableSource).delay(function) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048783, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sampler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource, false));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> timeout(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048859, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? timeout0(j2, timeUnit, null, scheduler) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048892, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, Integer.valueOf(i2)})) == null) {
            ObjectHelper.verifyPositive(j2, "timespan");
            ObjectHelper.verifyPositive(j3, "timeskip");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j2, j3, timeUnit, scheduler, Long.MAX_VALUE, i2, false));
        }
        return (Observable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.Observable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048907, this, observableSource, observableSource2, observableSource3, function4)) == null) {
            ObjectHelper.requireNonNull(observableSource, "o1 is null");
            ObjectHelper.requireNonNull(observableSource2, "o2 is null");
            ObjectHelper.requireNonNull(observableSource3, "o3 is null");
            ObjectHelper.requireNonNull(function4, "combiner is null");
            return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.toFunction(function4));
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, observableSource, observableSource2, observableSource3)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            return concatArray(observableSource, observableSource2, observableSource3);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65593, null, callable, biFunction, consumer)) == null) {
            ObjectHelper.requireNonNull(callable, "initialState is null");
            ObjectHelper.requireNonNull(biFunction, "generator  is null");
            ObjectHelper.requireNonNull(consumer, "disposeState is null");
            return RxJavaPlugins.onAssembly(new ObservableGenerate(callable, biFunction, consumer));
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65603, null, t, t2, t3, t4)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            return fromArray(t, t2, t3, t4);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, callable})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j2, j3, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048861, this, observableSource, function)) == null) {
            ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
            return timeout0(observableSource, function, null);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> doOnEach(Observer<? super T> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, observer)) == null) {
            ObjectHelper.requireNonNull(observer, "observer is null");
            return doOnEach(ObservableInternalHelper.observerOnNext(observer), ObservableInternalHelper.observerOnError(observer), ObservableInternalHelper.observerOnComplete(observer), Functions.EMPTY_ACTION);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048784, this, observableSource, z)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sampler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource, z));
        }
        return (Observable) invokeLZ.objValue;
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport("none")
    public final void subscribe(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, observer) == null) {
            ObjectHelper.requireNonNull(observer, "observer is null");
            try {
                Observer<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
                ObjectHelper.requireNonNull(onSubscribe, "Plugin returned null Observer");
                subscribeActual(onSubscribe);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65613, null, observableSource, observableSource2, observableSource3)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), false, 3);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65625, null, observableSource, observableSource2, observableSource3)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), true, 3);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65657, null, new Object[]{observableSource, observableSource2, biFunction, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), z, bufferSize(), observableSource, observableSource2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048699, this, function, function2, callable)) == null) {
            ObjectHelper.requireNonNull(function, "onNextMapper is null");
            ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
            ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
            return merge(new ObservableMapNotification(this, function, function2, callable));
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048837, this, j2, timeUnit)) == null) ? takeLast(j2, timeUnit, Schedulers.trampoline(), false, bufferSize()) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048862, this, observableSource, function, observableSource2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
            ObjectHelper.requireNonNull(observableSource2, "other is null");
            return timeout0(observableSource, function, observableSource2);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048841, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? takeLast(j2, timeUnit, Schedulers.trampoline(), z, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048880, this, function, function2, callable)) == null) ? toMultimap(function, function2, callable, ArrayListSupplier.asFunction()) : (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, observableSource, observableSource2, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return combineLatest(Functions.toFunction(biFunction), bufferSize(), observableSource, observableSource2);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65562, null, observableSource, observableSource2, observableSource3, observableSource4)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048604, this, j2, timeUnit)) == null) ? buffer(j2, timeUnit, Schedulers.computation(), Integer.MAX_VALUE) : (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, Scheduler scheduler) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048759, this, function, i2, scheduler)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i2), ObservableInternalHelper.replayFunction(function, scheduler));
        }
        return (Observable) invokeLIL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048838, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? takeLast(j2, timeUnit, scheduler, false, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65604, null, t, t2, t3, t4, t5)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            return fromArray(t, t2, t3, t4, t5);
        }
        return (Observable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65658, null, new Object[]{observableSource, observableSource2, biFunction, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), z, i2, observableSource, observableSource2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j2, TimeUnit timeUnit, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j2), timeUnit, Integer.valueOf(i2)})) == null) ? buffer(j2, timeUnit, Schedulers.computation(), i2) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048839, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) ? takeLast(j2, timeUnit, scheduler, z, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048893, this, j2, timeUnit)) == null) ? window(j2, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false) : (Observable) invokeJL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.Observable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048906, this, observableSource, observableSource2, observableSource3, observableSource4, function5)) == null) {
            ObjectHelper.requireNonNull(observableSource, "o1 is null");
            ObjectHelper.requireNonNull(observableSource2, "o2 is null");
            ObjectHelper.requireNonNull(observableSource3, "o3 is null");
            ObjectHelper.requireNonNull(observableSource4, "o4 is null");
            ObjectHelper.requireNonNull(function5, "combiner is null");
            return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.toFunction(function5));
        }
        return (Observable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65614, null, observableSource, observableSource2, observableSource3, observableSource4)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), false, 4);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65626, null, observableSource, observableSource2, observableSource3, observableSource4)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), true, 4);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i2)})) == null) ? (Observable<List<T>>) buffer(j2, timeUnit, scheduler, i2, ArrayListSupplier.asCallable(), false) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048700, this, function, function2, callable, i2)) == null) {
            ObjectHelper.requireNonNull(function, "onNextMapper is null");
            ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
            ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
            return merge(new ObservableMapNotification(this, function, function2, callable), i2);
        }
        return (Observable) invokeLLLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<T> takeLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048840, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? takeLast(Long.MAX_VALUE, j2, timeUnit, scheduler, z, i2) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048894, this, new Object[]{Long.valueOf(j2), timeUnit, Long.valueOf(j3)})) == null) ? window(j2, timeUnit, Schedulers.computation(), j3, false) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, observableSource, observableSource2, observableSource3, function3)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            return combineLatest(Functions.toFunction(function3), bufferSize(), observableSource, observableSource2, observableSource3);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> buffer(long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, Callable<U> callable, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i2), callable, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            ObjectHelper.verifyPositive(i2, "count");
            return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j2, j2, timeUnit, scheduler, callable, i2, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048895, this, new Object[]{Long.valueOf(j2), timeUnit, Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? window(j2, timeUnit, Schedulers.computation(), j3, z) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65655, null, observableSource, observableSource2, observableSource3, function3)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            return zipArray(Functions.toFunction(function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048896, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? window(j2, timeUnit, scheduler, Long.MAX_VALUE, false) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048897, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Long.valueOf(j3)})) == null) ? window(j2, timeUnit, scheduler, j3, false) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048693, this, function, i2)) == null) ? flatMap((Function) function, false, i2, bufferSize()) : (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048760, this, new Object[]{function, Long.valueOf(j2), timeUnit})) == null) ? replay(function, j2, timeUnit, Schedulers.computation()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048898, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? window(j2, timeUnit, scheduler, j3, z, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65545, null, observableSource, observableSource2, observableSource3, observableSource4, function4)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            return combineLatest(Functions.toFunction(function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
        }
        return (Observable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65605, null, new Object[]{t, t2, t3, t4, t5, t6})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            return fromArray(t, t2, t3, t4, t5, t6);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048694, this, function, biFunction)) == null) ? flatMap(function, biFunction, false, bufferSize(), bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048761, this, new Object[]{function, Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, j2, timeUnit, scheduler), function);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<Observable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048899, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Long.valueOf(j3), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.verifyPositive(j3, "count");
            return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j2, j2, timeUnit, scheduler, j3, i2, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65654, null, observableSource, observableSource2, observableSource3, observableSource4, function4)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            return zipArray(Functions.toFunction(function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
        }
        return (Observable) invokeLLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final Observable<List<T>> buffer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? (Observable<List<T>>) buffer(j2, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048696, this, function, biFunction, z)) == null) ? flatMap(function, biFunction, z, bufferSize(), bufferSize()) : (Observable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048911, this, observableSourceArr, function)) == null) {
            ObjectHelper.requireNonNull(observableSourceArr, "others is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, observableSourceArr, function));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, observableSource, function)) == null) ? (Observable<List<T>>) buffer(observableSource, function, ArrayListSupplier.asCallable()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048697, this, new Object[]{function, biFunction, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? flatMap(function, biFunction, z, i2, bufferSize()) : (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, observableSource, function, callable)) == null) {
            ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
            ObjectHelper.requireNonNull(function, "closingIndicator is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBufferBoundary(this, observableSource, function, callable));
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{function, biFunction, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "combiner is null");
            return flatMap(ObservableInternalHelper.flatMapWithCombiner(function, biFunction), z, i2, i3);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048762, this, function, scheduler)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this), ObservableInternalHelper.replayFunction(function, scheduler));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048910, this, iterable, function)) == null) {
            ObjectHelper.requireNonNull(iterable, "others is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, iterable, function));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, function5})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            return combineLatest(Functions.toFunction(function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048900, this, observableSource)) == null) ? window(observableSource, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65653, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, function5})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            return zipArray(Functions.toFunction(function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048695, this, function, biFunction, i2)) == null) ? flatMap(function, biFunction, false, i2, bufferSize()) : (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048901, this, observableSource, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "boundary is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindowBoundary(this, observableSource, i2));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65606, null, new Object[]{t, t2, t3, t4, t5, t6, t7})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            ObjectHelper.requireNonNull(t7, "The seventh item is null");
            return fromArray(t, t2, t3, t4, t5, t6, t7);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, observableSource)) == null) ? (Observable<List<T>>) buffer(observableSource, ArrayListSupplier.asCallable()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, observableSource, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "initialCapacity");
            return (Observable<List<T>>) buffer(observableSource, Functions.createArrayList(i2));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048764, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return ObservableReplay.create(this, i2);
        }
        return (ConnectableObservable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048902, this, observableSource, function)) == null) ? window(observableSource, function, bufferSize()) : (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, observableSource, callable)) == null) {
            ObjectHelper.requireNonNull(observableSource, "boundary is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBufferExactBoundary(this, observableSource, callable));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048903, this, observableSource, function, i2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
            ObjectHelper.requireNonNull(function, "closingIndicator is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySelector(this, observableSource, function, i2));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, function6})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            return combineLatest(Functions.toFunction(function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048765, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit})) == null) ? replay(i2, j2, timeUnit, Schedulers.computation()) : (ConnectableObservable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65652, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, function6})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            return zipArray(Functions.toFunction(function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048766, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.create(this, j2, timeUnit, scheduler, i2);
        }
        return (ConnectableObservable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, callable)) == null) ? (Observable<List<T>>) buffer(callable, ArrayListSupplier.asCallable()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, callable, callable2)) == null) {
            ObjectHelper.requireNonNull(callable, "boundarySupplier is null");
            ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBufferBoundarySupplier(this, callable, callable2));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048904, this, callable)) == null) ? window(callable, bufferSize()) : (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65607, null, new Object[]{t, t2, t3, t4, t5, t6, t7, t8})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            ObjectHelper.requireNonNull(t7, "The seventh item is null");
            ObjectHelper.requireNonNull(t8, "The eighth item is null");
            return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048905, this, callable, i2)) == null) {
            ObjectHelper.requireNonNull(callable, "boundary is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySupplier(this, callable, i2));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(int i2, Scheduler scheduler) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048767, this, i2, scheduler)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return ObservableReplay.observeOn(replay(i2), scheduler);
        }
        return (ConnectableObservable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, function7})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            ObjectHelper.requireNonNull(observableSource7, "source7 is null");
            return combineLatest(Functions.toFunction(function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048768, this, j2, timeUnit)) == null) ? replay(j2, timeUnit, Schedulers.computation()) : (ConnectableObservable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65651, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, function7})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            ObjectHelper.requireNonNull(observableSource7, "source7 is null");
            return zipArray(Functions.toFunction(function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048769, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.create(this, j2, timeUnit, scheduler);
        }
        return (ConnectableObservable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.CUSTOM)
    @CheckReturnValue
    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048770, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.observeOn(replay(), scheduler);
        }
        return (ConnectableObservable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65608, null, new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            ObjectHelper.requireNonNull(t7, "The seventh item is null");
            ObjectHelper.requireNonNull(t8, "The eighth item is null");
            ObjectHelper.requireNonNull(t9, "The ninth item is null");
            return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, function8})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            ObjectHelper.requireNonNull(observableSource7, "source7 is null");
            ObjectHelper.requireNonNull(observableSource8, "source8 is null");
            return combineLatest(Functions.toFunction(function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65650, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, function8})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            ObjectHelper.requireNonNull(observableSource7, "source7 is null");
            ObjectHelper.requireNonNull(observableSource8, "source8 is null");
            return zipArray(Functions.toFunction(function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, null, new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9, t10})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            ObjectHelper.requireNonNull(t7, "The seventh item is null");
            ObjectHelper.requireNonNull(t8, "The eighth item is null");
            ObjectHelper.requireNonNull(t9, "The ninth item is null");
            ObjectHelper.requireNonNull(t10, "The tenth item is null");
            return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9, function9})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            ObjectHelper.requireNonNull(observableSource7, "source7 is null");
            ObjectHelper.requireNonNull(observableSource8, "source8 is null");
            ObjectHelper.requireNonNull(observableSource9, "source9 is null");
            return combineLatest(Functions.toFunction(function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65649, null, new Object[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9, function9})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(observableSource3, "source3 is null");
            ObjectHelper.requireNonNull(observableSource4, "source4 is null");
            ObjectHelper.requireNonNull(observableSource5, "source5 is null");
            ObjectHelper.requireNonNull(observableSource6, "source6 is null");
            ObjectHelper.requireNonNull(observableSource7, "source7 is null");
            ObjectHelper.requireNonNull(observableSource8, "source8 is null");
            ObjectHelper.requireNonNull(observableSource9, "source9 is null");
            return zipArray(Functions.toFunction(function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
        }
        return (Observable) invokeCommon.objValue;
    }
}
