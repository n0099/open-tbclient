package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State iqC = State.NotReady;
    private T iqD;

    protected abstract void bZv();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.iqC, State.Failed)) {
            switch (this.iqC) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return bZu();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.iqC = State.NotReady;
            return this.iqD;
        }
        throw new NoSuchElementException();
    }

    private final boolean bZu() {
        this.iqC = State.Failed;
        bZv();
        return kotlin.jvm.internal.p.h(this.iqC, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aS(T t) {
        this.iqD = t;
        this.iqC = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.iqC = State.Done;
    }
}
