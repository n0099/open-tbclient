package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.a.e;
import f.b.x.e.c.l;
import f.b.x.e.c.m;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimeout$TimeoutOtherObserver<T, U, V> extends AtomicReference<b> implements o<T>, b, l {
    public static final long serialVersionUID = -1957813281749686898L;
    public final o<? super T> actual;
    public final e<T> arbiter;
    public boolean done;
    public final n<U> firstTimeoutIndicator;
    public volatile long index;
    public final h<? super T, ? extends n<V>> itemTimeoutIndicator;
    public final n<? extends T> other;
    public b s;

    public ObservableTimeout$TimeoutOtherObserver(o<? super T> oVar, n<U> nVar, h<? super T, ? extends n<V>> hVar, n<? extends T> nVar2) {
        this.actual = oVar;
        this.firstTimeoutIndicator = nVar;
        this.itemTimeoutIndicator = hVar;
        this.other = nVar2;
        this.arbiter = new e<>(oVar, this, 8);
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
        if (this.done) {
            return;
        }
        this.done = true;
        dispose();
        this.arbiter.c(this.s);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        dispose();
        this.arbiter.d(th, this.s);
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index + 1;
        this.index = j;
        if (this.arbiter.e(t, this.s)) {
            b bVar = (b) get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                n<V> apply = this.itemTimeoutIndicator.apply(t);
                f.b.x.b.a.b(apply, "The ObservableSource returned is null");
                n<V> nVar = apply;
                m mVar = new m(this, j);
                if (compareAndSet(bVar, mVar)) {
                    nVar.subscribe(mVar);
                }
            } catch (Throwable th) {
                f.b.u.a.a(th);
                this.actual.onError(th);
            }
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.arbiter.f(bVar);
            o<? super T> oVar = this.actual;
            n<U> nVar = this.firstTimeoutIndicator;
            if (nVar != null) {
                m mVar = new m(this, 0L);
                if (compareAndSet(null, mVar)) {
                    oVar.onSubscribe(this.arbiter);
                    nVar.subscribe(mVar);
                    return;
                }
                return;
            }
            oVar.onSubscribe(this.arbiter);
        }
    }

    @Override // f.b.x.e.c.l
    public void timeout(long j) {
        if (j == this.index) {
            dispose();
            this.other.subscribe(new f.b.x.d.a(this.arbiter));
        }
    }
}
