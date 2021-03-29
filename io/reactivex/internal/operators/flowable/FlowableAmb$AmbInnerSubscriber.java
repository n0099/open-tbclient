package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import f.a.x.e.a.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<d> implements g<T>, d {
    public static final long serialVersionUID = -1185974347409665484L;
    public final c<? super T> actual;
    public final int index;
    public final AtomicLong missedRequested = new AtomicLong();
    public final b<T> parent;
    public boolean won;

    public FlowableAmb$AmbInnerSubscriber(b<T> bVar, int i, c<? super T> cVar) {
        this.parent = bVar;
        this.index = i;
        this.actual = cVar;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.won) {
            this.actual.onComplete();
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onComplete();
        } else {
            get().cancel();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.won) {
            this.actual.onError(th);
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onError(th);
        } else {
            get().cancel();
            a.f(th);
        }
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.won) {
            this.actual.onNext(t);
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onNext(t);
        } else {
            get().cancel();
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, dVar);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
    }
}
