package io.reactivex.internal.operators.flowable;

import f.a.a0.a;
import f.a.k;
import g.d.c;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
/* loaded from: classes7.dex */
public final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, k<T>> {
    public static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(c<? super k<T>> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onComplete() {
        complete(k.a());
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
    public /* bridge */ /* synthetic */ void onDrop(Object obj) {
        onDrop((k) ((k) obj));
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onError(Throwable th) {
        complete(k.b(th));
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(k.c(t));
    }

    public void onDrop(k<T> kVar) {
        if (kVar.e()) {
            a.f(kVar.d());
        }
    }
}
