package io.reactivex.internal.subscribers;

import io.reactivex.internal.a.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes7.dex */
public abstract class b<T, R> implements d<R>, j<T> {
    protected final org.a.c<? super R> actual;
    protected boolean done;
    protected d<T> qs;
    protected org.a.d s;
    protected int sourceMode;

    public b(org.a.c<? super R> cVar) {
        this.actual = cVar;
    }

    @Override // io.reactivex.j, org.a.c
    public final void onSubscribe(org.a.d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            if (dVar instanceof d) {
                this.qs = (d) dVar;
            }
            if (dJk()) {
                this.actual.onSubscribe(this);
                dJl();
            }
        }
    }

    protected boolean dJk() {
        return true;
    }

    protected void dJl() {
    }

    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(Throwable th) {
        io.reactivex.exceptions.a.H(th);
        this.s.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int Nv(int i) {
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

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
        this.qs.clear();
    }

    @Override // io.reactivex.internal.a.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
