package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.k;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableInterval extends io.reactivex.g<Long> {
    final long initialDelay;
    final long period;
    final v scheduler;
    final TimeUnit unit;

    public FlowableInterval(long j, long j2, TimeUnit timeUnit, v vVar) {
        this.initialDelay = j;
        this.period = j2;
        this.unit = timeUnit;
        this.scheduler = vVar;
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> cVar) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(cVar);
        cVar.onSubscribe(intervalSubscriber);
        v vVar = this.scheduler;
        if (vVar instanceof k) {
            v.c dPr = vVar.dPr();
            intervalSubscriber.setResource(dPr);
            dPr.b(intervalSubscriber, this.initialDelay, this.period, this.unit);
            return;
        }
        intervalSubscriber.setResource(vVar.a(intervalSubscriber, this.initialDelay, this.period, this.unit));
    }

    /* loaded from: classes7.dex */
    static final class IntervalSubscriber extends AtomicLong implements Runnable, org.a.d {
        private static final long serialVersionUID = -2809475196591179431L;
        final org.a.c<? super Long> actual;
        long count;
        final AtomicReference<io.reactivex.disposables.b> resource = new AtomicReference<>();

        IntervalSubscriber(org.a.c<? super Long> cVar) {
            this.actual = cVar;
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
                if (get() != 0) {
                    org.a.c<? super Long> cVar = this.actual;
                    long j = this.count;
                    this.count = j + 1;
                    cVar.onNext(Long.valueOf(j));
                    io.reactivex.internal.util.b.c(this, 1L);
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
