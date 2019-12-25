package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
public abstract class b<T> implements Iterator<T> {
    private State mYB = State.NotReady;
    private T mYC;

    protected abstract void dEy();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.mYB, State.Failed)) {
            switch (this.mYB) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return dEx();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.mYB = State.NotReady;
            return this.mYC;
        }
        throw new NoSuchElementException();
    }

    private final boolean dEx() {
        this.mYB = State.Failed;
        dEy();
        return kotlin.jvm.internal.p.h(this.mYB, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bM(T t) {
        this.mYC = t;
        this.mYB = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.mYB = State.Done;
    }
}
