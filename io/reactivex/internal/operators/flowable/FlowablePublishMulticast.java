package io.reactivex.internal.operators.flowable;

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
/* loaded from: classes7.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public final boolean delayError;
    public final int prefetch;
    public final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    /* loaded from: classes7.dex */
    public static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        public static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        public static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        public int consumed;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public volatile SimpleQueue<T> queue;
        public int sourceMode;
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicReference<Subscription> s = new AtomicReference<>();
        public final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        public MulticastProcessor(int i2, boolean z) {
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.delayError = z;
        }

        public boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
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

        public void completeAll() {
            MulticastSubscription<T>[] andSet;
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.s);
            if (this.wip.getAndIncrement() != 0 || (simpleQueue = this.queue) == null) {
                return;
            }
            simpleQueue.clear();
        }

        /* JADX WARN: Code restructure failed: missing block: B:131:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00e8, code lost:
            r8 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00f8, code lost:
            if (r7 != 0) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00fe, code lost:
            if (isDisposed() == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0100, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0103, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0104, code lost:
            r5 = r24.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0106, code lost:
            if (r5 == false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x010a, code lost:
            if (r24.delayError != false) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x010c, code lost:
            r6 = r24.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x010e, code lost:
            if (r6 == null) goto L98;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0110, code lost:
            errorAll(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0113, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0114, code lost:
            if (r5 == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x011a, code lost:
            if (r0.isEmpty() == false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x011c, code lost:
            r0 = r24.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x011e, code lost:
            if (r0 == null) goto L106;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0120, code lost:
            errorAll(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0124, code lost:
            completeAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0127, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th;
            if (this.wip.getAndIncrement() != 0) {
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
            for (MulticastSubscription<T> multicastSubscription : this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.s.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
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
            if (SubscriptionHelper.setOnce(this.s, subscription)) {
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

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
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

    /* loaded from: classes7.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        public static final long serialVersionUID = 8664815189257569791L;
        public final Subscriber<? super T> actual;
        public long emitted;
        public final MulticastProcessor<T> parent;

        public MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.actual = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        public final Subscriber<? super R> actual;
        public final MulticastProcessor<?> processor;
        public Subscription s;

        public OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.actual = subscriber;
            this.processor = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        super(flowable);
        this.selector = function;
        this.prefetch = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
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
