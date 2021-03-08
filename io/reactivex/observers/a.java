package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.d;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public abstract class a<T> implements io.reactivex.disposables.b, u<T> {
    final AtomicReference<io.reactivex.disposables.b> s = new AtomicReference<>();

    @Override // io.reactivex.u
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        if (d.a(this.s, bVar, getClass())) {
            onStart();
        }
    }

    protected void onStart() {
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.s.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.s);
    }
}
