package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes7.dex */
public final class FlowableSingle$SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements g<T> {
    public static final long serialVersionUID = -5526049321428043809L;
    public final T defaultValue;
    public boolean done;
    public d s;

    public FlowableSingle$SingleElementSubscriber(c<? super T> cVar, T t) {
        super(cVar);
        this.defaultValue = t;
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
        T t = this.value;
        this.value = null;
        if (t == null) {
            t = this.defaultValue;
        }
        if (t == null) {
            this.actual.onComplete();
        } else {
            complete(t);
        }
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
        if (this.value != null) {
            this.done = true;
            this.s.cancel();
            this.actual.onError(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.value = t;
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
