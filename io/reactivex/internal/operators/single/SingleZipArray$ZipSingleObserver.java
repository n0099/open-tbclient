package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleZipArray$ZipSingleObserver<T> extends AtomicReference<b> implements r<T> {
    public static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final SingleZipArray$ZipCoordinator<T, ?> parent;

    public SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator<T, ?> singleZipArray$ZipCoordinator, int i) {
        this.parent = singleZipArray$ZipCoordinator;
        this.index = i;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.parent.innerError(th, this.index);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        this.parent.innerSuccess(t, this.index);
    }
}
