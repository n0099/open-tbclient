package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeZipArray$ZipMaybeObserver<T> extends AtomicReference<b> implements i<T> {
    public static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final MaybeZipArray$ZipCoordinator<T, ?> parent;

    public MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator<T, ?> maybeZipArray$ZipCoordinator, int i) {
        this.parent = maybeZipArray$ZipCoordinator;
        this.index = i;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.i
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.parent.innerError(th, this.index);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.parent.innerSuccess(t, this.index);
    }
}
