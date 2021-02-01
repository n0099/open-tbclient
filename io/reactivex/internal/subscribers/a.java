package io.reactivex.internal.subscribers;

import io.reactivex.internal.a.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes5.dex */
public abstract class a<T, R> implements io.reactivex.internal.a.a<T>, d<R> {
    protected final io.reactivex.internal.a.a<? super R> actual;
    protected boolean done;
    protected d<T> qs;
    protected org.a.d s;
    protected int sourceMode;

    public a(io.reactivex.internal.a.a<? super R> aVar) {
        this.actual = aVar;
    }

    @Override // io.reactivex.j, org.a.c
    public final void onSubscribe(org.a.d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof d) {
                this.qs = (d) dVar;
            }
            if (eKl()) {
                this.actual.onSubscribe(this);
                eKm();
            }
        }
    }

    protected boolean eKl() {
        return true;
    }

    protected void eKm() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O(Throwable th) {
        io.reactivex.exceptions.a.N(th);
        this.s.cancel();
        onError(th);
    }

    @Override // org.a.c
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int Sj(int i) {
        d<T> dVar = this.qs;
        if (dVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = dVar.requestFusion(i);
        if (requestFusion != 0) {
            this.sourceMode = requestFusion;
            return requestFusion;
        }
        return requestFusion;
    }

    @Override // org.a.d
    public void request(long j) {
        this.s.request(j);
    }

    @Override // org.a.d
    public void cancel() {
        this.s.cancel();
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.internal.a.f
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
