package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class b<T> implements Iterator<T> {
    private State pRT = State.NotReady;
    private T pRU;

    protected abstract void eBt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.pRT != State.Failed) {
            switch (this.pRT) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eBs();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.pRT = State.NotReady;
            return this.pRU;
        }
        throw new NoSuchElementException();
    }

    private final boolean eBs() {
        this.pRT = State.Failed;
        eBt();
        return this.pRT == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bT(T t) {
        this.pRU = t;
        this.pRT = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.pRT = State.Done;
    }
}
