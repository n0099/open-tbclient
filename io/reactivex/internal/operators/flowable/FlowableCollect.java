package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class FlowableCollect<T, U> extends a<T, U> {
    final io.reactivex.c.b<? super U, ? super T> collector;
    final Callable<? extends U> nnd;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super U> cVar) {
        try {
            this.nmU.a((j) new CollectSubscriber(cVar, io.reactivex.internal.functions.a.k(this.nnd.call(), "The initial value supplied is null"), this.collector));
        } catch (Throwable th) {
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements j<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final io.reactivex.c.b<? super U, ? super T> collector;
        boolean done;
        org.a.d s;
        final U u;

        CollectSubscriber(org.a.c<? super U> cVar, U u, io.reactivex.c.b<? super U, ? super T> bVar) {
            super(cVar);
            this.collector = bVar;
            this.u = u;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: U, ? super U */
        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.i((U) this.u, t);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                complete(this.u);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
