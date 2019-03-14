package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State jSa = State.NotReady;
    private T jSb;

    protected abstract void cCr();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.jSa, State.Failed)) {
            switch (this.jSa) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cCq();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.jSa = State.NotReady;
            return this.jSb;
        }
        throw new NoSuchElementException();
    }

    private final boolean cCq() {
        this.jSa = State.Failed;
        cCr();
        return kotlin.jvm.internal.p.h(this.jSa, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bj(T t) {
        this.jSb = t;
        this.jSa = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.jSa = State.Done;
    }
}
