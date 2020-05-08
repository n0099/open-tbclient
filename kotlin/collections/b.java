package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.h
/* loaded from: classes7.dex */
public abstract class b<T> implements Iterator<T> {
    private State mXd = State.NotReady;
    private T mXe;

    protected abstract void dDv();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.mXd != State.Failed) {
            switch (this.mXd) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dDu();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.mXd = State.NotReady;
            return this.mXe;
        }
        throw new NoSuchElementException();
    }

    private final boolean dDu() {
        this.mXd = State.Failed;
        dDv();
        return this.mXd == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bB(T t) {
        this.mXe = t;
        this.mXd = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.mXd = State.Done;
    }
}
