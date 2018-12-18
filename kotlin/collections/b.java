package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State ixM = State.NotReady;
    private T ixN;

    protected abstract void cbA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.ixM, State.Failed)) {
            switch (this.ixM) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cbz();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.ixM = State.NotReady;
            return this.ixN;
        }
        throw new NoSuchElementException();
    }

    private final boolean cbz() {
        this.ixM = State.Failed;
        cbA();
        return kotlin.jvm.internal.p.h(this.ixM, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aT(T t) {
        this.ixN = t;
        this.ixM = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.ixM = State.Done;
    }
}
