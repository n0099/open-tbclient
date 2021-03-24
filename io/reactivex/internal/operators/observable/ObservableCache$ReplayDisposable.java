package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.x.e.c.c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableCache$ReplayDisposable<T> extends AtomicInteger implements b {
    public static final long serialVersionUID = 7058506693698832024L;
    public volatile boolean cancelled;
    public final o<? super T> child;
    public Object[] currentBuffer;
    public int currentIndexInBuffer;
    public int index;
    public final c<T> state;

    public ObservableCache$ReplayDisposable(o<? super T> oVar, c<T> cVar) {
        this.child = oVar;
        this.state = cVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.state.b(this);
        throw null;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void replay() {
        if (getAndIncrement() == 0 && !this.cancelled) {
            this.state.a();
            throw null;
        }
    }
}
