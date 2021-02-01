package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
public abstract class b<T> implements Iterator<T> {
    private State qsP = State.NotReady;
    private T qsQ;

    protected abstract void eKS();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qsP, State.Failed)) {
            switch (this.qsP) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eKR();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.qsP = State.NotReady;
            return this.qsQ;
        }
        throw new NoSuchElementException();
    }

    private final boolean eKR() {
        this.qsP = State.Failed;
        eKS();
        return kotlin.jvm.internal.p.l(this.qsP, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.qsQ = t;
        this.qsP = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qsP = State.Done;
    }
}
