package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimeout<T, U, V> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final h<? super T, ? extends org.a.b<V>> itemTimeoutIndicator;
    final org.a.b<U> nKO;
    final org.a.b<? extends T> nKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a extends FlowableTimeoutTimed.b {
        void onTimeoutError(long j, Throwable th);
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        if (this.nKt == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(cVar, this.itemTimeoutIndicator);
            cVar.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startFirstTimeout(this.nKO);
            this.nJT.a((j) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(cVar, this.itemTimeoutIndicator, this.nKt);
        cVar.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startFirstTimeout(this.nKO);
        this.nJT.a((j) timeoutFallbackSubscriber);
    }

    /* loaded from: classes7.dex */
    static final class TimeoutSubscriber<T> extends AtomicLong implements a, j<T>, org.a.d {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.a.c<? super T> actual;
        final h<? super T, ? extends org.a.b<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<org.a.d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        TimeoutSubscriber(org.a.c<? super T> cVar, h<? super T, ? extends org.a.b<?>> hVar) {
            this.actual = cVar;
            this.itemTimeoutIndicator = hVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE && compareAndSet(j, j + 1)) {
                io.reactivex.disposables.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.actual.onNext(t);
                try {
                    org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.k(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                    TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j + 1, this);
                    if (this.task.replace(timeoutConsumer)) {
                        bVar2.subscribe(timeoutConsumer);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    this.upstream.get().cancel();
                    getAndSet(Long.MAX_VALUE);
                    this.actual.onError(th);
                }
            }
        }

        void startFirstTimeout(org.a.b<?> bVar) {
            if (bVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    bVar.subscribe(timeoutConsumer);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.a
        public void onTimeoutError(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }
    }

    /* loaded from: classes7.dex */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements a, j<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.a.c<? super T> actual;
        long consumed;
        org.a.b<? extends T> fallback;
        final h<? super T, ? extends org.a.b<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<org.a.d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        TimeoutFallbackSubscriber(org.a.c<? super T> cVar, h<? super T, ? extends org.a.b<?>> hVar, org.a.b<? extends T> bVar) {
            this.actual = cVar;
            this.itemTimeoutIndicator = hVar;
            this.fallback = bVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                setSubscription(dVar);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE && this.index.compareAndSet(j, j + 1)) {
                io.reactivex.disposables.b bVar = this.task.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.consumed++;
                this.actual.onNext(t);
                try {
                    org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.k(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                    TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j + 1, this);
                    if (this.task.replace(timeoutConsumer)) {
                        bVar2.subscribe(timeoutConsumer);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    this.upstream.get().cancel();
                    this.index.getAndSet(Long.MAX_VALUE);
                    this.actual.onError(th);
                }
            }
        }

        void startFirstTimeout(org.a.b<?> bVar) {
            if (bVar != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.replace(timeoutConsumer)) {
                    bVar.subscribe(timeoutConsumer);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onError(th);
                this.task.dispose();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onComplete();
                this.task.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                org.a.b<? extends T> bVar = this.fallback;
                this.fallback = null;
                long j2 = this.consumed;
                if (j2 != 0) {
                    produced(j2);
                }
                bVar.subscribe(new FlowableTimeoutTimed.a(this.actual, this));
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.a
        public void onTimeoutError(long j, Throwable th) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.a.d
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class TimeoutConsumer extends AtomicReference<org.a.d> implements io.reactivex.disposables.b, j<Object> {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final a parent;

        TimeoutConsumer(long j, a aVar) {
            this.idx = j;
            this.parent = aVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            org.a.d dVar = (org.a.d) get();
            if (dVar != SubscriptionHelper.CANCELLED) {
                dVar.cancel();
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.onTimeoutError(this.idx, th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(get());
        }
    }
}
