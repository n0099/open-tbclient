package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.s;
import f.a.t.b;
import f.a.x.d.c;
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

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.set(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.r
    public void onSuccess(U u) {
        this.source.a(new c(this, this.actual));
    }
}
