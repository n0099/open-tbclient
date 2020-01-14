package io.reactivex.internal.operators.flowable;

import io.reactivex.c.i;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes5.dex */
public final class d<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    private final i nwj;
    private final io.reactivex.c.a nwk;
    private final io.reactivex.c.g<? super org.a.d> onSubscribe;

    public d(io.reactivex.g<T> gVar, io.reactivex.c.g<? super org.a.d> gVar2, i iVar, io.reactivex.c.a aVar) {
        super(gVar);
        this.onSubscribe = gVar2;
        this.nwj = iVar;
        this.nwk = aVar;
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nvP.a((j) new a(cVar, this.onSubscribe, this.nwj, this.nwk));
    }

    /* loaded from: classes5.dex */
    static final class a<T> implements j<T>, org.a.d {
        final org.a.c<? super T> actual;
        final i nwj;
        final io.reactivex.c.a nwk;
        final io.reactivex.c.g<? super org.a.d> onSubscribe;
        org.a.d s;

        a(org.a.c<? super T> cVar, io.reactivex.c.g<? super org.a.d> gVar, i iVar, io.reactivex.c.a aVar) {
            this.actual = cVar;
            this.onSubscribe = gVar;
            this.nwk = aVar;
            this.nwj = iVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            try {
                this.onSubscribe.accept(dVar);
                if (SubscriptionHelper.validate(this.s, dVar)) {
                    this.s = dVar;
                    this.actual.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                dVar.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.actual);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onComplete();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            try {
                this.nwj.he(j);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                io.reactivex.e.a.onError(th);
            }
            this.s.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            try {
                this.nwk.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                io.reactivex.e.a.onError(th);
            }
            this.s.cancel();
        }
    }
}
