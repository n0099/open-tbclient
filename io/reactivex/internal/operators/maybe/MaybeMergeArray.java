package io.reactivex.internal.operators.maybe;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.a.c;
/* loaded from: classes5.dex */
public final class MaybeMergeArray<T> extends g<T> {
    final o<? extends T>[] sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a<T> extends io.reactivex.internal.a.g<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.a, io.reactivex.internal.a.g
        T poll();

        int producerIndex();
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        a clqSimpleQueue;
        o[] oVarArr = this.sources;
        int length = oVarArr.length;
        if (length <= dHR()) {
            clqSimpleQueue = new MpscFillOnceSimpleQueue(length);
        } else {
            clqSimpleQueue = new ClqSimpleQueue();
        }
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(cVar, length, clqSimpleQueue);
        cVar.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
        for (o oVar : oVarArr) {
            if (!mergeMaybeObserver.isCancelled() && atomicThrowable.get() == null) {
                oVar.a(mergeMaybeObserver);
            } else {
                return;
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements m<T> {
        private static final long serialVersionUID = -660395290758764731L;
        final c<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        boolean outputFused;
        final a<Object> queue;
        final int sourceCount;
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable error = new AtomicThrowable();

        MergeMaybeObserver(c<? super T> cVar, int i, a<Object> aVar) {
            this.actual = cVar;
            this.sourceCount = i;
            this.queue = aVar;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            T t;
            do {
                t = (T) this.queue.poll();
            } while (t == NotificationLite.COMPLETE);
            return t;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.queue.clear();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.set.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.set.a(bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.set.dispose();
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        void drainNormal() {
            c<? super T> cVar = this.actual;
            a<Object> aVar = this.queue;
            long j = this.consumed;
            int i = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = j;
                while (j3 != j2) {
                    if (this.cancelled) {
                        aVar.clear();
                        return;
                    } else if (this.error.get() != null) {
                        aVar.clear();
                        cVar.onError(this.error.terminate());
                        return;
                    } else if (aVar.consumerIndex() == this.sourceCount) {
                        cVar.onComplete();
                        return;
                    } else {
                        Object poll = aVar.poll();
                        if (poll == null) {
                            break;
                        } else if (poll != NotificationLite.COMPLETE) {
                            cVar.onNext(poll);
                            j3++;
                        }
                    }
                }
                if (j3 == j2) {
                    if (this.error.get() != null) {
                        aVar.clear();
                        cVar.onError(this.error.terminate());
                        return;
                    }
                    while (aVar.peek() == NotificationLite.COMPLETE) {
                        aVar.drop();
                    }
                    if (aVar.consumerIndex() == this.sourceCount) {
                        cVar.onComplete();
                        return;
                    }
                }
                this.consumed = j3;
                int addAndGet = addAndGet(-i);
                if (addAndGet == 0) {
                    return;
                }
                i = addAndGet;
                j = j3;
            }
        }

        void drainFused() {
            c<? super T> cVar = this.actual;
            a<Object> aVar = this.queue;
            int i = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    aVar.clear();
                    cVar.onError(th);
                    return;
                }
                boolean z = aVar.producerIndex() == this.sourceCount;
                if (!aVar.isEmpty()) {
                    cVar.onNext(null);
                }
                if (z) {
                    cVar.onComplete();
                    return;
                }
                int addAndGet = addAndGet(-i);
                if (addAndGet == 0) {
                    return;
                }
                i = addAndGet;
            }
            aVar.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements a<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        MpscFillOnceSimpleQueue(int i) {
            super(i);
            this.producerIndex = new AtomicInteger();
        }

        @Override // io.reactivex.internal.a.g
        public boolean offer(T t) {
            io.reactivex.internal.functions.a.h(t, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement < length()) {
                lazySet(andIncrement, t);
                return true;
            }
            return false;
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a, java.util.Queue, io.reactivex.internal.a.g
        public T poll() {
            int i = this.consumerIndex;
            if (i == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t = get(i);
                if (t != null) {
                    this.consumerIndex = i + 1;
                    lazySet(i, null);
                    return t;
                }
            } while (atomicInteger.get() != i);
            return null;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public T peek() {
            int i = this.consumerIndex;
            if (i == length()) {
                return null;
            }
            return get(i);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public void drop() {
            int i = this.consumerIndex;
            lazySet(i, null);
            this.consumerIndex = i + 1;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int producerIndex() {
            return this.producerIndex.get();
        }
    }

    /* loaded from: classes5.dex */
    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements a<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        ClqSimpleQueue() {
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.a.g
        public boolean offer(T t) {
            this.producerIndex.getAndIncrement();
            return super.offer(t);
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.a, io.reactivex.internal.a.g
        public T poll() {
            T t = (T) super.poll();
            if (t != null) {
                this.consumerIndex++;
            }
            return t;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public void drop() {
            poll();
        }
    }
}
