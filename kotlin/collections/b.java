package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class b<T> implements Iterator<T> {
    private T pIA;
    private State pIz = State.NotReady;

    protected abstract void exE();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.pIz != State.Failed) {
            switch (this.pIz) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return exD();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.pIz = State.NotReady;
            return this.pIA;
        }
        throw new NoSuchElementException();
    }

    private final boolean exD() {
        this.pIz = State.Failed;
        exE();
        return this.pIz == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bT(T t) {
        this.pIA = t;
        this.pIz = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.pIz = State.Done;
    }
}
