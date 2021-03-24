package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.s;
import f.a.t.b;
import f.a.x.d.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDelayWithCompletable$OtherObserver<T> extends AtomicReference<b> implements f.a.b, b {
    public static final long serialVersionUID = -8565274649390031272L;
    public final r<? super T> actual;
    public final s<T> source;

    public SingleDelayWithCompletable$OtherObserver(r<? super T> rVar, s<T> sVar) {
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

    @Override // f.a.b
    public void onComplete() {
        this.source.a(new c(this, this.actual));
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.b
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }
}
