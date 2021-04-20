package io.reactivex.internal.operators.observable;

import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.b.a;
import f.b.x.e.c.l;
import f.b.x.e.c.m;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimeout$TimeoutObserver<T, U, V> extends AtomicReference<b> implements o<T>, b, l {
    public static final long serialVersionUID = 2672739326310051084L;
    public final o<? super T> actual;
    public final n<U> firstTimeoutIndicator;
    public volatile long index;
    public final h<? super T, ? extends n<V>> itemTimeoutIndicator;
    public b s;

    public ObservableTimeout$TimeoutObserver(o<? super T> oVar, n<U> nVar, h<? super T, ? extends n<V>> hVar) {
        this.actual = oVar;
        this.firstTimeoutIndicator = nVar;
        this.itemTimeoutIndicator = hVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.s.dispose();
        }
    }

    @Override // f.b.x.e.c.l
    public void innerError(Throwable th) {
        this.s.dispose();
        this.actual.onError(th);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // f.b.o
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.actual.onComplete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        long j = this.index + 1;
        this.index = j;
        this.actual.onNext(t);
        b bVar = (b) get();
        if (bVar != null) {
            bVar.dispose();
        }
        try {
            n<V> apply = this.itemTimeoutIndicator.apply(t);
            a.b(apply, "The ObservableSource returned is null");
            n<V> nVar = apply;
            m mVar = new m(this, j);
            if (compareAndSet(bVar, mVar)) {
                nVar.subscribe(mVar);
            }
        } catch (Throwable th) {
            f.b.u.a.a(th);
            dispose();
            this.actual.onError(th);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            o<? super T> oVar = this.actual;
            n<U> nVar = this.firstTimeoutIndicator;
            if (nVar != null) {
                m mVar = new m(this, 0L);
                if (compareAndSet(null, mVar)) {
                    oVar.onSubscribe(this);
                    nVar.subscribe(mVar);
                    return;
                }
                return;
            }
            oVar.onSubscribe(this);
        }
    }

    @Override // f.b.x.e.c.l
    public void timeout(long j) {
        if (j == this.index) {
            dispose();
            this.actual.onError(new TimeoutException());
        }
    }
}
