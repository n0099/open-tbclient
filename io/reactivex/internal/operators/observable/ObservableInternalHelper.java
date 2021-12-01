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
/* loaded from: classes3.dex */
public final class ObservableInternalHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final Observable<T> parent;

        public BufferedReplayCallable(Observable<T> observable, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = observable;
            this.bufferSize = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.parent.replay(this.bufferSize) : (ConnectableObservable) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final Observable<T> parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public BufferedTimedReplayCallable(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = observable;
            this.bufferSize = i2;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler) : (ConnectableObservable) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function<? super T, ? extends Iterable<? extends U>> mapper;

        public FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mapper = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapIntoIterable<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<U> apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? new ObservableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Iterable")) : (ObservableSource) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiFunction<? super T, ? super U, ? extends R> combiner;
        public final T t;

        public FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biFunction, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.combiner = biFunction;
            this.t = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.functions.Function
        public R apply(U u) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u)) == null) ? this.combiner.apply((T) this.t, u) : (R) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiFunction<? super T, ? super U, ? extends R> combiner;
        public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

        public FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biFunction, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.combiner = biFunction;
            this.mapper = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((FlatMapWithCombinerOuter<T, R, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<R> apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? new ObservableMap((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.combiner, t)) : (ObservableSource) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function<? super T, ? extends ObservableSource<U>> itemDelay;

        public ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.itemDelay = function;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((ItemDelayFunction<T, U>) obj);
        }

        @Override // io.reactivex.functions.Function
        public ObservableSource<T> apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? new ObservableTake((ObservableSource) ObjectHelper.requireNonNull(this.itemDelay.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t) : (ObservableSource) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class MapToInt implements Function<Object, Object> {
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

        public MapToInt(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MapToInt) Enum.valueOf(MapToInt.class, str) : (MapToInt) invokeL.objValue;
        }

        public static MapToInt[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MapToInt[]) $VALUES.clone() : (MapToInt[]) invokeV.objValue;
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

    /* loaded from: classes3.dex */
    public static final class ObserverOnComplete<T> implements Action {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<T> observer;

        public ObserverOnComplete(Observer<T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public static final class ObserverOnError<T> implements Consumer<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<T> observer;

        public ObserverOnError(Observer<T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public static final class ObserverOnNext<T> implements Consumer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<T> observer;

        public ObserverOnNext(Observer<T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(T t) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.observer.onNext(t);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observable<T> parent;

        public ReplayCallable(Observable<T> observable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.parent.replay() : (ConnectableObservable) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Scheduler scheduler;
        public final Function<? super Observable<T>, ? extends ObservableSource<R>> selector;

        public ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.selector = function;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((Observable) ((Observable) obj));
        }

        public ObservableSource<R> apply(Observable<T> observable) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, observable)) == null) ? Observable.wrap((ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(observable), "The selector returned a null ObservableSource")).observeOn(this.scheduler) : (ObservableSource) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiConsumer<S, Emitter<T>> consumer;

        public SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {biConsumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.consumer = biConsumer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleBiGenerator<T, S>) obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, s, emitter)) == null) {
                this.consumer.accept(s, emitter);
                return s;
            }
            return (S) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Consumer<Emitter<T>> consumer;

        public SimpleGenerator(Consumer<Emitter<T>> consumer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.consumer = consumer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.BiFunction
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            return apply((SimpleGenerator<T, S>) obj, (Emitter) ((Emitter) obj2));
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, s, emitter)) == null) {
                this.consumer.accept(emitter);
                return s;
            }
            return (S) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observable<T> parent;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public TimedReplayCallable(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Long.valueOf(j2), timeUnit, scheduler};
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
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public ConnectableObservable<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.parent.replay(this.time, this.unit, this.scheduler) : (ConnectableObservable) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.zipper = function;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((List) ((List) obj));
        }

        public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) ? Observable.zipIterable(list, this.zipper, false, Observable.bufferSize()) : (ObservableSource) invokeL.objValue;
        }
    }

    public ObservableInternalHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, function)) == null) ? new FlatMapIntoIterable(function) : (Function) invokeL.objValue;
    }

    public static <T, U, R> Function<T, ObservableSource<R>> flatMapWithCombiner(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, function, biFunction)) == null) ? new FlatMapWithCombinerOuter(biFunction, function) : (Function) invokeLL.objValue;
    }

    public static <T, U> Function<T, ObservableSource<T>> itemDelay(Function<? super T, ? extends ObservableSource<U>> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, function)) == null) ? new ItemDelayFunction(function) : (Function) invokeL.objValue;
    }

    public static <T> Action observerOnComplete(Observer<T> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, observer)) == null) ? new ObserverOnComplete(observer) : (Action) invokeL.objValue;
    }

    public static <T> Consumer<Throwable> observerOnError(Observer<T> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, observer)) == null) ? new ObserverOnError(observer) : (Consumer) invokeL.objValue;
    }

    public static <T> Consumer<T> observerOnNext(Observer<T> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, observer)) == null) ? new ObserverOnNext(observer) : (Consumer) invokeL.objValue;
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, observable)) == null) ? new ReplayCallable(observable) : (Callable) invokeL.objValue;
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> replayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, function, scheduler)) == null) ? new ReplayFunction(function, scheduler) : (Function) invokeLL.objValue;
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, biConsumer)) == null) ? new SimpleBiGenerator(biConsumer) : (BiFunction) invokeL.objValue;
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, consumer)) == null) ? new SimpleGenerator(consumer) : (BiFunction) invokeL.objValue;
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, function)) == null) ? new ZipIterableFunction(function) : (Function) invokeL.objValue;
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, observable, i2)) == null) ? new BufferedReplayCallable(observable, i2) : (Callable) invokeLI.objValue;
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{observable, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, scheduler})) == null) ? new BufferedTimedReplayCallable(observable, i2, j2, timeUnit, scheduler) : (Callable) invokeCommon.objValue;
    }

    public static <T> Callable<ConnectableObservable<T>> replayCallable(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{observable, Long.valueOf(j2), timeUnit, scheduler})) == null) ? new TimedReplayCallable(observable, j2, timeUnit, scheduler) : (Callable) invokeCommon.objValue;
    }
}
