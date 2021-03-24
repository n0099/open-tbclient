package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableReplay$InnerDisposable<T> extends AtomicInteger implements b {
    public static final long serialVersionUID = 2728361546769921047L;
    public volatile boolean cancelled;
    public final o<? super T> child;
    public Object index;
    public final ObservableReplay$ReplayObserver<T> parent;

    public ObservableReplay$InnerDisposable(ObservableReplay$ReplayObserver<T> observableReplay$ReplayObserver, o<? super T> oVar) {
        this.parent = observableReplay$ReplayObserver;
        this.child = oVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.parent.remove(this);
    }

    public <U> U index() {
        return (U) this.index;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }
}
