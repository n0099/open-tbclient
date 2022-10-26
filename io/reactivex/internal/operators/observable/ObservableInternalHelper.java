package io.reactivex.internal.operators.observable;

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
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class ObservableInternalHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public final class BufferedReplayCallable implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final Observable parent;

        public BufferedReplayCallable(Observable observable, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = observable;
            this.bufferSize = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay(this.bufferSize);
            }
            return (ConnectableObservable) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class BufferedTimedReplayCallable implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final Observable parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public BufferedTimedReplayCallable(Observable observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = observable;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
            }
            return (ConnectableObservable) invokeV.objValue;
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
        public ObservableSource apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null Iterable"));
            }
            return (ObservableSource) invokeL.objValue;
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
        public ObservableSource apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, obj));
            }
            return (ObservableSource) invokeL.objValue;
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
        public ObservableSource apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(obj), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(obj)).defaultIfEmpty(obj);
            }
            return (ObservableSource) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class MapToInt implements Function {
        public static final /* synthetic */ MapToInt[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MapToInt INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-632536076, "Lio/reactivex/internal/operators/observable/ObservableInternalHelper$MapToInt;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-632536076, "Lio/reactivex/internal/operators/observable/ObservableInternalHelper$MapToInt;");
                    return;
                }
            }
            MapToInt mapToInt = new MapToInt("INSTANCE", 0);
            INSTANCE = mapToInt;
            $VALUES = new MapToInt[]{mapToInt};
        }

        public static MapToInt[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MapToInt[]) $VALUES.clone();
            }
            return (MapToInt[]) invokeV.objValue;
        }

        public MapToInt(String str, int i) {
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

        public static MapToInt valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MapToInt) Enum.valueOf(MapToInt.class, str);
            }
            return (MapToInt) invokeL.objValue;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return 0;
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ObserverOnComplete implements Action {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer observer;

        public ObserverOnComplete(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Action
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.observer.onComplete();
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ObserverOnError implements Consumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer observer;

        public ObserverOnError(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.observer.onError(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ObserverOnNext implements Consumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer observer;

        public ObserverOnNext(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.observer.onNext(obj);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ReplayCallable implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observable parent;

        public ReplayCallable(Observable observable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = observable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay();
            }
            return (ConnectableObservable) invokeV.objValue;
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
        public ObservableSource apply(Observable observable) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, observable)) == null) {
                return Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.scheduler);
            }
            return (ObservableSource) invokeL.objValue;
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
    public final class TimedReplayCallable implements Callable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observable parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public TimedReplayCallable(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = observable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.parent.replay(this.time, this.unit, this.scheduler);
            }
            return (ConnectableObservable) invokeV.objValue;
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
        public ObservableSource apply(List list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                return Observable.zipIterable(list, this.zipper, false, Observable.bufferSize());
            }
            return (ObservableSource) invokeL.objValue;
        }
    }

    public ObservableInternalHelper() {
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

    public static Action observerOnComplete(Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, observer)) == null) {
            return new ObserverOnComplete(observer);
        }
        return (Action) invokeL.objValue;
    }

    public static Consumer observerOnError(Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, observer)) == null) {
            return new ObserverOnError(observer);
        }
        return (Consumer) invokeL.objValue;
    }

    public static Consumer observerOnNext(Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, observer)) == null) {
            return new ObserverOnNext(observer);
        }
        return (Consumer) invokeL.objValue;
    }

    public static Callable replayCallable(Observable observable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, observable)) == null) {
            return new ReplayCallable(observable);
        }
        return (Callable) invokeL.objValue;
    }

    public static BiFunction simpleBiGenerator(BiConsumer biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, biConsumer)) == null) {
            return new SimpleBiGenerator(biConsumer);
        }
        return (BiFunction) invokeL.objValue;
    }

    public static BiFunction simpleGenerator(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, consumer)) == null) {
            return new SimpleGenerator(consumer);
        }
        return (BiFunction) invokeL.objValue;
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

    public static Callable replayCallable(Observable observable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, observable, i)) == null) {
            return new BufferedReplayCallable(observable, i);
        }
        return (Callable) invokeLI.objValue;
    }

    public static Function replayFunction(Function function, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, function, scheduler)) == null) {
            return new ReplayFunction(function, scheduler);
        }
        return (Function) invokeLL.objValue;
    }

    public static Callable replayCallable(Observable observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{observable, Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new BufferedTimedReplayCallable(observable, i, j, timeUnit, scheduler);
        }
        return (Callable) invokeCommon.objValue;
    }

    public static Callable replayCallable(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{observable, Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new TimedReplayCallable(observable, j, timeUnit, scheduler);
        }
        return (Callable) invokeCommon.objValue;
    }
}
