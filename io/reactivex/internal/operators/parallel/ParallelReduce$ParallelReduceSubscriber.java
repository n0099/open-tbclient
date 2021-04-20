package io.reactivex.internal.operators.parallel;

import f.b.a0.a;
import f.b.w.c;
import g.d.d;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    public static final long serialVersionUID = 8200530050639449080L;
    public R accumulator;
    public boolean done;
    public final c<R, ? super T, R> reducer;

    public ParallelReduce$ParallelReduceSubscriber(g.d.c<? super R> cVar, R r, c<R, ? super T, R> cVar2) {
        super(cVar);
        this.accumulator = r;
        this.reducer = cVar2;
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
        R r = this.accumulator;
        this.accumulator = null;
        complete(r);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.accumulator = null;
        this.actual.onError(th);
    }

    @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            R apply = this.reducer.apply(this.accumulator, t);
            f.b.x.b.a.b(apply, "The reducer returned a null value");
            this.accumulator = apply;
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
