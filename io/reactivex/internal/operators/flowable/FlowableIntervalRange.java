package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.k;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class FlowableIntervalRange extends io.reactivex.g<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final v scheduler;
    final long start;
    final TimeUnit unit;

    public FlowableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, v vVar) {
        this.initialDelay = j3;
        this.period = j4;
        this.unit = timeUnit;
        this.scheduler = vVar;
        this.start = j;
        this.end = j2;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> cVar) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(cVar, this.start, this.end);
        cVar.onSubscribe(intervalRangeSubscriber);
        v vVar = this.scheduler;
        if (vVar instanceof k) {
            v.c eAB = vVar.eAB();
            intervalRangeSubscriber.setResource(eAB);
            eAB.b(intervalRangeSubscriber, this.initialDelay, this.period, this.unit);
            return;
        }
        intervalRangeSubscriber.setResource(vVar.a(intervalRangeSubscriber, this.initialDelay, this.period, this.unit));
    }

    /* loaded from: classes5.dex */
    static final class IntervalRangeSubscriber extends AtomicLong implements Runnable, org.a.d {
        private static final long serialVersionUID = -2809475196591179431L;
        final org.a.c<? super Long> actual;
        long count;
        final long end;
        final AtomicReference<io.reactivex.disposables.b> resource = new AtomicReference<>();

        IntervalRangeSubscriber(org.a.c<? super Long> cVar, long j, long j2) {
            this.actual = cVar;
            this.count = j;
            this.end = j2;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // org.a.d
        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.resource.get() != DisposableHelper.DISPOSED) {
                long j = get();
                if (j != 0) {
                    long j2 = this.count;
                    this.actual.onNext(Long.valueOf(j2));
                    if (j2 == this.end) {
                        if (this.resource.get() != DisposableHelper.DISPOSED) {
                            this.actual.onComplete();
                        }
                        DisposableHelper.dispose(this.resource);
                        return;
                    }
                    this.count = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                this.actual.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                DisposableHelper.dispose(this.resource);
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.resource, bVar);
        }
    }
}
