package io.reactivex.internal.operators.flowable;

import io.reactivex.c.i;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public final class d<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    private final io.reactivex.c.g<? super org.b.d> onSubscribe;
    private final i ono;
    private final io.reactivex.c.a onp;

    public d(io.reactivex.g<T> gVar, io.reactivex.c.g<? super org.b.d> gVar2, i iVar, io.reactivex.c.a aVar) {
        super(gVar);
        this.onSubscribe = gVar2;
        this.ono = iVar;
        this.onp = aVar;
    }

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omT.a((j) new a(cVar, this.onSubscribe, this.ono, this.onp));
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements j<T>, org.b.d {
        final org.b.c<? super T> actual;
        final io.reactivex.c.g<? super org.b.d> onSubscribe;
        final i ono;
        final io.reactivex.c.a onp;
        org.b.d s;

        a(org.b.c<? super T> cVar, io.reactivex.c.g<? super org.b.d> gVar, i iVar, io.reactivex.c.a aVar) {
            this.actual = cVar;
            this.onSubscribe = gVar;
            this.onp = aVar;
            this.ono = iVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            try {
                this.onSubscribe.accept(dVar);
                if (SubscriptionHelper.validate(this.s, dVar)) {
                    this.s = dVar;
                    this.actual.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                dVar.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.actual);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onError(th);
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.b.c
        public void onComplete() {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onComplete();
            }
        }

        @Override // org.b.d
        public void request(long j) {
            try {
                this.ono.gM(j);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                io.reactivex.e.a.onError(th);
            }
            this.s.request(j);
        }

        @Override // org.b.d
        public void cancel() {
            try {
                this.onp.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                io.reactivex.e.a.onError(th);
            }
            this.s.cancel();
        }
    }
}
