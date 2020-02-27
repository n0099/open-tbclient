package io.reactivex.internal.operators.flowable;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableMergeWithSingle<T> extends a<T, T> {
    final aa<? extends T> other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(cVar);
        cVar.onSubscribe(mergeWithObserver);
        this.nwr.a((j) mergeWithObserver);
        this.other.a(mergeWithObserver.otherObserver);
    }

    /* loaded from: classes7.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements j<T>, org.a.d {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        int consumed;
        long emitted;
        volatile boolean mainDone;
        volatile int otherState;
        volatile io.reactivex.internal.a.f<T> queue;
        T singleItem;
        final AtomicReference<org.a.d> mainSubscription = new AtomicReference<>();
        final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final int prefetch = io.reactivex.g.dJa();
        final int limit = this.prefetch - (this.prefetch >> 2);

        MergeWithObserver(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.setOnce(this.mainSubscription, dVar, this.prefetch);
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    io.reactivex.internal.a.f<T> fVar = this.queue;
                    if (fVar == null || fVar.isEmpty()) {
                        this.emitted = j + 1;
                        this.actual.onNext(t);
                        int i = this.consumed + 1;
                        if (i == this.limit) {
                            this.consumed = 0;
                            this.mainSubscription.get().request(i);
                        } else {
                            this.consumed = i;
                        }
                    } else {
                        fVar.offer(t);
                    }
                } else {
                    getOrCreateQueue().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                SubscriptionHelper.cancel(this.mainSubscription);
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // org.a.d
        public void request(long j) {
            io.reactivex.internal.util.b.a(this.requested, j);
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    this.emitted = j + 1;
                    this.actual.onNext(t);
                    this.otherState = 2;
                } else {
                    this.singleItem = t;
                    this.otherState = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        void otherError(Throwable th) {
            if (this.error.addThrowable(th)) {
                SubscriptionHelper.cancel(this.mainSubscription);
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        io.reactivex.internal.a.f<T> getOrCreateQueue() {
            io.reactivex.internal.a.f<T> fVar = this.queue;
            if (fVar == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(io.reactivex.g.dJa());
                this.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return fVar;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX DEBUG: Type inference failed for r4v16. Raw type applied. Possible types: T, ? super T */
        void drainLoop() {
            org.a.c<? super T> cVar = this.actual;
            int i = 1;
            long j = this.emitted;
            int i2 = this.consumed;
            int i3 = this.limit;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    } else if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        cVar.onError(this.error.terminate());
                        return;
                    } else {
                        int i4 = this.otherState;
                        if (i4 == 1) {
                            this.singleItem = null;
                            this.otherState = 2;
                            cVar.onNext((T) this.singleItem);
                            j++;
                        } else {
                            boolean z = this.mainDone;
                            io.reactivex.internal.a.f<T> fVar = this.queue;
                            Object obj = fVar != null ? (Object) fVar.poll() : (Object) null;
                            boolean z2 = obj == null;
                            if (z && z2 && i4 == 2) {
                                this.queue = null;
                                cVar.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                cVar.onNext(obj);
                                long j3 = 1 + j;
                                i2++;
                                if (i2 == i3) {
                                    this.mainSubscription.get().request(i3);
                                    i2 = 0;
                                }
                                j = j3;
                            }
                        }
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    } else if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        cVar.onError(this.error.terminate());
                        return;
                    } else {
                        boolean z3 = this.mainDone;
                        io.reactivex.internal.a.f<T> fVar2 = this.queue;
                        boolean z4 = fVar2 == null || fVar2.isEmpty();
                        if (z3 && z4 && this.otherState == 2) {
                            this.queue = null;
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                this.consumed = i2;
                i = addAndGet(-i);
            } while (i != 0);
        }

        /* loaded from: classes7.dex */
        static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements y<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }
        }
    }
}
