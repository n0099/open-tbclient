package io.reactivex.internal.disposables;

import f.a.t.b;
import f.a.u.a;
import f.a.w.f;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CancellableDisposable extends AtomicReference<f> implements b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f fVar) {
        super(fVar);
    }

    @Override // f.a.t.b
    public void dispose() {
        f andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            a.a(e2);
            f.a.a0.a.f(e2);
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == null;
    }
}
