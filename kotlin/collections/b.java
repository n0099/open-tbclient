package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes20.dex */
public abstract class b<T> implements Iterator<T> {
    private State orO = State.NotReady;
    private T orP;

    protected abstract void efN();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.orO != State.Failed) {
            switch (this.orO) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return efM();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.orO = State.NotReady;
            return this.orP;
        }
        throw new NoSuchElementException();
    }

    private final boolean efM() {
        this.orO = State.Failed;
        efN();
        return this.orO == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bK(T t) {
        this.orP = t;
        this.orO = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.orO = State.Done;
    }
}
