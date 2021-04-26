package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public final ErrorMode errorMode;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;

    /* loaded from: classes7.dex */
    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        public static final long serialVersionUID = -4255299542215038287L;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public volatile InnerQueuedSubscriber<R> current;
        public volatile boolean done;
        public final ErrorMode errorMode;
        public final Function<? super T, ? extends Publisher<? extends R>> mapper;
        public final int maxConcurrency;
        public final int prefetch;
        public Subscription s;
        public final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.actual = subscriber;
            this.mapper = function;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i3, i2));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            drainAndCancel();
        }

        public void cancelAll() {
            while (true) {
                InnerQueuedSubscriber<R> poll = this.subscribers.poll();
                if (poll == null) {
                    return;
                }
                poll.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00cc, code lost:
            r0 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00cd, code lost:
            if (r17 != 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00d1, code lost:
            if (r19.cancelled == false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
            cancelAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d6, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00d9, code lost:
            if (r3 != io.reactivex.internal.util.ErrorMode.IMMEDIATE) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00e3, code lost:
            if (r19.errors.get() == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00e5, code lost:
            r19.current = null;
            r8.cancel();
            cancelAll();
            r2.onError(r19.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00f6, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00f7, code lost:
            r15 = r8.isDone();
            r12 = r12.isEmpty();
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00ff, code lost:
            if (r15 == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0101, code lost:
            if (r12 == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0103, code lost:
            r19.current = null;
            r19.s.request(1);
            r8 = null;
            r0 = true;
         */
        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i2;
            long j;
            boolean z;
            SimpleQueue<R> queue;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
            Subscriber<? super R> subscriber = this.actual;
            ErrorMode errorMode = this.errorMode;
            int i3 = 1;
            while (true) {
                long j2 = this.requested.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else if (errorMode != ErrorMode.END && this.errors.get() != null) {
                    cancelAll();
                    subscriber.onError(this.errors.terminate());
                    return;
                } else {
                    boolean z2 = this.done;
                    innerQueuedSubscriber = this.subscribers.poll();
                    if (z2 && innerQueuedSubscriber == null) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (innerQueuedSubscriber != null) {
                        this.current = innerQueuedSubscriber;
                    }
                }
                if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                    i2 = i3;
                    j = 0;
                    z = false;
                } else {
                    i2 = i3;
                    j = 0;
                    while (true) {
                        int i4 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i4 == 0) {
                            break;
                        } else if (this.cancelled) {
                            cancelAll();
                            return;
                        } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            boolean isDone = innerQueuedSubscriber.isDone();
                            try {
                                R poll = queue.poll();
                                boolean z3 = poll == null;
                                if (isDone && z3) {
                                    this.current = null;
                                    this.s.request(1L);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                    break;
                                } else if (z3) {
                                    break;
                                } else {
                                    subscriber.onNext(poll);
                                    j++;
                                    innerQueuedSubscriber.requestOne();
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                }
                if (j != 0 && j2 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j);
                }
                if (z) {
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                    i3 = i2;
                } else {
                    i3 = addAndGet(-i2);
                    if (i3 == 0) {
                        return;
                    }
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                }
            }
        }

        public void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.s.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : i2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
        super(flowable);
        this.mapper = function;
        this.maxConcurrency = i2;
        this.prefetch = i3;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
