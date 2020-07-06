package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSequenceEqual<T> extends io.reactivex.g<Boolean> {
    final io.reactivex.c.d<? super T, ? super T> comparer;
    final org.a.b<? extends T> nKP;
    final org.a.b<? extends T> nKQ;
    final int prefetch;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void drain();

        void innerError(Throwable th);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Boolean> cVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(cVar, this.prefetch, this.comparer);
        cVar.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.nKP, this.nKQ);
    }

    /* loaded from: classes7.dex */
    static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements a {
        private static final long serialVersionUID = -6178010334400373240L;
        final io.reactivex.c.d<? super T, ? super T> comparer;
        final AtomicThrowable error;
        final EqualSubscriber<T> first;
        final EqualSubscriber<T> second;
        T v1;
        T v2;
        final AtomicInteger wip;

        EqualCoordinator(org.a.c<? super Boolean> cVar, int i, io.reactivex.c.d<? super T, ? super T> dVar) {
            super(cVar);
            this.comparer = dVar;
            this.wip = new AtomicInteger();
            this.first = new EqualSubscriber<>(this, i);
            this.second = new EqualSubscriber<>(this, i);
            this.error = new AtomicThrowable();
        }

        void subscribe(org.a.b<? extends T> bVar, org.a.b<? extends T> bVar2) {
            bVar.subscribe(this.first);
            bVar2.subscribe(this.second);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.first.cancel();
            this.second.cancel();
            if (this.wip.getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (true) {
                io.reactivex.internal.a.g<T> gVar = this.first.queue;
                io.reactivex.internal.a.g<T> gVar2 = this.second.queue;
                if (gVar != null && gVar2 != null) {
                    while (!isCancelled()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.v1;
                        if (t == null) {
                            try {
                                t = gVar.poll();
                                this.v1 = t;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.L(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        T t2 = t;
                        boolean z2 = t2 == null;
                        boolean z3 = this.second.done;
                        T t3 = this.v2;
                        if (t3 == null) {
                            try {
                                t3 = gVar2.poll();
                                this.v2 = t3;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.L(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        T t4 = t3;
                        boolean z4 = t4 == null;
                        if (z && z3 && z2 && z4) {
                            complete(true);
                            return;
                        } else if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            complete(false);
                            return;
                        } else if (!z2 && !z4) {
                            try {
                                if (!this.comparer.j(t2, t4)) {
                                    cancelAndClear();
                                    complete(false);
                                    return;
                                }
                                this.v1 = null;
                                this.v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.L(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isCancelled()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.actual.onError(this.error.terminate());
                    return;
                }
                int addAndGet = this.wip.addAndGet(-i);
                if (addAndGet == 0) {
                    return;
                }
                i = addAndGet;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                io.reactivex.e.a.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class EqualSubscriber<T> extends AtomicReference<org.a.d> implements j<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        volatile boolean done;
        final int limit;
        final a parent;
        final int prefetch;
        long produced;
        volatile io.reactivex.internal.a.g<T> queue;
        int sourceMode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EqualSubscriber(a aVar, int i) {
            this.parent = aVar;
            this.limit = i - (i >> 2);
            this.prefetch = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = dVar2;
                        dVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                dVar.request(this.prefetch);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException());
            } else {
                this.parent.drain();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void request() {
            if (this.sourceMode != 1) {
                long j = 1 + this.produced;
                if (j >= this.limit) {
                    this.produced = 0L;
                    get().request(j);
                    return;
                }
                this.produced = j;
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            io.reactivex.internal.a.g<T> gVar = this.queue;
            if (gVar != null) {
                gVar.clear();
            }
        }
    }
}
