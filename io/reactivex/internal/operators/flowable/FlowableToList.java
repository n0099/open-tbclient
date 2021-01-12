package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableToList<T, U extends Collection<? super T>> extends a<T, U> {
    final Callable<U> qeJ;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super U> cVar) {
        try {
            this.qdR.a((j) new ToListSubscriber(cVar, (Collection) io.reactivex.internal.functions.a.m(this.qeJ.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes5.dex */
    static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements j<T>, d {
        private static final long serialVersionUID = -8134157938864266736L;
        d s;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: U extends java.util.Collection<? super T> */
        /* JADX WARN: Multi-variable type inference failed */
        ToListSubscriber(org.a.c<? super U> cVar, U u) {
            super(cVar);
            this.value = u;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            Collection collection = (Collection) this.value;
            if (collection != null) {
                collection.add(t);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.value = null;
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            complete(this.value);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }
    }
}
