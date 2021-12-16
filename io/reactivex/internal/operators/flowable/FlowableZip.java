package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes4.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayError;
    public final Publisher<? extends T>[] sources;
    public final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    public final Function<? super Object[], ? extends R> zipper;

    /* loaded from: classes4.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2434867452883857743L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final Object[] current;
        public final boolean delayErrors;
        public final AtomicThrowable errors;
        public final AtomicLong requested;
        public final ZipSubscriber<T, R>[] subscribers;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.zipper = function;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                zipSubscriberArr[i6] = new ZipSubscriber<>(this, i3);
            }
            this.current = new Object[i2];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        public void cancelAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                    zipSubscriber.cancel();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x016d, code lost:
            r7 = addAndGet(-r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d1, code lost:
            if (r16 != 0) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00d5, code lost:
            if (r18.cancelled == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d7, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00da, code lost:
            if (r18.delayErrors != false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
            if (r18.errors.get() == null) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00e4, code lost:
            cancelAll();
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f0, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00f1, code lost:
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00f2, code lost:
            if (r6 >= r4) goto L108;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f4, code lost:
            r0 = r3[r6];
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00f8, code lost:
            if (r5[r6] != null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00fa, code lost:
            r10 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00fe, code lost:
            if (r0 == null) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0100, code lost:
            r0 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0105, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0106, code lost:
            if (r0 != null) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0108, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x010a, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x010b, code lost:
            if (r10 == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x010d, code lost:
            if (r11 == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x010f, code lost:
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x011a, code lost:
            if (r18.errors.get() == null) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x011c, code lost:
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0126, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0129, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x012a, code lost:
            if (r11 != false) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x012c, code lost:
            r5[r6] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x012f, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0130, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r0);
            r18.errors.addThrowable(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x013a, code lost:
            if (r18.delayErrors == false) goto L103;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x013c, code lost:
            cancelAll();
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0148, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0149, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0150, code lost:
            if (r12 == 0) goto L120;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0152, code lost:
            r0 = r3.length;
            r15 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0154, code lost:
            if (r15 >= r0) goto L116;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0156, code lost:
            r3[r15].request(r12);
            r15 = r15 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0165, code lost:
            if (r8 == Long.MAX_VALUE) goto L120;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0167, code lost:
            r18.requested.addAndGet(-r12);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            boolean z;
            T poll;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
                int length = zipSubscriberArr.length;
                Object[] objArr = this.current;
                int i2 = 1;
                do {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        } else if (this.cancelled) {
                            return;
                        } else {
                            if (!this.delayErrors && this.errors.get() != null) {
                                cancelAll();
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                            boolean z3 = false;
                            for (int i4 = 0; i4 < length; i4++) {
                                ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i4];
                                if (objArr[i4] == null) {
                                    try {
                                        z = zipSubscriber.done;
                                        SimpleQueue<T> simpleQueue = zipSubscriber.queue;
                                        poll = simpleQueue != null ? simpleQueue.poll() : null;
                                        z2 = poll == null;
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.errors.addThrowable(th);
                                        if (!this.delayErrors) {
                                            cancelAll();
                                            subscriber.onError(this.errors.terminate());
                                            return;
                                        }
                                    }
                                    if (z && z2) {
                                        cancelAll();
                                        if (this.errors.get() != null) {
                                            subscriber.onError(this.errors.terminate());
                                            return;
                                        } else {
                                            subscriber.onComplete();
                                            return;
                                        }
                                    }
                                    if (!z2) {
                                        objArr[i4] = poll;
                                    }
                                    z3 = true;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            try {
                                subscriber.onNext((Object) ObjectHelper.requireNonNull(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                                j3++;
                                Arrays.fill(objArr, (Object) null);
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                cancelAll();
                                this.errors.addThrowable(th2);
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                } while (i2 != 0);
            }
        }

        public void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, zipSubscriber, th) == null) {
                if (this.errors.addThrowable(th)) {
                    zipSubscriber.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }

        public void subscribe(Publisher<? extends T>[] publisherArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, publisherArr, i2) == null) {
                ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
                for (int i3 = 0; i3 < i2 && !this.cancelled; i3++) {
                    if (!this.delayErrors && this.errors.get() != null) {
                        return;
                    }
                    publisherArr[i3].subscribe(zipSubscriberArr[i3]);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4627193790118206028L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public final int limit;
        public final ZipCoordinator<T, R> parent;
        public final int prefetch;
        public long produced;
        public SimpleQueue<T> queue;
        public int sourceMode;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipCoordinator, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = zipCoordinator;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.error(this, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                this.parent.drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) && SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.sourceMode == 1) {
                return;
            }
            long j3 = this.produced + j2;
            if (j3 >= this.limit) {
                this.produced = 0L;
                get().request(j3);
                return;
            }
            this.produced = j3;
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisherArr, iterable, function, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            Publisher<? extends T>[] publisherArr = this.sources;
            if (publisherArr == null) {
                publisherArr = new Publisher[8];
                length = 0;
                for (Publisher<? extends T> publisher : this.sourcesIterable) {
                    if (length == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    publisherArr[length] = publisher;
                    length++;
                }
            } else {
                length = publisherArr.length;
            }
            int i2 = length;
            if (i2 == 0) {
                EmptySubscription.complete(subscriber);
                return;
            }
            ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.zipper, i2, this.bufferSize, this.delayError);
            subscriber.onSubscribe(zipCoordinator);
            zipCoordinator.subscribe(publisherArr, i2);
        }
    }
}
