package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes25.dex */
public class StrictSubscriber<T> extends AtomicInteger implements j<T>, d {
    private static final long serialVersionUID = -4945028590049415624L;
    final org.a.c<? super T> actual;
    volatile boolean done;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<d> s = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(org.a.c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // org.a.d
    public void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
            return;
        }
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }

    @Override // org.a.d
    public void cancel() {
        if (!this.done) {
            SubscriptionHelper.cancel(this.s);
        }
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
            return;
        }
        dVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // org.a.c
    public void onNext(T t) {
        e.a(this.actual, t, this, this.error);
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        this.done = true;
        e.a((org.a.c<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    @Override // org.a.c
    public void onComplete() {
        this.done = true;
        e.a(this.actual, this, this.error);
    }
}
