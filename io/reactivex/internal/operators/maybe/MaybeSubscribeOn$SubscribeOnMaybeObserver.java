package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeSubscribeOn$SubscribeOnMaybeObserver<T> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = 8571289934935992137L;
    public final i<? super T> actual;
    public final SequentialDisposable task = new SequentialDisposable();

    public MaybeSubscribeOn$SubscribeOnMaybeObserver(i<? super T> iVar) {
        this.actual = iVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.i
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
