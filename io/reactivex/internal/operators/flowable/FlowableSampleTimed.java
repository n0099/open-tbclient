package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSampleTimed<T> extends a<T, T> {
    final boolean onK;
    final long period;
    final v scheduler;
    final TimeUnit unit;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        if (this.onK) {
            this.omT.a((j) new SampleTimedEmitLast(bVar, this.period, this.unit, this.scheduler));
        } else {
            this.omT.a((j) new SampleTimedNoLast(bVar, this.period, this.unit, this.scheduler));
        }
    }

    /* loaded from: classes7.dex */
    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements j<T>, Runnable, org.b.d {
        private static final long serialVersionUID = -3517602651313910099L;
        final org.b.c<? super T> actual;
        final long period;
        org.b.d s;
        final v scheduler;
        final TimeUnit unit;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable timer = new SequentialDisposable();

        abstract void complete();

        SampleTimedSubscriber(org.b.c<? super T> cVar, long j, TimeUnit timeUnit, v vVar) {
            this.actual = cVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = vVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                this.timer.replace(this.scheduler.a(this, this.period, this.period, this.unit));
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            cancelTimer();
            complete();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // org.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
            }
        }

        @Override // org.b.d
        public void cancel() {
            cancelTimer();
            this.s.cancel();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(andSet);
                    io.reactivex.internal.util.b.c(this.requested, 1L);
                    return;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(org.b.c<? super T> cVar, long j, TimeUnit timeUnit, v vVar) {
            super(cVar, j, timeUnit, vVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* loaded from: classes7.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(org.b.c<? super T> cVar, long j, TimeUnit timeUnit, v vVar) {
            super(cVar, j, timeUnit, vVar);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }
}
