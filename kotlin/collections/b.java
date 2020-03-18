package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nDB = State.NotReady;
    private T nDC;

    protected abstract void dKA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nDB != State.Failed) {
            switch (this.nDB) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dKz();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nDB = State.NotReady;
            return this.nDC;
        }
        throw new NoSuchElementException();
    }

    private final boolean dKz() {
        this.nDB = State.Failed;
        dKA();
        return this.nDB == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.nDC = t;
        this.nDB = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nDB = State.Done;
    }
}
