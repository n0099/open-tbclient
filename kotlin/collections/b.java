package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes17.dex */
public abstract class b<T> implements Iterator<T> {
    private State pKb = State.NotReady;
    private T pKc;

    protected abstract void eDG();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.pKb, State.Failed)) {
            switch (this.pKb) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eDF();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.pKb = State.NotReady;
            return this.pKc;
        }
        throw new NoSuchElementException();
    }

    private final boolean eDF() {
        this.pKb = State.Failed;
        eDG();
        return kotlin.jvm.internal.p.l(this.pKb, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bO(T t) {
        this.pKc = t;
        this.pKb = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.pKb = State.Done;
    }
}
