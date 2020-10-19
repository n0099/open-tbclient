package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class b<T> implements Iterator<T> {
    private State oRc = State.NotReady;
    private T oRd;

    protected abstract void enF();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.oRc != State.Failed) {
            switch (this.oRc) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return enE();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.oRc = State.NotReady;
            return this.oRd;
        }
        throw new NoSuchElementException();
    }

    private final boolean enE() {
        this.oRc = State.Failed;
        enF();
        return this.oRc == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bP(T t) {
        this.oRd = t;
        this.oRc = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.oRc = State.Done;
    }
}
