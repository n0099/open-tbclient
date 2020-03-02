package io.reactivex.internal.operators.flowable;

import io.reactivex.c.i;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class d<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    private final i nwN;
    private final io.reactivex.c.a nwO;
    private final io.reactivex.c.g<? super org.a.d> onSubscribe;

    public d(io.reactivex.g<T> gVar, io.reactivex.c.g<? super org.a.d> gVar2, i iVar, io.reactivex.c.a aVar) {
        super(gVar);
        this.onSubscribe = gVar2;
        this.nwN = iVar;
        this.nwO = aVar;
    }

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nwt.a((j) new a(cVar, this.onSubscribe, this.nwN, this.nwO));
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements j<T>, org.a.d {
        final org.a.c<? super T> actual;
        final i nwN;
        final io.reactivex.c.a nwO;
        final io.reactivex.c.g<? super org.a.d> onSubscribe;
        org.a.d s;

        a(org.a.c<? super T> cVar, io.reactivex.c.g<? super org.a.d> gVar, i iVar, io.reactivex.c.a aVar) {
            this.actual = cVar;
            this.onSubscribe = gVar;
            this.nwO = aVar;
            this.nwN = iVar;
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
                io.reactivex.exceptions.a.H(th);
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
                this.nwN.hc(j);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                io.reactivex.e.a.onError(th);
            }
            this.s.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            try {
                this.nwO.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                io.reactivex.e.a.onError(th);
            }
            this.s.cancel();
        }
    }
}
