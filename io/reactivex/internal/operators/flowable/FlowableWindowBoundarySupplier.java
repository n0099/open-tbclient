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
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacityHint;
    public final Callable<? extends Publisher<B>> other;

    /* loaded from: classes8.dex */
    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean done;
        public final WindowBoundaryMainSubscriber<T, B> parent;

        public WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowBoundaryMainSubscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b) == null) || this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.parent.innerNext(this);
        }
    }

    /* loaded from: classes8.dex */
    public static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final WindowBoundaryInnerSubscriber<Object, Object> BOUNDARY_DISPOSED;
        public static final Object NEXT_WINDOW;
        public static final long serialVersionUID = 2233020065421370272L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<WindowBoundaryInnerSubscriber<T, B>> boundarySubscriber;
        public final int capacityHint;
        public volatile boolean done;
        public final Subscriber<? super Flowable<T>> downstream;
        public long emitted;
        public final AtomicThrowable errors;
        public final Callable<? extends Publisher<B>> other;
        public final MpscLinkedQueue<Object> queue;
        public final AtomicLong requested;
        public final AtomicBoolean stopWindows;
        public Subscription upstream;
        public UnicastProcessor<T> window;
        public final AtomicInteger windows;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1485080148, "Lio/reactivex/internal/operators/flowable/FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1485080148, "Lio/reactivex/internal/operators/flowable/FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber;");
                    return;
                }
            }
            BOUNDARY_DISPOSED = new WindowBoundaryInnerSubscriber<>(null);
            NEXT_WINDOW = new Object();
        }

        public WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i, Callable<? extends Publisher<B>> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i), callable};
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
            this.capacityHint = i;
            this.boundarySubscriber = new AtomicReference<>();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue<>();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.other = callable;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$WindowBoundaryInnerSubscriber<T, B>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeBoundary() {
            Disposable disposable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (disposable = (Disposable) this.boundarySubscriber.getAndSet(BOUNDARY_DISPOSED)) == null || disposable == BOUNDARY_DISPOSED) {
                return;
            }
            disposable.dispose();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: io.reactivex.processors.UnicastProcessor<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.downstream;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                long j = this.emitted;
                int i = 1;
                while (this.windows.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.window;
                    boolean z = this.done;
                    if (z && atomicThrowable.get() != null) {
                        mpscLinkedQueue.clear();
                        Throwable terminate = atomicThrowable.terminate();
                        if (unicastProcessor != 0) {
                            this.window = null;
                            unicastProcessor.onError(terminate);
                        }
                        subscriber.onError(terminate);
                        return;
                    }
                    Object poll = mpscLinkedQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (terminate2 == null) {
                            if (unicastProcessor != 0) {
                                this.window = null;
                                unicastProcessor.onComplete();
                            }
                            subscriber.onComplete();
                            return;
                        }
                        if (unicastProcessor != 0) {
                            this.window = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    } else if (z2) {
                        this.emitted = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll != NEXT_WINDOW) {
                        unicastProcessor.onNext(poll);
                    } else {
                        if (unicastProcessor != 0) {
                            this.window = null;
                            unicastProcessor.onComplete();
                        }
                        if (!this.stopWindows.get()) {
                            if (j != this.requested.get()) {
                                UnicastProcessor<T> create = UnicastProcessor.create(this.capacityHint, this);
                                this.window = create;
                                this.windows.getAndIncrement();
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.other.call(), "The other Callable returned a null Publisher");
                                    WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber<>(this);
                                    if (this.boundarySubscriber.compareAndSet(null, windowBoundaryInnerSubscriber)) {
                                        publisher.subscribe(windowBoundaryInnerSubscriber);
                                        j++;
                                        subscriber.onNext(create);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    atomicThrowable.addThrowable(th);
                                    this.done = true;
                                }
                            } else {
                                this.upstream.cancel();
                                disposeBoundary();
                                atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                this.done = true;
                            }
                        }
                    }
                }
                mpscLinkedQueue.clear();
                this.window = null;
            }
        }

        public void innerComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.upstream.cancel();
                this.done = true;
                drain();
            }
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.upstream.cancel();
                if (this.errors.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerNext(WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, windowBoundaryInnerSubscriber) == null) {
                this.boundarySubscriber.compareAndSet(windowBoundaryInnerSubscriber, null);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                disposeBoundary();
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                disposeBoundary();
                if (this.errors.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, subscription) == null) && SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
                BackpressureHelper.add(this.requested, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.windows.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int i) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, callable, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.other = callable;
        this.capacityHint = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            this.source.subscribe((FlowableSubscriber) new WindowBoundaryMainSubscriber(subscriber, this.capacityHint, this.other));
        }
    }
}
