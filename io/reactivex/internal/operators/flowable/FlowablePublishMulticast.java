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
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes2.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayError;
    public final int prefetch;
    public final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    /* loaded from: classes2.dex */
    public static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        public static /* synthetic */ Interceptable $ic;
        public static final MulticastSubscription[] EMPTY;
        public static final MulticastSubscription[] TERMINATED;
        public transient /* synthetic */ FieldHolder $fh;
        public int consumed;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public volatile SimpleQueue<T> queue;
        public final AtomicReference<Subscription> s;
        public int sourceMode;
        public final AtomicReference<MulticastSubscription<T>[]> subscribers;
        public final AtomicInteger wip;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(891232880, "Lio/reactivex/internal/operators/flowable/FlowablePublishMulticast$MulticastProcessor;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(891232880, "Lio/reactivex/internal/operators/flowable/FlowablePublishMulticast$MulticastProcessor;");
                    return;
                }
            }
            EMPTY = new MulticastSubscription[0];
            TERMINATED = new MulticastSubscription[0];
        }

        public MulticastProcessor(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.delayError = z;
            this.wip = new AtomicInteger();
            this.s = new AtomicReference<>();
            this.subscribers = new AtomicReference<>(EMPTY);
        }

        public boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, multicastSubscription)) == null) {
                do {
                    multicastSubscriptionArr = this.subscribers.get();
                    if (multicastSubscriptionArr == TERMINATED) {
                        return false;
                    }
                    int length = multicastSubscriptionArr.length;
                    multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                    multicastSubscriptionArr2[length] = multicastSubscription;
                } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        public void completeAll() {
            MulticastSubscription<T>[] andSet;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    if (multicastSubscription.get() != Long.MIN_VALUE) {
                        multicastSubscription.actual.onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SubscriptionHelper.cancel(this.s);
                if (this.wip.getAndIncrement() != 0 || (simpleQueue = this.queue) == null) {
                    return;
                }
                simpleQueue.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x012b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x00ec, code lost:
            r8 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00fc, code lost:
            if (r7 != 0) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0102, code lost:
            if (isDisposed() == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0104, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0107, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0108, code lost:
            r5 = r24.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x010a, code lost:
            if (r5 == false) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x010e, code lost:
            if (r24.delayError != false) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0110, code lost:
            r6 = r24.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0112, code lost:
            if (r6 == null) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0114, code lost:
            errorAll(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0117, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0118, code lost:
            if (r5 == false) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x011e, code lost:
            if (r0.isEmpty() == false) goto L113;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0120, code lost:
            r0 = r24.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0122, code lost:
            if (r0 == null) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0124, code lost:
            errorAll(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0128, code lost:
            completeAll();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.wip.getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.queue;
            int i2 = this.consumed;
            int i3 = this.limit;
            boolean z = this.sourceMode != 1;
            AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.subscribers;
            MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference2.get();
            int i4 = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (simpleQueue == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr.length;
                    long j = Long.MAX_VALUE;
                    long j2 = Long.MAX_VALUE;
                    int i5 = 0;
                    while (i5 < length2) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i5];
                        AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                        if (j3 == Long.MIN_VALUE) {
                            length--;
                        } else if (j2 > j3) {
                            j2 = j3;
                        }
                        i5++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j4 = 0;
                    if (length == 0) {
                        j2 = 0;
                    }
                    while (true) {
                        int i6 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                        if (i6 == 0) {
                            break;
                        } else if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        } else {
                            boolean z2 = this.done;
                            if (z2 && !this.delayError && (th = this.error) != null) {
                                errorAll(th);
                                return;
                            }
                            try {
                                T poll = simpleQueue.poll();
                                boolean z3 = poll == null;
                                if (z2 && z3) {
                                    Throwable th2 = this.error;
                                    if (th2 != null) {
                                        errorAll(th2);
                                        return;
                                    } else {
                                        completeAll();
                                        return;
                                    }
                                } else if (z3) {
                                    break;
                                } else {
                                    int length3 = multicastSubscriptionArr.length;
                                    int i7 = 0;
                                    boolean z4 = false;
                                    while (i7 < length3) {
                                        MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i7];
                                        long j5 = multicastSubscription2.get();
                                        if (j5 != Long.MIN_VALUE) {
                                            if (j5 != j) {
                                                multicastSubscription2.emitted++;
                                            }
                                            multicastSubscription2.actual.onNext(poll);
                                        } else {
                                            z4 = true;
                                        }
                                        i7++;
                                        j = Long.MAX_VALUE;
                                    }
                                    j2--;
                                    if (z && (i2 = i2 + 1) == i3) {
                                        this.s.get().request(i3);
                                        i2 = 0;
                                    }
                                    MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                                    if (z4 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                        break;
                                    }
                                    j4 = 0;
                                    j = Long.MAX_VALUE;
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                SubscriptionHelper.cancel(this.s);
                                errorAll(th3);
                                return;
                            }
                        }
                    }
                }
                this.consumed = i2;
                i4 = this.wip.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
                if (simpleQueue == null) {
                    simpleQueue = this.queue;
                }
                multicastSubscriptionArr = atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        public void errorAll(Throwable th) {
            MulticastSubscription<T>[] andSet;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(TERMINATED)) {
                    if (multicastSubscription.get() != Long.MIN_VALUE) {
                        multicastSubscription.actual.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? SubscriptionHelper.isCancelled(this.s.get()) : invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.error = th;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || this.done) {
                return;
            }
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                this.s.get().cancel();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, subscription) == null) && SubscriptionHelper.setOnce(this.s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, multicastSubscription) == null) {
                do {
                    multicastSubscriptionArr = this.subscribers.get();
                    int length = multicastSubscriptionArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (multicastSubscriptionArr[i3] == multicastSubscription) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 < 0) {
                        return;
                    }
                    if (length == 1) {
                        multicastSubscriptionArr2 = EMPTY;
                    } else {
                        MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                        System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i2);
                        System.arraycopy(multicastSubscriptionArr, i2 + 1, multicastSubscriptionArr3, i2, (length - i2) - 1);
                        multicastSubscriptionArr2 = multicastSubscriptionArr3;
                    }
                } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            }
        }

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, subscriber) == null) {
                MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
                subscriber.onSubscribe(multicastSubscription);
                if (add(multicastSubscription)) {
                    if (multicastSubscription.isCancelled()) {
                        remove(multicastSubscription);
                        return;
                    } else {
                        drain();
                        return;
                    }
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8664815189257569791L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public long emitted;
        public final MulticastProcessor<T> parent;

        public MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, multicastProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.remove(this);
            this.parent.drain();
        }

        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public final MulticastProcessor<?> processor;
        public Subscription s;

        public OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, multicastProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.processor = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.s.cancel();
                this.processor.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.actual.onComplete();
                this.processor.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.actual.onError(th);
                this.processor.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                this.actual.onNext(r);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.s.request(j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.selector = function;
        this.prefetch = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
                this.source.subscribe((FlowableSubscriber) multicastProcessor);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        }
    }
}
