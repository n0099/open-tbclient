package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nBD = State.NotReady;
    private T nBE;

    protected abstract void dJZ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nBD != State.Failed) {
            switch (this.nBD) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dJY();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nBD = State.NotReady;
            return this.nBE;
        }
        throw new NoSuchElementException();
    }

    private final boolean dJY() {
        this.nBD = State.Failed;
        dJZ();
        return this.nBD == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.nBE = t;
        this.nBD = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nBD = State.Done;
    }
}
