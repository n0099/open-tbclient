package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nXQ = State.NotReady;
    private T nXR;

    protected abstract void dTL();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nXQ != State.Failed) {
            switch (this.nXQ) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dTK();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nXQ = State.NotReady;
            return this.nXR;
        }
        throw new NoSuchElementException();
    }

    private final boolean dTK() {
        this.nXQ = State.Failed;
        dTL();
        return this.nXQ == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bI(T t) {
        this.nXR = t;
        this.nXQ = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nXQ = State.Done;
    }
}
