package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes6.dex */
public abstract class b<T> implements Iterator<T> {
    private State qtp = State.NotReady;
    private T qtq;

    protected abstract void eLa();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qtp, State.Failed)) {
            switch (this.qtp) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eKZ();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.qtp = State.NotReady;
            return this.qtq;
        }
        throw new NoSuchElementException();
    }

    private final boolean eKZ() {
        this.qtp = State.Failed;
        eLa();
        return kotlin.jvm.internal.p.l(this.qtp, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.qtq = t;
        this.qtp = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qtp = State.Done;
    }
}
