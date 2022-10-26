package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableOnBackpressureBuffer extends AbstractFlowableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayError;
    public final Action onOverflow;
    public final boolean unbounded;

    /* loaded from: classes8.dex */
    public final class BackpressureBufferSubscriber extends BasicIntQueueSubscription implements FlowableSubscriber {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2514538129242366402L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final Action onOverflow;
        public boolean outputFused;
        public final SimplePlainQueue queue;
        public final AtomicLong requested;
        public Subscription s;

        public BackpressureBufferSubscriber(Subscriber subscriber, int i, boolean z, boolean z2, Action action) {
            SimplePlainQueue spscArrayQueue;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), action};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.requested = new AtomicLong();
            this.actual = subscriber;
            this.onOverflow = action;
            this.delayError = z2;
            if (z) {
                spscArrayQueue = new SpscLinkedArrayQueue(i);
            } else {
                spscArrayQueue = new SpscArrayQueue(i);
            }
            this.queue = spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.queue.isEmpty();
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.done = true;
                if (this.outputFused) {
                    this.actual.onComplete();
                } else {
                    drain();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.queue.poll();
            }
            return invokeV.objValue;
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber subscriber) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber})) == null) {
                if (this.cancelled) {
                    this.queue.clear();
                    return true;
                } else if (z) {
                    if (this.delayError) {
                        if (z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                subscriber.onError(th);
                            } else {
                                subscriber.onComplete();
                            }
                            return true;
                        }
                        return false;
                    }
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        subscriber.onError(th2);
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
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

        public void drain() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.queue;
                Subscriber subscriber = this.actual;
                int i2 = 1;
                while (!checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (checkTerminated(z2, z, subscriber)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    }
                    if (i == 0 && checkTerminated(this.done, simplePlainQueue.isEmpty(), subscriber)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                this.error = th;
                this.done = true;
                if (this.outputFused) {
                    this.actual.onError(th);
                } else {
                    drain();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048586, this, j) == null) && !this.outputFused && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                if ((i & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                if (!this.queue.offer(obj)) {
                    this.s.cancel();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                    try {
                        this.onOverflow.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        missingBackpressureException.initCause(th);
                    }
                    onError(missingBackpressureException);
                } else if (this.outputFused) {
                    this.actual.onNext(null);
                } else {
                    drain();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableOnBackpressureBuffer(Flowable flowable, int i, boolean z, boolean z2, Action action) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), action};
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
        this.bufferSize = i;
        this.unbounded = z;
        this.delayError = z2;
        this.onOverflow = action;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            this.source.subscribe((FlowableSubscriber) new BackpressureBufferSubscriber(subscriber, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
        }
    }
}
