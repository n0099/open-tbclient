package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State mXa = State.NotReady;
    private T mXb;

    protected abstract void dDz();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.mXa != State.Failed) {
            switch (this.mXa) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dDy();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.mXa = State.NotReady;
            return this.mXb;
        }
        throw new NoSuchElementException();
    }

    private final boolean dDy() {
        this.mXa = State.Failed;
        dDz();
        return this.mXa == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bA(T t) {
        this.mXb = t;
        this.mXa = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.mXa = State.Done;
    }
}
