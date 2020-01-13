package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State nAU = State.NotReady;
    private T nAV;

    protected abstract void dIO();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nAU != State.Failed) {
            switch (this.nAU) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dIN();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nAU = State.NotReady;
            return this.nAV;
        }
        throw new NoSuchElementException();
    }

    private final boolean dIN() {
        this.nAU = State.Failed;
        dIO();
        return this.nAU == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bQ(T t) {
        this.nAV = t;
        this.nAU = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nAU = State.Done;
    }
}
