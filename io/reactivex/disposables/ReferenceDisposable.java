package io.reactivex.disposables;

import f.a.t.b;
import f.a.x.b.a;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    public static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(T t) {
        super(t);
        a.b(t, "value is null");
    }

    @Override // f.a.t.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // f.a.t.b
    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(T t);
}
