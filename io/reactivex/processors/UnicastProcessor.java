package io.reactivex.processors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes2.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<Subscriber<? super T>> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public boolean enableOperatorFusion;
    public Throwable error;
    public final AtomicReference<Runnable> onTerminate;
    public final AtomicBoolean once;
    public final SpscLinkedArrayQueue<T> queue;
    public final AtomicLong requested;
    public final BasicIntQueueSubscription<T> wip;

    /* loaded from: classes2.dex */
    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4896760517184205454L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnicastProcessor this$0;

        public UnicastQueueSubscription(UnicastProcessor unicastProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {unicastProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.this$0.cancelled) {
                return;
            }
            this.this$0.cancelled = true;
            this.this$0.doTerminate();
            UnicastProcessor unicastProcessor = this.this$0;
            if (unicastProcessor.enableOperatorFusion || unicastProcessor.wip.getAndIncrement() != 0) {
                return;
            }
            this.this$0.queue.clear();
            this.this$0.actual.lazySet(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.queue.isEmpty() : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.queue.poll() : (T) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.this$0.requested, j2);
                this.this$0.drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                if ((i2 & 2) != 0) {
                    this.this$0.enableOperatorFusion = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnicastProcessor(int i2) {
        this(i2, null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Runnable) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new UnicastProcessor<>(Flowable.bufferSize()) : (UnicastProcessor) invokeV.objValue;
    }

    public boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), subscriber, spscLinkedArrayQueue})) == null) {
            if (this.cancelled) {
                spscLinkedArrayQueue.clear();
                this.actual.lazySet(null);
                return true;
            } else if (z2) {
                if (z && this.error != null) {
                    spscLinkedArrayQueue.clear();
                    this.actual.lazySet(null);
                    subscriber.onError(this.error);
                    return true;
                } else if (z3) {
                    Throwable th = this.error;
                    this.actual.lazySet(null);
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void doTerminate() {
        Runnable andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (andSet = this.onTerminate.getAndSet(null)) == null) {
            return;
        }
        andSet.run();
    }

    public void drain() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.wip.getAndIncrement() == 0) {
            int i2 = 1;
            Subscriber<? super T> subscriber = this.actual.get();
            while (subscriber == null) {
                i2 = this.wip.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                subscriber = this.actual.get();
            }
            if (this.enableOperatorFusion) {
                drainFused(subscriber);
            } else {
                drainRegular(subscriber);
            }
        }
    }

    public void drainFused(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, subscriber) == null) {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            int i2 = 1;
            boolean z = !this.delayError;
            while (!this.cancelled) {
                boolean z2 = this.done;
                if (z && z2 && this.error != null) {
                    spscLinkedArrayQueue.clear();
                    this.actual.lazySet(null);
                    subscriber.onError(this.error);
                    return;
                }
                subscriber.onNext(null);
                if (z2) {
                    this.actual.lazySet(null);
                    Throwable th = this.error;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i2 = this.wip.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
            this.actual.lazySet(null);
        }
    }

    public void drainRegular(Subscriber<? super T> subscriber) {
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, subscriber) != null) {
            return;
        }
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
        boolean z = !this.delayError;
        int i3 = 1;
        while (true) {
            long j3 = this.requested.get();
            long j4 = 0;
            while (true) {
                i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
                if (i2 == 0) {
                    j2 = j4;
                    break;
                }
                boolean z2 = this.done;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j2 = j4;
                if (checkTerminated(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z3) {
                    break;
                }
                subscriber.onNext(poll);
                j4 = 1 + j2;
            }
            if (i2 == 0 && checkTerminated(z, this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j2 != 0 && j3 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            i3 = this.wip.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.done) {
                return this.error;
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.done && this.error == null : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.actual.get() != null : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.done && this.error != null : invokeV.booleanValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.done || this.cancelled) {
            return;
        }
        this.done = true;
        doTerminate();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.done && !this.cancelled) {
                this.error = th;
                this.done = true;
                doTerminate();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done || this.cancelled) {
                return;
            }
            this.queue.offer(t);
            drain();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, subscription) == null) {
            if (!this.done && !this.cancelled) {
                subscription.request(Long.MAX_VALUE);
            } else {
                subscription.cancel();
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, subscriber) == null) {
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                subscriber.onSubscribe(this.wip);
                this.actual.set(subscriber);
                if (this.cancelled) {
                    this.actual.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnicastProcessor(int i2, Runnable runnable) {
        this(i2, runnable, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), runnable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Runnable) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? new UnicastProcessor<>(i2) : (UnicastProcessor) invokeI.objValue;
    }

    public UnicastProcessor(int i2, Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), runnable, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.queue = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i2, "capacityHint"));
        this.onTerminate = new AtomicReference<>(runnable);
        this.delayError = z;
        this.actual = new AtomicReference<>();
        this.once = new AtomicBoolean();
        this.wip = new UnicastQueueSubscription(this);
        this.requested = new AtomicLong();
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65543, null, z)) == null) ? new UnicastProcessor<>(Flowable.bufferSize(), null, z) : (UnicastProcessor) invokeZ.objValue;
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i2, Runnable runnable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, runnable)) == null) {
            ObjectHelper.requireNonNull(runnable, "onTerminate");
            return new UnicastProcessor<>(i2, runnable);
        }
        return (UnicastProcessor) invokeIL.objValue;
    }

    @CheckReturnValue
    @Experimental
    public static <T> UnicastProcessor<T> create(int i2, Runnable runnable, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), runnable, Boolean.valueOf(z)})) == null) {
            ObjectHelper.requireNonNull(runnable, "onTerminate");
            return new UnicastProcessor<>(i2, runnable, z);
        }
        return (UnicastProcessor) invokeCommon.objValue;
    }
}
