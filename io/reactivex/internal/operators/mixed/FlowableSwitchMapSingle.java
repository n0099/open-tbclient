package io.reactivex.internal.operators.mixed;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Experimental
/* loaded from: classes8.dex */
public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    public final Flowable<T> source;

    /* loaded from: classes8.dex */
    public static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final SwitchMapSingleObserver<Object> INNER_DISPOSED;
        public static final long serialVersionUID = -5402190102429853762L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final AtomicThrowable errors;
        public final AtomicReference<SwitchMapSingleObserver<R>> inner;
        public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        public final AtomicLong requested;
        public Subscription upstream;

        /* loaded from: classes8.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8042919737683345351L;
            public transient /* synthetic */ FieldHolder $fh;
            public volatile R item;
            public final SwitchMapSingleSubscriber<?, R> parent;

            public SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {switchMapSingleSubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = switchMapSingleSubscriber;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.parent.innerError(this, th);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                    this.item = r;
                    this.parent.drain();
                }
            }

            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DisposableHelper.dispose(this);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(849678712, "Lio/reactivex/internal/operators/mixed/FlowableSwitchMapSingle$SwitchMapSingleSubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(849678712, "Lio/reactivex/internal/operators/mixed/FlowableSwitchMapSingle$SwitchMapSingleSubscriber;");
                    return;
                }
            }
            INNER_DISPOSED = new SwitchMapSingleObserver<>(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeInner();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeInner() {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (switchMapSingleObserver = (SwitchMapSingleObserver) this.inner.getAndSet(INNER_DISPOSED)) != null && switchMapSingleObserver != INNER_DISPOSED) {
                switchMapSingleObserver.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.done = true;
                drain();
            }
        }

        public SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.downstream = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
            this.inner = new AtomicReference<>();
        }

        /* JADX DEBUG: Type inference failed for r8v6. Raw type applied. Possible types: R, ? super R */
        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j = this.emitted;
            int i = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    subscriber.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z2 = this.done;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                if (switchMapSingleObserver == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable terminate = atomicThrowable.terminate();
                    if (terminate != null) {
                        subscriber.onError(terminate);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else if (!z && switchMapSingleObserver.item != null && j != atomicLong.get()) {
                    atomicReference.compareAndSet(switchMapSingleObserver, null);
                    subscriber.onNext((R) switchMapSingleObserver.item);
                    j++;
                } else {
                    this.emitted = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, switchMapSingleObserver, th) == null) {
                if (this.inner.compareAndSet(switchMapSingleObserver, null) && this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.upstream.cancel();
                        disposeInner();
                    }
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        disposeInner();
                    }
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) && SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
                if (switchMapSingleObserver2 != null) {
                    switchMapSingleObserver2.dispose();
                }
                try {
                    SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                    SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                    do {
                        switchMapSingleObserver = this.inner.get();
                        if (switchMapSingleObserver == INNER_DISPOSED) {
                            return;
                        }
                    } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                    singleSource.subscribe(switchMapSingleObserver3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    this.inner.getAndSet(INNER_DISPOSED);
                    onError(th);
                }
            }
        }
    }

    public FlowableSwitchMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = flowable;
        this.mapper = function;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            this.source.subscribe((FlowableSubscriber) new SwitchMapSingleSubscriber(subscriber, this.mapper, this.delayErrors));
        }
    }
}
