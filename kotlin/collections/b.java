package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nPc = State.NotReady;
    private T nPd;

    protected abstract void dQk();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nPc != State.Failed) {
            switch (this.nPc) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dQj();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nPc = State.NotReady;
            return this.nPd;
        }
        throw new NoSuchElementException();
    }

    private final boolean dQj() {
        this.nPc = State.Failed;
        dQk();
        return this.nPc == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bI(T t) {
        this.nPd = t;
        this.nPc = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nPc = State.Done;
    }
}
