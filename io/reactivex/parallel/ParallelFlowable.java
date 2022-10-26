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
import io.reactivex.annotations.CheckReturnValue;
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
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public abstract class ParallelFlowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract int parallelism();

    public abstract void subscribe(Subscriber[] subscriberArr);

    public ParallelFlowable() {
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
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable sequential() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return sequential(Flowable.bufferSize());
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable sequentialDelayError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return sequentialDelayError(Flowable.bufferSize());
        }
        return (Flowable) invokeV.objValue;
    }

    @CheckReturnValue
    public static ParallelFlowable from(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, publisher)) == null) {
            return from(publisher, Runtime.getRuntime().availableProcessors(), Flowable.bufferSize());
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public static ParallelFlowable fromArray(Publisher... publisherArr) {
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
    public final Object as(ParallelFlowableConverter parallelFlowableConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parallelFlowableConverter)) == null) {
            return ((ParallelFlowableConverter) ObjectHelper.requireNonNull(parallelFlowableConverter, "converter is null")).apply(this);
        }
        return invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable compose(ParallelTransformer parallelTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parallelTransformer)) == null) {
            return RxJavaPlugins.onAssembly(((ParallelTransformer) ObjectHelper.requireNonNull(parallelTransformer, "composer is null")).apply(this));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable concatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, function)) == null) {
            return concatMap(function, 2);
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable filter(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate");
            return RxJavaPlugins.onAssembly(new ParallelFilter(this, predicate));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable flatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, function)) == null) {
            return flatMap(function, false, Integer.MAX_VALUE, Flowable.bufferSize());
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable map(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper");
            return RxJavaPlugins.onAssembly(new ParallelMap(this, function));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final Flowable reduce(BiFunction biFunction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, biFunction)) == null) {
            ObjectHelper.requireNonNull(biFunction, "reducer");
            return RxJavaPlugins.onAssembly(new ParallelReduceFull(this, biFunction));
        }
        return (Flowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable runOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, scheduler)) == null) {
            return runOn(scheduler, Flowable.bufferSize());
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable sequential(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelJoin(this, i, false));
        }
        return (Flowable) invokeI.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable sequentialDelayError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelJoin(this, i, true));
        }
        return (Flowable) invokeI.objValue;
    }

    @CheckReturnValue
    public final Flowable sorted(Comparator comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, comparator)) == null) {
            return sorted(comparator, 16);
        }
        return (Flowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final Object to(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, function)) == null) {
            try {
                return ((Function) ObjectHelper.requireNonNull(function, "converter is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return invokeL.objValue;
    }

    @CheckReturnValue
    public final Flowable toSortedList(Comparator comparator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, comparator)) == null) {
            return toSortedList(comparator, 16);
        }
        return (Flowable) invokeL.objValue;
    }

    @CheckReturnValue
    public static ParallelFlowable from(Publisher publisher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, publisher, i)) == null) {
            return from(publisher, i, Flowable.bufferSize());
        }
        return (ParallelFlowable) invokeLI.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable collect(Callable callable, BiConsumer biConsumer) {
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
    public final ParallelFlowable concatMap(Function function, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, function, i)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, function, i, ErrorMode.IMMEDIATE));
        }
        return (ParallelFlowable) invokeLI.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable concatMapDelayError(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, function, z)) == null) {
            return concatMapDelayError(function, 2, z);
        }
        return (ParallelFlowable) invokeLZ.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable doOnNext(Consumer consumer, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, consumer, biFunction)) == null) {
            ObjectHelper.requireNonNull(consumer, "onNext is null");
            ObjectHelper.requireNonNull(biFunction, "errorHandler is null");
            return RxJavaPlugins.onAssembly(new ParallelDoOnNextTry(this, consumer, biFunction));
        }
        return (ParallelFlowable) invokeLL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable filter(Predicate predicate, BiFunction biFunction) {
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
    public final ParallelFlowable flatMap(Function function, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, function, z)) == null) {
            return flatMap(function, z, Integer.MAX_VALUE, Flowable.bufferSize());
        }
        return (ParallelFlowable) invokeLZ.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable map(Function function, BiFunction biFunction) {
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
    public final ParallelFlowable reduce(Callable callable, BiFunction biFunction) {
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
    public final ParallelFlowable runOn(Scheduler scheduler, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048607, this, scheduler, i)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelRunOn(this, scheduler, i));
        }
        return (ParallelFlowable) invokeLI.objValue;
    }

    @CheckReturnValue
    public static ParallelFlowable from(Publisher publisher, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, publisher, i, i2)) == null) {
            ObjectHelper.requireNonNull(publisher, "source");
            ObjectHelper.verifyPositive(i, "parallelism");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelFromPublisher(publisher, i, i2));
        }
        return (ParallelFlowable) invokeLII.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable concatMapDelayError(Function function, int i, boolean z) {
        InterceptResult invokeCommon;
        ErrorMode errorMode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{function, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, PrefetchEvent.MODULE);
            if (z) {
                errorMode = ErrorMode.END;
            } else {
                errorMode = ErrorMode.BOUNDARY;
            }
            return RxJavaPlugins.onAssembly(new ParallelConcatMap(this, function, i, errorMode));
        }
        return (ParallelFlowable) invokeCommon.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable flatMap(Function function, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return flatMap(function, z, i, Flowable.bufferSize());
        }
        return (ParallelFlowable) invokeCommon.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable doAfterNext(Consumer consumer) {
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
    public final ParallelFlowable doAfterTerminated(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.EMPTY_ACTION, action, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable doOnCancel(Action action) {
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
    public final ParallelFlowable doOnComplete(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onComplete is null");
            return RxJavaPlugins.onAssembly(new ParallelPeek(this, Functions.emptyConsumer(), Functions.emptyConsumer(), Functions.emptyConsumer(), action, Functions.EMPTY_ACTION, Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION));
        }
        return (ParallelFlowable) invokeL.objValue;
    }

    @CheckReturnValue
    public final ParallelFlowable doOnError(Consumer consumer) {
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
    public final ParallelFlowable doOnNext(Consumer consumer) {
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
    public final ParallelFlowable doOnRequest(LongConsumer longConsumer) {
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
    public final ParallelFlowable doOnSubscribe(Consumer consumer) {
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
    public final ParallelFlowable doOnNext(Consumer consumer, ParallelFailureHandling parallelFailureHandling) {
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
    public final ParallelFlowable filter(Predicate predicate, ParallelFailureHandling parallelFailureHandling) {
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
    public final ParallelFlowable map(Function function, ParallelFailureHandling parallelFailureHandling) {
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
    public final ParallelFlowable flatMap(Function function, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            ObjectHelper.verifyPositive(i, "maxConcurrency");
            ObjectHelper.verifyPositive(i2, PrefetchEvent.MODULE);
            return RxJavaPlugins.onAssembly(new ParallelFlatMap(this, function, z, i, i2));
        }
        return (ParallelFlowable) invokeCommon.objValue;
    }

    @CheckReturnValue
    public final Flowable sorted(Comparator comparator, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048613, this, comparator, i)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            ObjectHelper.verifyPositive(i, "capacityHint");
            return RxJavaPlugins.onAssembly(new ParallelSortedJoin(reduce(Functions.createArrayList((i / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)), comparator));
        }
        return (Flowable) invokeLI.objValue;
    }

    @CheckReturnValue
    public final Flowable toSortedList(Comparator comparator, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048617, this, comparator, i)) == null) {
            ObjectHelper.requireNonNull(comparator, "comparator is null");
            ObjectHelper.verifyPositive(i, "capacityHint");
            return RxJavaPlugins.onAssembly(reduce(Functions.createArrayList((i / parallelism()) + 1), ListAddBiConsumer.instance()).map(new SorterFunction(comparator)).reduce(new MergerBiFunction(comparator)));
        }
        return (Flowable) invokeLI.objValue;
    }

    public final boolean validate(Subscriber[] subscriberArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, subscriberArr)) == null) {
            int parallelism = parallelism();
            if (subscriberArr.length != parallelism) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + parallelism + ", subscribers = " + subscriberArr.length);
                for (Subscriber subscriber : subscriberArr) {
                    EmptySubscription.error(illegalArgumentException, subscriber);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
