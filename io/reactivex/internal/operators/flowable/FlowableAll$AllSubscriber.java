package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.w.i;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableAll$AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements g<T> {
    public static final long serialVersionUID = -3521127104134758517L;
    public boolean done;
    public final i<? super T> predicate;
    public d s;

    public FlowableAll$AllSubscriber(c<? super Boolean> cVar, i<? super T> iVar) {
        super(cVar);
        this.predicate = iVar;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        super.cancel();
        this.s.cancel();
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        complete(Boolean.TRUE);
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
        try {
            if (this.predicate.test(t)) {
                return;
            }
            this.done = true;
            this.s.cancel();
            complete(Boolean.FALSE);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
