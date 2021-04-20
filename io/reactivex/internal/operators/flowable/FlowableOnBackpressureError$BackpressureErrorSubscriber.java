package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureError$BackpressureErrorSubscriber<T> extends AtomicLong implements g<T>, d {
    public static final long serialVersionUID = -3176480756392482682L;
    public final c<? super T> actual;
    public boolean done;
    public d s;

    public FlowableOnBackpressureError$BackpressureErrorSubscriber(c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            b.e(this, 1L);
            return;
        }
        onError(new MissingBackpressureException("could not emit value due to lack of requests"));
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this, j);
        }
    }
}
