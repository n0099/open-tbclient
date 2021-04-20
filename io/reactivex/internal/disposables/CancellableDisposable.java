package io.reactivex.internal.disposables;

import f.b.t.b;
import f.b.u.a;
import f.b.w.f;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CancellableDisposable extends AtomicReference<f> implements b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // f.b.t.b
    public void dispose() {
        f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            a.a(e2);
            f.b.a0.a.f(e2);
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == null;
    }
}
