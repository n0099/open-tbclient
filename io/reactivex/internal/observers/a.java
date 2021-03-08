package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
/* loaded from: classes6.dex */
public abstract class a<T, R> implements io.reactivex.internal.a.b<R>, u<T> {
    protected final u<? super R> actual;
    protected boolean done;
    protected io.reactivex.internal.a.b<T> qoP;
    protected io.reactivex.disposables.b s;
    protected int sourceMode;

    public a(u<? super R> uVar) {
        this.actual = uVar;
    }

    @Override // io.reactivex.u
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            if (bVar instanceof io.reactivex.internal.a.b) {
                this.qoP = (io.reactivex.internal.a.b) bVar;
            }
            if (eKb()) {
                this.actual.onSubscribe(this);
                eKc();
            }
        }
    }

    protected boolean eKb() {
        return true;
    }

    protected void eKc() {
    }

    @Override // io.reactivex.u
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
        this.s.dispose();
        onError(th);
    }

    @Override // io.reactivex.u
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int Sj(int i) {
        io.reactivex.internal.a.b<T> bVar = this.qoP;
        if (bVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i);
        if (requestFusion != 0) {
            this.sourceMode = requestFusion;
            return requestFusion;
        }
        return requestFusion;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.s.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return this.qoP.isEmpty();
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        this.qoP.clear();
    }

    @Override // io.reactivex.internal.a.f
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
