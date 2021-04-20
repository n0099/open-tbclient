package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.g;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureDrop$BackpressureDropSubscriber<T> extends AtomicLong implements g<T>, d {
    public static final long serialVersionUID = -6246093802440953054L;
    public final c<? super T> actual;
    public boolean done;
    public final f.b.w.g<? super T> onDrop;
    public d s;

    public FlowableOnBackpressureDrop$BackpressureDropSubscriber(c<? super T> cVar, f.b.w.g<? super T> gVar) {
        this.actual = cVar;
        this.onDrop = gVar;
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
        try {
            this.onDrop.accept(t);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            cancel();
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

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this, j);
        }
    }
}
