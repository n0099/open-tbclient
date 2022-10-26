package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableInternalHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public final class BufferedReplayCallable implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final Flowable parent;

        public BufferedReplayCallable(Flowable flowable, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowable, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = flowable;
            this.bufferSize = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay(this.bufferSize);
            }
            return (ConnectableFlowable) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class BufferedTimedReplay implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final Flowable parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public BufferedTimedReplay(Flowable flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowable, Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = flowable;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
            }
            return (ConnectableFlowable) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class FlatMapIntoIterable implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function mapper;

        public FlatMapIntoIterable(Function function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mapper = function;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Function
        public Publisher apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Iterable"));
            }
            return (Publisher) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class FlatMapWithCombinerInner implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiFunction combiner;
        public final Object t;

        public FlatMapWithCombinerInner(BiFunction biFunction, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biFunction, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.combiner = biFunction;
            this.t = obj;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return this.combiner.apply(this.t, obj);
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class FlatMapWithCombinerOuter implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiFunction combiner;
        public final Function mapper;

        public FlatMapWithCombinerOuter(BiFunction biFunction, Function function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biFunction, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.combiner = biFunction;
            this.mapper = function;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Function
        public Publisher apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return new FlowableMapPublisher((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.combiner, obj));
            }
            return (Publisher) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ItemDelayFunction implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function itemDelay;

        public ItemDelayFunction(Function function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.itemDelay = function;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Function
        public Publisher apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return new FlowableTakePublisher((Publisher) ObjectHelper.requireNonNull(this.itemDelay.apply(obj), "The itemDelay returned a null Publisher"), 1L).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
            }
            return (Publisher) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ReplayCallable implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Flowable parent;

        public ReplayCallable(Flowable flowable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = flowable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay();
            }
            return (ConnectableFlowable) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ReplayFunction implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Scheduler scheduler;
        public final Function selector;

        public ReplayFunction(Function function, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.selector = function;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Function
        public Publisher apply(Flowable flowable) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flowable)) == null) {
                return Flowable.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.selector.apply(flowable), "The selector returned a null Publisher")).observeOn(this.scheduler);
            }
            return (Publisher) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class RequestMax implements Consumer {
        public static final /* synthetic */ RequestMax[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RequestMax INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1544453993, "Lio/reactivex/internal/operators/flowable/FlowableInternalHelper$RequestMax;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1544453993, "Lio/reactivex/internal/operators/flowable/FlowableInternalHelper$RequestMax;");
                    return;
                }
            }
            RequestMax requestMax = new RequestMax("INSTANCE", 0);
            INSTANCE = requestMax;
            $VALUES = new RequestMax[]{requestMax};
        }

        public static RequestMax[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RequestMax[]) $VALUES.clone();
            }
            return (RequestMax[]) invokeV.objValue;
        }

        public RequestMax(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RequestMax valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RequestMax) Enum.valueOf(RequestMax.class, str);
            }
            return (RequestMax) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subscription) == null) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class SimpleBiGenerator implements BiFunction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiConsumer consumer;

        public SimpleBiGenerator(BiConsumer biConsumer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biConsumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.consumer = biConsumer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Emitter emitter) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, emitter)) == null) {
                this.consumer.accept(obj, emitter);
                return obj;
            }
            return invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class SimpleGenerator implements BiFunction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Consumer consumer;

        public SimpleGenerator(Consumer consumer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.consumer = consumer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.BiFunction
        public Object apply(Object obj, Emitter emitter) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, emitter)) == null) {
                this.consumer.accept(emitter);
                return obj;
            }
            return invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class SubscriberOnComplete implements Action {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber subscriber;

        public SubscriberOnComplete(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = subscriber;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.subscriber.onComplete();
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class SubscriberOnError implements Consumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber subscriber;

        public SubscriberOnError(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = subscriber;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.subscriber.onError(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class SubscriberOnNext implements Consumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber subscriber;

        public SubscriberOnNext(Subscriber subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriber = subscriber;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.subscriber.onNext(obj);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class TimedReplay implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Flowable parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public TimedReplay(Flowable flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowable, Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = flowable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableFlowable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay(this.time, this.unit, this.scheduler);
            }
            return (ConnectableFlowable) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ZipIterableFunction implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function zipper;

        public ZipIterableFunction(Function function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.zipper = function;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Function
        public Publisher apply(List list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                return Flowable.zipIterable(list, this.zipper, false, Flowable.bufferSize());
            }
            return (Publisher) invokeL.objValue;
        }
    }

    public FlowableInternalHelper() {
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

    public static Function flatMapIntoIterable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, function)) == null) {
            return new FlatMapIntoIterable(function);
        }
        return (Function) invokeL.objValue;
    }

    public static Function itemDelay(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, function)) == null) {
            return new ItemDelayFunction(function);
        }
        return (Function) invokeL.objValue;
    }

    public static Callable replayCallable(Flowable flowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, flowable)) == null) {
            return new ReplayCallable(flowable);
        }
        return (Callable) invokeL.objValue;
    }

    public static BiFunction simpleBiGenerator(BiConsumer biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, biConsumer)) == null) {
            return new SimpleBiGenerator(biConsumer);
        }
        return (BiFunction) invokeL.objValue;
    }

    public static BiFunction simpleGenerator(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, consumer)) == null) {
            return new SimpleGenerator(consumer);
        }
        return (BiFunction) invokeL.objValue;
    }

    public static Action subscriberOnComplete(Subscriber subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, subscriber)) == null) {
            return new SubscriberOnComplete(subscriber);
        }
        return (Action) invokeL.objValue;
    }

    public static Consumer subscriberOnError(Subscriber subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, subscriber)) == null) {
            return new SubscriberOnError(subscriber);
        }
        return (Consumer) invokeL.objValue;
    }

    public static Consumer subscriberOnNext(Subscriber subscriber) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, subscriber)) == null) {
            return new SubscriberOnNext(subscriber);
        }
        return (Consumer) invokeL.objValue;
    }

    public static Function zipIterable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, function)) == null) {
            return new ZipIterableFunction(function);
        }
        return (Function) invokeL.objValue;
    }

    public static Function flatMapWithCombiner(Function function, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, function, biFunction)) == null) {
            return new FlatMapWithCombinerOuter(biFunction, function);
        }
        return (Function) invokeLL.objValue;
    }

    public static Callable replayCallable(Flowable flowable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, flowable, i)) == null) {
            return new BufferedReplayCallable(flowable, i);
        }
        return (Callable) invokeLI.objValue;
    }

    public static Function replayFunction(Function function, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, function, scheduler)) == null) {
            return new ReplayFunction(function, scheduler);
        }
        return (Function) invokeLL.objValue;
    }

    public static Callable replayCallable(Flowable flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{flowable, Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new BufferedTimedReplay(flowable, i, j, timeUnit, scheduler);
        }
        return (Callable) invokeCommon.objValue;
    }

    public static Callable replayCallable(Flowable flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{flowable, Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new TimedReplay(flowable, j, timeUnit, scheduler);
        }
        return (Callable) invokeCommon.objValue;
    }
}
