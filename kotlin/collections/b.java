package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State oBN = State.NotReady;
    private T oBO;

    protected abstract void ejT();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.oBN != State.Failed) {
            switch (this.oBN) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return ejS();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.oBN = State.NotReady;
            return this.oBO;
        }
        throw new NoSuchElementException();
    }

    private final boolean ejS() {
        this.oBN = State.Failed;
        ejT();
        return this.oBN == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bM(T t) {
        this.oBO = t;
        this.oBN = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.oBN = State.Done;
    }
}
