package io.reactivex.internal.operators.parallel;

import io.reactivex.b.c;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.Callable;
import org.a.d;
/* loaded from: classes3.dex */
public final class ParallelReduce<T, R> extends a<R> {
    final Callable<R> qgS;
    final a<? extends T> qiK;
    final c<R, ? super T, R> reducer;

    @Override // io.reactivex.parallel.a
    public void a(org.a.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            org.a.c<? super Object>[] cVarArr2 = new org.a.c[length];
            for (int i = 0; i < length; i++) {
                try {
                    cVarArr2[i] = new ParallelReduceSubscriber(cVarArr[i], io.reactivex.internal.functions.a.m(this.qgS.call(), "The initialSupplier returned a null value"), this.reducer);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.O(th);
                    a(cVarArr, th);
                    return;
                }
            }
            this.qiK.a(cVarArr2);
        }
    }

    void a(org.a.c<?>[] cVarArr, Throwable th) {
        for (org.a.c<?> cVar : cVarArr) {
            EmptySubscription.error(th, cVar);
        }
    }

    @Override // io.reactivex.parallel.a
    public int eLm() {
        return this.qiK.eLm();
    }

    /* loaded from: classes3.dex */
    static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final c<R, ? super T, R> reducer;

        ParallelReduceSubscriber(org.a.c<? super R> cVar, R r, c<R, ? super T, R> cVar2) {
            super(cVar);
            this.accumulator = r;
            this.reducer = cVar2;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.accumulator = (R) io.reactivex.internal.functions.a.m(this.reducer.apply(this.accumulator, t), "The reducer returned a null value");
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
            this.accumulator = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                R r = this.accumulator;
                this.accumulator = null;
                complete(r);
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
