package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.j;
import io.reactivex.p;
/* loaded from: classes17.dex */
public final class FlowableMaterialize<T> extends a<T, p<T>> {
    @Override // io.reactivex.g
    protected void a(org.a.c<? super p<T>> cVar) {
        this.pDq.a((j) new MaterializeSubscriber(cVar));
    }

    /* loaded from: classes17.dex */
    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, p<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        protected /* bridge */ /* synthetic */ void onDrop(Object obj) {
            onDrop((p) ((p) obj));
        }

        MaterializeSubscriber(org.a.c<? super p<T>> cVar) {
            super(cVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(p.bL(t));
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            complete(p.I(th));
        }

        @Override // org.a.c
        public void onComplete() {
            complete(p.ewK());
        }

        protected void onDrop(p<T> pVar) {
            if (pVar.ewI()) {
                io.reactivex.e.a.onError(pVar.ewJ());
            }
        }
    }
}
