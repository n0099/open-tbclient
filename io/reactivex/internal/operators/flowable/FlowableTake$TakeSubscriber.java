package io.reactivex.internal.operators.flowable;

import f.a.g;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class FlowableTake$TakeSubscriber<T> extends AtomicBoolean implements g<T>, d {
    public static final long serialVersionUID = -5636543848937116287L;
    public final c<? super T> actual;
    public boolean done;
    public final long limit;
    public long remaining;
    public d subscription;

    public FlowableTake$TakeSubscriber(c<? super T> cVar, long j) {
        this.actual = cVar;
        this.limit = j;
        this.remaining = j;
    }

    @Override // g.d.d
    public void cancel() {
        this.subscription.cancel();
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
            return;
        }
        this.done = true;
        this.subscription.cancel();
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.remaining;
        long j2 = j - 1;
        this.remaining = j2;
        if (j > 0) {
            boolean z = j2 == 0;
            this.actual.onNext(t);
            if (z) {
                this.subscription.cancel();
                onComplete();
            }
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.subscription, dVar)) {
            this.subscription = dVar;
            if (this.limit == 0) {
                dVar.cancel();
                this.done = true;
                EmptySubscription.complete(this.actual);
                return;
            }
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            if (!get() && compareAndSet(false, true) && j >= this.limit) {
                this.subscription.request(Long.MAX_VALUE);
            } else {
                this.subscription.request(j);
            }
        }
    }
}
