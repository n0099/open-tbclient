package io.reactivex.internal.subscribers;

import f.a.g;
import f.a.x.i.e;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class StrictSubscriber<T> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = -4945028590049415624L;
    public final c<? super T> actual;
    public volatile boolean done;
    public final AtomicThrowable error = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> s = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.s);
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        e.b(this.actual, this, this.error);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.done = true;
        e.d(this.actual, th, this, this.error);
    }

    @Override // g.d.c
    public void onNext(T t) {
        e.f(this.actual, t, this, this.error);
    }

    @Override // f.a.g, g.d.c
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

    @Override // g.d.d
    public void request(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
            return;
        }
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }
}
