package io.reactivex.parallel;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.Beta;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.internal.operators.parallel.ParallelFilter;
import io.reactivex.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.internal.operators.parallel.ParallelFromArray;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelMap;
import io.reactivex.internal.operators.parallel.ParallelMapTry;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.internal.util.MergerBiFunction;
import io.reactivex.internal.util.SorterFunction;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Beta
/* loaded from: classes3.dex */
public abstract class ParallelFlowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ParallelFlowable() {
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

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, publisher)) == null) ? from(publisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize()) : (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> fromArray(@NonNull Publisher<T>... publisherArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, publisherArr)) == null) {
            if (publisherArr.length != 0) {
                return RxJavaPlugins.onAssembly(new ParallelFromArray(publisherArr));
            }
            throw new IllegalArgumentException("Zero publishers not supported");
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> R as(@NonNull ParallelFlowableConverter<T, R> parallelFlowableConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parallelFlowableConverter)) == null) ? (R) ((ParallelFlowableConverter) ObjectHelper.requireNonNull(parallelFlowableConverter, "converter is null")).apply(this) : (R) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <C> ParallelFlowable<C> collect(@NonNull Callable<? extends C> callable, @NonNull BiConsumer<? super C, ? super T> biConsumer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callable, biConsumer)) == null) {
            ObjectHelper.requireNonNull(callable, "collectionSupplier is null");
            ObjectHelper.requireNonNull(biConsumer, "collector is null");
            return RxJavaPlugins.onAssembly(new ParallelCollect(this, callable, biConsumer));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <U> ParallelFlowable<U> compose(@NonNull ParallelTransformer<T, U> parallelTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parallelTransformer)) == null) ? RxJavaPlugins.onAssembly(((ParallelTransformer) ObjectHelper.requireNonNull(parallelTransformer, "composer is null")).apply(this)) : (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, function)) == null) ? concatMap(function, 2) : (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, function, z)) == null) ? concatMapDelayError(function, 2, z) : (ParallelFlowable) invokeLZ.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doAfterNext(@NonNull Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onAfterNext is null");
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, consumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doAfterTerminated(@NonNull Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnCancel(@NonNull Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onCancel is null");
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Consumer emptyConsumer3 = Functions.emptyConsumer();
            Action action2 = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action2, action2, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnComplete(@NonNull Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onComplete is null");
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnError(@NonNull Consumer<Throwable> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onError is null");
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, consumer, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, consumer, emptyConsumer, emptyConsumer2, action, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnRequest(@NonNull LongConsumer longConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, longConsumer)) == null) {
            ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Consumer emptyConsumer3 = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, Functions.emptyConsumer(), longConsumer, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> doOnSubscribe(@NonNull Consumer<? super Subscription> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
            Consumer emptyConsumer = Functions.emptyConsumer();
            Consumer emptyConsumer2 = Functions.emptyConsumer();
            Consumer emptyConsumer3 = Functions.emptyConsumer();
            Action action = Functions.EMPTY_ACTION;
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, emptyConsumer, emptyConsumer2, emptyConsumer3, action, action, consumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate");
            return RxJavaPlugins.onAssembly(new ParallelFilter(this, predicate));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, function)) == null) ? flatMap(function, false, Integer.MAX_VALUE, Flowable.bufferSize()) : (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper");
            return RxJavaPlugins.onAssembly(new ParallelMap(this, function));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    public abstract int parallelism();

    @CheckReturnValue
    @NonNull
    public final Flowable<T> reduce(@NonNull BiFunction<T, T, T> biFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, biFunction)) == null) {
            ObjectHelper.requireNonNull(biFunction, "reducer");
            return RxJavaPlugins.onAssembly(new ParallelReduceFull(this, biFunction));
        }
        return (Flowable) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> runOn(@NonNull Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, scheduler)) == null) ? runOn(scheduler, Flowable.bufferSize()) : (ParallelFlowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable<T> sequential() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? sequential(Flowable.bufferSize()) : (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @Experimental
    @NonNull
    public final Flowable<T> sequentialDelayError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? sequentialDelayError(Flowable.bufferSize()) : (Flowable) invokeV.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(@NonNull Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, comparator)) == null) ? sorted(comparator, 16) : (Flowable) invokeL.objValue;
    }

    public abstract void subscribe(@NonNull Subscriber<? super T>[] subscriberArr);

    @CheckReturnValue
    @NonNull
    public final <U> U to(@NonNull Function<? super ParallelFlowable<T>, U> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, function)) == null) {
            try {
                return (U) ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return (U) invokeL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, comparator)) == null) ? toSortedList(comparator, 16) : (Flowable) invokeL.objValue;
    }

    public final boolean validate(@NonNull Subscriber<?>[] subscriberArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, subscriberArr)) == null) {
            int parallelism = parallelism();
            if (subscriberArr.length != parallelism) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + parallelism + ", subscribers = " + subscriberArr.length);
                for (Subscriber<?> subscriber : subscriberArr) {
                    EmptySubscription.error(illegalArgumentException, subscriber);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @CheckReturnValue
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> publisher, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, publisher, i2)) == null) ? from(publisher, i2, Flowable.bufferSize()) : (ParallelFlowable) invokeLI.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, function, i2)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
        }
        return (ParallelFlowable) invokeLI.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> concatMapDelayError(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{function, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        return (ParallelFlowable) invokeCommon.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, function, z)) == null) ? flatMap(function, z, Integer.MAX_VALUE, Flowable.bufferSize()) : (ParallelFlowable) invokeLZ.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final ParallelFlowable<T> runOn(@NonNull Scheduler scheduler, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, scheduler, i2)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelRunOn(this, scheduler, i2));
        }
        return (ParallelFlowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequential(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelJoin(this, i2, false));
        }
        return (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    @NonNull
    public final Flowable<T> sequentialDelayError(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelJoin(this, i2, true));
        }
        return (Flowable) invokeI.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<T> sorted(@NonNull Comparator<? super T> comparator, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048613, this, comparator, i2)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            ObjectHelper.verifyPositive(i2, "capacityHint");
            return RxJavaPlugins.onAssembly(new ParallelSortedJoin(reduce(Functions.createArrayList((i2 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)), comparator));
        }
        return (Flowable) invokeLI.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final Flowable<List<T>> toSortedList(@NonNull Comparator<? super T> comparator, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048617, this, comparator, i2)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            ObjectHelper.verifyPositive(i2, "capacityHint");
            return RxJavaPlugins.onAssembly(reduce(Functions.createArrayList((i2 / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)).reduce(new MergerBiFunction(comparator)));
        }
        return (Flowable) invokeLI.objValue;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> from(@NonNull Publisher<? extends T> publisher, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, publisher, i2, i3)) == null) {
            ObjectHelper.requireNonNull(publisher, "source");
            ObjectHelper.verifyPositive(i2, "parallelism");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelFromPublisher(publisher, i2, i3));
        }
        return (ParallelFlowable) invokeLII.objValue;
    }

    @CheckReturnValue
    @Experimental
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> predicate, @NonNull ParallelFailureHandling parallelFailureHandling) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, predicate, parallelFailureHandling)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate");
            ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, predicate, parallelFailureHandling));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? flatMap(function, z, i2, Flowable.bufferSize()) : (ParallelFlowable) invokeCommon.objValue;
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> function, @NonNull ParallelFailureHandling parallelFailureHandling) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, function, parallelFailureHandling)) == null) {
            ObjectHelper.requireNonNull(function, "mapper");
            ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelMapTry(this, function, parallelFailureHandling));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> reduce(@NonNull Callable<R> callable, @NonNull BiFunction<R, ? super T, R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, callable, biFunction)) == null) {
            ObjectHelper.requireNonNull(callable, "initialSupplier");
            ObjectHelper.requireNonNull(biFunction, "reducer");
            return RxJavaPlugins.onAssembly(new ParallelReduce(this, callable, biFunction));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @NonNull
    public final <R> ParallelFlowable<R> flatMap(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i2, "maxConcurrency");
            ObjectHelper.verifyPositive(i3, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelFlatMap(this, function, z, i2, i3));
        }
        return (ParallelFlowable) invokeCommon.objValue;
    }

    @CheckReturnValue
    @Experimental
    public final ParallelFlowable<T> filter(@NonNull Predicate<? super T> predicate, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, predicate, biFunction)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate");
            ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelFilterTry(this, predicate, biFunction));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final <R> ParallelFlowable<R> map(@NonNull Function<? super T, ? extends R> function, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, function, biFunction)) == null) {
            ObjectHelper.requireNonNull(function, "mapper");
            ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelMapTry(this, function, biFunction));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> consumer, @NonNull ParallelFailureHandling parallelFailureHandling) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, consumer, parallelFailureHandling)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(parallelFailureHandling, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, consumer, parallelFailureHandling));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    @Experimental
    @NonNull
    public final ParallelFlowable<T> doOnNext(@NonNull Consumer<? super T> consumer, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, consumer, biFunction)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, consumer, biFunction));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }
}
