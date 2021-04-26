package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    public final AtomicBoolean once;
    public final CacheState<T> state;

    /* loaded from: classes7.dex */
    public static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        public static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
        public static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
        public final AtomicReference<Subscription> connection;
        public volatile boolean isConnected;
        public final Flowable<T> source;
        public boolean sourceDone;
        public final AtomicReference<ReplaySubscription<T>[]> subscribers;

        public CacheState(Flowable<T> flowable, int i2) {
            super(i2);
            this.connection = new AtomicReference<>();
            this.source = flowable;
            this.subscribers = new AtomicReference<>(EMPTY);
        }

        public boolean addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = replaySubscriptionArr.length;
                replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                replaySubscriptionArr2[length] = replaySubscription;
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
            return true;
        }

        public void connect() {
            this.source.subscribe((FlowableSubscriber) this);
            this.isConnected = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.complete());
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                SubscriptionHelper.cancel(this.connection);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                    replaySubscription.replay();
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceDone) {
                return;
            }
            add(NotificationLite.next(t));
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                replaySubscription.replay();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.connection, subscription, Long.MAX_VALUE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableCache$ReplaySubscription<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                int length = replaySubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (replaySubscriptionArr[i3].equals(replaySubscription)) {
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
                    replaySubscriptionArr2 = EMPTY;
                } else {
                    ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                    System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i2);
                    System.arraycopy(replaySubscriptionArr, i2 + 1, replaySubscriptionArr3, i2, (length - i2) - 1);
                    replaySubscriptionArr2 = replaySubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }
    }

    /* loaded from: classes7.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        public static final long CANCELLED = Long.MIN_VALUE;
        public static final long serialVersionUID = -2557562030197141021L;
        public final Subscriber<? super T> child;
        public Object[] currentBuffer;
        public int currentIndexInBuffer;
        public long emitted;
        public int index;
        public final AtomicLong requested = new AtomicLong();
        public final CacheState<T> state;

        public ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.state.removeChild(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.child;
            AtomicLong atomicLong = this.requested;
            long j = this.emitted;
            int i2 = 1;
            int i3 = 1;
            while (true) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - i2;
                    int i4 = this.index;
                    int i5 = this.currentIndexInBuffer;
                    while (i4 < size && j != j2) {
                        if (atomicLong.get() == Long.MIN_VALUE) {
                            return;
                        }
                        if (i5 == length) {
                            objArr = (Object[]) objArr[length];
                            i5 = 0;
                        }
                        if (NotificationLite.accept(objArr[i5], subscriber)) {
                            return;
                        }
                        i5++;
                        i4++;
                        j++;
                    }
                    if (atomicLong.get() == Long.MIN_VALUE) {
                        return;
                    }
                    if (j2 == j) {
                        Object obj = objArr[i5];
                        if (NotificationLite.isComplete(obj)) {
                            subscriber.onComplete();
                            return;
                        } else if (NotificationLite.isError(obj)) {
                            subscriber.onError(NotificationLite.getError(obj));
                            return;
                        }
                    }
                    this.index = i4;
                    this.currentIndexInBuffer = i5;
                    this.currentBuffer = objArr;
                }
                this.emitted = j;
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                i2 = 1;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this.requested, j);
                replay();
            }
        }
    }

    public FlowableCache(Flowable<T> flowable, int i2) {
        super(flowable);
        this.state = new CacheState<>(flowable, i2);
        this.once = new AtomicBoolean();
    }

    public int cachedEventCount() {
        return this.state.size();
    }

    public boolean hasSubscribers() {
        return this.state.subscribers.get().length != 0;
    }

    public boolean isConnected() {
        return this.state.isConnected;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this.state);
        subscriber.onSubscribe(replaySubscription);
        if (this.state.addChild(replaySubscription) && replaySubscription.requested.get() == Long.MIN_VALUE) {
            this.state.removeChild(replaySubscription);
            z = false;
        } else {
            z = true;
        }
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            this.state.connect();
        }
        if (z) {
            replaySubscription.replay();
        }
    }
}
