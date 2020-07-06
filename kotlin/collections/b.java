package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State nPf = State.NotReady;
    private T nPg;

    protected abstract void dQo();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nPf != State.Failed) {
            switch (this.nPf) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dQn();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.nPf = State.NotReady;
            return this.nPg;
        }
        throw new NoSuchElementException();
    }

    private final boolean dQn() {
        this.nPf = State.Failed;
        dQo();
        return this.nPf == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bI(T t) {
        this.nPg = t;
        this.nPf = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.nPf = State.Done;
    }
}
