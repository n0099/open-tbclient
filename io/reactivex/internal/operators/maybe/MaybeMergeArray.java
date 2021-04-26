package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class MaybeMergeArray<T> extends Flowable<T> {
    public final MaybeSource<? extends T>[] sources;

    /* loaded from: classes7.dex */
    public static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        public static final long serialVersionUID = -4025173261791142821L;
        public int consumerIndex;
        public final AtomicInteger producerIndex = new AtomicInteger();

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            poll();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T t = (T) super.poll();
            if (t != null) {
                this.consumerIndex++;
            }
            return t;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            this.producerIndex.getAndIncrement();
            return super.offer(t);
        }
    }

    /* loaded from: classes7.dex */
    public static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        public static final long serialVersionUID = -660395290758764731L;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public long consumed;
        public boolean outputFused;
        public final SimpleQueueWithConsumerIndex<Object> queue;
        public final int sourceCount;
        public final CompositeDisposable set = new CompositeDisposable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable error = new AtomicThrowable();

        public MergeMaybeObserver(Subscriber<? super T> subscriber, int i2, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.actual = subscriber;
            this.sourceCount = i2;
            this.queue = simpleQueueWithConsumerIndex;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.queue.clear();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        public void drainFused() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount;
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z) {
                    subscriber.onComplete();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
            if (r7 != 0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
            if (r10.error.get() == null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
            r1.clear();
            r0.onError(r10.error.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
            if (r1.peek() != io.reactivex.internal.util.NotificationLite.COMPLETE) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
            r1.drop();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
            if (r1.consumerIndex() != r10.sourceCount) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
            r10.consumed = r2;
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainNormal() {
            Subscriber<? super T> subscriber = this.actual;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            long j = this.consumed;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                while (true) {
                    int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i3 == 0) {
                        break;
                    } else if (this.cancelled) {
                        simpleQueueWithConsumerIndex.clear();
                        return;
                    } else if (this.error.get() != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(this.error.terminate());
                        return;
                    } else if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                        subscriber.onComplete();
                        return;
                    } else {
                        Object poll = simpleQueueWithConsumerIndex.poll();
                        if (poll == null) {
                            break;
                        } else if (poll != NotificationLite.COMPLETE) {
                            subscriber.onNext(poll);
                            j++;
                        }
                    }
                }
            } while (i2 != 0);
        }

        public boolean isCancelled() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.set.dispose();
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            T t;
            do {
                t = (T) this.queue.poll();
            } while (t == NotificationLite.COMPLETE);
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }
    }

    /* loaded from: classes7.dex */
    public interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.sources = maybeSourceArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SimpleQueueWithConsumerIndex clqSimpleQueue;
        MaybeSource[] maybeSourceArr = this.sources;
        int length = maybeSourceArr.length;
        if (length <= Flowable.bufferSize()) {
            clqSimpleQueue = new MpscFillOnceSimpleQueue(length);
        } else {
            clqSimpleQueue = new ClqSimpleQueue();
        }
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, clqSimpleQueue);
        subscriber.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
        for (MaybeSource maybeSource : maybeSourceArr) {
            if (mergeMaybeObserver.isCancelled() || atomicThrowable.get() != null) {
                return;
            }
            maybeSource.subscribe(mergeMaybeObserver);
        }
    }

    /* loaded from: classes7.dex */
    public static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        public static final long serialVersionUID = -7969063454040569579L;
        public int consumerIndex;
        public final AtomicInteger producerIndex;

        public MpscFillOnceSimpleQueue(int i2) {
            super(i2);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void drop() {
            int i2 = this.consumerIndex;
            lazySet(i2, null);
            this.consumerIndex = i2 + 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            ObjectHelper.requireNonNull(t, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement < length()) {
                lazySet(andIncrement, t);
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public T peek() {
            int i2 = this.consumerIndex;
            if (i2 == length()) {
                return null;
            }
            return get(i2);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            int i2 = this.consumerIndex;
            if (i2 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t = get(i2);
                if (t != null) {
                    this.consumerIndex = i2 + 1;
                    lazySet(i2, null);
                    return t;
                }
            } while (atomicInteger.get() != i2);
            return null;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }
}
