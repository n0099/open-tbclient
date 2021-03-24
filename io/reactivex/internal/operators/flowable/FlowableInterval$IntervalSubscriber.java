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
public final class FlowableInterval$IntervalSubscriber extends AtomicLong implements d, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final c<? super Long> actual;
    public long count;
    public final AtomicReference<b> resource = new AtomicReference<>();

    public FlowableInterval$IntervalSubscriber(c<? super Long> cVar) {
        this.actual = cVar;
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
            if (get() != 0) {
                c<? super Long> cVar = this.actual;
                long j = this.count;
                this.count = j + 1;
                cVar.onNext(Long.valueOf(j));
                f.a.x.i.b.e(this, 1L);
                return;
            }
            c<? super Long> cVar2 = this.actual;
            cVar2.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this.resource, bVar);
    }
}
