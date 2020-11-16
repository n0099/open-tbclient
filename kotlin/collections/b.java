package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes9.dex */
public abstract class b<T> implements Iterator<T> {
    private State pTw = State.NotReady;
    private T pTx;

    protected abstract void eBu();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.pTw != State.Failed) {
            switch (this.pTw) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eBt();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.pTw = State.NotReady;
            return this.pTx;
        }
        throw new NoSuchElementException();
    }

    private final boolean eBt() {
        this.pTw = State.Failed;
        eBu();
        return this.pTw == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bU(T t) {
        this.pTx = t;
        this.pTw = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.pTw = State.Done;
    }
}
