package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    public final long bufferSize;
    public final Action onOverflow;
    public final BackpressureOverflowStrategy strategy;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureOverflowStrategy;

        static {
            int[] iArr = new int[BackpressureOverflowStrategy.values().length];
            $SwitchMap$io$reactivex$BackpressureOverflowStrategy = iArr;
            try {
                iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureOverflowStrategy[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final long serialVersionUID = 3240706908776709697L;
        public final Subscriber<? super T> actual;
        public final long bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public Throwable error;
        public final Action onOverflow;
        public Subscription s;
        public final BackpressureOverflowStrategy strategy;
        public final AtomicLong requested = new AtomicLong();
        public final Deque<T> deque = new ArrayDeque();

        public OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.actual = subscriber;
            this.onOverflow = action;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        public void clear(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
            if (r10 != 0) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
            if (r14.cancelled == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
            clear(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
            r4 = r14.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x005c, code lost:
            r5 = r0.isEmpty();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0060, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0061, code lost:
            if (r4 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
            r4 = r14.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0065, code lost:
            if (r4 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0067, code lost:
            clear(r0);
            r1.onError(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x006d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x006e, code lost:
            if (r5 == false) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0070, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0073, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
            if (r8 == 0) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x007b, code lost:
            io.reactivex.internal.util.BackpressureHelper.produced(r14.requested, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0080, code lost:
            r3 = addAndGet(-r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            T poll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.deque;
            Subscriber<? super T> subscriber = this.actual;
            int i2 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    int i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i3 == 0) {
                        break;
                    } else if (this.cancelled) {
                        clear(deque);
                        return;
                    } else {
                        boolean z = this.done;
                        synchronized (deque) {
                            poll = deque.poll();
                        }
                        boolean z2 = poll == null;
                        if (z) {
                            Throwable th = this.error;
                            if (th != null) {
                                clear(deque);
                                subscriber.onError(th);
                                return;
                            } else if (z2) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    }
                }
            } while (i2 != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
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
            boolean z;
            boolean z2;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.bufferSize) {
                    int i2 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[this.strategy.ordinal()];
                    if (i2 == 1) {
                        deque.pollLast();
                        deque.offer(t);
                    } else if (i2 == 2) {
                        deque.poll();
                        deque.offer(t);
                    }
                    z = true;
                } else {
                    deque.offer(t);
                }
                z2 = false;
            }
            if (!z) {
                if (z2) {
                    this.s.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
                drain();
                return;
            }
            Action action = this.onOverflow;
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
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

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.bufferSize = j;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new OnBackpressureBufferStrategySubscriber(subscriber, this.onOverflow, this.strategy, this.bufferSize));
    }
}
