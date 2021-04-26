package io.reactivex.internal.operators.flowable;

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
/* loaded from: classes7.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    public final int bufferSize;
    public final boolean delayError;
    public final Publisher<? extends T>[] sources;
    public final Iterable<? extends Publisher<? extends T>> sourcesIterable;
    public final Function<? super Object[], ? extends R> zipper;

    /* loaded from: classes7.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        public static final long serialVersionUID = -2434867452883857743L;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final Object[] current;
        public final boolean delayErrors;
        public final AtomicThrowable errors;
        public final AtomicLong requested;
        public final ZipSubscriber<T, R>[] subscribers;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z) {
            this.actual = subscriber;
            this.zipper = function;
            this.delayErrors = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                zipSubscriberArr[i4] = new ZipSubscriber<>(this, i3);
            }
            this.current = new Object[i2];
            this.subscribers = zipSubscriberArr;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        public void cancelAll() {
            for (ZipSubscriber<T, R> zipSubscriber : this.subscribers) {
                zipSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00cd, code lost:
            if (r16 != 0) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d1, code lost:
            if (r18.cancelled == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00d6, code lost:
            if (r18.delayErrors != false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
            if (r18.errors.get() == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00e0, code lost:
            cancelAll();
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00ed, code lost:
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ee, code lost:
            if (r6 >= r4) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00f0, code lost:
            r0 = r3[r6];
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00f4, code lost:
            if (r5[r6] != null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f6, code lost:
            r10 = r0.done;
            r0 = r0.queue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00fa, code lost:
            if (r0 == null) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00fc, code lost:
            r0 = r0.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0101, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0102, code lost:
            if (r0 != null) goto L96;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0104, code lost:
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0106, code lost:
            r11 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0107, code lost:
            if (r10 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0109, code lost:
            if (r11 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x010b, code lost:
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0116, code lost:
            if (r18.errors.get() == null) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0118, code lost:
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0122, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0125, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0126, code lost:
            if (r11 != false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0128, code lost:
            r5[r6] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x012b, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x012c, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r0);
            r18.errors.addThrowable(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0136, code lost:
            if (r18.delayErrors == false) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0138, code lost:
            cancelAll();
            r2.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0144, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0145, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x014c, code lost:
            if (r12 == 0) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x014e, code lost:
            r0 = r3.length;
            r15 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0150, code lost:
            if (r15 >= r0) goto L114;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0152, code lost:
            r3[r15].request(r12);
            r15 = r15 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0161, code lost:
            if (r8 == Long.MAX_VALUE) goto L118;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0163, code lost:
            r18.requested.addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0169, code lost:
            r7 = addAndGet(-r7);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            boolean z;
            T poll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.actual;
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            int length = zipSubscriberArr.length;
            Object[] objArr = this.current;
            int i2 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
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
                            j2++;
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

        public void error(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                zipSubscriber.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void subscribe(Publisher<? extends T>[] publisherArr, int i2) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.subscribers;
            for (int i3 = 0; i3 < i2 && !this.cancelled; i3++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                publisherArr[i3].subscribe(zipSubscriberArr[i3]);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = -4627193790118206028L;
        public volatile boolean done;
        public final int limit;
        public final ZipCoordinator<T, R> parent;
        public final int prefetch;
        public long produced;
        public SimpleQueue<T> queue;
        public int sourceMode;

        public ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i2) {
            this.parent = zipCoordinator;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
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
        public void request(long j) {
            if (this.sourceMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        this.sources = publisherArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
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
