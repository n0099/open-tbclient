package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableCollect<T, U> extends a<T, U> {
    final io.reactivex.b.b<? super U, ? super T> collector;
    final Callable<? extends U> qdZ;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super U> cVar) {
        try {
            this.qdR.a((j) new CollectSubscriber(cVar, io.reactivex.internal.functions.a.m(this.qdZ.call(), "The initial value supplied is null"), this.collector));
        } catch (Throwable th) {
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes5.dex */
    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements j<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final io.reactivex.b.b<? super U, ? super T> collector;
        boolean done;
        d s;
        final U u;

        CollectSubscriber(org.a.c<? super U> cVar, U u, io.reactivex.b.b<? super U, ? super T> bVar) {
            super(cVar);
            this.collector = bVar;
            this.u = u;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
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
                    io.reactivex.exceptions.a.O(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
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
