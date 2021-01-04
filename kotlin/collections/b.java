package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State qlE = State.NotReady;
    private T qlF;

    protected abstract void eLO();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qlE, State.Failed)) {
            switch (this.qlE) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eLN();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.qlE = State.NotReady;
            return this.qlF;
        }
        throw new NoSuchElementException();
    }

    private final boolean eLN() {
        this.qlE = State.Failed;
        eLO();
        return kotlin.jvm.internal.p.l(this.qlE, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bQ(T t) {
        this.qlF = t;
        this.qlE = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qlE = State.Done;
    }
}
