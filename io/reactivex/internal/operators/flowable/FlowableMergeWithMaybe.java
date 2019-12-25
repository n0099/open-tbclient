package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
import io.reactivex.internal.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes4.dex */
public final class FlowableMergeWithMaybe<T> extends a<T, T> {
    final o<? extends T> other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(cVar);
        cVar.onSubscribe(mergeWithObserver);
        this.mTG.a((j) mergeWithObserver);
        this.other.a(mergeWithObserver.otherObserver);
    }

    /* loaded from: classes4.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements j<T>, d {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        int consumed;
        long emitted;
        volatile boolean mainDone;
        volatile int otherState;
        volatile e<T> queue;
        T singleItem;
        final AtomicReference<d> mainSubscription = new AtomicReference<>();
        final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final int prefetch = g.dDL();
        final int limit = this.prefetch - (this.prefetch >> 2);

        MergeWithObserver(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.setOnce(this.mainSubscription, dVar, this.prefetch);
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    e<T> eVar = this.queue;
                    if (eVar == null || eVar.isEmpty()) {
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
                        eVar.offer(t);
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
            io.reactivex.d.a.onError(th);
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
            io.reactivex.d.a.onError(th);
        }

        void otherComplete() {
            this.otherState = 2;
            drain();
        }

        e<T> getOrCreateQueue() {
            e<T> eVar = this.queue;
            if (eVar == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(g.dDL());
                this.queue = spscArrayQueue;
                return spscArrayQueue;
            }
            return eVar;
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
                            e<T> eVar = this.queue;
                            Object obj = eVar != null ? (Object) eVar.poll() : (Object) null;
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
                        e<T> eVar2 = this.queue;
                        boolean z4 = eVar2 == null || eVar2.isEmpty();
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

        /* loaded from: classes4.dex */
        static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.m
            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }

            @Override // io.reactivex.m
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
