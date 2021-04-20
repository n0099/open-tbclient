package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class FlowableElementAt$ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements g<T> {
    public static final long serialVersionUID = 4066607327284737757L;
    public long count;
    public final T defaultValue;
    public boolean done;
    public final boolean errorOnFewer;
    public final long index;
    public d s;

    public FlowableElementAt$ElementAtSubscriber(c<? super T> cVar, long j, T t, boolean z) {
        super(cVar);
        this.index = j;
        this.defaultValue = t;
        this.errorOnFewer = z;
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
        T t = this.defaultValue;
        if (t == null) {
            if (this.errorOnFewer) {
                this.actual.onError(new NoSuchElementException());
                return;
            } else {
                this.actual.onComplete();
                return;
            }
        }
        complete(t);
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
        long j = this.count;
        if (j == this.index) {
            this.done = true;
            this.s.cancel();
            complete(t);
            return;
        }
        this.count = j + 1;
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
