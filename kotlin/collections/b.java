package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nBO = State.NotReady;
    private T nBP;

    protected abstract void dKa();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nBO != State.Failed) {
            switch (this.nBO) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dJZ();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nBO = State.NotReady;
            return this.nBP;
        }
        throw new NoSuchElementException();
    }

    private final boolean dJZ() {
        this.nBO = State.Failed;
        dKa();
        return this.nBO == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.nBP = t;
        this.nBO = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nBO = State.Done;
    }
}
