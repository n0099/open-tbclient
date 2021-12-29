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
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.flowables.GroupedFlowable;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDefer;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.internal.operators.flowable.FlowableDetach;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFilter;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableHide;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.internal.operators.flowable.FlowableLift;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableNever;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableScan;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSerialized;
import io.reactivex.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.flowable.FlowableSkip;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.FutureSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import io.reactivex.subscribers.SafeSubscriber;
import io.reactivex.subscribers.TestSubscriber;
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
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes4.dex */
public abstract class Flowable<T> implements Publisher<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final int BUFFER_SIZE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(930932998, "Lio/reactivex/Flowable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(930932998, "Lio/reactivex/Flowable;");
                return;
            }
        }
        BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public Flowable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> amb(Iterable<? extends Publisher<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new FlowableAmb(null, iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> ambArray(Publisher<? extends T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, publisherArr)) == null) {
            ObjectHelper.requireNonNull(publisherArr, "sources is null");
            int length = publisherArr.length;
            if (length == 0) {
                return empty();
            }
            if (length == 1) {
                return fromPublisher(publisherArr[0]);
            }
            return RxJavaPlugins.onAssembly(new FlowableAmb(publisherArr, null));
        }
        return (Flowable) invokeL.objValue;
    }

    public static int bufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? BUFFER_SIZE : invokeV.intValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, publisherArr, function)) == null) ? combineLatest(publisherArr, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, publisherArr, function)) == null) ? combineLatestDelayError(publisherArr, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Iterable<? extends Publisher<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return fromIterable(iterable).concatMapDelayError(Functions.identity(), 2, false);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArray(Publisher<? extends T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, publisherArr)) == null) {
            if (publisherArr.length == 0) {
                return empty();
            }
            if (publisherArr.length == 1) {
                return fromPublisher(publisherArr[0]);
            }
            return RxJavaPlugins.onAssembly(new FlowableConcatArray(publisherArr, false));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayDelayError(Publisher<? extends T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, publisherArr)) == null) {
            if (publisherArr.length == 0) {
                return empty();
            }
            if (publisherArr.length == 1) {
                return fromPublisher(publisherArr[0]);
            }
            return RxJavaPlugins.onAssembly(new FlowableConcatArray(publisherArr, true));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(Publisher<? extends T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, publisherArr)) == null) ? concatArrayEager(bufferSize(), bufferSize(), publisherArr) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return fromIterable(iterable).concatMapDelayError(Functions.identity());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65575, null, publisher)) == null) ? concatEager(publisher, bufferSize(), bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public static <T> Flowable<T> create(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, flowableOnSubscribe, backpressureStrategy)) == null) {
            ObjectHelper.requireNonNull(flowableOnSubscribe, "source is null");
            ObjectHelper.requireNonNull(backpressureStrategy, "mode is null");
            return RxJavaPlugins.onAssembly(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> defer(Callable<? extends Publisher<? extends T>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "supplier is null");
            return RxJavaPlugins.onAssembly(new FlowableDefer(callable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    private Flowable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65579, this, consumer, consumer2, action, action2)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ObjectHelper.requireNonNull(action2, "onAfterTerminate is null");
            return RxJavaPlugins.onAssembly(new FlowableDoOnEach(this, consumer, consumer2, action, action2));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> empty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? RxJavaPlugins.onAssembly(FlowableEmpty.INSTANCE) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> error(Callable<? extends Throwable> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "errorSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableError(callable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromArray(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, tArr)) == null) {
            ObjectHelper.requireNonNull(tArr, "items is null");
            if (tArr.length == 0) {
                return empty();
            }
            if (tArr.length == 1) {
                return just(tArr[0]);
            }
            return RxJavaPlugins.onAssembly(new FlowableFromArray(tArr));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromCallable(Callable<? extends T> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "supplier is null");
            return RxJavaPlugins.onAssembly(new FlowableFromCallable(callable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromFuture(Future<? extends T> future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, future)) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            return RxJavaPlugins.onAssembly(new FlowableFromFuture(future, 0L, null));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromIterable(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "source is null");
            return RxJavaPlugins.onAssembly(new FlowableFromIterable(iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> fromPublisher(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, publisher)) == null) {
            if (publisher instanceof Flowable) {
                return RxJavaPlugins.onAssembly((Flowable) publisher);
            }
            ObjectHelper.requireNonNull(publisher, "publisher is null");
            return RxJavaPlugins.onAssembly(new FlowableFromPublisher(publisher));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> generate(Consumer<Emitter<T>> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "generator is null");
            return generate(Functions.nullSupplier(), FlowableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65596, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? interval(j2, j3, timeUnit, Schedulers.computation()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65600, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), timeUnit})) == null) ? intervalRange(j2, j3, j4, j5, timeUnit, Schedulers.computation()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, t)) == null) {
            ObjectHelper.requireNonNull(t, "item is null");
            return RxJavaPlugins.onAssembly(new FlowableJust(t));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65614, null, iterable, i2, i3)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), false, i2, i3) : (Flowable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArray(int i2, int i3, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65620, null, i2, i3, publisherArr)) == null) ? fromArray(publisherArr).flatMap(Functions.identity(), false, i2, i3) : (Flowable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(int i2, int i3, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65622, null, i2, i3, publisherArr)) == null) ? fromArray(publisherArr).flatMap(Functions.identity(), true, i2, i3) : (Flowable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65624, null, iterable)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), true) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) ? RxJavaPlugins.onAssembly(FlowableNever.INSTANCE) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable<Integer> range(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65633, null, i2, i3)) == null) {
            if (i3 < 0) {
                throw new IllegalArgumentException("count >= 0 required but it was " + i3);
            } else if (i3 == 0) {
                return empty();
            } else {
                if (i3 == 1) {
                    return just(Integer.valueOf(i2));
                }
                if (i2 + (i3 - 1) <= 2147483647L) {
                    return RxJavaPlugins.onAssembly(new FlowableRange(i2, i3));
                }
                throw new IllegalArgumentException("Integer overflow");
            }
        }
        return (Flowable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable<Long> rangeLong(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65634, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
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
                return RxJavaPlugins.onAssembly(new FlowableRangeLong(j2, j3));
            }
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65635, null, publisher, publisher2)) == null) ? sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), bufferSize()) : (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65640, null, publisher, i2)) == null) ? fromPublisher(publisher).switchMap(Functions.identity(), i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65641, null, publisher)) == null) ? switchOnNextDelayError(publisher, bufferSize()) : (Flowable) invokeL.objValue;
    }

    private Flowable<T> timeout0(long j2, TimeUnit timeUnit, Publisher<? extends T> publisher, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65643, this, new Object[]{Long.valueOf(j2), timeUnit, publisher, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "timeUnit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableTimeoutTimed(this, j2, timeUnit, scheduler, publisher));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> timer(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65645, null, j2, timeUnit)) == null) ? timer(j2, timeUnit, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public static <T> Flowable<T> unsafeCreate(Publisher<T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65647, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "onSubscribe is null");
            if (!(publisher instanceof Flowable)) {
                return RxJavaPlugins.onAssembly(new FlowableFromPublisher(publisher));
            }
            throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65648, null, callable, function, consumer)) == null) ? using(callable, function, consumer, true) : (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> zip(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65650, null, iterable, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new FlowableZip(null, iterable, function, bufferSize(), false));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i2, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65662, null, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2), publisherArr})) == null) {
            if (publisherArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableZip(publisherArr, null, function, i2, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> zipIterable(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65663, null, new Object[]{iterable, function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableZip(null, iterable, function, i2, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableAllSingle(this, predicate));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> ambWith(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return ambArray(this, publisher);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableAnySingle(this, predicate));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @Experimental
    public final <R> R as(@NonNull FlowableConverter<T, ? extends R> flowableConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, flowableConverter)) == null) ? (R) ((FlowableConverter) ObjectHelper.requireNonNull(flowableConverter, "converter is null")).apply(this) : (R) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
            subscribe((FlowableSubscriber) blockingFirstSubscriber);
            T blockingGet = blockingFirstSubscriber.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
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
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Iterable<T> blockingIterable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? blockingIterable(bufferSize()) : (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
            subscribe((FlowableSubscriber) blockingLastSubscriber);
            T blockingGet = blockingLastSubscriber.blockingGet();
            if (blockingGet != null) {
                return blockingGet;
            }
            throw new NoSuchElementException();
        }
        return (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Iterable<T> blockingLatest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new BlockingFlowableLatest(this) : (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Iterable<T> blockingMostRecent(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, t)) == null) ? new BlockingFlowableMostRecent(this, t) : (Iterable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Iterable<T> blockingNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new BlockingFlowableNext(this) : (Iterable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingSingle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? singleOrError().blockingGet() : (T) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FlowableBlockingSubscribe.subscribe(this);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? buffer(i2, i2) : (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? cacheWithInitialCapacity(16) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> cacheWithInitialCapacity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "initialCapacity");
            return RxJavaPlugins.onAssembly(new FlowableCache(this, i2));
        }
        return (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <U> Flowable<U> cast(Class<U> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return (Flowable<U>) map(Functions.castFunction(cls));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, callable, biConsumer)) == null) {
            ObjectHelper.requireNonNull(callable, "initialItemSupplier is null");
            ObjectHelper.requireNonNull(biConsumer, "collector is null");
            return RxJavaPlugins.onAssembly(new FlowableCollectSingle(this, callable, biConsumer));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, u, biConsumer)) == null) {
            ObjectHelper.requireNonNull(u, "initialItem is null");
            return collect(Functions.justCallable(u), biConsumer);
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <R> Flowable<R> compose(FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, flowableTransformer)) == null) ? fromPublisher(((FlowableTransformer) ObjectHelper.requireNonNull(flowableTransformer, "composer is null")).apply(this)) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, function)) == null) ? concatMap(function, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, function)) == null) ? concatMapCompletable(function, 2) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, function)) == null) ? concatMapCompletableDelayError(function, true, 2) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, function)) == null) ? concatMapDelayError(function, 2, true) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, function)) == null) ? concatMapEager(function, bufferSize(), bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048634, this, function, z)) == null) ? concatMapEagerDelayError(function, bufferSize(), bufferSize(), z) : (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, function)) == null) ? concatMapIterable(function, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, function)) == null) ? concatMapMaybe(function, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, function)) == null) ? concatMapMaybeDelayError(function, true, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, function)) == null) ? concatMapSingle(function, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, function)) == null) ? concatMapSingleDelayError(function, true, 2) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> concatWith(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return concat(this, publisher);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Boolean> contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "item is null");
            return any(Functions.equalsWith(obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Long> count() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableCountSingle(this)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U> Flowable<T> debounce(Function<? super T, ? extends Publisher<U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "debounceIndicator is null");
            return RxJavaPlugins.onAssembly(new FlowableDebounce(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> defaultIfEmpty(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "item is null");
            return switchIfEmpty(just(t));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<T> delay(Function<? super T, ? extends Publisher<U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "itemDelayIndicator is null");
            return (Flowable<T>) flatMap(FlowableInternalHelper.itemDelay(function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<T> delaySubscription(Publisher<U> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "subscriptionIndicator is null");
            return RxJavaPlugins.onAssembly(new FlowableDelaySubscriptionOther(this, publisher));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T2> Flowable<T2> dematerialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableDematerialize(this)) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> distinct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? distinct(Functions.identity(), Functions.createHashSet()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> distinctUntilChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? distinctUntilChanged(Functions.identity()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doAfterNext(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
            return RxJavaPlugins.onAssembly(new FlowableDoAfterNext(this, consumer));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doAfterTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, action)) == null) ? doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doFinally(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return RxJavaPlugins.onAssembly(new FlowableDoFinally(this, action));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnCancel(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, action)) == null) ? doOnLifecycle(Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnComplete(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, action)) == null) ? doOnEach(Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnError(Consumer<? super Throwable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, consumer)) == null) {
            Consumer<? super T> emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnEach(emptyConsumer, consumer, action, action);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnLifecycle(Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048681, this, consumer, longConsumer, action)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
            ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
            ObjectHelper.requireNonNull(action, "onCancel is null");
            return RxJavaPlugins.onAssembly(new FlowableDoOnLifecycle(this, consumer, longConsumer, action));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnNext(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, consumer)) == null) {
            Consumer<? super Throwable> emptyConsumer = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return doOnEach(consumer, emptyConsumer, action, action);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnRequest(LongConsumer longConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048683, this, longConsumer)) == null) ? doOnLifecycle(Functions.emptyConsumer(), longConsumer, Functions.EMPTY_ACTION) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, consumer)) == null) ? doOnLifecycle(consumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, action)) == null) ? doOnEach(Functions.emptyConsumer(), Functions.actionConsumer(action), action, Functions.EMPTY_ACTION) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> elementAt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048686, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new FlowableElementAtMaybe(this, j2));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
        }
        return (Maybe) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> elementAtOrError(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048688, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, j2, null));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
        }
        return (Single) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> filter(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableFilter(this, predicate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Single<T> first(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, t)) == null) ? elementAt(0L, t) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Maybe<T> firstElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? elementAt(0L) : (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Single<T> firstOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? elementAtOrError(0L) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, function)) == null) ? flatMap((Function) function, false, bufferSize(), bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048705, this, function)) == null) ? flatMapCompletable(function, false, Integer.MAX_VALUE) : (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, function)) == null) ? flatMapIterable(function, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048711, this, function)) == null) ? flatMapMaybe(function, false, Integer.MAX_VALUE) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, function)) == null) ? flatMapSingle(function, false, Integer.MAX_VALUE) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEach(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048715, this, consumer)) == null) ? subscribe(consumer) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048716, this, predicate)) == null) ? forEachWhile(predicate, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048719, this, function)) == null) ? (Flowable<GroupedFlowable<K, T>>) groupBy(function, Functions.identity(), false, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super Flowable<TRight>, ? extends R> biFunction) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048725, this, publisher, function, function2, biFunction)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            ObjectHelper.requireNonNull(function, "leftEnd is null");
            ObjectHelper.requireNonNull(function2, "rightEnd is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return RxJavaPlugins.onAssembly(new FlowableGroupJoin(this, publisher, function, function2, biFunction));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableHide(this)) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Completable ignoreElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableIgnoreElementsCompletable(this)) : (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<Boolean> isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? all(Functions.alwaysFalse()) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048729, this, publisher, function, function2, biFunction)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            ObjectHelper.requireNonNull(function, "leftEnd is null");
            ObjectHelper.requireNonNull(function2, "rightEnd is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return RxJavaPlugins.onAssembly(new FlowableJoin(this, publisher, function, function2, biFunction));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> last(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048730, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "defaultItem");
            return RxJavaPlugins.onAssembly(new FlowableLastSingle(this, t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> lastElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableLastMaybe(this)) : (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> lastOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableLastSingle(this, null)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> Flowable<R> lift(FlowableOperator<? extends R, ? super T> flowableOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048733, this, flowableOperator)) == null) {
            ObjectHelper.requireNonNull(flowableOperator, "lifter is null");
            return RxJavaPlugins.onAssembly(new FlowableLift(this, flowableOperator));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> limit(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048734, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new FlowableLimit(this, j2));
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        return (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <R> Flowable<R> map(Function<? super T, ? extends R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048735, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableMap(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Notification<T>> materialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableMaterialize(this)) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> mergeWith(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048740, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return merge(this, publisher);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048741, this, scheduler)) == null) ? observeOn(scheduler, false, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <U> Flowable<U> ofType(Class<U> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048744, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return filter(Functions.isInstanceOf(cls)).cast(cls);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) ? onBackpressureBuffer(bufferSize(), false, true) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureDrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this)) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureLatest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableOnBackpressureLatest(this)) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> onErrorResumeNext(Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048756, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunction is null");
            return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, function, false));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048758, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "valueSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableOnErrorReturn(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> onErrorReturnItem(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048759, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "item is null");
            return onErrorReturn(Functions.justFunction(t));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> onExceptionResumeNext(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048760, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "next is null");
            return RxJavaPlugins.onAssembly(new FlowableOnErrorNext(this, Functions.justFunction(publisher), true));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableDetach(this)) : (Flowable) invokeV.objValue;
    }

    @Beta
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ParallelFlowable<T> parallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? ParallelFlowable.from(this) : (ParallelFlowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> publish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? publish(bufferSize()) : (ConnectableFlowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> rebatchRequests(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048769, this, i2)) == null) ? observeOn(ImmediateThinScheduler.INSTANCE, true, i2) : (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048770, this, biFunction)) == null) {
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new FlowableReduceMaybe(this, biFunction));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048772, this, callable, biFunction)) == null) {
            ObjectHelper.requireNonNull(callable, "seedSupplier is null");
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new FlowableReduceWithSingle(this, callable, biFunction));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) ? repeat(Long.MAX_VALUE) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048775, this, booleanSupplier)) == null) {
            ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
            return RxJavaPlugins.onAssembly(new FlowableRepeatUntil(this, booleanSupplier));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048776, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "handler is null");
            return RxJavaPlugins.onAssembly(new FlowableRepeatWhen(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) ? FlowableReplay.createFrom(this) : (ConnectableFlowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? retry(Long.MAX_VALUE, Functions.alwaysTrue()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retryUntil(BooleanSupplier booleanSupplier) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048798, this, booleanSupplier)) == null) {
            ObjectHelper.requireNonNull(booleanSupplier, "stop is null");
            return retry(Long.MAX_VALUE, Functions.predicateReverseFor(booleanSupplier));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048799, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "handler is null");
            return RxJavaPlugins.onAssembly(new FlowableRetryWhen(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    public final void safeSubscribe(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, subscriber) == null) {
            ObjectHelper.requireNonNull(subscriber, "s is null");
            if (subscriber instanceof SafeSubscriber) {
                subscribe((FlowableSubscriber) ((SafeSubscriber) subscriber));
            } else {
                subscribe((FlowableSubscriber) new SafeSubscriber(subscriber));
            }
        }
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> sample(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048801, this, j2, timeUnit)) == null) ? sample(j2, timeUnit, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> scan(BiFunction<T, T, T> biFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048807, this, biFunction)) == null) {
            ObjectHelper.requireNonNull(biFunction, "accumulator is null");
            return RxJavaPlugins.onAssembly(new FlowableScan(this, biFunction));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048809, this, callable, biFunction)) == null) {
            ObjectHelper.requireNonNull(callable, "seedSupplier is null");
            ObjectHelper.requireNonNull(biFunction, "accumulator is null");
            return RxJavaPlugins.onAssembly(new FlowableScanSeed(this, callable, biFunction));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> serialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableSerialized(this)) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> share() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) ? publish().refCount() : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> single(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048812, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "defaultItem is null");
            return RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, t));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Maybe<T> singleElement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableSingleMaybe(this)) : (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> singleOrError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableSingleSingle(this, null)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skip(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048815, this, j2)) == null) {
            if (j2 <= 0) {
                return RxJavaPlugins.onAssembly(this);
            }
            return RxJavaPlugins.onAssembly(new FlowableSkip(this, j2));
        }
        return (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skipLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048818, this, i2)) == null) {
            if (i2 >= 0) {
                if (i2 == 0) {
                    return RxJavaPlugins.onAssembly(this);
                }
                return RxJavaPlugins.onAssembly(new FlowableSkipLast(this, i2));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        return (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<T> skipUntil(Publisher<U> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048824, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableSkipUntil(this, publisher));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skipWhile(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048825, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableSkipWhile(this, predicate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sorted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048826, this)) == null) ? toList().toFlowable().map(Functions.listSorter(Functions.naturalComparator())).flatMapIterable(Functions.identity()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> startWith(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048828, this, iterable)) == null) ? concatArray(fromIterable(iterable), this) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> startWithArray(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048831, this, tArr)) == null) {
            Flowable fromArray = fromArray(tArr);
            if (fromArray == empty()) {
                return RxJavaPlugins.onAssembly(this);
            }
            return concatArray(fromArray, this);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048832, this)) == null) ? subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE) : (Disposable) invokeV.objValue;
    }

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> subscribeOn(@NonNull Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048840, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return subscribeOn(scheduler, !(this instanceof FlowableCreate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <E extends Subscriber<? super T>> E subscribeWith(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048842, this, e2)) == null) {
            subscribe(e2);
            return e2;
        }
        return (E) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> switchIfEmpty(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048843, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchIfEmpty(this, publisher));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048844, this, function)) == null) ? switchMap(function, bufferSize()) : (Flowable) invokeL.objValue;
    }

    public <R> Flowable<R> switchMap0(Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048846, this, new Object[]{function, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return FlowableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new FlowableSwitchMap(this, function, i2, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @Experimental
    public final Completable switchMapCompletable(@NonNull Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048847, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchMapCompletable(this, function, false));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @Experimental
    public final Completable switchMapCompletableDelayError(@NonNull Function<? super T, ? extends CompletableSource> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048848, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchMapCompletable(this, function, true));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048849, this, function)) == null) ? switchMapDelayError(function, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> switchMapMaybe(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048851, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, function, false));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> switchMapMaybeDelayError(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048852, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchMapMaybe(this, function, true));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> switchMapSingle(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048853, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, function, false));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> switchMapSingleDelayError(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048854, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new FlowableSwitchMapSingle(this, function, true));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> take(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048855, this, j2)) == null) {
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new FlowableTake(this, j2));
            }
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        return (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048858, this, i2)) == null) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
            } else if (i2 == 0) {
                return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this));
            } else {
                if (i2 == 1) {
                    return RxJavaPlugins.onAssembly(new FlowableTakeLastOne(this));
                }
                return RxJavaPlugins.onAssembly(new FlowableTakeLast(this, i2));
            }
        }
        return (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> takeUntil(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048867, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "stopPredicate is null");
            return RxJavaPlugins.onAssembly(new FlowableTakeUntilPredicate(this, predicate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> takeWhile(Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048869, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableTakeWhile(this, predicate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final TestSubscriber<T> test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048870, this)) == null) {
            TestSubscriber<T> testSubscriber = new TestSubscriber<>();
            subscribe((FlowableSubscriber) testSubscriber);
            return testSubscriber;
        }
        return (TestSubscriber) invokeV.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleFirst(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048873, this, j2, timeUnit)) == null) ? throttleFirst(j2, timeUnit, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048875, this, j2, timeUnit)) == null) ? sample(j2, timeUnit) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleWithTimeout(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048877, this, j2, timeUnit)) == null) ? debounce(j2, timeUnit) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048879, this)) == null) ? timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048887, this, function)) == null) ? timeout0(null, function, null) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048891, this)) == null) ? timestamp(TimeUnit.MILLISECONDS, Schedulers.computation()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> R to(Function<? super Flowable<T>, R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048895, this, function)) == null) {
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
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Future<T> toFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048896, this)) == null) ? (Future) subscribeWith(new FutureSubscriber()) : (Future) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048897, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableToListSingle(this)) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048900, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            return (Single<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048903, this, function)) == null) ? (Single<Map<K, Collection<T>>>) toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction()) : (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Observable<T> toObservable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048907, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableFromPublisher(this)) : (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toSortedList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048908, this)) == null) ? toSortedList(Functions.naturalComparator()) : (Single) invokeV.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> unsubscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048912, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableUnsubscribeOn(this, scheduler));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048913, this, j2)) == null) ? window(j2, j2, bufferSize()) : (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <U, R> Flowable<R> withLatestFrom(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048933, this, publisher, biFunction)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            ObjectHelper.requireNonNull(biFunction, "combiner is null");
            return RxJavaPlugins.onAssembly(new FlowableWithLatestFrom(this, biFunction, publisher));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048938, this, iterable, biFunction)) == null) {
            ObjectHelper.requireNonNull(iterable, "other is null");
            ObjectHelper.requireNonNull(biFunction, "zipper is null");
            return RxJavaPlugins.onAssembly(new FlowableZipIterable(this, iterable, biFunction));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, function, publisherArr)) == null) ? combineLatest(publisherArr, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, function, publisherArr)) == null) ? combineLatestDelayError(publisherArr, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatArrayEager(int i2, int i3, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65568, null, i2, i3, publisherArr)) == null) {
            ObjectHelper.requireNonNull(publisherArr, "sources is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromArray(publisherArr), Functions.identity(), i2, i3, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65576, null, publisher, i2, i3)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapEagerPublisher(publisher, Functions.identity(), i2, i3, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLII.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65597, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableInterval(Math.max(0L, j2), Math.max(0L, j3), timeUnit, scheduler));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> intervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65601, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), timeUnit, scheduler})) == null) {
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
                return RxJavaPlugins.onAssembly(new FlowableIntervalRange(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, scheduler));
            }
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65612, null, iterable)) == null) ? fromIterable(iterable).flatMap(Functions.identity()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArray(Publisher<? extends T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, publisherArr)) == null) ? fromArray(publisherArr).flatMap(Functions.identity(), publisherArr.length) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeArrayDelayError(Publisher<? extends T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65623, null, publisherArr)) == null) ? fromArray(publisherArr).flatMap(Functions.identity(), true, publisherArr.length) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65626, null, iterable, i2, i3)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), true, i2, i3) : (Flowable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65637, null, publisher, publisher2, biPredicate)) == null) ? sequenceEqual(publisher, publisher2, biPredicate, bufferSize()) : (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65639, null, publisher)) == null) ? fromPublisher(publisher).switchMap(Functions.identity()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65642, null, publisher, i2)) == null) ? fromPublisher(publisher).switchMapDelayError(Functions.identity(), i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> timer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65646, null, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableTimer(Math.max(0L, j2), timeUnit, scheduler));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65649, null, new Object[]{callable, function, consumer, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
            ObjectHelper.requireNonNull(function, "sourceSupplier is null");
            ObjectHelper.requireNonNull(consumer, "disposer is null");
            return RxJavaPlugins.onAssembly(new FlowableUsing(callable, function, consumer, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Iterable<T> blockingIterable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return new BlockingFlowableIterable(this, i2);
        }
        return (Iterable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingSingle(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, t)) == null) ? single(t).blockingGet() : (T) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, consumer) == null) {
            FlowableBlockingSubscribe.subscribe(this, consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) ? (Flowable<List<T>>) buffer(i2, i3, ArrayListSupplier.asCallable()) : (Flowable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
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
                return FlowableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048625, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i2));
        }
        return (Completable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, function, z)) == null) ? concatMapCompletableDelayError(function, z, 2) : (Completable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
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
                return FlowableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new FlowableConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048632, this, function, i2, i3)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, function, i2, i3, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{function, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(this, function, i2, i3, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048636, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, function, i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048638, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, function, z)) == null) ? concatMapMaybeDelayError(function, z, 2) : (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048643, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048645, this, function, z)) == null) ? concatMapSingleDelayError(function, z, 2) : (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<T> distinct(Function<? super T, K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, function)) == null) ? distinct(function, Functions.createHashSet()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<T> distinctUntilChanged(Function<? super T, K> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048702, this, function, z)) == null) ? flatMap(function, z, bufferSize(), bufferSize()) : (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048706, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletableCompletable(this, function, z, i2));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048708, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableFlattenIterable(this, function, i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048712, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapMaybe(this, function, z, i2));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048714, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapSingle(this, function, z, i2));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048717, this, predicate, consumer)) == null) ? forEachWhile(predicate, consumer, Functions.EMPTY_ACTION) : (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048724, this, function, z)) == null) ? (Flowable<GroupedFlowable<K, T>>) groupBy(function, Functions.identity(), z, bufferSize()) : (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> observeOn(Scheduler scheduler, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048742, this, scheduler, z)) == null) ? observeOn(scheduler, z, bufferSize()) : (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048752, this, z)) == null) ? onBackpressureBuffer(bufferSize(), z, true) : (Flowable) invokeZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> onBackpressureDrop(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048754, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onDrop is null");
            return RxJavaPlugins.onAssembly(new FlowableOnBackpressureDrop(this, consumer));
        }
        return (Flowable) invokeL.objValue;
    }

    @Beta
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ParallelFlowable<T> parallel(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048763, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "parallelism");
            return ParallelFlowable.from(this, i2);
        }
        return (ParallelFlowable) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.functions.Function<? super io.reactivex.Flowable<T>, ? extends org.reactivestreams.Publisher<R>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048765, this, function)) == null) ? publish(function, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> repeat(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048774, this, j2)) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 >= 0) {
                if (i2 == 0) {
                    return empty();
                }
                return RxJavaPlugins.onAssembly(new FlowableRepeat(this, j2));
            }
            throw new IllegalArgumentException("times >= 0 required but it was " + j2);
        }
        return (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048777, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this), function);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048796, this, biPredicate)) == null) {
            ObjectHelper.requireNonNull(biPredicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new FlowableRetryBiPredicate(this, biPredicate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> sample(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048804, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? sample(j2, timeUnit, Schedulers.computation(), z) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sorted(Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048827, this, comparator)) == null) {
            ObjectHelper.requireNonNull(comparator, "sortFunction");
            return toList().toFlowable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> startWith(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048830, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return concatArray(publisher, this);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048833, this, consumer)) == null) ? subscribe(consumer, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE) : (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048845, this, function, i2)) == null) ? switchMap0(function, i2, false) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048850, this, function, i2)) == null) ? switchMap0(function, i2, true) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleFirst(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048874, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableThrottleFirstTimed(this, j2, timeUnit, scheduler));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleLast(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048876, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? sample(j2, timeUnit, scheduler) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> throttleWithTimeout(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048878, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? debounce(j2, timeUnit, scheduler) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048880, this, scheduler)) == null) ? timeInterval(TimeUnit.MILLISECONDS, scheduler) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function, Flowable<? extends T> flowable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048888, this, function, flowable)) == null) {
            ObjectHelper.requireNonNull(flowable, "other is null");
            return timeout0(null, function, flowable);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048892, this, scheduler)) == null) ? timestamp(TimeUnit.MILLISECONDS, scheduler) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048898, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "capacityHint");
            return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, Functions.createArrayList(i2)));
        }
        return (Single) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048910, this, comparator)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            return (Single<List<T>>) toList().map(Functions.listSorter(comparator));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048914, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? window(j2, j3, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65553, null, publisherArr, function, i2)) == null) {
            ObjectHelper.requireNonNull(publisherArr, "sources is null");
            if (publisherArr.length == 0) {
                return empty();
            }
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableCombineLatest((Publisher[]) publisherArr, (Function) function, i2, false));
        }
        return (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i2, Publisher<? extends T>... publisherArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, function, i2, publisherArr)) == null) ? combineLatestDelayError(publisherArr, function, i2) : (Flowable) invokeLIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, publisher)) == null) ? concat(publisher, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, publisher)) == null) ? concatDelayError(publisher, bufferSize(), true) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public static <T> Flowable<T> error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "throwable is null");
            return error(Functions.justCallable(th));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65586, null, new Object[]{future, Long.valueOf(j2), timeUnit})) == null) {
            ObjectHelper.requireNonNull(future, "future is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new FlowableFromFuture(future, j2, timeUnit));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, t, t2)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            return fromArray(t, t2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65613, null, iterable, i2)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65625, null, iterable, i2)) == null) ? fromIterable(iterable).flatMap(Functions.identity(), true, i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65638, null, publisher, publisher2, biPredicate, i2)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(biPredicate, "isEqual is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, i2));
        }
        return (Single) invokeLLLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, consumer, consumer2) == null) {
            FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, Functions.EMPTY_ACTION);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(int i2, int i3, Callable<U> callable) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048599, this, i2, i3, callable)) == null) {
            ObjectHelper.verifyPositive(i2, "count");
            ObjectHelper.verifyPositive(i3, FreeSpaceBox.TYPE);
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableBuffer(this, i2, i3, callable));
        }
        return (Flowable) invokeIIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
        }
        return (Completable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> concatWith(@NonNull SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableConcatWithSingle(this, singleSource));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> debounce(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048653, this, j2, timeUnit)) == null) ? debounce(j2, timeUnit, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048657, this, j2, timeUnit)) == null) ? delay(j2, timeUnit, Schedulers.computation(), false) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delaySubscription(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048663, this, j2, timeUnit)) == null) ? delaySubscription(j2, timeUnit, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K> Flowable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048669, this, function, callable)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableDistinct(this, function, callable));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<T> elementAt(long j2, T t) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048687, this, j2, t)) == null) {
            if (j2 >= 0) {
                ObjectHelper.requireNonNull(t, "defaultItem is null");
                return RxJavaPlugins.onAssembly(new FlowableElementAtSingle(this, j2, t));
            }
            throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048694, this, function, i2)) == null) ? flatMap((Function) function, false, i2, bufferSize()) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.NONE)
    @CheckReturnValue
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048718, this, predicate, consumer, action)) == null) {
            ObjectHelper.requireNonNull(predicate, "onNext is null");
            ObjectHelper.requireNonNull(consumer, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(predicate, consumer, action);
            subscribe((FlowableSubscriber) forEachWhileSubscriber);
            return forEachWhileSubscriber;
        }
        return (Disposable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048720, this, function, function2)) == null) ? groupBy(function, function2, false, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> mergeWith(@NonNull SingleSource<? extends T> singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048739, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableMergeWithSingle(this, singleSource));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> observeOn(Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048743, this, new Object[]{scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableObserveOn(this, scheduler, z, i2));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048746, this, i2)) == null) ? onBackpressureBuffer(i2, false, false) : (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> onErrorResumeNext(Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048757, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "next is null");
            return onErrorResumeNext(Functions.justFunction(publisher));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048766, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowablePublishMulticast(this, function, i2, false));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048771, this, r, biFunction)) == null) {
            ObjectHelper.requireNonNull(r, "seed is null");
            ObjectHelper.requireNonNull(biFunction, "reducer is null");
            return RxJavaPlugins.onAssembly(new FlowableReduceSeedSingle(this, r, biFunction));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> sample(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048802, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, j2, timeUnit, scheduler, false));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048808, this, r, biFunction)) == null) {
            ObjectHelper.requireNonNull(r, "seed is null");
            return scanWith(Functions.justCallable(r), biFunction);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skip(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048816, this, j2, timeUnit)) == null) ? skipUntil(timer(j2, timeUnit)) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048834, this, consumer, consumer2)) == null) ? subscribe(consumer, consumer2, Functions.EMPTY_ACTION, FlowableInternalHelper.RequestMax.INSTANCE) : (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> subscribeOn(@NonNull Scheduler scheduler, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048841, this, scheduler, z)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableSubscribeOn(this, scheduler, z));
        }
        return (Flowable) invokeLZ.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> take(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048856, this, j2, timeUnit)) == null) ? takeUntil(timer(j2, timeUnit)) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <U> Flowable<T> takeUntil(Publisher<U> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048868, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableTakeUntil(this, publisher));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final TestSubscriber<T> test(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048871, this, j2)) == null) {
            TestSubscriber<T> testSubscriber = new TestSubscriber<>(j2);
            subscribe((FlowableSubscriber) testSubscriber);
            return testSubscriber;
        }
        return (TestSubscriber) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048881, this, timeUnit)) == null) ? timeInterval(timeUnit, Schedulers.computation()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048893, this, timeUnit)) == null) ? timestamp(timeUnit, Schedulers.computation()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048901, this, function, function2)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            return (Single<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, long j3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048915, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)})) == null) {
            ObjectHelper.verifyPositive(j3, FreeSpaceBox.TYPE);
            ObjectHelper.verifyPositive(j2, "count");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableWindow(this, j2, j3, i2));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65559, null, publisherArr, function, i2)) == null) {
            ObjectHelper.requireNonNull(publisherArr, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (publisherArr.length == 0) {
                return empty();
            }
            return RxJavaPlugins.onAssembly(new FlowableCombineLatest((Publisher[]) publisherArr, (Function) function, i2, true));
        }
        return (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, publisher, i2)) == null) ? fromPublisher(publisher).concatMap(Functions.identity(), i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{publisher, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? fromPublisher(publisher).concatMapDelayError(Functions.identity(), i2, z) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65615, null, publisher)) == null) ? merge(publisher, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65627, null, publisher)) == null) ? mergeDelayError(publisher, bufferSize()) : (Flowable) invokeL.objValue;
    }

    private <U, V> Flowable<T> timeout0(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65644, this, publisher, function, publisher2)) == null) {
            ObjectHelper.requireNonNull(function, "itemTimeoutIndicator is null");
            return RxJavaPlugins.onAssembly(new FlowableTimeout(this, publisher, function, publisher2));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> zip(Publisher<? extends Publisher<? extends T>> publisher, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65651, null, publisher, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            return fromPublisher(publisher).toList().flatMapPublisher(FlowableInternalHelper.zipIterable(function));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, consumer, consumer2, action) == null) {
            FlowableBlockingSubscribe.subscribe(this, consumer, consumer2, action);
        }
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> debounce(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableDebounceTimed(this, j2, timeUnit, scheduler));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048660, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? delay(j2, timeUnit, Schedulers.computation(), z) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delaySubscription(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048664, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? delaySubscription(timer(j2, timeUnit, scheduler)) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, biPredicate)) == null) {
            ObjectHelper.requireNonNull(biPredicate, "comparer is null");
            return RxJavaPlugins.onAssembly(new FlowableDistinctUntilChanged(this, Functions.identity(), biPredicate));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048703, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? flatMap(function, z, i2, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048721, this, function, function2, z)) == null) ? groupBy(function, function2, z, bufferSize()) : (Flowable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048748, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? onBackpressureBuffer(i2, z, false) : (Flowable) invokeCommon.objValue;
    }

    @Beta
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ParallelFlowable<T> parallel(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048764, this, i2, i3)) == null) {
            ObjectHelper.verifyPositive(i2, "parallelism");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return ParallelFlowable.from(this, i2, i3);
        }
        return (ParallelFlowable) invokeII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048778, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, i2), function);
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048794, this, j2)) == null) ? retry(j2, Functions.alwaysTrue()) : (Flowable) invokeJ.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> skip(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048817, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? skipUntil(timer(j2, timeUnit, scheduler)) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048819, this, j2, timeUnit)) == null) ? skipLast(j2, timeUnit, Schedulers.computation(), false, bufferSize()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> startWith(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048829, this, t)) == null) {
            ObjectHelper.requireNonNull(t, "item is null");
            return concatArray(just(t), this);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048835, this, consumer, consumer2, action)) == null) ? subscribe(consumer, consumer2, action, FlowableInternalHelper.RequestMax.INSTANCE) : (Disposable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> take(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048857, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? takeUntil(timer(j2, timeUnit, scheduler)) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048882, this, timeUnit, scheduler)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableTimeInterval(this, timeUnit, scheduler));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> timeout(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048883, this, j2, timeUnit)) == null) ? timeout0(j2, timeUnit, null, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048894, this, timeUnit, scheduler)) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return (Flowable<Timed<T>>) map(Functions.timestampWith(timeUnit, scheduler));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048899, this, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableToListSingle(this, callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048911, this, comparator, i2)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            return (Single<List<T>>) toList(i2).map(Functions.listSorter(comparator));
        }
        return (Single) invokeLI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.Flowable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048934, this, publisher, publisher2, function3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return withLatestFrom(new Publisher[]{publisher, publisher2}, Functions.toFunction(function3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048939, this, publisher, biFunction)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return zip(this, publisher, biFunction);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, publisher, publisher2)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return concatArray(publisher, publisher2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65598, null, j2, timeUnit)) == null) ? interval(j2, j2, timeUnit, Schedulers.computation()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65616, null, publisher, i2)) == null) ? fromPublisher(publisher).flatMap(Functions.identity(), i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65628, null, publisher, i2)) == null) ? fromPublisher(publisher).flatMap(Functions.identity(), true, i2) : (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingFirst(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) {
            BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
            subscribe((FlowableSubscriber) blockingFirstSubscriber);
            T blockingGet = blockingFirstSubscriber.blockingGet();
            return blockingGet != null ? blockingGet : t;
        }
        return (T) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final T blockingLast(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, t)) == null) {
            BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
            subscribe((FlowableSubscriber) blockingLastSubscriber);
            T blockingGet = blockingLastSubscriber.blockingGet();
            return blockingGet != null ? blockingGet : t;
        }
        return (T) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void blockingSubscribe(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, subscriber) == null) {
            FlowableBlockingSubscribe.subscribe(this, subscriber);
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> concatWith(@NonNull MaybeSource<? extends T> maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableConcatWithMaybe(this, maybeSource));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? delay(j2, timeUnit, scheduler, false) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048704, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, "bufferSize");
            if (this instanceof ScalarCallable) {
                Object call = ((ScalarCallable) this).call();
                if (call == null) {
                    return empty();
                }
                return FlowableScalarXMap.scalarXMap(call, function);
            }
            return RxJavaPlugins.onAssembly(new FlowableFlatMap(this, function, z, i2, i3));
        }
        return (Flowable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048709, this, function, biFunction)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return (Flowable<V>) flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), bufferSize());
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048722, this, new Object[]{function, function2, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, function, function2, i2, z, null));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> mergeWith(@NonNull MaybeSource<? extends T> maybeSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048738, this, maybeSource)) == null) {
            ObjectHelper.requireNonNull(maybeSource, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableMergeWithMaybe(this, maybeSource));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048749, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, i2, z2, z, Functions.EMPTY_ACTION));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry(long j2, Predicate<? super Throwable> predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048795, this, j2, predicate)) == null) {
            if (j2 >= 0) {
                ObjectHelper.requireNonNull(predicate, "predicate is null");
                return RxJavaPlugins.onAssembly(new FlowableRetryPredicate(this, j2, predicate));
            }
            throw new IllegalArgumentException("times >= 0 required but it was " + j2);
        }
        return (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048823, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? skipLast(j2, timeUnit, Schedulers.computation(), z, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048836, this, consumer, consumer2, action, consumer3)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ObjectHelper.requireNonNull(action, "onComplete is null");
            ObjectHelper.requireNonNull(consumer3, "onSubscribe is null");
            LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, consumer3);
            subscribe((FlowableSubscriber) lambdaSubscriber);
            return lambdaSubscriber;
        }
        return (Disposable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048859, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? takeLast(j2, j3, timeUnit, Schedulers.computation(), false, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final TestSubscriber<T> test(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048872, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            TestSubscriber<T> testSubscriber = new TestSubscriber<>(j2);
            if (z) {
                testSubscriber.cancel();
            }
            subscribe((FlowableSubscriber) testSubscriber);
            return testSubscriber;
        }
        return (TestSubscriber) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> timeout(long j2, TimeUnit timeUnit, Publisher<? extends T> publisher) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048886, this, new Object[]{Long.valueOf(j2), timeUnit, publisher})) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return timeout0(j2, timeUnit, publisher, Schedulers.computation());
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048904, this, function, function2)) == null) ? toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction()) : (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65573, null, iterable)) == null) ? concatEager(iterable, bufferSize(), bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65587, null, new Object[]{future, Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return fromFuture(future, j2, timeUnit).subscribeOn(scheduler);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, callable, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "generator is null");
            return generate(callable, FlowableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public static Flowable<Long> interval(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65599, null, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? interval(j2, j2, timeUnit, scheduler) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65604, null, t, t2, t3)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            return fromArray(t, t2, t3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65617, null, publisher, publisher2)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return fromArray(publisher, publisher2).flatMap(Functions.identity(), false, 2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65629, null, publisher, publisher2)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return fromArray(publisher, publisher2).flatMap(Functions.identity(), true, 2);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65652, null, publisher, publisher2, biFunction)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), false, bufferSize(), publisher, publisher2);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> delay(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048659, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableDelay(this, Math.max(0L, j2), timeUnit, scheduler, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "consumer is null");
            return doOnEach(Functions.notificationOnNext(consumer), Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> publish(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048768, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return FlowablePublish.create(this, i2);
        }
        return (ConnectableFlowable) invokeI.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> sample(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048803, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new FlowableSampleTimed(this, j2, timeUnit, scheduler, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048820, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? skipLast(j2, timeUnit, scheduler, false, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048860, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) ? takeLast(j2, j3, timeUnit, scheduler, false, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.concurrent.Callable<? extends java.util.Map<K, V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048902, this, function, function2, callable)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            return (Single<Map<K, V>>) collect(callable, Functions.toMapKeyValueSelector(function, function2));
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Single<List<T>> toSortedList(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048909, this, i2)) == null) ? toSortedList(Functions.naturalComparator(), i2) : (Single) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048940, this, publisher, biFunction, z)) == null) ? zip(this, publisher, biFunction, z) : (Flowable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65574, null, iterable, i2, i3)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.identity(), i2, i3, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLII.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(int i2, Callable<U> callable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i2, callable)) == null) ? buffer(i2, i2, callable) : (Flowable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> concatWith(@NonNull CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableConcatWithCompletable(this, completableSource));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @Experimental
    public final Flowable<T> mergeWith(@NonNull CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048737, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new FlowableMergeWithCompletable(this, completableSource));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i2, boolean z, boolean z2, Action action) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048750, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), action})) == null) {
            ObjectHelper.requireNonNull(action, "onOverflow is null");
            ObjectHelper.verifyPositive(i2, "capacity");
            return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBuffer(this, i2, z2, z, action));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048779, this, new Object[]{function, Integer.valueOf(i2), Long.valueOf(j2), timeUnit})) == null) ? replay(function, i2, j2, timeUnit, Schedulers.computation()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048821, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) ? skipLast(j2, timeUnit, scheduler, z, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048861, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            if (j2 >= 0) {
                return RxJavaPlugins.onAssembly(new FlowableTakeLastTimed(this, j2, j3, timeUnit, scheduler, i2, z));
            }
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> timeout(long j2, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048885, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, publisher})) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return timeout0(j2, timeUnit, publisher, scheduler);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048916, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? window(j2, j3, timeUnit, Schedulers.computation(), bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048941, this, new Object[]{publisher, biFunction, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? zip(this, publisher, biFunction, z, i2) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, publisher, publisher2, publisher3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            return concatArray(publisher, publisher2, publisher3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, future, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return fromFuture(future).subscribeOn(scheduler);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65636, null, publisher, publisher2, i2)) == null) ? sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), i2) : (Single) invokeLLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j2, long j3, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit})) == null) ? (Flowable<List<T>>) buffer(j2, j3, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable()) : (Flowable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: io.reactivex.functions.BiFunction<? super T, ? super U, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048710, this, function, biFunction, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "resultSelector is null");
            return (Flowable<V>) flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, bufferSize(), i2);
        }
        return (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048780, this, new Object[]{function, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, i2, j2, timeUnit, scheduler), function);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> retry(Predicate<? super Throwable> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048797, this, predicate)) == null) ? retry(Long.MAX_VALUE, predicate) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final Flowable<T> skipLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048822, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableSkipLastTimed(this, j2, timeUnit, scheduler, i2 << 1, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.concurrent.Callable<? extends java.util.Map<K, java.util.Collection<V>>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048906, this, function, function2, callable, function3)) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.requireNonNull(callable, "mapSupplier is null");
            ObjectHelper.requireNonNull(function3, "collectionFactory is null");
            return (Single<Map<K, Collection<V>>>) collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
        }
        return (Single) invokeLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048917, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) ? window(j2, j3, timeUnit, scheduler, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.Flowable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048935, this, publisher, publisher2, publisher3, function4)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            return withLatestFrom(new Publisher[]{publisher, publisher2, publisher3}, Functions.toFunction(function4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, iterable, function)) == null) ? combineLatest(iterable, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65618, null, publisher, publisher2, publisher3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            return fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), false, 3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65630, null, publisher, publisher2, publisher3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            return fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), true, 3);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65653, null, new Object[]{publisher, publisher2, biFunction, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), z, bufferSize(), publisher, publisher2);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler})) == null) ? (Flowable<List<T>>) buffer(j2, j3, timeUnit, scheduler, ArrayListSupplier.asCallable()) : (Flowable) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, V> Flowable<T> delay(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048662, this, publisher, function)) == null) ? delaySubscription(publisher).delay(function) : (Flowable) invokeLL.objValue;
    }

    @Beta
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i2, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048723, this, new Object[]{function, function2, Boolean.valueOf(z), Integer.valueOf(i2), function3})) == null) {
            ObjectHelper.requireNonNull(function, "keySelector is null");
            ObjectHelper.requireNonNull(function2, "valueSelector is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(function3, "evictingMapFactory is null");
            return RxJavaPlugins.onAssembly(new FlowableGroupBy(this, function, function2, i2, z, function3));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U> Flowable<T> sample(Publisher<U> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048805, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "sampler is null");
            return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, publisher, false));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> timeout(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048884, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? timeout0(j2, timeUnit, null, scheduler) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048918, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, Integer.valueOf(i2)})) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.verifyPositive(j2, "timespan");
            ObjectHelper.verifyPositive(j3, "timeskip");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, j2, j3, timeUnit, scheduler, Long.MAX_VALUE, i2, false));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, iterable, function, i2)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableCombineLatest((Iterable) iterable, (Function) function, i2, false));
        }
        return (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, iterable, function)) == null) ? combineLatestDelayError(iterable, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65593, null, callable, biConsumer, consumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "generator is null");
            return generate(callable, FlowableInternalHelper.simpleBiGenerator(biConsumer), consumer);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65605, null, t, t2, t3, t4)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            return fromArray(t, t2, t3, t4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, callable})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, j2, j3, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(int i2, Action action) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048747, this, i2, action)) == null) ? onBackpressureBuffer(i2, false, false, action) : (Flowable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048889, this, publisher, function)) == null) {
            ObjectHelper.requireNonNull(publisher, "firstTimeoutIndicator is null");
            return timeout0(publisher, function, null);
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65557, null, iterable, function, i2)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableCombineLatest((Iterable) iterable, (Function) function, i2, true));
        }
        return (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final Flowable<T> doOnEach(Subscriber<? super T> subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, subscriber)) == null) {
            ObjectHelper.requireNonNull(subscriber, "subscriber is null");
            return doOnEach(FlowableInternalHelper.subscriberOnNext(subscriber), FlowableInternalHelper.subscriberOnError(subscriber), FlowableInternalHelper.subscriberOnComplete(subscriber), Functions.EMPTY_ACTION);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @CheckReturnValue
    public final Flowable<T> onBackpressureBuffer(long j2, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048751, this, new Object[]{Long.valueOf(j2), action, backpressureOverflowStrategy})) == null) {
            ObjectHelper.requireNonNull(backpressureOverflowStrategy, "strategy is null");
            ObjectHelper.verifyPositive(j2, "capacity");
            return RxJavaPlugins.onAssembly(new FlowableOnBackpressureBufferStrategy(this, j2, action, backpressureOverflowStrategy));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U> Flowable<T> sample(Publisher<U> publisher, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048806, this, publisher, z)) == null) {
            ObjectHelper.requireNonNull(publisher, "sampler is null");
            return RxJavaPlugins.onAssembly(new FlowableSamplePublisher(this, publisher, z));
        }
        return (Flowable) invokeLZ.objValue;
    }

    @Override // org.reactivestreams.Publisher
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    public final void subscribe(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, subscriber) == null) {
            if (subscriber instanceof FlowableSubscriber) {
                subscribe((FlowableSubscriber) ((FlowableSubscriber) subscriber));
                return;
            }
            ObjectHelper.requireNonNull(subscriber, "s is null");
            subscribe((FlowableSubscriber) new StrictSubscriber(subscriber));
        }
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65565, null, publisher, publisher2, publisher3, publisher4)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            return concatArray(publisher, publisher2, publisher3, publisher4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65594, null, callable, biFunction)) == null) ? generate(callable, biFunction, Functions.emptyConsumer()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65654, null, new Object[]{publisher, publisher2, biFunction, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), z, i2, publisher, publisher2);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048862, this, j2, timeUnit)) == null) ? takeLast(j2, timeUnit, Schedulers.computation(), false, bufferSize()) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048890, this, publisher, function, publisher2)) == null) {
            ObjectHelper.requireNonNull(publisher, "firstTimeoutSelector is null");
            ObjectHelper.requireNonNull(publisher2, "other is null");
            return timeout0(publisher, function, publisher2);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65595, null, callable, biFunction, consumer)) == null) {
            ObjectHelper.requireNonNull(callable, "initialState is null");
            ObjectHelper.requireNonNull(biFunction, "generator is null");
            ObjectHelper.requireNonNull(consumer, "disposeState is null");
            return RxJavaPlugins.onAssembly(new FlowableGenerate(callable, biFunction, consumer));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65619, null, publisher, publisher2, publisher3, publisher4)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), false, 4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65631, null, publisher, publisher2, publisher3, publisher4)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), true, 4);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048700, this, function, function2, callable)) == null) {
            ObjectHelper.requireNonNull(function, "onNextMapper is null");
            ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
            ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
            return merge(new FlowableMapNotification(this, function, function2, callable));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048866, this, new Object[]{Long.valueOf(j2), timeUnit, Boolean.valueOf(z)})) == null) ? takeLast(j2, timeUnit, Schedulers.computation(), z, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048905, this, function, function2, callable)) == null) ? toMultimap(function, function2, callable, ArrayListSupplier.asFunction()) : (Single) invokeLLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.Flowable<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048936, this, publisher, publisher2, publisher3, publisher4, function5)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            return withLatestFrom(new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.toFunction(function5));
        }
        return (Flowable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, publisher, publisher2, biFunction)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            return combineLatest(Functions.toFunction(biFunction), publisher, publisher2);
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048604, this, j2, timeUnit)) == null) ? buffer(j2, timeUnit, Schedulers.computation(), Integer.MAX_VALUE) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, Scheduler scheduler) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048781, this, function, i2, scheduler)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, i2), FlowableInternalHelper.replayFunction(function, scheduler));
        }
        return (Flowable) invokeLIL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048863, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? takeLast(j2, timeUnit, scheduler, false, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65606, null, t, t2, t3, t4, t5)) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            return fromArray(t, t2, t3, t4, t5);
        }
        return (Flowable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65655, null, publisher, publisher2, publisher3, function3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            return zipArray(Functions.toFunction(function3), false, bufferSize(), publisher, publisher2, publisher3);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j2, TimeUnit timeUnit, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j2), timeUnit, Integer.valueOf(i2)})) == null) ? buffer(j2, timeUnit, Schedulers.computation(), i2) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.SPECIAL)
    @Beta
    public final void subscribe(FlowableSubscriber<? super T> flowableSubscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048837, this, flowableSubscriber) == null) {
            ObjectHelper.requireNonNull(flowableSubscriber, "s is null");
            try {
                Subscriber<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, flowableSubscriber);
                ObjectHelper.requireNonNull(onSubscribe, "Plugin returned null Subscriber");
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

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048864, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z)})) == null) ? takeLast(j2, timeUnit, scheduler, z, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048919, this, j2, timeUnit)) == null) ? window(j2, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false) : (Flowable) invokeJL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i2)})) == null) ? (Flowable<List<T>>) buffer(j2, timeUnit, scheduler, i2, ArrayListSupplier.asCallable(), false) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> takeLast(long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048865, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? takeLast(Long.MAX_VALUE, j2, timeUnit, scheduler, z, i2) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048920, this, new Object[]{Long.valueOf(j2), timeUnit, Long.valueOf(j3)})) == null) ? window(j2, timeUnit, Schedulers.computation(), j3, false) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> buffer(long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, Callable<U> callable, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i2), callable, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            ObjectHelper.verifyPositive(i2, "count");
            return RxJavaPlugins.onAssembly(new FlowableBufferTimed(this, j2, j2, timeUnit, scheduler, callable, i2, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048701, this, function, function2, callable, i2)) == null) {
            ObjectHelper.requireNonNull(function, "onNextMapper is null");
            ObjectHelper.requireNonNull(function2, "onErrorMapper is null");
            ObjectHelper.requireNonNull(callable, "onCompleteSupplier is null");
            return merge(new FlowableMapNotification(this, function, function2, callable), i2);
        }
        return (Flowable) invokeLLLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048921, this, new Object[]{Long.valueOf(j2), timeUnit, Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? window(j2, timeUnit, Schedulers.computation(), j3, z) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, publisher, publisher2, publisher3, function3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            return combineLatest(Functions.toFunction(function3), publisher, publisher2, publisher3);
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048922, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? window(j2, timeUnit, scheduler, Long.MAX_VALUE, false) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65656, null, publisher, publisher2, publisher3, publisher4, function4)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            return zipArray(Functions.toFunction(function4), false, bufferSize(), publisher, publisher2, publisher3, publisher4);
        }
        return (Flowable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048923, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Long.valueOf(j3)})) == null) ? window(j2, timeUnit, scheduler, j3, false) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <R> Flowable<R> withLatestFrom(Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048937, this, publisherArr, function)) == null) {
            ObjectHelper.requireNonNull(publisherArr, "others is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, publisherArr, function));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048782, this, new Object[]{function, Long.valueOf(j2), timeUnit})) == null) ? replay(function, j2, timeUnit, Schedulers.computation()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048924, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? window(j2, timeUnit, scheduler, j3, z, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65607, null, new Object[]{t, t2, t3, t4, t5, t6})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            return fromArray(t, t2, t3, t4, t5, t6);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048695, this, function, biFunction)) == null) ? flatMap(function, biFunction, false, bufferSize(), bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048783, this, new Object[]{function, Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this, j2, timeUnit, scheduler), function);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<Flowable<T>> window(long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048925, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler, Long.valueOf(j3), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.verifyPositive(j3, "count");
            return RxJavaPlugins.onAssembly(new FlowableWindowTimed(this, j2, j2, timeUnit, scheduler, j3, i2, z));
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65546, null, publisher, publisher2, publisher3, publisher4, function4)) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            return combineLatest(Functions.toFunction(function4), publisher, publisher2, publisher3, publisher4);
        }
        return (Flowable) invokeLLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final Flowable<List<T>> buffer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) ? (Flowable<List<T>>) buffer(j2, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048697, this, function, biFunction, z)) == null) ? flatMap(function, biFunction, z, bufferSize(), bufferSize()) : (Flowable) invokeLLZ.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    public final <R> Flowable<R> withLatestFrom(Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048932, this, iterable, function)) == null) {
            ObjectHelper.requireNonNull(iterable, "others is null");
            ObjectHelper.requireNonNull(function, "combiner is null");
            return RxJavaPlugins.onAssembly(new FlowableWithLatestFromMany(this, iterable, function));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <TOpening, TClosing> Flowable<List<T>> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, flowable, function)) == null) ? (Flowable<List<T>>) buffer(flowable, function, ArrayListSupplier.asCallable()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{function, biFunction, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? flatMap(function, biFunction, z, i2, bufferSize()) : (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65657, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, function5})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            return zipArray(Functions.toFunction(function5), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function, Callable<U> callable) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, flowable, function, callable)) == null) {
            ObjectHelper.requireNonNull(flowable, "openingIndicator is null");
            ObjectHelper.requireNonNull(function, "closingIndicator is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableBufferBoundary(this, flowable, function, callable));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048699, this, new Object[]{function, biFunction, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.requireNonNull(biFunction, "combiner is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, "bufferSize");
            return flatMap(FlowableInternalHelper.flatMapWithCombiner(function, biFunction), z, i2, i3);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048784, this, function, scheduler)) == null) {
            ObjectHelper.requireNonNull(function, "selector is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return FlowableReplay.multicastSelector(FlowableInternalHelper.replayCallable(this), FlowableInternalHelper.replayFunction(function, scheduler));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048928, this, publisher)) == null) ? window(publisher, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, function5})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            return combineLatest(Functions.toFunction(function5), publisher, publisher2, publisher3, publisher4, publisher5);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048929, this, publisher, i2)) == null) {
            ObjectHelper.requireNonNull(publisher, "boundaryIndicator is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableWindowBoundary(this, publisher, i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65608, null, new Object[]{t, t2, t3, t4, t5, t6, t7})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            ObjectHelper.requireNonNull(t7, "The seventh item is null");
            return fromArray(t, t2, t3, t4, t5, t6, t7);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, publisher)) == null) ? (Flowable<List<T>>) buffer(publisher, ArrayListSupplier.asCallable()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048614, this, publisher, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "initialCapacity");
            return (Flowable<List<T>>) buffer(publisher, Functions.createArrayList(i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048696, this, function, biFunction, i2)) == null) ? flatMap(function, biFunction, false, i2, bufferSize()) : (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65658, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, function6})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            return zipArray(Functions.toFunction(function6), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048786, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return FlowableReplay.create(this, i2);
        }
        return (ConnectableFlowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048930, this, publisher, function)) == null) ? window(publisher, function, bufferSize()) : (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Publisher<B> publisher, Callable<U> callable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, publisher, callable)) == null) {
            ObjectHelper.requireNonNull(publisher, "boundaryIndicator is null");
            ObjectHelper.requireNonNull(callable, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableBufferExactBoundary(this, publisher, callable));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048931, this, publisher, function, i2)) == null) {
            ObjectHelper.requireNonNull(publisher, "openingIndicator is null");
            ObjectHelper.requireNonNull(function, "closingIndicator is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySelector(this, publisher, function, i2));
        }
        return (Flowable) invokeLLI.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i2, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048787, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit})) == null) ? replay(i2, j2, timeUnit, Schedulers.computation()) : (ConnectableFlowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, function6})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            return combineLatest(Functions.toFunction(function6), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048788, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.verifyPositive(i2, "bufferSize");
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return FlowableReplay.create(this, j2, timeUnit, scheduler, i2);
        }
        return (ConnectableFlowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<List<T>> buffer(Callable<? extends Publisher<B>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, callable)) == null) ? (Flowable<List<T>>) buffer(callable, ArrayListSupplier.asCallable()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, callable, callable2)) == null) {
            ObjectHelper.requireNonNull(callable, "boundaryIndicatorSupplier is null");
            ObjectHelper.requireNonNull(callable2, "bufferSupplier is null");
            return RxJavaPlugins.onAssembly(new FlowableBufferBoundarySupplier(this, callable, callable2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048926, this, callable)) == null) ? window(callable, bufferSize()) : (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, null, new Object[]{t, t2, t3, t4, t5, t6, t7, t8})) == null) {
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
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.ERROR)
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048927, this, callable, i2)) == null) {
            ObjectHelper.requireNonNull(callable, "boundaryIndicatorSupplier is null");
            ObjectHelper.verifyPositive(i2, "bufferSize");
            return RxJavaPlugins.onAssembly(new FlowableWindowBoundarySupplier(this, callable, i2));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65659, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, function7})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            ObjectHelper.requireNonNull(publisher7, "source7 is null");
            return zipArray(Functions.toFunction(function7), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(int i2, Scheduler scheduler) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048789, this, i2, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return FlowableReplay.observeOn(replay(i2), scheduler);
        }
        return (ConnectableFlowable) invokeIL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, function7})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            ObjectHelper.requireNonNull(publisher7, "source7 is null");
            return combineLatest(Functions.toFunction(function7), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long j2, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048790, this, j2, timeUnit)) == null) ? replay(j2, timeUnit, Schedulers.computation()) : (ConnectableFlowable) invokeJL.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048791, this, new Object[]{Long.valueOf(j2), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return FlowableReplay.create(this, j2, timeUnit, scheduler);
        }
        return (ConnectableFlowable) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final ConnectableFlowable<T> replay(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048792, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return FlowableReplay.observeOn(replay(), scheduler);
        }
        return (ConnectableFlowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65610, null, new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9})) == null) {
            ObjectHelper.requireNonNull(t, "The first item is null");
            ObjectHelper.requireNonNull(t2, "The second item is null");
            ObjectHelper.requireNonNull(t3, "The third item is null");
            ObjectHelper.requireNonNull(t4, "The fourth item is null");
            ObjectHelper.requireNonNull(t5, "The fifth item is null");
            ObjectHelper.requireNonNull(t6, "The sixth item is null");
            ObjectHelper.requireNonNull(t7, "The seventh item is null");
            ObjectHelper.requireNonNull(t8, "The eighth item is null");
            ObjectHelper.requireNonNull(t9, "The ninth is null");
            return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65660, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, function8})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            ObjectHelper.requireNonNull(publisher7, "source7 is null");
            ObjectHelper.requireNonNull(publisher8, "source8 is null");
            return zipArray(Functions.toFunction(function8), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, function8})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            ObjectHelper.requireNonNull(publisher7, "source7 is null");
            ObjectHelper.requireNonNull(publisher8, "source8 is null");
            return combineLatest(Functions.toFunction(function8), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65661, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9, function9})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            ObjectHelper.requireNonNull(publisher7, "source7 is null");
            ObjectHelper.requireNonNull(publisher8, "source8 is null");
            ObjectHelper.requireNonNull(publisher9, "source9 is null");
            return zipArray(Functions.toFunction(function9), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
        }
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65611, null, new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9, t10})) == null) {
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
        return (Flowable) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9, function9})) == null) {
            ObjectHelper.requireNonNull(publisher, "source1 is null");
            ObjectHelper.requireNonNull(publisher2, "source2 is null");
            ObjectHelper.requireNonNull(publisher3, "source3 is null");
            ObjectHelper.requireNonNull(publisher4, "source4 is null");
            ObjectHelper.requireNonNull(publisher5, "source5 is null");
            ObjectHelper.requireNonNull(publisher6, "source6 is null");
            ObjectHelper.requireNonNull(publisher7, "source7 is null");
            ObjectHelper.requireNonNull(publisher8, "source8 is null");
            ObjectHelper.requireNonNull(publisher9, "source9 is null");
            return combineLatest(Functions.toFunction(function9), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
        }
        return (Flowable) invokeCommon.objValue;
    }
}
