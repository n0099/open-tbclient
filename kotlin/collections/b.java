package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
public abstract class b<T> implements Iterator<T> {
    private State osg = State.NotReady;
    private T osh;

    protected abstract void efW();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.osg != State.Failed) {
            switch (this.osg) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return efV();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.osg = State.NotReady;
            return this.osh;
        }
        throw new NoSuchElementException();
    }

    private final boolean efV() {
        this.osg = State.Failed;
        efW();
        return this.osg == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bK(T t) {
        this.osh = t;
        this.osg = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.osg = State.Done;
    }
}
