package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State ntp = State.NotReady;
    private T ntq;

    protected abstract void dLE();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.ntp != State.Failed) {
            switch (this.ntp) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dLD();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.ntp = State.NotReady;
            return this.ntq;
        }
        throw new NoSuchElementException();
    }

    private final boolean dLD() {
        this.ntp = State.Failed;
        dLE();
        return this.ntp == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bH(T t) {
        this.ntq = t;
        this.ntp = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.ntp = State.Done;
    }
}
