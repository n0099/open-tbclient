package io.reactivex.internal.operators.flowable;

import f.a.t.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableTimer$TimerSubscriber extends AtomicReference<b> implements d, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final c<? super Long> actual;
    public volatile boolean requested;

    public FlowableTimer$TimerSubscriber(c<? super Long> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.requested = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != DisposableHelper.DISPOSED) {
            if (this.requested) {
                this.actual.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.actual.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.actual.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
