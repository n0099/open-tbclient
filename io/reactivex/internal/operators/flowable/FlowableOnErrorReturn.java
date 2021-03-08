package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.j;
/* loaded from: classes6.dex */
public final class FlowableOnErrorReturn<T> extends a<T, T> {
    final h<? super Throwable, ? extends T> valueSupplier;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.qoY.a((j) new OnErrorReturnSubscriber(cVar, this.valueSupplier));
    }

    /* loaded from: classes6.dex */
    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final h<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnSubscriber(org.a.c<? super T> cVar, h<? super Throwable, ? extends T> hVar) {
            super(cVar);
            this.valueSupplier = hVar;
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            try {
                complete(io.reactivex.internal.functions.a.n(this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.N(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
