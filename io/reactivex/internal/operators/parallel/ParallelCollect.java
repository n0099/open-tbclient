package io.reactivex.internal.operators.parallel;

import io.reactivex.b.b;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.Callable;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public final class ParallelCollect<T, C> extends a<C> {
    final b<? super C, ? super T> collector;
    final a<? extends T> qfR;
    final Callable<? extends C> qfS;

    @Override // io.reactivex.parallel.a
    public void a(c<? super C>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            c<? super Object>[] cVarArr2 = new c[length];
            for (int i = 0; i < length; i++) {
                try {
                    cVarArr2[i] = new ParallelCollectSubscriber(cVarArr[i], io.reactivex.internal.functions.a.m(this.qfS.call(), "The initialSupplier returned a null value"), this.collector);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.O(th);
                    a(cVarArr, th);
                    return;
                }
            }
            this.qfR.a(cVarArr2);
        }
    }

    void a(c<?>[] cVarArr, Throwable th) {
        for (c<?> cVar : cVarArr) {
            EmptySubscription.error(th, cVar);
        }
    }

    @Override // io.reactivex.parallel.a
    public int eIa() {
        return this.qfR.eIa();
    }

    /* loaded from: classes5.dex */
    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final b<? super C, ? super T> collector;
        boolean done;

        ParallelCollectSubscriber(c<? super C> cVar, C c, b<? super C, ? super T> bVar) {
            super(cVar);
            this.collection = c;
            this.collector = bVar;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: C, ? super C */
        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.i((C) this.collection, t);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.O(th);
                    cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.d.a.onError(th);
                return;
            }
            this.done = true;
            this.collection = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c = this.collection;
                this.collection = null;
                complete(c);
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
