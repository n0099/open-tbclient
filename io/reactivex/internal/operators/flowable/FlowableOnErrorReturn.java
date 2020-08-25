package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class FlowableOnErrorReturn<T> extends a<T, T> {
    final h<? super Throwable, ? extends T> valueSupplier;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omB.a((j) new OnErrorReturnSubscriber(cVar, this.valueSupplier));
    }

    /* loaded from: classes7.dex */
    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final h<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnSubscriber(org.b.c<? super T> cVar, h<? super Throwable, ? extends T> hVar) {
            super(cVar);
            this.valueSupplier = hVar;
        }

        @Override // org.b.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            try {
                complete(io.reactivex.internal.functions.a.k(this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.b.c
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
