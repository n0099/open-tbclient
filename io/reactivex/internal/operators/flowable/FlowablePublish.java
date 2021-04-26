package io.reactivex.internal.operators.flowable;

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
/* loaded from: classes7.dex */
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    public static final long CANCELLED = Long.MIN_VALUE;
    public final int bufferSize;
    public final AtomicReference<PublishSubscriber<T>> current;
    public final Publisher<T> onSubscribe;
    public final Flowable<T> source;

    /* loaded from: classes7.dex */
    public static final class FlowablePublisher<T> implements Publisher<T> {
        public final int bufferSize;
        public final AtomicReference<PublishSubscriber<T>> curr;

        public FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i2) {
            this.curr = atomicReference;
            this.bufferSize = i2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.curr.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.curr, this.bufferSize);
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

    /* loaded from: classes7.dex */
    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        public static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber<? super T> child;
        public long emitted;
        public volatile PublishSubscriber<T> parent;

        public InnerSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.parent) == null) {
                return;
            }
            publishSubscriber.remove(this);
            publishSubscriber.dispatch();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        public static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        public static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        public static final long serialVersionUID = -202316842419149694L;
        public final int bufferSize;
        public final AtomicReference<PublishSubscriber<T>> current;
        public volatile SimpleQueue<T> queue;
        public int sourceMode;
        public volatile Object terminalEvent;
        public final AtomicReference<Subscription> s = new AtomicReference<>();
        public final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i2) {
            this.current = atomicReference;
            this.bufferSize = i2;
        }

        public boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber<T>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
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

        public boolean checkTerminated(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].child.onError(error);
                            i2++;
                        }
                    } else {
                        RxJavaPlugins.onError(error);
                    }
                    return true;
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber<T>[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i2 < length2) {
                        andSet2[i2].child.onComplete();
                        i2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:106:0x0014, code lost:
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x011e, code lost:
            r4 = r0;
            r3 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0122, code lost:
            if (r11 <= 0) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x0124, code lost:
            r3 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0127, code lost:
            if (r25.sourceMode == 1) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x0129, code lost:
            r25.s.get().request(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0135, code lost:
            r3 = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x013a, code lost:
            if (r14 == 0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x013c, code lost:
            if (r8 != false) goto L70;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void dispatch() {
            T t;
            T t2;
            SimpleQueue<T> simpleQueue;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<InnerSubscriber<T>[]> atomicReference = this.subscribers;
            int i2 = 1;
            InnerSubscriber<T>[] innerSubscriberArr = atomicReference.get();
            int i3 = 1;
            while (true) {
                Object obj = this.terminalEvent;
                SimpleQueue<T> simpleQueue2 = this.queue;
                boolean z2 = simpleQueue2 == null || simpleQueue2.isEmpty();
                if (checkTerminated(obj, z2)) {
                    return;
                }
                if (!z2) {
                    int length = innerSubscriberArr.length;
                    int i4 = 0;
                    long j = Long.MAX_VALUE;
                    for (InnerSubscriber<T> innerSubscriber : innerSubscriberArr) {
                        long j2 = innerSubscriber.get();
                        if (j2 != Long.MIN_VALUE) {
                            j = Math.min(j, j2 - innerSubscriber.emitted);
                        } else {
                            i4++;
                        }
                    }
                    if (length != i4) {
                        int i5 = 0;
                        while (true) {
                            long j3 = i5;
                            if (j3 >= j) {
                                break;
                            }
                            Object obj2 = this.terminalEvent;
                            try {
                                t2 = simpleQueue2.poll();
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.s.get().cancel();
                                obj2 = NotificationLite.error(th);
                                this.terminalEvent = obj2;
                                t2 = null;
                            }
                            boolean z3 = t2 == null;
                            if (checkTerminated(obj2, z3)) {
                                return;
                            }
                            if (z3) {
                                z2 = z3;
                                break;
                            }
                            Object value = NotificationLite.getValue(t2);
                            int length2 = innerSubscriberArr.length;
                            int i6 = 0;
                            boolean z4 = false;
                            while (i6 < length2) {
                                InnerSubscriber<T> innerSubscriber2 = innerSubscriberArr[i6];
                                long j4 = innerSubscriber2.get();
                                if (j4 != Long.MIN_VALUE) {
                                    int i7 = (j4 > Long.MAX_VALUE ? 1 : (j4 == Long.MAX_VALUE ? 0 : -1));
                                    simpleQueue = simpleQueue2;
                                    z = z3;
                                    if (i7 != 0) {
                                        innerSubscriber2.emitted++;
                                    }
                                    innerSubscriber2.child.onNext(value);
                                } else {
                                    simpleQueue = simpleQueue2;
                                    z = z3;
                                    z4 = true;
                                }
                                i6++;
                                simpleQueue2 = simpleQueue;
                                z3 = z;
                            }
                            SimpleQueue<T> simpleQueue3 = simpleQueue2;
                            boolean z5 = z3;
                            i5++;
                            InnerSubscriber<T>[] innerSubscriberArr2 = atomicReference.get();
                            if (z4 || innerSubscriberArr2 != innerSubscriberArr) {
                                break;
                            }
                            simpleQueue2 = simpleQueue3;
                            z2 = z5;
                        }
                    } else {
                        Object obj3 = this.terminalEvent;
                        try {
                            t = simpleQueue2.poll();
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.s.get().cancel();
                            obj3 = NotificationLite.error(th2);
                            this.terminalEvent = obj3;
                            t = null;
                        }
                        if (checkTerminated(obj3, t == null)) {
                            return;
                        }
                        if (this.sourceMode != i2) {
                            this.s.get().request(1L);
                        }
                    }
                }
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                innerSubscriberArr = atomicReference.get();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            SubscriptionHelper.cancel(this.s);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            } else {
                dispatch();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.s, subscription)) {
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

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (innerSubscriberArr[i3].equals(innerSubscriber)) {
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
                    innerSubscriberArr2 = EMPTY;
                } else {
                    InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i2);
                    System.arraycopy(innerSubscriberArr, i2 + 1, innerSubscriberArr3, i2, (length - i2) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }
    }

    public FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<PublishSubscriber<T>> atomicReference, int i2) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferSize = i2;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowablePublish(new FlowablePublisher(atomicReference, i2), flowable, atomicReference, i2));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current, this.bufferSize);
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

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }
}
