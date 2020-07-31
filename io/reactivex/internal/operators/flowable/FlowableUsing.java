package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class FlowableUsing<T, D> extends io.reactivex.g<T> {
    final io.reactivex.c.g<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> nSC;
    final h<? super D, ? extends org.a.b<? extends T>> nTE;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        try {
            D call = this.nSC.call();
            try {
                ((org.a.b) io.reactivex.internal.functions.a.k(this.nTE.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(cVar, call, this.disposer, this.eager));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                try {
                    this.disposer.accept(call);
                    EmptySubscription.error(th, cVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.K(th2);
                    EmptySubscription.error(new CompositeException(th, th2), cVar);
                }
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.K(th3);
            EmptySubscription.error(th3, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class UsingSubscriber<T, D> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = 5904473792286235046L;
        final org.a.c<? super T> actual;
        final io.reactivex.c.g<? super D> disposer;
        final boolean eager;
        final D resource;
        org.a.d s;

        UsingSubscriber(org.a.c<? super T> cVar, D d, io.reactivex.c.g<? super D> gVar, boolean z) {
            this.actual = cVar;
            this.resource = d;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: D, ? super D */
        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.eager) {
                Throwable th2 = null;
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th3) {
                        th2 = th3;
                        io.reactivex.exceptions.a.K(th2);
                    }
                }
                this.s.cancel();
                if (th2 != null) {
                    this.actual.onError(new CompositeException(th, th2));
                    return;
                } else {
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onError(th);
            this.s.cancel();
            disposeAfter();
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: D, ? super D */
        @Override // org.a.c
        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept((D) this.resource);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.K(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.s.cancel();
                this.actual.onComplete();
                return;
            }
            this.actual.onComplete();
            this.s.cancel();
            disposeAfter();
        }

        @Override // org.a.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            disposeAfter();
            this.s.cancel();
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: D, ? super D */
        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.K(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }
    }
}
