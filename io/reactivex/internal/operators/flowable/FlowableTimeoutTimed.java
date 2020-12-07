package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes9.dex */
public final class FlowableTimeoutTimed<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final org.a.b<? extends T> pFA;
    final v scheduler;
    final long timeout;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface b {
        void onTimeout(long j);
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        if (this.pFA == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(cVar, this.timeout, this.unit, this.scheduler.eCV());
            cVar.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startTimeout(0L);
            this.pFg.a((j) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(cVar, this.timeout, this.unit, this.scheduler.eCV(), this.pFA);
        cVar.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startTimeout(0L);
        this.pFg.a((j) timeoutFallbackSubscriber);
    }

    /* loaded from: classes9.dex */
    static final class TimeoutSubscriber<T> extends AtomicLong implements b, j<T>, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.a.c<? super T> actual;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        TimeoutSubscriber(org.a.c<? super T> cVar, long j, TimeUnit timeUnit, v.c cVar2) {
            this.actual = cVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE && compareAndSet(j, j + 1)) {
                this.task.get().dispose();
                this.actual.onNext(t);
                startTimeout(j + 1);
            }
        }

        void startTimeout(long j) {
            this.task.replace(this.worker.c(new c(j, this), this.timeout, this.unit));
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onError(th);
                this.worker.dispose();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
                this.worker.dispose();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class c implements Runnable {
        final long idx;
        final b pFX;

        c(long j, b bVar) {
            this.idx = j;
            this.pFX = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.pFX.onTimeout(this.idx);
        }
    }

    /* loaded from: classes9.dex */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements b, j<T> {
        private static final long serialVersionUID = 3764492702657003550L;
        final org.a.c<? super T> actual;
        long consumed;
        org.a.b<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final v.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        TimeoutFallbackSubscriber(org.a.c<? super T> cVar, long j, TimeUnit timeUnit, v.c cVar2, org.a.b<? extends T> bVar) {
            this.actual = cVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar2;
            this.fallback = bVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
                setSubscription(dVar);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE && this.index.compareAndSet(j, j + 1)) {
                this.task.get().dispose();
                this.consumed++;
                this.actual.onNext(t);
                startTimeout(j + 1);
            }
        }

        void startTimeout(long j) {
            this.task.replace(this.worker.c(new c(j, this), this.timeout, this.unit));
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onError(th);
                this.worker.dispose();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.actual.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                long j2 = this.consumed;
                if (j2 != 0) {
                    produced(j2);
                }
                org.a.b<? extends T> bVar = this.fallback;
                this.fallback = null;
                bVar.subscribe(new a(this.actual, this));
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.a.d
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }
    }

    /* loaded from: classes9.dex */
    static final class a<T> implements j<T> {
        final org.a.c<? super T> actual;
        final SubscriptionArbiter pFW;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(org.a.c<? super T> cVar, SubscriptionArbiter subscriptionArbiter) {
            this.actual = cVar;
            this.pFW = subscriptionArbiter;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            this.pFW.setSubscription(dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
