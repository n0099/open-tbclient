package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.s;
import f.b.t.b;
import f.b.x.d.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDelayWithSingle$OtherObserver<T, U> extends AtomicReference<b> implements r<U>, b {
    public static final long serialVersionUID = -8565274649390031272L;
    public final r<? super T> actual;
    public final s<T> source;

    public SingleDelayWithSingle$OtherObserver(r<? super T> rVar, s<T> sVar) {
        this.actual = rVar;
        this.source = sVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.set(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(U u) {
        this.source.a(new c(this, this.actual));
    }
}
