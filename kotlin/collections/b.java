package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nXO = State.NotReady;
    private T nXP;

    protected abstract void dTK();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nXO != State.Failed) {
            switch (this.nXO) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dTJ();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nXO = State.NotReady;
            return this.nXP;
        }
        throw new NoSuchElementException();
    }

    private final boolean dTJ() {
        this.nXO = State.Failed;
        dTK();
        return this.nXO == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bI(T t) {
        this.nXP = t;
        this.nXO = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nXO = State.Done;
    }
}
