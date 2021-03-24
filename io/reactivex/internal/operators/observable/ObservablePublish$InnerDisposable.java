package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.x.e.c.g;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservablePublish$InnerDisposable<T> extends AtomicReference<Object> implements b {
    public static final long serialVersionUID = -1100270633763673112L;
    public final o<? super T> child;

    public ObservablePublish$InnerDisposable(o<? super T> oVar) {
        this.child = oVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        Object andSet = getAndSet(this);
        if (andSet == null || andSet == this) {
            return;
        }
        ((g) andSet).a(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == this;
    }

    public void setParent(g<T> gVar) {
        if (compareAndSet(null, gVar)) {
            return;
        }
        gVar.a(this);
    }
}
