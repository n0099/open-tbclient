package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.j;
import f.b.t.b;
import f.b.x.e.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeDelayWithCompletable$OtherObserver<T> extends AtomicReference<b> implements f.b.b, b {
    public static final long serialVersionUID = 703409937383992161L;
    public final i<? super T> actual;
    public final j<T> source;

    public MaybeDelayWithCompletable$OtherObserver(i<? super T> iVar, j<T> jVar) {
        this.actual = iVar;
        this.source = jVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.b
    public void onComplete() {
        this.source.a(new a(this, this.actual));
    }

    @Override // f.b.b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.b
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }
}
