package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class CancellableDisposable extends AtomicReference<io.reactivex.c.f> implements io.reactivex.disposables.b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(io.reactivex.c.f fVar) {
        super(fVar);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        io.reactivex.c.f andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                io.reactivex.exceptions.a.J(e);
                io.reactivex.e.a.onError(e);
            }
        }
    }
}
