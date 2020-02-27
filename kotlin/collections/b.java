package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nBB = State.NotReady;
    private T nBC;

    protected abstract void dJX();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nBB != State.Failed) {
            switch (this.nBB) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dJW();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nBB = State.NotReady;
            return this.nBC;
        }
        throw new NoSuchElementException();
    }

    private final boolean dJW() {
        this.nBB = State.Failed;
        dJX();
        return this.nBB == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.nBC = t;
        this.nBB = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nBB = State.Done;
    }
}
