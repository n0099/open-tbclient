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
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowablePublish extends ConnectableFlowable implements HasUpstreamPublisher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CANCELLED = Long.MIN_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final AtomicReference current;
    public final Publisher onSubscribe;
    public final Flowable source;

    /* loaded from: classes8.dex */
    public final class FlowablePublisher implements Publisher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final AtomicReference curr;

        public FlowablePublisher(AtomicReference atomicReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.curr = atomicReference;
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber subscriber) {
            PublishSubscriber publishSubscriber;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
                InnerSubscriber innerSubscriber = new InnerSubscriber(subscriber);
                subscriber.onSubscribe(innerSubscriber);
                while (true) {
                    publishSubscriber = (PublishSubscriber) this.curr.get();
                    if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                        PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.curr, this.bufferSize);
                        if (this.curr.compareAndSet(publishSubscriber, publishSubscriber2)) {
                            publishSubscriber = publishSubscriber2;
                        } else {
                            continue;
                        }
                    }
                    if (publishSubscriber.add(innerSubscriber)) {
                        break;
                    }
                }
                if (innerSubscriber.get() == Long.MIN_VALUE) {
                    publishSubscriber.remove(innerSubscriber);
                } else {
                    innerSubscriber.parent = publishSubscriber;
                }
                publishSubscriber.dispatch();
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class InnerSubscriber extends AtomicLong implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4453897557930727610L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber child;
        public long emitted;
        public volatile PublishSubscriber parent;

        public InnerSubscriber(Subscriber subscriber) {
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
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                PublishSubscriber publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber publishSubscriber;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (publishSubscriber = this.parent) != null) {
                publishSubscriber.remove(this);
                publishSubscriber.dispatch();
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class PublishSubscriber extends AtomicInteger implements FlowableSubscriber, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final InnerSubscriber[] EMPTY;
        public static final InnerSubscriber[] TERMINATED;
        public static final long serialVersionUID = -202316842419149694L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final AtomicReference current;
        public volatile SimpleQueue queue;
        public final AtomicReference s;
        public final AtomicBoolean shouldConnect;
        public int sourceMode;
        public final AtomicReference subscribers;
        public volatile Object terminalEvent;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(102337187, "Lio/reactivex/internal/operators/flowable/FlowablePublish$PublishSubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(102337187, "Lio/reactivex/internal/operators/flowable/FlowablePublish$PublishSubscriber;");
                    return;
                }
            }
            EMPTY = new InnerSubscriber[0];
            TERMINATED = new InnerSubscriber[0];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Object obj = this.subscribers.get();
                Object obj2 = TERMINATED;
                if (obj != obj2 && ((InnerSubscriber[]) this.subscribers.getAndSet(obj2)) != TERMINATED) {
                    this.current.compareAndSet(this, null);
                    SubscriptionHelper.cancel(this.s);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.subscribers.get() == TERMINATED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        public PublishSubscriber(AtomicReference atomicReference, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.s = new AtomicReference();
            this.subscribers = new AtomicReference(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = i;
        }

        public boolean checkTerminated(Object obj, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, z)) == null) {
                int i = 0;
                if (obj != null) {
                    if (NotificationLite.isComplete(obj)) {
                        if (z) {
                            this.current.compareAndSet(this, null);
                            InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                            int length = innerSubscriberArr.length;
                            while (i < length) {
                                innerSubscriberArr[i].child.onComplete();
                                i++;
                            }
                            return true;
                        }
                    } else {
                        Throwable error = NotificationLite.getError(obj);
                        this.current.compareAndSet(this, null);
                        InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                        if (innerSubscriberArr2.length != 0) {
                            int length2 = innerSubscriberArr2.length;
                            while (i < length2) {
                                innerSubscriberArr2[i].child.onError(error);
                                i++;
                            }
                        } else {
                            RxJavaPlugins.onError(error);
                        }
                        return true;
                    }
                }
                return false;
            }
            return invokeLZ.booleanValue;
        }

        public boolean add(InnerSubscriber innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerSubscriber)) == null) {
                do {
                    innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                    if (innerSubscriberArr == TERMINATED) {
                        return false;
                    }
                    int length = innerSubscriberArr.length;
                    innerSubscriberArr2 = new InnerSubscriber[length + 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                    innerSubscriberArr2[length] = innerSubscriber;
                } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                if (this.terminalEvent == null) {
                    this.terminalEvent = NotificationLite.error(th);
                    dispatch();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                if (this.sourceMode == 0 && !this.queue.offer(obj)) {
                    onError(new MissingBackpressureException("Prefetch queue is full?!"));
                } else {
                    dispatch();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x0122, code lost:
            r4 = r0;
            r3 = 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void dispatch() {
            boolean z;
            Object obj;
            boolean z2;
            long j;
            Object obj2;
            boolean z3;
            SimpleQueue simpleQueue;
            boolean z4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            AtomicReference atomicReference = this.subscribers;
            int i = 1;
            InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) atomicReference.get();
            int i2 = 1;
            while (true) {
                Object obj3 = this.terminalEvent;
                SimpleQueue simpleQueue2 = this.queue;
                if (simpleQueue2 != null && !simpleQueue2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (checkTerminated(obj3, z)) {
                    return;
                }
                if (!z) {
                    int length = innerSubscriberArr.length;
                    int i3 = 0;
                    long j2 = Long.MAX_VALUE;
                    for (InnerSubscriber innerSubscriber : innerSubscriberArr) {
                        long j3 = innerSubscriber.get();
                        if (j3 != Long.MIN_VALUE) {
                            j2 = Math.min(j2, j3 - innerSubscriber.emitted);
                        } else {
                            i3++;
                        }
                    }
                    if (length == i3) {
                        Object obj4 = this.terminalEvent;
                        try {
                            obj = simpleQueue2.poll();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            ((Subscription) this.s.get()).cancel();
                            obj4 = NotificationLite.error(th);
                            this.terminalEvent = obj4;
                            obj = null;
                        }
                        if (obj == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (checkTerminated(obj4, z2)) {
                            return;
                        }
                        if (this.sourceMode != i) {
                            ((Subscription) this.s.get()).request(1L);
                        }
                    } else {
                        int i4 = 0;
                        while (true) {
                            j = i4;
                            if (j >= j2) {
                                break;
                            }
                            Object obj5 = this.terminalEvent;
                            try {
                                obj2 = simpleQueue2.poll();
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                ((Subscription) this.s.get()).cancel();
                                obj5 = NotificationLite.error(th2);
                                this.terminalEvent = obj5;
                                obj2 = null;
                            }
                            if (obj2 == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (checkTerminated(obj5, z3)) {
                                return;
                            }
                            if (z3) {
                                z = z3;
                                break;
                            }
                            Object value = NotificationLite.getValue(obj2);
                            int length2 = innerSubscriberArr.length;
                            int i5 = 0;
                            boolean z5 = false;
                            while (i5 < length2) {
                                InnerSubscriber innerSubscriber2 = innerSubscriberArr[i5];
                                long j4 = innerSubscriber2.get();
                                if (j4 != Long.MIN_VALUE) {
                                    int i6 = (j4 > Long.MAX_VALUE ? 1 : (j4 == Long.MAX_VALUE ? 0 : -1));
                                    simpleQueue = simpleQueue2;
                                    z4 = z3;
                                    if (i6 != 0) {
                                        innerSubscriber2.emitted++;
                                    }
                                    innerSubscriber2.child.onNext(value);
                                } else {
                                    simpleQueue = simpleQueue2;
                                    z4 = z3;
                                    z5 = true;
                                }
                                i5++;
                                simpleQueue2 = simpleQueue;
                                z3 = z4;
                            }
                            SimpleQueue simpleQueue3 = simpleQueue2;
                            boolean z6 = z3;
                            i4++;
                            InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) atomicReference.get();
                            if (z5 || innerSubscriberArr2 != innerSubscriberArr) {
                                break;
                            }
                            simpleQueue2 = simpleQueue3;
                            z = z6;
                        }
                        if (i4 > 0) {
                            i = 1;
                            if (this.sourceMode != 1) {
                                ((Subscription) this.s.get()).request(j);
                            }
                        } else {
                            i = 1;
                        }
                        if (j2 != 0 && !z) {
                        }
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                innerSubscriberArr = (InnerSubscriber[]) atomicReference.get();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subscription) == null) && SubscriptionHelper.setOnce(this.s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        public void remove(InnerSubscriber innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, innerSubscriber) == null) {
                do {
                    innerSubscriberArr = (InnerSubscriber[]) this.subscribers.get();
                    int length = innerSubscriberArr.length;
                    if (length != 0) {
                        int i = -1;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i < 0) {
                            return;
                        }
                        if (length == 1) {
                            innerSubscriberArr2 = EMPTY;
                        } else {
                            InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                            System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            }
        }
    }

    public FlowablePublish(Publisher publisher, Flowable flowable, AtomicReference atomicReference, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisher, flowable, atomicReference, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferSize = i;
    }

    public static ConnectableFlowable create(Flowable flowable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, flowable, i)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowablePublish(new FlowablePublisher(atomicReference, i), flowable, atomicReference, i));
        }
        return (ConnectableFlowable) invokeLI.objValue;
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer consumer) {
        PublishSubscriber publishSubscriber;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, consumer) == null) {
            while (true) {
                publishSubscriber = (PublishSubscriber) this.current.get();
                if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                    break;
                }
                PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.current, this.bufferSize);
                if (this.current.compareAndSet(publishSubscriber, publishSubscriber2)) {
                    publishSubscriber = publishSubscriber2;
                    break;
                }
            }
            boolean z = true;
            z = (publishSubscriber.shouldConnect.get() || !publishSubscriber.shouldConnect.compareAndSet(false, true)) ? false : false;
            try {
                consumer.accept(publishSubscriber);
                if (z) {
                    this.source.subscribe((FlowableSubscriber) publishSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.source;
        }
        return (Publisher) invokeV.objValue;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subscriber) == null) {
            this.onSubscribe.subscribe(subscriber);
        }
    }
}
