package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
/* loaded from: classes25.dex */
public abstract class a<T, R> implements io.reactivex.internal.a.b<R>, u<T> {
    protected final u<? super R> actual;
    protected boolean done;
    protected io.reactivex.internal.a.b<T> owv;
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
                this.owv = (io.reactivex.internal.a.b) bVar;
            }
            if (ejg()) {
                this.actual.onSubscribe(this);
                ejh();
            }
        }
    }

    protected boolean ejg() {
        return true;
    }

    protected void ejh() {
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
    public final int Or(int i) {
        io.reactivex.internal.a.b<T> bVar = this.owv;
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
        return this.owv.isEmpty();
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
        this.owv.clear();
    }

    @Override // io.reactivex.internal.a.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
