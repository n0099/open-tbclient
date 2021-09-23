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
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
/* loaded from: classes10.dex */
public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public final Flowable<T> source;

    /* loaded from: classes10.dex */
    public static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final SwitchMapMaybeObserver<Object> INNER_DISPOSED;
        public static final long serialVersionUID = -5402190102429853762L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final AtomicThrowable errors;
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public final AtomicLong requested;
        public Subscription upstream;

        /* loaded from: classes10.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8042919737683345351L;
            public transient /* synthetic */ FieldHolder $fh;
            public volatile R item;
            public final SwitchMapMaybeSubscriber<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {switchMapMaybeSubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = switchMapMaybeSubscriber;
            }

            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DisposableHelper.dispose(this);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.parent.innerComplete(this);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.parent.innerError(this, th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, r) == null) {
                    this.item = r;
                    this.parent.drain();
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-274982256, "Lio/reactivex/internal/operators/mixed/FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-274982256, "Lio/reactivex/internal/operators/mixed/FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber;");
                    return;
                }
            }
            INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
        }

        public SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeInner();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeInner() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (switchMapMaybeObserver = (SwitchMapMaybeObserver) this.inner.getAndSet(INNER_DISPOSED)) == null || switchMapMaybeObserver == INNER_DISPOSED) {
                return;
            }
            switchMapMaybeObserver.dispose();
        }

        /* JADX DEBUG: Type inference failed for r8v6. Raw type applied. Possible types: R, ? super R */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
                AtomicLong atomicLong = this.requested;
                long j2 = this.emitted;
                int i2 = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() != null && !this.delayErrors) {
                        subscriber.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z = this.done;
                    SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                    boolean z2 = switchMapMaybeObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (!z2 && switchMapMaybeObserver.item != null && j2 != atomicLong.get()) {
                        atomicReference.compareAndSet(switchMapMaybeObserver, null);
                        subscriber.onNext((R) switchMapMaybeObserver.item);
                        j2++;
                    } else {
                        this.emitted = j2;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        public void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, switchMapMaybeObserver) == null) && this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                drain();
            }
        }

        public void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, switchMapMaybeObserver, th) == null) {
                if (this.inner.compareAndSet(switchMapMaybeObserver, null) && this.errors.addThrowable(th)) {
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
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
                if (switchMapMaybeObserver2 != null) {
                    switchMapMaybeObserver2.dispose();
                }
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                    SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                    do {
                        switchMapMaybeObserver = this.inner.get();
                        if (switchMapMaybeObserver == INNER_DISPOSED) {
                            return;
                        }
                    } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                    maybeSource.subscribe(switchMapMaybeObserver3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    this.inner.getAndSet(INNER_DISPOSED);
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subscription) == null) && SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }
    }

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.source.subscribe((FlowableSubscriber) new SwitchMapMaybeSubscriber(subscriber, this.mapper, this.delayErrors));
        }
    }
}
