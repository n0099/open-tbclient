package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes17.dex */
public abstract class b<T> implements Iterator<T> {
    private State pJZ = State.NotReady;
    private T pKa;

    protected abstract void eDF();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.pJZ, State.Failed)) {
            switch (this.pJZ) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eDE();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.pJZ = State.NotReady;
            return this.pKa;
        }
        throw new NoSuchElementException();
    }

    private final boolean eDE() {
        this.pJZ = State.Failed;
        eDF();
        return kotlin.jvm.internal.p.l(this.pJZ, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bO(T t) {
        this.pKa = t;
        this.pJZ = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.pJZ = State.Done;
    }
}
