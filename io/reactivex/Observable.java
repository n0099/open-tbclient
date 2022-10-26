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
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
/* loaded from: classes8.dex */
public abstract class Observable implements ObservableSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void subscribeActual(Observer observer);

    /* renamed from: io.reactivex.Observable$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public /* synthetic */ class AnonymousClass1 {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int bufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Flowable.bufferSize();
        }
        return invokeV.intValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable empty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return RxJavaPlugins.onAssembly(ObservableEmpty.INSTANCE);
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) {
            return RxJavaPlugins.onAssembly(ObservableNever.INSTANCE);
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
            subscribe(blockingFirstObserver);
            Object blockingGet = blockingFirstObserver.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable blockingIterable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return blockingIterable(bufferSize());
        }
        return (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
            subscribe(blockingLastObserver);
            Object blockingGet = blockingLastObserver.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable blockingLatest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new BlockingObservableLatest(this);
        }
        return (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable blockingNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new BlockingObservableNext(this);
        }
        return (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingSingle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Object blockingGet = singleElement().blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
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
    public final Observable cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return ObservableCache.from(this);
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableCountSingle(this));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable dematerialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableDematerialize(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable distinct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return distinct(Functions.identity(), Functions.createHashSet());
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable distinctUntilChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return distinctUntilChanged(Functions.identity());
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe firstElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return elementAt(0L);
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single firstOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return elementAtOrError(0L);
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableHide(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ignoreElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableIgnoreElementsCompletable(this));
        }
        return (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return all(Functions.alwaysFalse());
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe lastElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableLastMaybe(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single lastOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, null));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable materialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableMaterialize(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableDetach(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable publish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return ObservablePublish.create(this);
        }
        return (ConnectableObservable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return repeat(Long.MAX_VALUE);
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final ConnectableObservable replay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            return ObservableReplay.createFrom(this);
        }
        return (ConnectableObservable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            return retry(Long.MAX_VALUE, Functions.alwaysTrue());
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable serialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableSerialized(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable share() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) {
            return publish().refCount();
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe singleElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableSingleMaybe(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single singleOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, null));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable sorted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            return toList().toObservable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity());
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) {
            return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
        }
        return (Disposable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048845, this)) == null) {
            TestObserver testObserver = new TestObserver();
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048853, this)) == null) {
            return timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048865, this)) == null) {
            return timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future toFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048871, this)) == null) {
            return (Future) subscribeWith(new FutureObserver());
        }
        return (Future) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048872, this)) == null) {
            return toList(16);
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toSortedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048882, this)) == null) {
            return toSortedList(Functions.naturalOrder());
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable amb(Iterable iterable) {
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
    public static Observable concat(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, observableSource)) == null) {
            return concat(observableSource, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatArrayDelayError(ObservableSource... observableSourceArr) {
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
    public static Observable concatArrayEager(ObservableSource... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, observableSourceArr)) == null) {
            return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatDelayError(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, observableSource)) == null) {
            return concatDelayError(observableSource, bufferSize(), true);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatEager(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, observableSource)) == null) {
            return concatEager(observableSource, bufferSize(), bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable create(ObservableOnSubscribe observableOnSubscribe) {
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
    public static Observable defer(Callable callable) {
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
    public static Observable error(Throwable th) {
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
    public static Observable fromCallable(Callable callable) {
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
    public static Observable fromFuture(Future future) {
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
    public static Observable fromIterable(Iterable iterable) {
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
    public static Observable fromPublisher(Publisher publisher) {
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
    public static Observable generate(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "generator  is null");
            return generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable just(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "The item is null");
            return RxJavaPlugins.onAssembly(new ObservableJust(obj));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(ObservableSource observableSource) {
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
    public static Observable mergeArray(ObservableSource... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, observableSourceArr)) == null) {
            return fromArray(observableSourceArr).flatMap(Functions.identity(), observableSourceArr.length);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeArrayDelayError(ObservableSource... observableSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65621, null, observableSourceArr)) == null) {
            return fromArray(observableSourceArr).flatMap(Functions.identity(), true, observableSourceArr.length);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeDelayError(ObservableSource observableSource) {
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
    public static Observable switchOnNext(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65637, null, observableSource)) == null) {
            return switchOnNext(observableSource, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable switchOnNextDelayError(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65639, null, observableSource)) == null) {
            return switchOnNextDelayError(observableSource, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable wrap(ObservableSource observableSource) {
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
    public final Single all(Predicate predicate) {
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
    public final Observable ambWith(ObservableSource observableSource) {
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
    public final Single any(Predicate predicate) {
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
    public final Object as(ObservableConverter observableConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, observableConverter)) == null) {
            return ((ObservableConverter) ObjectHelper.requireNonNull(observableConverter, "converter is null")).apply(this);
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingFirst(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
            subscribe(blockingFirstObserver);
            Object blockingGet = blockingFirstObserver.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            return obj;
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable blockingIterable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ObjectHelper.verifyPositive(i, "bufferSize");
            return new BlockingObservableIterable(this, i);
        }
        return (Iterable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingLast(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
            subscribe(blockingLastObserver);
            Object blockingGet = blockingLastObserver.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            return obj;
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Iterable blockingMostRecent(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            return new BlockingObservableMostRecent(this, obj);
        }
        return (Iterable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object blockingSingle(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            return single(obj).blockingGet();
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, observer) == null) {
            ObservableBlockingSubscribe.subscribe(this, observer);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            return buffer(i, i);
        }
        return (Observable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable cacheWithInitialCapacity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
            return ObservableCache.from(this, i);
        }
        return (Observable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable cast(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return map(Functions.castFunction(cls));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable compose(ObservableTransformer observableTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, observableTransformer)) == null) {
            return wrap(((ObservableTransformer) ObjectHelper.requireNonNull(observableTransformer, "composer is null")).apply(this));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, function)) == null) {
            return concatMap(function, 2);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, function)) == null) {
            return concatMapCompletable(function, 2);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, function)) == null) {
            return concatMapCompletableDelayError(function, true, 2);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapDelayError(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, function)) == null) {
            return concatMapDelayError(function, bufferSize(), true);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapEager(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, function)) == null) {
            return concatMapEager(function, Integer.MAX_VALUE, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapIterable(Function function) {
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
    public final Observable concatMapMaybe(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, function)) == null) {
            return concatMapMaybe(function, 2);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapMaybeDelayError(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, function)) == null) {
            return concatMapMaybeDelayError(function, true, 2);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapSingle(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, function)) == null) {
            return concatMapSingle(function, 2);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapSingleDelayError(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, function)) == null) {
            return concatMapSingleDelayError(function, true, 2);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatWith(CompletableSource completableSource) {
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
    public final Single contains(Object obj) {
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
    public final Observable debounce(Function function) {
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
    public final Observable defaultIfEmpty(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "defaultItem is null");
            return switchIfEmpty(just(obj));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable delay(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "itemDelay is null");
            return flatMap(ObservableInternalHelper.itemDelay(function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable delaySubscription(ObservableSource observableSource) {
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
    public final Observable distinct(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, function)) == null) {
            return distinct(function, Functions.createHashSet());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable distinctUntilChanged(BiPredicate biPredicate) {
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
    public final Observable doAfterNext(Consumer consumer) {
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
    public final Observable doAfterTerminate(Action action) {
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
    public final Observable doFinally(Action action) {
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
    public final Observable doOnComplete(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, action)) == null) {
            return doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable doOnDispose(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, action)) == null) {
            return doOnLifecycle(Functions.emptyConsumer(), action);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable doOnEach(Observer observer) {
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
    public final Observable doOnError(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, consumer)) == null) {
            Consumer emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnEach(emptyConsumer, consumer, action, action);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable doOnNext(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, consumer)) == null) {
            Consumer emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnEach(consumer, emptyConsumer, action, action);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable doOnSubscribe(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, consumer)) == null) {
            return doOnLifecycle(consumer, Functions.EMPTY_ACTION);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable doOnTerminate(Action action) {
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
    public final Observable filter(Predicate predicate) {
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
    public final Single first(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, obj)) == null) {
            return elementAt(0L, obj);
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, function)) == null) {
            return flatMap(function, false);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, function)) == null) {
            return flatMapCompletable(function, false);
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMapIterable(Function function) {
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
    public final Observable flatMapMaybe(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, function)) == null) {
            return flatMapMaybe(function, false);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMapSingle(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048710, this, function)) == null) {
            return flatMapSingle(function, false);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEach(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048712, this, consumer)) == null) {
            return subscribe(consumer);
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, predicate)) == null) {
            return forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable groupBy(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048716, this, function)) == null) {
            return groupBy(function, Functions.identity(), false, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single last(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048726, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new ObservableLastSingle(this, obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable lift(ObservableOperator observableOperator) {
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
    public final Observable map(Function function) {
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
    public final Observable mergeWith(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048732, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableMergeWithCompletable(this, completableSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048736, this, scheduler)) == null) {
            return observeOn(scheduler, false, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable ofType(Class cls) {
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
    public final Observable onErrorResumeNext(ObservableSource observableSource) {
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
    public final Observable onErrorReturn(Function function) {
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
    public final Observable onErrorReturnItem(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048743, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return onErrorReturn(Functions.justFunction(obj));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable onExceptionResumeNext(ObservableSource observableSource) {
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
    public final Observable publish(Function function) {
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
    public final Maybe reduce(BiFunction biFunction) {
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
    public final Observable repeatUntil(BooleanSupplier booleanSupplier) {
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
    public final Observable repeatWhen(Function function) {
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
    public final Observable replay(Function function) {
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
    public final Observable retry(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048772, this, j)) == null) {
            return retry(j, Functions.alwaysTrue());
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable retryUntil(BooleanSupplier booleanSupplier) {
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
    public final Observable retryWhen(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048777, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "handler is null");
            return RxJavaPlugins.onAssembly(new ObservableRetryWhen(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void safeSubscribe(Observer observer) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable sample(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048783, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sampler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource, false));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable scan(BiFunction biFunction) {
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
    public final Single single(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048790, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new ObservableSingleSingle(this, obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048793, this, j)) == null) {
            if (j <= 0) {
                return RxJavaPlugins.onAssembly(this);
            }
            return RxJavaPlugins.onAssembly(new ObservableSkip(this, j));
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable skipUntil(ObservableSource observableSource) {
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
    public final Observable skipWhile(Predicate predicate) {
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
    public final Observable sorted(Comparator comparator) {
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
    public final Observable startWith(ObservableSource observableSource) {
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
    public final Observable startWithArray(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048809, this, objArr)) == null) {
            Observable fromArray = fromArray(objArr);
            if (fromArray == empty()) {
                return RxJavaPlugins.onAssembly(this);
            }
            return concatArray(fromArray, this);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048811, this, consumer)) == null) {
            return subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable subscribeOn(Scheduler scheduler) {
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
    public final Observer subscribeWith(Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048818, this, observer)) == null) {
            subscribe(observer);
            return observer;
        }
        return (Observer) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable switchIfEmpty(ObservableSource observableSource) {
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
    public final Observable switchMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048820, this, function)) == null) {
            return switchMap(function, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable switchMapCompletable(Function function) {
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
    public final Completable switchMapCompletableDelayError(Function function) {
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
    public final Observable switchMapDelayError(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048824, this, function)) == null) {
            return switchMapDelayError(function, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable switchMapMaybe(Function function) {
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
    public final Observable switchMapMaybeDelayError(Function function) {
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
    public final Observable switchMapSingle(Function function) {
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
    public final Observable switchMapSingleDelayError(Function function) {
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
    public final Observable takeUntil(ObservableSource observableSource) {
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
    public final Observable takeWhile(Predicate predicate) {
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
    public final TestObserver test(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048846, this, z)) == null) {
            TestObserver testObserver = new TestObserver();
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
    public final Observable timeInterval(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048854, this, scheduler)) == null) {
            return timeInterval(TimeUnit.MILLISECONDS, scheduler);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timeout(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048863, this, function)) == null) {
            return timeout0(null, function, null);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timestamp(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048866, this, scheduler)) == null) {
            return timestamp(TimeUnit.MILLISECONDS, scheduler);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object to(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048869, this, function)) == null) {
            try {
                return ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048873, this, i)) == null) {
            ObjectHelper.verifyPositive(i, "capacityHint");
            return RxJavaPlugins.onAssembly(new ObservableToListSingle(this, i));
        }
        return (Single) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048875, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            return collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMultimap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048878, this, function)) == null) {
            return toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toSortedList(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048883, this, i)) == null) {
            return toSortedList(Functions.naturalOrder(), i);
        }
        return (Single) invokeI.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable unsubscribeOn(Scheduler scheduler) {
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
    public final Observable window(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048887, this, j)) == null) {
            return window(j, j, bufferSize());
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable ambArray(ObservableSource... observableSourceArr) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatArray(ObservableSource... observableSourceArr) {
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
    public static Observable fromArray(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, objArr)) == null) {
            ObjectHelper.requireNonNull(objArr, "items is null");
            if (objArr.length == 0) {
                return empty();
            }
            if (objArr.length == 1) {
                return just(objArr[0]);
            }
            return RxJavaPlugins.onAssembly(new ObservableFromArray(objArr));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable unsafeCreate(ObservableSource observableSource) {
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
    public final void blockingForEach(Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, consumer) == null) {
            Iterator it = blockingIterable().iterator();
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
    public final Maybe elementAt(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048685, this, j)) == null) {
            if (j >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableElementAtMaybe(this, j));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
        }
        return (Maybe) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single elementAtOrError(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048687, this, j)) == null) {
            if (j >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j, null));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
        }
        return (Single) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable repeat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048752, this, j)) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return empty();
                }
                return RxJavaPlugins.onAssembly(new ObservableRepeat(this, j));
            }
            throw new IllegalArgumentException("times >= 0 required but it was " + j);
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable skipLast(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048796, this, i)) == null) {
            if (i >= 0) {
                if (i == 0) {
                    return RxJavaPlugins.onAssembly(this);
                }
                return RxJavaPlugins.onAssembly(new ObservableSkipLast(this, i));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
        }
        return (Observable) invokeI.objValue;
    }

    @Override // io.reactivex.ObservableSource
    @SchedulerSupport("none")
    public final void subscribe(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, observer) == null) {
            ObjectHelper.requireNonNull(observer, "observer is null");
            try {
                Observer onSubscribe = RxJavaPlugins.onSubscribe(this, observer);
                ObjectHelper.requireNonNull(onSubscribe, "Plugin returned null Observer");
                subscribeActual(onSubscribe);
            } catch (NullPointerException e) {
                throw e;
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
    public final Observable take(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048830, this, j)) == null) {
            if (j >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableTake(this, j));
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + j);
        }
        return (Observable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable toFlowable(BackpressureStrategy backpressureStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048870, this, backpressureStrategy)) == null) {
            FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
            int i = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[backpressureStrategy.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
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
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, ObservableSource observableSource7, ObservableSource observableSource8, ObservableSource observableSource9, Function9 function9) {
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
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10})) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            ObjectHelper.requireNonNull(obj5, "The fifth item is null");
            ObjectHelper.requireNonNull(obj6, "The sixth item is null");
            ObjectHelper.requireNonNull(obj7, "The seventh item is null");
            ObjectHelper.requireNonNull(obj8, "The eighth item is null");
            ObjectHelper.requireNonNull(obj9, "The ninth item is null");
            ObjectHelper.requireNonNull(obj10, "The tenth item is null");
            return fromArray(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, ObservableSource observableSource7, ObservableSource observableSource8, ObservableSource observableSource9, Function9 function9) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, ObservableSource observableSource7, ObservableSource observableSource8, Function8 function8) {
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
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65608, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9})) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            ObjectHelper.requireNonNull(obj5, "The fifth item is null");
            ObjectHelper.requireNonNull(obj6, "The sixth item is null");
            ObjectHelper.requireNonNull(obj7, "The seventh item is null");
            ObjectHelper.requireNonNull(obj8, "The eighth item is null");
            ObjectHelper.requireNonNull(obj9, "The ninth item is null");
            return fromArray(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, ObservableSource observableSource7, ObservableSource observableSource8, Function8 function8) {
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
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, ObservableSource observableSource7, Function7 function7) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65607, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8})) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            ObjectHelper.requireNonNull(obj5, "The fifth item is null");
            ObjectHelper.requireNonNull(obj6, "The sixth item is null");
            ObjectHelper.requireNonNull(obj7, "The seventh item is null");
            ObjectHelper.requireNonNull(obj8, "The eighth item is null");
            return fromArray(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, ObservableSource observableSource7, Function7 function7) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, Function6 function6) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65606, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7})) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            ObjectHelper.requireNonNull(obj5, "The fifth item is null");
            ObjectHelper.requireNonNull(obj6, "The sixth item is null");
            ObjectHelper.requireNonNull(obj7, "The seventh item is null");
            return fromArray(obj, obj2, obj3, obj4, obj5, obj6, obj7);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, ObservableSource observableSource6, Function6 function6) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, Function5 function5) {
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
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65605, null, new Object[]{obj, obj2, obj3, obj4, obj5, obj6})) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            ObjectHelper.requireNonNull(obj5, "The fifth item is null");
            ObjectHelper.requireNonNull(obj6, "The sixth item is null");
            return fromArray(obj, obj2, obj3, obj4, obj5, obj6);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, ObservableSource observableSource5, Function5 function5) {
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

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i, Callable callable, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i), callable, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            ObjectHelper.verifyPositive(i, "count");
            return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j, j, timeUnit, scheduler, callable, i, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048836, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            if (j >= 0) {
                return RxJavaPlugins.onAssembly(new ObservableTakeLastTimed(this, j, j2, timeUnit, scheduler, i, z));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + j);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048899, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.verifyPositive(i, "bufferSize");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.verifyPositive(j2, "count");
            return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j, j, timeUnit, scheduler, j2, i, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, Function4 function4) {
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
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65604, null, obj, obj2, obj3, obj4, obj5)) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            ObjectHelper.requireNonNull(obj5, "The fifth item is null");
            return fromArray(obj, obj2, obj3, obj4, obj5);
        }
        return (Observable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, Function4 function4) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable withLatestFrom(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4, Function5 function5) {
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
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, Function3 function3) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concat(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    private Observable doOnEach(Consumer consumer, Consumer consumer2, Action action, Action action2) {
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

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable fromFuture(Future future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65585, null, new Object[]{future, Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable just(Object obj, Object obj2, Object obj3, Object obj4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65603, null, obj, obj2, obj3, obj4)) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            ObjectHelper.requireNonNull(obj4, "The fourth item is null");
            return fromArray(obj, obj2, obj3, obj4);
        }
        return (Observable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4) {
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
    public static Observable mergeDelayError(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, ObservableSource observableSource4) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single sequenceEqual(ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65636, null, observableSource, observableSource2, biPredicate, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i));
        }
        return (Single) invokeLLLI.objValue;
    }

    private Observable timeout0(long j, TimeUnit timeUnit, ObservableSource observableSource, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65641, this, new Object[]{Long.valueOf(j), timeUnit, observableSource, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableTimeoutTimed(this, j, timeUnit, scheduler, observableSource));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable using(Callable callable, Function function, Consumer consumer, boolean z) {
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
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, Function3 function3) {
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

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            return buffer(j, j2, timeUnit, scheduler, ArrayListSupplier.asCallable());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, BiFunction biFunction, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048697, this, new Object[]{function, biFunction, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return flatMap(function, biFunction, z, i, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable groupJoin(ObservableSource observableSource, Function function, Function function2, BiFunction biFunction) {
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
    public final Observable join(ObservableSource observableSource, Function function, Function function2, BiFunction biFunction) {
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

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable replay(Function function, int i, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048757, this, new Object[]{function, Integer.valueOf(i), Long.valueOf(j), timeUnit})) == null) {
            return replay(function, i, j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048799, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            return skipLast(j, timeUnit, scheduler, z, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048835, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable timeout(long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource observableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048860, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, observableSource})) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return timeout0(j, timeUnit, observableSource, scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048891, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            return window(j, j2, timeUnit, scheduler, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable withLatestFrom(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3, Function4 function4) {
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
    public final Observable zipWith(ObservableSource observableSource, BiFunction biFunction, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048914, this, new Object[]{observableSource, biFunction, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return zip(this, observableSource, biFunction, z, i);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(ObservableSource observableSource, ObservableSource observableSource2, BiFunction biFunction) {
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
    public static Observable combineLatestDelayError(Iterable iterable, Function function, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65555, null, iterable, function, i)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, iterable, function, i << 1, true));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concat(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3) {
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
    public static Observable concatEager(ObservableSource observableSource, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65572, null, observableSource, i, i2)) == null) {
            ObjectHelper.requireNonNull(Integer.valueOf(i), "maxConcurrency is null");
            ObjectHelper.requireNonNull(Integer.valueOf(i2), "prefetch is null");
            return wrap(observableSource).concatMapEager(Functions.identity(), i, i2);
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable fromFuture(Future future, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65584, null, new Object[]{future, Long.valueOf(j), timeUnit})) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new ObservableFromFuture(future, j, timeUnit));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable interval(long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65594, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            return interval(j, j2, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable just(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65602, null, obj, obj2, obj3)) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            ObjectHelper.requireNonNull(obj3, "The third item is null");
            return fromArray(obj, obj2, obj3);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3) {
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
    public static Observable mergeDelayError(ObservableSource observableSource, ObservableSource observableSource2, ObservableSource observableSource3) {
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

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65644, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableTimer(Math.max(j, 0L), timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, BiFunction biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65656, null, observableSource, observableSource2, biFunction)) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), false, bufferSize(), observableSource, observableSource2);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable buffer(long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            return buffer(j, j2, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function function, boolean z, int i) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMapCompletable(this, function, errorMode, i));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapEager(Function function, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048632, this, function, i, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i, i2));
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapMaybeDelayError(Function function, boolean z, int i) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, function, errorMode, i));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapSingleDelayError(Function function, boolean z, int i) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, function, errorMode, i));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, j, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable delay(long j, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048660, this, new Object[]{Long.valueOf(j), timeUnit, Boolean.valueOf(z)})) == null) {
            return delay(j, timeUnit, Schedulers.computation(), z);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048702, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return flatMap(function, z, i, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable observeOn(Scheduler scheduler, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048738, this, new Object[]{scheduler, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, scheduler, z, i));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable replay(Function function, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048760, this, new Object[]{function, Long.valueOf(j), timeUnit})) == null) {
            return replay(function, j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048780, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j, timeUnit, scheduler, false));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048798, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return skipLast(j, timeUnit, scheduler, false, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable takeLast(long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048834, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            return takeLast(j, j2, timeUnit, Schedulers.trampoline(), false, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048848, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableThrottleFirstTimed(this, j, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable timeout(long j, TimeUnit timeUnit, ObservableSource observableSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048858, this, new Object[]{Long.valueOf(j), timeUnit, observableSource})) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return timeout0(j, timeUnit, observableSource, Schedulers.computation());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable window(long j, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048890, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit})) == null) {
            return window(j, j2, timeUnit, Schedulers.computation(), bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable withLatestFrom(ObservableSource observableSource, ObservableSource observableSource2, Function3 function3) {
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
    public static Observable combineLatest(Function function, int i, ObservableSource... observableSourceArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, function, i, observableSourceArr)) == null) {
            return combineLatest(observableSourceArr, function, i);
        }
        return (Observable) invokeLIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatestDelayError(Function function, int i, ObservableSource... observableSourceArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65553, null, function, i, observableSourceArr)) == null) {
            return combineLatestDelayError(observableSourceArr, function, i);
        }
        return (Observable) invokeLIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatArrayEager(int i, int i2, ObservableSource... observableSourceArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65566, null, i, i2, observableSourceArr)) == null) {
            return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.identity(), i, i2, false);
        }
        return (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable generate(Callable callable, BiConsumer biConsumer, Consumer consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65591, null, callable, biConsumer, consumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "generator  is null");
            return generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65597, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return interval(j, j, timeUnit, scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(Iterable iterable, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65617, null, iterable, i, i2)) == null) {
            return fromIterable(iterable).flatMap(Functions.identity(), false, i, i2);
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeArray(int i, int i2, ObservableSource... observableSourceArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65618, null, i, i2, observableSourceArr)) == null) {
            return fromArray(observableSourceArr).flatMap(Functions.identity(), false, i, i2);
        }
        return (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeArrayDelayError(int i, int i2, ObservableSource... observableSourceArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65620, null, i, i2, observableSourceArr)) == null) {
            return fromArray(observableSourceArr).flatMap(Functions.identity(), true, i, i2);
        }
        return (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeDelayError(Iterable iterable, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65629, null, iterable, i, i2)) == null) {
            return fromIterable(iterable).flatMap(Functions.identity(), true, i, i2);
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single sequenceEqual(ObservableSource observableSource, ObservableSource observableSource2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65634, null, observableSource, observableSource2, i)) == null) {
            return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), i);
        }
        return (Single) invokeLLI.objValue;
    }

    private Observable timeout0(ObservableSource observableSource, Function function, ObservableSource observableSource2) {
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
    public static Observable using(Callable callable, Function function, Consumer consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65646, null, callable, function, consumer)) == null) {
            return using(callable, function, consumer, true);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer consumer, Consumer consumer2, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, consumer, consumer2, action) == null) {
            ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(int i, int i2, Callable callable) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048599, this, i, i2, callable)) == null) {
            ObjectHelper.verifyPositive(i, "count");
            ObjectHelper.verifyPositive(i2, FreeSpaceBox.TYPE);
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBuffer(this, i, i2, callable));
        }
        return (Observable) invokeIIL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return delay(j, timeUnit, scheduler, false);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048664, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return delaySubscription(timer(j, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, BiFunction biFunction, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048695, this, function, biFunction, i)) == null) {
            return flatMap(function, biFunction, false, i, bufferSize());
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate predicate, Consumer consumer, Action action) {
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
    public final Observable groupBy(Function function, Function function2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048718, this, function, function2, z)) == null) {
            return groupBy(function, function2, z, bufferSize());
        }
        return (Observable) invokeLLZ.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable replay(Function function, int i, Scheduler scheduler) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048759, this, function, i, scheduler)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i), ObservableInternalHelper.replayFunction(function, scheduler));
        }
        return (Observable) invokeLIL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048795, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return skipUntil(timer(j, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer, Consumer consumer2, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048813, this, consumer, consumer2, action)) == null) {
            return subscribe(consumer, consumer2, action, Functions.emptyConsumer());
        }
        return (Disposable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048832, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return takeUntil(timer(j, timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048850, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return sample(j, timeUnit, scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048852, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return debounce(j, timeUnit, scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048859, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return timeout0(j, timeUnit, null, scheduler);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMap(Function function, Function function2, Callable callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048877, this, function, function2, callable)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.requireNonNull(callable, "mapSupplier is null");
            return collect(callable, Functions.toMapKeyValueSelector(function, function2));
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMultimap(Function function, Function function2, Callable callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048880, this, function, function2, callable)) == null) {
            return toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable window(ObservableSource observableSource, Function function, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048903, this, observableSource, function, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "openingIndicator is null");
            ObjectHelper.requireNonNull(function, "closingIndicator is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySelector(this, observableSource, function, i));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable zipWith(ObservableSource observableSource, BiFunction biFunction, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048913, this, observableSource, biFunction, z)) == null) {
            return zip(this, observableSource, biFunction, z);
        }
        return (Observable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(Iterable iterable, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, iterable, function)) == null) {
            return combineLatest(iterable, function, bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatestDelayError(Iterable iterable, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, iterable, function)) == null) {
            return combineLatestDelayError(iterable, function, bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concat(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, observableSource, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, Functions.identity(), i, ErrorMode.IMMEDIATE));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable fromFuture(Future future, Scheduler scheduler) {
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
    public static Observable generate(Callable callable, BiConsumer biConsumer) {
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
    public static Observable interval(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65596, null, j, timeUnit)) == null) {
            return interval(j, j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable just(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65601, null, obj, obj2)) == null) {
            ObjectHelper.requireNonNull(obj, "The first item is null");
            ObjectHelper.requireNonNull(obj2, "The second item is null");
            return fromArray(obj, obj2);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(Iterable iterable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65616, null, iterable, i)) == null) {
            return fromIterable(iterable).flatMap(Functions.identity(), i);
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeDelayError(Iterable iterable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65628, null, iterable, i)) == null) {
            return fromIterable(iterable).flatMap(Functions.identity(), true, i);
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single sequenceEqual(ObservableSource observableSource, ObservableSource observableSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65633, null, observableSource, observableSource2)) == null) {
            return sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), bufferSize());
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable switchOnNext(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65638, null, observableSource, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i, false));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable switchOnNextDelayError(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65640, null, observableSource, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(observableSource, Functions.identity(), i, true));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable timer(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65643, null, j, timeUnit)) == null) {
            return timer(j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(Iterable iterable, Function function) {
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
    public final void blockingSubscribe(Consumer consumer, Consumer consumer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, consumer, consumer2) == null) {
            ObservableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            return buffer(i, i2, ArrayListSupplier.asCallable());
        }
        return (Observable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single collect(Callable callable, BiConsumer biConsumer) {
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
    public final Single collectInto(Object obj, BiConsumer biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, obj, biConsumer)) == null) {
            ObjectHelper.requireNonNull(obj, "initialValue is null");
            return collect(Functions.justCallable(obj), biConsumer);
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletable(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048625, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "capacityHint");
            return RxJavaPlugins.onAssembly(new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i));
        }
        return (Completable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatMapCompletableDelayError(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, function, z)) == null) {
            return concatMapCompletableDelayError(function, z, 2);
        }
        return (Completable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapEagerDelayError(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048634, this, function, z)) == null) {
            return concatMapEagerDelayError(function, Integer.MAX_VALUE, bufferSize(), z);
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapIterable(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048636, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return concatMap(ObservableInternalHelper.flatMapIntoIterable(function), i);
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapMaybe(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048638, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapMaybeDelayError(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, function, z)) == null) {
            return concatMapMaybeDelayError(function, z, 2);
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapSingle(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048643, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapSingleDelayError(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048645, this, function, z)) == null) {
            return concatMapSingleDelayError(function, z, 2);
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable debounce(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048653, this, j, timeUnit)) == null) {
            return debounce(j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable delay(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048657, this, j, timeUnit)) == null) {
            return delay(j, timeUnit, Schedulers.computation(), false);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable delaySubscription(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048663, this, j, timeUnit)) == null) {
            return delaySubscription(j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable distinct(Function function, Callable callable) {
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
    public final Observable doOnLifecycle(Consumer consumer, Action action) {
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
    public final Observable flatMap(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048693, this, function, i)) == null) {
            return flatMap(function, false, i, bufferSize());
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function function, boolean z) {
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
    public final Observable flatMapIterable(Function function, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048707, this, function, biFunction)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return flatMap(ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMapMaybe(Function function, boolean z) {
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
    public final Observable flatMapSingle(Function function, boolean z) {
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
    public final Disposable forEachWhile(Predicate predicate, Consumer consumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048714, this, predicate, consumer)) == null) {
            return forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
        }
        return (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable groupBy(Function function, Function function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048717, this, function, function2)) == null) {
            return groupBy(function, function2, false, bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable observeOn(Scheduler scheduler, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048737, this, scheduler, z)) == null) {
            return observeOn(scheduler, z, bufferSize());
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single reduce(Object obj, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048749, this, obj, biFunction)) == null) {
            ObjectHelper.requireNonNull(obj, "seed is null");
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new ObservableReduceSeedSingle(this, obj, biFunction));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single reduceWith(Callable callable, BiFunction biFunction) {
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
    public final Observable replay(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048756, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i), function);
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable sample(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048779, this, j, timeUnit)) == null) {
            return sample(j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable scan(Object obj, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048786, this, obj, biFunction)) == null) {
            ObjectHelper.requireNonNull(obj, "seed is null");
            return scanWith(Functions.justCallable(obj), biFunction);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable scanWith(Callable callable, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048787, this, callable, biFunction)) == null) {
            ObjectHelper.requireNonNull(callable, "seedSupplier is null");
            ObjectHelper.requireNonNull(biFunction, "accumulator is null");
            return RxJavaPlugins.onAssembly(new ObservableScanSeed(this, callable, biFunction));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable skip(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048794, this, j, timeUnit)) == null) {
            return skipUntil(timer(j, timeUnit));
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable skipLast(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048797, this, j, timeUnit)) == null) {
            return skipLast(j, timeUnit, Schedulers.trampoline(), false, bufferSize());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer, Consumer consumer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048812, this, consumer, consumer2)) == null) {
            return subscribe(consumer, consumer2, Functions.EMPTY_ACTION, Functions.emptyConsumer());
        }
        return (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable take(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048831, this, j, timeUnit)) == null) {
            return takeUntil(timer(j, timeUnit));
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable takeLast(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048837, this, j, timeUnit)) == null) {
            return takeLast(j, timeUnit, Schedulers.trampoline(), false, bufferSize());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable throttleFirst(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048847, this, j, timeUnit)) == null) {
            return throttleFirst(j, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable throttleLast(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048849, this, j, timeUnit)) == null) {
            return sample(j, timeUnit);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable throttleWithTimeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048851, this, j, timeUnit)) == null) {
            return debounce(j, timeUnit);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
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
    public final Observable timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048857, this, j, timeUnit)) == null) {
            return timeout0(j, timeUnit, null, Schedulers.computation());
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048868, this, timeUnit, scheduler)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return map(Functions.timestampWith(timeUnit, scheduler));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMap(Function function, Function function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048876, this, function, function2)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            return collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMultimap(Function function, Function function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048879, this, function, function2)) == null) {
            return toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toSortedList(Comparator comparator, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048885, this, comparator, i)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            return toList(i).map(Functions.listSorter(comparator));
        }
        return (Single) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048893, this, j, timeUnit)) == null) {
            return window(j, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable withLatestFrom(ObservableSource observableSource, BiFunction biFunction) {
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
    public final Observable zipWith(ObservableSource observableSource, BiFunction biFunction) {
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
    public static Observable combineLatest(Iterable iterable, Function function, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, iterable, function, i)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(null, iterable, function, i << 1, false));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatestDelayError(ObservableSource[] observableSourceArr, Function function, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65557, null, observableSourceArr, function, i)) == null) {
            ObjectHelper.verifyPositive(i, "bufferSize");
            ObjectHelper.requireNonNull(function, "combiner is null");
            if (observableSourceArr.length == 0) {
                return empty();
            }
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, true));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatEager(Iterable iterable, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65574, null, iterable, i, i2)) == null) {
            ObjectHelper.requireNonNull(Integer.valueOf(i), "maxConcurrency is null");
            ObjectHelper.requireNonNull(Integer.valueOf(i2), "prefetch is null");
            return fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), i, i2, false);
        }
        return (Observable) invokeLII.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable buffer(long j, TimeUnit timeUnit, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), timeUnit, Integer.valueOf(i)})) == null) {
            return buffer(j, timeUnit, Schedulers.computation(), i);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable replay(int i, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048765, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit})) == null) {
            return replay(i, j, timeUnit, Schedulers.computation());
        }
        return (ConnectableObservable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable sample(long j, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048782, this, new Object[]{Long.valueOf(j), timeUnit, Boolean.valueOf(z)})) == null) {
            return sample(j, timeUnit, Schedulers.computation(), z);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable skipLast(long j, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048801, this, new Object[]{Long.valueOf(j), timeUnit, Boolean.valueOf(z)})) == null) {
            return skipLast(j, timeUnit, Schedulers.trampoline(), z, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048838, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return takeLast(j, timeUnit, scheduler, false, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048894, this, new Object[]{Long.valueOf(j), timeUnit, Long.valueOf(j2)})) == null) {
            return window(j, timeUnit, Schedulers.computation(), j2, false);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatest(ObservableSource[] observableSourceArr, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, observableSourceArr, function)) == null) {
            return combineLatest(observableSourceArr, function, bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable combineLatestDelayError(ObservableSource[] observableSourceArr, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, observableSourceArr, function)) == null) {
            return combineLatestDelayError(observableSourceArr, function, bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concat(ObservableSource observableSource, ObservableSource observableSource2) {
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
    public static Observable generate(Callable callable, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, callable, biFunction)) == null) {
            return generate(callable, biFunction, Functions.emptyConsumer());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(int i, Callable callable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, callable)) == null) {
            return buffer(i, i, callable);
        }
        return (Observable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable delay(ObservableSource observableSource, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048661, this, observableSource, function)) == null) {
            return delaySubscription(observableSource).delay(function);
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048694, this, function, biFunction)) == null) {
            return flatMap(function, biFunction, false, bufferSize(), bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable groupBy(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048720, this, function, z)) == null) {
            return groupBy(function, Functions.identity(), z, bufferSize());
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable replay(Function function, Scheduler scheduler) {
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
    public final Observable sample(ObservableSource observableSource, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048784, this, observableSource, z)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sampler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleWithObservable(this, observableSource, z));
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timeout(ObservableSource observableSource, Function function) {
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
    public final Observable window(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048901, this, observableSource, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "boundary is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindowBoundary(this, observableSource, i));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable withLatestFrom(Iterable iterable, Function function) {
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
    public final Observable zipWith(Iterable iterable, BiFunction biFunction) {
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
    public static Observable combineLatest(ObservableSource[] observableSourceArr, Function function, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65552, null, observableSourceArr, function, i)) == null) {
            ObjectHelper.requireNonNull(observableSourceArr, "sources is null");
            if (observableSourceArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
        }
        return (Observable) invokeLLI.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return buffer(j, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048769, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.create(this, j, timeUnit, scheduler);
        }
        return (ConnectableObservable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.TRAMPOLINE)
    @CheckReturnValue
    public final Observable takeLast(long j, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048841, this, new Object[]{Long.valueOf(j), timeUnit, Boolean.valueOf(z)})) == null) {
            return takeLast(j, timeUnit, Schedulers.trampoline(), z, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048896, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return window(j, timeUnit, scheduler, Long.MAX_VALUE, false);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concat(Iterable iterable) {
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
    public static Observable concatDelayError(Iterable iterable) {
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
    public static Observable concatEager(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, iterable)) == null) {
            return concatEager(iterable, bufferSize(), bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable error(Callable callable) {
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
    public static Observable merge(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, iterable)) == null) {
            return fromIterable(iterable).flatMap(Functions.identity());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeDelayError(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65627, null, iterable)) == null) {
            return fromIterable(iterable).flatMap(Functions.identity(), true);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    public final void blockingSubscribe(Consumer consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, consumer) == null) {
            ObservableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
        }
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, observableSource)) == null) {
            return buffer(observableSource, ArrayListSupplier.asCallable());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatWith(MaybeSource maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatWithMaybe(this, maybeSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable distinctUntilChanged(Function function) {
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
    public final Observable doOnEach(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "consumer is null");
            return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable mergeWith(MaybeSource maybeSource) {
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
    public final Observable onErrorResumeNext(Function function) {
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
    public final ConnectableObservable replay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048764, this, i)) == null) {
            ObjectHelper.verifyPositive(i, "bufferSize");
            return ObservableReplay.create(this, i);
        }
        return (ConnectableObservable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable retry(BiPredicate biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048774, this, biPredicate)) == null) {
            ObjectHelper.requireNonNull(biPredicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new ObservableRetryBiPredicate(this, biPredicate));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable startWith(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048807, this, iterable)) == null) {
            return concatArray(fromIterable(iterable), this);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable takeUntil(Predicate predicate) {
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
    public final Observable timeInterval(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048855, this, timeUnit)) == null) {
            return timeInterval(timeUnit, Schedulers.computation());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timestamp(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048867, this, timeUnit)) == null) {
            return timestamp(timeUnit, Schedulers.computation());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toList(Callable callable) {
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
    public final Single toSortedList(Comparator comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048884, this, comparator)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            return toList().map(Functions.listSorter(comparator));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable window(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048900, this, observableSource)) == null) {
            return window(observableSource, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concatDelayError(ObservableSource observableSource, int i, boolean z) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{observableSource, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i, "prefetch is null");
            Function identity = Functions.identity();
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, identity, i, errorMode));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapDelayError(Function function, int i, boolean z) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{function, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i, errorMode));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable window(long j, long j2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048889, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)})) == null) {
            ObjectHelper.verifyPositive(j, "count");
            ObjectHelper.verifyPositive(j2, FreeSpaceBox.TYPE);
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindow(this, j, j2, i));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable generate(Callable callable, BiFunction biFunction, Consumer consumer) {
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
    public static Single sequenceEqual(ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65635, null, observableSource, observableSource2, biPredicate)) == null) {
            return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(ObservableSource observableSource, Function function, Callable callable) {
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
    public final Observable flatMap(Function function, BiFunction biFunction, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048696, this, function, biFunction, z)) == null) {
            return flatMap(function, biFunction, z, bufferSize(), bufferSize());
        }
        return (Observable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timeout(ObservableSource observableSource, Function function, ObservableSource observableSource2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048862, this, observableSource, function, observableSource2)) == null) {
            ObjectHelper.requireNonNull(observableSource, "firstTimeoutIndicator is null");
            ObjectHelper.requireNonNull(observableSource2, "other is null");
            return timeout0(observableSource, function, observableSource2);
        }
        return (Observable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65595, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, scheduler));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, BiFunction biFunction, boolean z) {
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
    public static Observable zipArray(Function function, boolean z, int i, ObservableSource... observableSourceArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65661, null, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i), observableSourceArr})) == null) {
            if (observableSourceArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableZip(observableSourceArr, null, function, i, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zipIterable(Iterable iterable, Function function, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65662, null, new Object[]{iterable, function, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableZip(null, iterable, function, i, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatMapEagerDelayError(Function function, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{function, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMapEager(this, function, errorMode, i, i2));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048659, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableDelay(this, j, timeUnit, scheduler, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable groupBy(Function function, Function function2, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048719, this, new Object[]{function, function2, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableGroupBy(this, function, function2, i, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048766, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.verifyPositive(i, "bufferSize");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.create(this, j, timeUnit, scheduler, i);
        }
        return (ConnectableObservable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable sample(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048781, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new ObservableSampleTimed(this, j, timeUnit, scheduler, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Observable intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65598, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), timeUnit})) == null) {
            return intervalRange(j, j2, j3, j4, timeUnit, Schedulers.computation());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, ObservableSource observableSource2, BiFunction biFunction, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65658, null, new Object[]{observableSource, observableSource2, biFunction, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(observableSource, "source1 is null");
            ObjectHelper.requireNonNull(observableSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), z, i, observableSource, observableSource2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable callable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler, callable})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new ObservableBufferTimed(this, j, j2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, BiFunction biFunction, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{function, biFunction, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "combiner is null");
            return flatMap(ObservableInternalHelper.flatMapWithCombiner(function, biFunction), z, i, i2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable replay(Function function, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048758, this, new Object[]{function, Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, i, j, timeUnit, scheduler), function);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048800, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048840, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return takeLast(Long.MAX_VALUE, j, timeUnit, scheduler, z, i);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048898, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return window(j, timeUnit, scheduler, j2, z, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Observable intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65599, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), timeUnit, scheduler})) == null) {
            int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return empty().delay(j3, timeUnit, scheduler);
                }
                long j5 = j + (j2 - 1);
                if (j > 0 && j5 < 0) {
                    throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                }
                ObjectHelper.requireNonNull(timeUnit, "unit is null");
                ObjectHelper.requireNonNull(scheduler, "scheduler is null");
                return RxJavaPlugins.onAssembly(new ObservableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, scheduler));
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65611, null, observableSource, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), false, i, bufferSize()));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable mergeDelayError(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65623, null, observableSource, i)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(observableSource, Functions.identity(), true, i, bufferSize()));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable zip(ObservableSource observableSource, Function function) {
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
    @CheckReturnValue
    public final Observable concatMap(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048623, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single elementAt(long j, Object obj) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048686, this, j, obj)) == null) {
            if (j >= 0) {
                ObjectHelper.requireNonNull(obj, "defaultItem is null");
                return RxJavaPlugins.onAssembly(new ObservableElementAtSingle(this, j, obj));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable retry(long j, Predicate predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048773, this, j, predicate)) == null) {
            if (j >= 0) {
                ObjectHelper.requireNonNull(predicate, "predicate is null");
                return RxJavaPlugins.onAssembly(new ObservableRetryPredicate(this, j, predicate));
            }
            throw new IllegalArgumentException("times >= 0 required but it was " + j);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable switchMap(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048821, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i, false));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable switchMapDelayError(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048825, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableSwitchMap(this, function, i, true));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable window(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048888, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return window(j, j2, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable merge(ObservableSource observableSource, ObservableSource observableSource2) {
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
    public static Observable mergeDelayError(ObservableSource observableSource, ObservableSource observableSource2) {
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
    public static Observable range(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65631, null, i, i2)) == null) {
            if (i2 >= 0) {
                if (i2 == 0) {
                    return empty();
                }
                if (i2 == 1) {
                    return just(Integer.valueOf(i));
                }
                if (i + (i2 - 1) <= 2147483647L) {
                    return RxJavaPlugins.onAssembly(new ObservableRange(i, i2));
                }
                throw new IllegalArgumentException("Integer overflow");
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + i2);
        }
        return (Observable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable rangeLong(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65632, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return empty();
                }
                if (j2 == 1) {
                    return just(Long.valueOf(j));
                }
                long j3 = (j2 - 1) + j;
                if (j > 0 && j3 < 0) {
                    throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                }
                return RxJavaPlugins.onAssembly(new ObservableRangeLong(j, j2));
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable buffer(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048604, this, j, timeUnit)) == null) {
            return buffer(j, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
        }
        return (Observable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048701, this, function, z)) == null) {
            return flatMap(function, z, Integer.MAX_VALUE);
        }
        return (Observable) invokeLZ.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable replay(int i, Scheduler scheduler) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048767, this, i, scheduler)) == null) {
            ObjectHelper.verifyPositive(i, "bufferSize");
            return ObservableReplay.observeOn(replay(i), scheduler);
        }
        return (ConnectableObservable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable timeout(Function function, ObservableSource observableSource) {
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
    public final Observable window(ObservableSource observableSource, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048902, this, observableSource, function)) == null) {
            return window(observableSource, function, bufferSize());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable withLatestFrom(ObservableSource[] observableSourceArr, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048911, this, observableSourceArr, function)) == null) {
            ObjectHelper.requireNonNull(observableSourceArr, "others is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            return RxJavaPlugins.onAssembly(new ObservableWithLatestFromMany(this, observableSourceArr, function));
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i)})) == null) {
            return buffer(j, timeUnit, scheduler, i, ArrayListSupplier.asCallable(), false);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable replay(Function function, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048761, this, new Object[]{function, Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return ObservableReplay.multicastSelector(ObservableInternalHelper.replayCallable(this, j, timeUnit, scheduler), function);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048839, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            return takeLast(j, timeUnit, scheduler, z, bufferSize());
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048895, this, new Object[]{Long.valueOf(j), timeUnit, Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return window(j, timeUnit, Schedulers.computation(), j2, z);
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(ObservableSource observableSource, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048610, this, observableSource, i)) == null) {
            ObjectHelper.verifyPositive(i, "initialCapacity");
            return buffer(observableSource, Functions.createArrayList(i));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final ConnectableObservable replay(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048768, this, j, timeUnit)) == null) {
            return replay(j, timeUnit, Schedulers.computation());
        }
        return (ConnectableObservable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable window(Callable callable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048905, this, callable, i)) == null) {
            ObjectHelper.requireNonNull(callable, "boundary is null");
            ObjectHelper.verifyPositive(i, "bufferSize");
            return RxJavaPlugins.onAssembly(new ObservableWindowBoundarySupplier(this, callable, i));
        }
        return (Observable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(ObservableSource observableSource, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, observableSource, function)) == null) {
            return buffer(observableSource, function, ArrayListSupplier.asCallable());
        }
        return (Observable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(ObservableSource observableSource, Callable callable) {
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
    public final Observable buffer(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, callable)) == null) {
            return buffer(callable, ArrayListSupplier.asCallable());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable concatWith(ObservableSource observableSource) {
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
    public final Observable mergeWith(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048734, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return merge(this, observableSource);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final ConnectableObservable replay(Scheduler scheduler) {
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
    public final Observable retry(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048775, this, predicate)) == null) {
            return retry(Long.MAX_VALUE, predicate);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable startWith(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048808, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return concatArray(just(obj), this);
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable window(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048904, this, callable)) == null) {
            return window(callable, bufferSize());
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable buffer(Callable callable, Callable callable2) {
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
    public final Observable concatWith(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatWithSingle(this, singleSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable mergeWith(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048735, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new ObservableMergeWithSingle(this, singleSource));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, Function function2, Callable callable) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, Function function2, Callable callable, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048700, this, function, function2, callable, i)) == null) {
            ObjectHelper.requireNonNull(function, "onNextMapper is null");
            ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
            ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
            return merge(new ObservableMapNotification(this, function, function2, callable), i);
        }
        return (Observable) invokeLLLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer, Consumer consumer2, Action action, Consumer consumer3) {
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

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single toMultimap(Function function, Function function2, Callable callable, Function function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048881, this, function, function2, callable, function3)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.requireNonNull(callable, "mapSupplier is null");
            ObjectHelper.requireNonNull(function3, "collectionFactory is null");
            return collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
        }
        return (Single) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMap(Function function, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048703, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return ObservableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, function, z, i, i2));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable takeLast(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048833, this, i)) == null) {
            if (i >= 0) {
                if (i == 0) {
                    return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this));
                }
                if (i == 1) {
                    return RxJavaPlugins.onAssembly(new ObservableTakeLastOne(this));
                }
                return RxJavaPlugins.onAssembly(new ObservableTakeLast(this, i));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
        }
        return (Observable) invokeI.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048892, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i)})) == null) {
            ObjectHelper.verifyPositive(j, "timespan");
            ObjectHelper.verifyPositive(j2, "timeskip");
            ObjectHelper.verifyPositive(i, "bufferSize");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new ObservableWindowTimed(this, j, j2, timeUnit, scheduler, Long.MAX_VALUE, i, false));
        }
        return (Observable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048897, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Long.valueOf(j2)})) == null) {
            return window(j, timeUnit, scheduler, j2, false);
        }
        return (Observable) invokeCommon.objValue;
    }
}
