package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nsf = State.NotReady;
    private T nsg;

    protected abstract void dLq();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nsf != State.Failed) {
            switch (this.nsf) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dLp();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nsf = State.NotReady;
            return this.nsg;
        }
        throw new NoSuchElementException();
    }

    private final boolean dLp() {
        this.nsf = State.Failed;
        dLq();
        return this.nsf == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bH(T t) {
        this.nsg = t;
        this.nsf = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nsf = State.Done;
    }
}
