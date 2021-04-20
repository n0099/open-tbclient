package io.reactivex.internal.operators.parallel;

import f.b.a0.a;
import f.b.w.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class ParallelCollect$ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    public static final long serialVersionUID = -4767392946044436228L;
    public C collection;
    public final b<? super C, ? super T> collector;
    public boolean done;

    public ParallelCollect$ParallelCollectSubscriber(c<? super C> cVar, C c2, b<? super C, ? super T> bVar) {
        super(cVar);
        this.collection = c2;
        this.collector = bVar;
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        C c2 = this.collection;
        this.collection = null;
        complete(c2);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.collection = null;
        this.actual.onError(th);
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: C, ? super C */
    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            this.collector.a((C) this.collection, t);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
