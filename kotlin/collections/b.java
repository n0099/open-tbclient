package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State nAZ = State.NotReady;
    private T nBa;

    protected abstract void dIQ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nAZ != State.Failed) {
            switch (this.nAZ) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dIP();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nAZ = State.NotReady;
            return this.nBa;
        }
        throw new NoSuchElementException();
    }

    private final boolean dIP() {
        this.nAZ = State.Failed;
        dIQ();
        return this.nAZ == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bQ(T t) {
        this.nBa = t;
        this.nAZ = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nAZ = State.Done;
    }
}
