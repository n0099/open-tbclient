package io.reactivex.internal.operators.flowable;

import f.a.w.h;
import f.a.x.b.a;
import g.d.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
/* loaded from: classes7.dex */
public final class FlowableOnErrorReturn$OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    public static final long serialVersionUID = -3740826063558713822L;
    public final h<? super Throwable, ? extends T> valueSupplier;

    public FlowableOnErrorReturn$OnErrorReturnSubscriber(c<? super T> cVar, h<? super Throwable, ? extends T> hVar) {
        super(cVar);
        this.valueSupplier = hVar;
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onError(Throwable th) {
        try {
            T apply = this.valueSupplier.apply(th);
            a.b(apply, "The valueSupplier returned a null value");
            complete(apply);
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }
}
