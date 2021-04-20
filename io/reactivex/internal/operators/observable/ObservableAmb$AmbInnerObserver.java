package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableAmb$AmbInnerObserver<T> extends AtomicReference<b> implements o<T> {
    public static final long serialVersionUID = -1185974347409665484L;
    public final o<? super T> actual;
    public final int index;
    public final f.b.x.e.c.b<T> parent;
    public boolean won;

    public ObservableAmb$AmbInnerObserver(f.b.x.e.c.b<T> bVar, int i, o<? super T> oVar) {
        this.parent = bVar;
        this.index = i;
        this.actual = oVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.won) {
            this.actual.onComplete();
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onComplete();
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.won) {
            this.actual.onError(th);
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onError(th);
        } else {
            a.f(th);
        }
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.won) {
            this.actual.onNext(t);
        } else if (this.parent.a(this.index)) {
            this.won = true;
            this.actual.onNext(t);
        } else {
            get().dispose();
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
