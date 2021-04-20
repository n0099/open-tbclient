package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeEqualSingle$EqualObserver<T> extends AtomicReference<b> implements i<T> {
    public static final long serialVersionUID = -3031974433025990931L;
    public final MaybeEqualSingle$EqualCoordinator<T> parent;
    public Object value;

    public MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator<T> maybeEqualSingle$EqualCoordinator) {
        this.parent = maybeEqualSingle$EqualCoordinator;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.i
    public void onComplete() {
        this.parent.done();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.parent.error(this, th);
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        this.value = t;
        this.parent.done();
    }
}
