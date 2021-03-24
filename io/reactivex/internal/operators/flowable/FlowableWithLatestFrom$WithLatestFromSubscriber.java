package io.reactivex.internal.operators.flowable;

import f.a.x.c.a;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements a<T>, d {
    public static final long serialVersionUID = -312246233408980075L;
    public final c<? super R> actual;
    public final f.a.w.c<? super T, ? super U, ? extends R> combiner;
    public final AtomicReference<d> s = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<d> other = new AtomicReference<>();

    public FlowableWithLatestFrom$WithLatestFromSubscriber(c<? super R> cVar, f.a.w.c<? super T, ? super U, ? extends R> cVar2) {
        this.actual = cVar;
        this.combiner = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.s);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // g.d.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (tryOnNext(t)) {
            return;
        }
        this.s.get().request(1L);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
    }

    public void otherError(Throwable th) {
        SubscriptionHelper.cancel(this.s);
        this.actual.onError(th);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }

    public boolean setOther(d dVar) {
        return SubscriptionHelper.setOnce(this.other, dVar);
    }

    @Override // f.a.x.c.a
    public boolean tryOnNext(T t) {
        U u = get();
        if (u != null) {
            try {
                R apply = this.combiner.apply(t, u);
                f.a.x.b.a.b(apply, "The combiner returned a null value");
                this.actual.onNext(apply);
                return true;
            } catch (Throwable th) {
                f.a.u.a.a(th);
                cancel();
                this.actual.onError(th);
            }
        }
        return false;
    }
}
