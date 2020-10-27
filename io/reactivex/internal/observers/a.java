package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
/* loaded from: classes17.dex */
public abstract class a<T, R> implements io.reactivex.internal.a.b<R>, u<T> {
    protected final u<? super R> actual;
    protected boolean done;
    protected io.reactivex.internal.a.b<T> pDh;
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
                this.pDh = (io.reactivex.internal.a.b) bVar;
            }
            if (ewR()) {
                this.actual.onSubscribe(this);
                ewS();
            }
        }
    }

    protected boolean ewR() {
        return true;
    }

    protected void ewS() {
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.e.a.onError(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(Throwable th) {
        io.reactivex.exceptions.a.J(th);
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
    public final int QO(int i) {
        io.reactivex.internal.a.b<T> bVar = this.pDh;
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

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return this.pDh.isEmpty();
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
        this.pDh.clear();
    }

    @Override // io.reactivex.internal.a.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
