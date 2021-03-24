package io.reactivex.internal.operators.flowable;

import f.a.t.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements d, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final c<? super Long> actual;
    public long count;
    public final long end;
    public final AtomicReference<b> resource = new AtomicReference<>();

    public FlowableIntervalRange$IntervalRangeSubscriber(c<? super Long> cVar, long j, long j2) {
        this.actual = cVar;
        this.count = j;
        this.end = j2;
    }

    @Override // g.d.d
    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.a.x.i.b.a(this, j);
        }
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
            c<? super Long> cVar = this.actual;
            cVar.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this.resource, bVar);
    }
}
