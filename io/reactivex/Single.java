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
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
/* loaded from: classes8.dex */
public abstract class Single implements SingleSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void subscribeActual(SingleObserver singleObserver);

    public Single() {
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
    public static Single never() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return RxJavaPlugins.onAssembly(SingleNever.INSTANCE);
        }
        return (Single) invokeV.objValue;
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
    public final Single cache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return RxJavaPlugins.onAssembly(new SingleCache(this));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single hide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return RxJavaPlugins.onAssembly(new SingleHide(this));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single onTerminateDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return RxJavaPlugins.onAssembly(new SingleDetach(this));
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable repeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return toFlowable().repeat();
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single retry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return toSingle(toFlowable().retry());
        }
        return (Single) invokeV.objValue;
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING);
        }
        return (Disposable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver test() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            TestObserver testObserver = new TestObserver();
            subscribe(testObserver);
            return testObserver;
        }
        return (TestObserver) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable toCompletable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return RxJavaPlugins.onAssembly(new CompletableFromSingle(this));
        }
        return (Completable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable toFlowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (this instanceof FuseToFlowable) {
                return ((FuseToFlowable) this).fuseToFlowable();
            }
            return RxJavaPlugins.onAssembly(new SingleToFlowable(this));
        }
        return (Flowable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Future toFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return (Future) subscribeWith(new FutureSingleObserver());
        }
        return (Future) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe toMaybe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this instanceof FuseToMaybe) {
                return ((FuseToMaybe) this).fuseToMaybe();
            }
            return RxJavaPlugins.onAssembly(new MaybeFromSingle(this));
        }
        return (Maybe) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable toObservable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this instanceof FuseToObservable) {
                return ((FuseToObservable) this).fuseToObservable();
            }
            return RxJavaPlugins.onAssembly(new SingleToObservable(this));
        }
        return (Observable) invokeV.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single amb(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iterable)) == null) {
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new SingleAmb(null, iterable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, iterable)) == null) {
            return concat(Flowable.fromIterable(iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concatArray(SingleSource... singleSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, singleSourceArr)) == null) {
            return RxJavaPlugins.onAssembly(new FlowableConcatMap(Flowable.fromArray(singleSourceArr), SingleInternalHelper.toFlowable(), 2, ErrorMode.BOUNDARY));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single create(SingleOnSubscribe singleOnSubscribe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, singleOnSubscribe)) == null) {
            ObjectHelper.requireNonNull(singleOnSubscribe, "source is null");
            return RxJavaPlugins.onAssembly(new SingleCreate(singleOnSubscribe));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single defer(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "singleSupplier is null");
            return RxJavaPlugins.onAssembly(new SingleDefer(callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single error(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, th)) == null) {
            ObjectHelper.requireNonNull(th, "error is null");
            return error(Functions.justCallable(th));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single fromCallable(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "callable is null");
            return RxJavaPlugins.onAssembly(new SingleFromCallable(callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single fromFuture(Future future) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, future)) == null) {
            return toSingle(Flowable.fromFuture(future));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single fromObservable(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "observableSource is null");
            return RxJavaPlugins.onAssembly(new ObservableSingleSingle(observableSource, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Single fromPublisher(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "publisher is null");
            return RxJavaPlugins.onAssembly(new SingleFromPublisher(publisher));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single just(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "value is null");
            return RxJavaPlugins.onAssembly(new SingleJust(obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, iterable)) == null) {
            return merge(Flowable.fromIterable(iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, iterable)) == null) {
            return mergeDelayError(Flowable.fromIterable(iterable));
        }
        return (Flowable) invokeL.objValue;
    }

    public static Single toSingle(Flowable flowable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, flowable)) == null) {
            return RxJavaPlugins.onAssembly(new FlowableSingleSingle(flowable, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single unsafeCreate(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "onSubscribe is null");
            if (!(singleSource instanceof Single)) {
                return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(singleSource));
            }
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single wrap(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source is null");
            if (singleSource instanceof Single) {
                return RxJavaPlugins.onAssembly((Single) singleSource);
            }
            return RxJavaPlugins.onAssembly(new SingleFromUnsafeSource(singleSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single ambWith(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return ambArray(this, singleSource);
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Object as(SingleConverter singleConverter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, singleConverter)) == null) {
            return ((SingleConverter) ObjectHelper.requireNonNull(singleConverter, "converter is null")).apply(this);
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single cast(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            ObjectHelper.requireNonNull(cls, "clazz is null");
            return map(Functions.castFunction(cls));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single compose(SingleTransformer singleTransformer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, singleTransformer)) == null) {
            return wrap(((SingleTransformer) ObjectHelper.requireNonNull(singleTransformer, "transformer is null")).apply(this));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable concatWith(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, singleSource)) == null) {
            return concat(this, singleSource);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            return contains(obj, ObjectHelper.equalsPredicate());
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single delaySubscription(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(this, completableSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doAfterSuccess(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "doAfterSuccess is null");
            return RxJavaPlugins.onAssembly(new SingleDoAfterSuccess(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doAfterTerminate(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onAfterTerminate is null");
            return RxJavaPlugins.onAssembly(new SingleDoAfterTerminate(this, action));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doFinally(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onFinally is null");
            return RxJavaPlugins.onAssembly(new SingleDoFinally(this, action));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doOnDispose(Action action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, action)) == null) {
            ObjectHelper.requireNonNull(action, "onDispose is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnDispose(this, action));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doOnError(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onError is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnError(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doOnEvent(BiConsumer biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "onEvent is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnEvent(this, biConsumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doOnSubscribe(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSubscribe is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnSubscribe(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single doOnSuccess(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, consumer)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSuccess is null");
            return RxJavaPlugins.onAssembly(new SingleDoOnSuccess(this, consumer));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe filter(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, predicate)) == null) {
            ObjectHelper.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.onAssembly(new MaybeFilterSingle(this, predicate));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single flatMap(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMap(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable flatMapCompletable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapCompletable(this, function));
        }
        return (Completable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Maybe flatMapMaybe(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapMaybe(this, function));
        }
        return (Maybe) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flatMapObservable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, function)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, function)) == null) {
            return toFlowable().flatMap(function);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable flattenAsFlowable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapIterableFlowable(this, function));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable flattenAsObservable(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMapIterableObservable(this, function));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single lift(SingleOperator singleOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, singleOperator)) == null) {
            ObjectHelper.requireNonNull(singleOperator, "onLift is null");
            return RxJavaPlugins.onAssembly(new SingleLift(this, singleOperator));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single map(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "mapper is null");
            return RxJavaPlugins.onAssembly(new SingleMap(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable mergeWith(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, singleSource)) == null) {
            return merge(this, singleSource);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single observeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleObserveOn(this, scheduler));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single onErrorResumeNext(Single single) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, single)) == null) {
            ObjectHelper.requireNonNull(single, "resumeSingleInCaseOfError is null");
            return onErrorResumeNext(Functions.justFunction(single));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single onErrorReturn(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunction is null");
            return RxJavaPlugins.onAssembly(new SingleOnErrorReturn(this, function, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single onErrorReturnItem(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "value is null");
            return RxJavaPlugins.onAssembly(new SingleOnErrorReturn(this, null, obj));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Flowable repeat(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048622, this, j)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, booleanSupplier)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, function)) == null) {
            return toFlowable().repeatWhen(function);
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single retry(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048626, this, j)) == null) {
            return toSingle(toFlowable().retry(j));
        }
        return (Single) invokeJ.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single retryWhen(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, function)) == null) {
            return toSingle(toFlowable().retryWhen(function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(BiConsumer biConsumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, biConsumer)) == null) {
            ObjectHelper.requireNonNull(biConsumer, "onCallback is null");
            BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
            subscribe(biConsumerSingleObserver);
            return biConsumerSingleObserver;
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single subscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleSubscribeOn(this, scheduler));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final SingleObserver subscribeWith(SingleObserver singleObserver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, singleObserver)) == null) {
            subscribe(singleObserver);
            return singleObserver;
        }
        return (SingleObserver) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single takeUntil(CompletableSource completableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, completableSource)) == null) {
            ObjectHelper.requireNonNull(completableSource, "other is null");
            return takeUntil(new CompletableToFlowable(completableSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver test(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
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
    public final Object to(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, function)) == null) {
            try {
                return ((Function) ObjectHelper.requireNonNull(function, "convert is null")).apply(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        return invokeL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single unsubscribeOn(Scheduler scheduler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, scheduler)) == null) {
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleUnsubscribeOn(this, scheduler));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single ambArray(SingleSource... singleSourceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, singleSourceArr)) == null) {
            if (singleSourceArr.length == 0) {
                return error(SingleInternalHelper.emptyThrower());
            }
            if (singleSourceArr.length == 1) {
                return wrap(singleSourceArr[0]);
            }
            return RxJavaPlugins.onAssembly(new SingleAmb(singleSourceArr, null));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(SingleSource singleSource, SingleSource singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return concat(Flowable.fromArray(singleSource, singleSource2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single equals(SingleSource singleSource, SingleSource singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "first is null");
            ObjectHelper.requireNonNull(singleSource2, "second is null");
            return RxJavaPlugins.onAssembly(new SingleEquals(singleSource, singleSource2));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Single fromFuture(Future future, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, future, scheduler)) == null) {
            return toSingle(Flowable.fromFuture(future, scheduler));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(SingleSource singleSource, SingleSource singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return merge(Flowable.fromArray(singleSource, singleSource2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(SingleSource singleSource, SingleSource singleSource2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, singleSource, singleSource2)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return mergeDelayError(Flowable.fromArray(singleSource, singleSource2));
        }
        return (Flowable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Single timer(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65573, null, j, timeUnit)) == null) {
            return timer(j, timeUnit, Schedulers.computation());
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(Iterable iterable, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, iterable, function)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(iterable, "sources is null");
            return RxJavaPlugins.onAssembly(new SingleZipIterable(iterable, function));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single contains(Object obj, BiPredicate biPredicate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, biPredicate)) == null) {
            ObjectHelper.requireNonNull(obj, "value is null");
            ObjectHelper.requireNonNull(biPredicate, "comparer is null");
            return RxJavaPlugins.onAssembly(new SingleContains(this, obj, biPredicate));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single delay(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j, timeUnit)) == null) {
            return delay(j, timeUnit, Schedulers.computation(), false);
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single delaySubscription(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048589, this, j, timeUnit)) == null) {
            return delaySubscription(j, timeUnit, Schedulers.computation());
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single retry(long j, Predicate predicate) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048627, this, j, predicate)) == null) {
            return toSingle(toFlowable().retry(j, predicate));
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer, Consumer consumer2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, consumer, consumer2)) == null) {
            ObjectHelper.requireNonNull(consumer, "onSuccess is null");
            ObjectHelper.requireNonNull(consumer2, "onError is null");
            ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
            subscribe(consumerSingleObserver);
            return consumerSingleObserver;
        }
        return (Disposable) invokeLL.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single timeout(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048644, this, j, timeUnit)) == null) {
            return timeout0(j, timeUnit, Schedulers.computation(), null);
        }
        return (Single) invokeJL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single zipWith(SingleSource singleSource, BiFunction biFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048655, this, singleSource, biFunction)) == null) {
            return zip(this, singleSource, biFunction);
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, singleSource, singleSource2, singleSource3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return concat(Flowable.fromArray(singleSource, singleSource2, singleSource3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, singleSource, singleSource2, singleSource3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return merge(Flowable.fromArray(singleSource, singleSource2, singleSource3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, singleSource, singleSource2, singleSource3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return mergeDelayError(Flowable.fromArray(singleSource, singleSource2, singleSource3));
        }
        return (Flowable) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Single timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleTimer(j, timeUnit, scheduler));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single delay(long j, TimeUnit timeUnit, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), timeUnit, Boolean.valueOf(z)})) == null) {
            return delay(j, timeUnit, Schedulers.computation(), z);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Single timeout(long j, TimeUnit timeUnit, SingleSource singleSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Long.valueOf(j), timeUnit, singleSource})) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return timeout0(j, timeUnit, Schedulers.computation(), singleSource);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable concat(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, singleSource, singleSource2, singleSource3, singleSource4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return concat(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Single fromFuture(Future future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{future, Long.valueOf(j), timeUnit, scheduler})) == null) {
            return toSingle(Flowable.fromFuture(future, j, timeUnit, scheduler));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65562, null, singleSource, singleSource2, singleSource3, singleSource4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return merge(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65568, null, singleSource, singleSource2, singleSource3, singleSource4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return mergeDelayError(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
        }
        return (Flowable) invokeLLLL.objValue;
    }

    private Single timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource singleSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, singleSource})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleTimeout(this, j, timeUnit, scheduler, singleSource));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single using(Callable callable, Function function, Consumer consumer, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65578, null, new Object[]{callable, function, consumer, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(callable, "resourceSupplier is null");
            ObjectHelper.requireNonNull(function, "singleFunction is null");
            ObjectHelper.requireNonNull(consumer, "disposer is null");
            return RxJavaPlugins.onAssembly(new SingleUsing(callable, function, consumer, z));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, Function3 function3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65586, null, singleSource, singleSource2, singleSource3, function3)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            return zipArray(Functions.toFunction(function3), singleSource, singleSource2, singleSource3);
        }
        return (Single) invokeLLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single timeout(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource singleSource) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, singleSource})) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return timeout0(j, timeUnit, scheduler, singleSource);
        }
        return (Single) invokeCommon.objValue;
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
    @CheckReturnValue
    public static Single error(Callable callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, callable)) == null) {
            ObjectHelper.requireNonNull(callable, "errorSupplier is null");
            return RxJavaPlugins.onAssembly(new SingleError(callable));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable merge(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), false, Integer.MAX_VALUE, Flowable.bufferSize()));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Flowable mergeDelayError(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "sources is null");
            return RxJavaPlugins.onAssembly(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.toFlowable(), true, Integer.MAX_VALUE, Flowable.bufferSize()));
        }
        return (Flowable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single delaySubscription(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithObservable(this, observableSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single onErrorResumeNext(Function function) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, function)) == null) {
            ObjectHelper.requireNonNull(function, "resumeFunctionInCaseOfError is null");
            return RxJavaPlugins.onAssembly(new SingleResumeNext(this, function));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single retry(BiPredicate biPredicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, biPredicate)) == null) {
            return toSingle(toFlowable().retry(biPredicate));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Consumer consumer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, consumer)) == null) {
            return subscribe(consumer, Functions.ON_ERROR_MISSING);
        }
        return (Disposable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single takeUntil(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return takeUntil(new SingleToFlowable(singleSource));
        }
        return (Single) invokeL.objValue;
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
            return RxJavaPlugins.onAssembly(new FlowableConcatMapPublisher(publisher, SingleInternalHelper.toFlowable(), i, ErrorMode.IMMEDIATE));
        }
        return (Flowable) invokeLI.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Observable concat(ObservableSource observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, observableSource)) == null) {
            ObjectHelper.requireNonNull(observableSource, "sources is null");
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(observableSource, SingleInternalHelper.toObservable(), 2, ErrorMode.IMMEDIATE));
        }
        return (Observable) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single merge(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source is null");
            return RxJavaPlugins.onAssembly(new SingleFlatMap(singleSource, Functions.identity()));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single delaySubscription(SingleSource singleSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, singleSource)) == null) {
            ObjectHelper.requireNonNull(singleSource, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithSingle(this, singleSource));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Single retry(Predicate predicate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, predicate)) == null) {
            return toSingle(toFlowable().retry(predicate));
        }
        return (Single) invokeL.objValue;
    }

    @Override // io.reactivex.SingleSource
    @SchedulerSupport("none")
    public final void subscribe(SingleObserver singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, singleObserver) == null) {
            ObjectHelper.requireNonNull(singleObserver, "subscriber is null");
            SingleObserver onSubscribe = RxJavaPlugins.onSubscribe(this, singleObserver);
            ObjectHelper.requireNonNull(onSubscribe, "subscriber returned by the RxJavaPlugins hook is null");
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
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Single takeUntil(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new SingleTakeUntil(this, publisher));
        }
        return (Single) invokeL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single fromFuture(Future future, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{future, Long.valueOf(j), timeUnit})) == null) {
            return toSingle(Flowable.fromFuture(future, j, timeUnit));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single using(Callable callable, Function function, Consumer consumer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65577, null, callable, function, consumer)) == null) {
            return using(callable, function, consumer, true);
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, BiFunction biFunction) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65587, null, singleSource, singleSource2, biFunction)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            return zipArray(Functions.toFunction(biFunction), singleSource, singleSource2);
        }
        return (Single) invokeLLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return delay(j, timeUnit, scheduler, false);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return delaySubscription(Observable.timer(j, timeUnit, scheduler));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048645, this, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return timeout0(j, timeUnit, scheduler, null);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4, SingleSource singleSource5, SingleSource singleSource6, SingleSource singleSource7, SingleSource singleSource8, SingleSource singleSource9, Function9 function9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9, function9})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            ObjectHelper.requireNonNull(singleSource7, "source7 is null");
            ObjectHelper.requireNonNull(singleSource8, "source8 is null");
            ObjectHelper.requireNonNull(singleSource9, "source9 is null");
            return zipArray(Functions.toFunction(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4, SingleSource singleSource5, SingleSource singleSource6, SingleSource singleSource7, SingleSource singleSource8, Function8 function8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, function8})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            ObjectHelper.requireNonNull(singleSource7, "source7 is null");
            ObjectHelper.requireNonNull(singleSource8, "source8 is null");
            return zipArray(Functions.toFunction(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4, SingleSource singleSource5, SingleSource singleSource6, SingleSource singleSource7, Function7 function7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65582, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, function7})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            ObjectHelper.requireNonNull(singleSource7, "source7 is null");
            return zipArray(Functions.toFunction(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4, SingleSource singleSource5, SingleSource singleSource6, Function6 function6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, function6})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            ObjectHelper.requireNonNull(singleSource6, "source6 is null");
            return zipArray(Functions.toFunction(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4, SingleSource singleSource5, Function5 function5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65584, null, new Object[]{singleSource, singleSource2, singleSource3, singleSource4, singleSource5, function5})) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            ObjectHelper.requireNonNull(singleSource5, "source5 is null");
            return zipArray(Functions.toFunction(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zip(SingleSource singleSource, SingleSource singleSource2, SingleSource singleSource3, SingleSource singleSource4, Function4 function4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65585, null, singleSource, singleSource2, singleSource3, singleSource4, function4)) == null) {
            ObjectHelper.requireNonNull(singleSource, "source1 is null");
            ObjectHelper.requireNonNull(singleSource2, "source2 is null");
            ObjectHelper.requireNonNull(singleSource3, "source3 is null");
            ObjectHelper.requireNonNull(singleSource4, "source4 is null");
            return zipArray(Functions.toFunction(function4), singleSource, singleSource2, singleSource3, singleSource4);
        }
        return (Single) invokeLLLLL.objValue;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Single zipArray(Function function, SingleSource... singleSourceArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, function, singleSourceArr)) == null) {
            ObjectHelper.requireNonNull(function, "zipper is null");
            ObjectHelper.requireNonNull(singleSourceArr, "sources is null");
            if (singleSourceArr.length == 0) {
                return error(new NoSuchElementException());
            }
            return RxJavaPlugins.onAssembly(new SingleZipArray(singleSourceArr, function));
        }
        return (Single) invokeLL.objValue;
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Single delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(timeUnit, "unit is null");
            ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            return RxJavaPlugins.onAssembly(new SingleDelay(this, j, timeUnit, scheduler, z));
        }
        return (Single) invokeCommon.objValue;
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final Single delaySubscription(Publisher publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, publisher)) == null) {
            ObjectHelper.requireNonNull(publisher, "other is null");
            return RxJavaPlugins.onAssembly(new SingleDelayWithPublisher(this, publisher));
        }
        return (Single) invokeL.objValue;
    }
}
