package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State qnm = State.NotReady;
    private T qnn;

    protected abstract void eMs();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qnm, State.Failed)) {
            switch (this.qnm) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eMr();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.qnm = State.NotReady;
            return this.qnn;
        }
        throw new NoSuchElementException();
    }

    private final boolean eMr() {
        this.qnm = State.Failed;
        eMs();
        return kotlin.jvm.internal.p.l(this.qnm, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.qnn = t;
        this.qnm = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qnm = State.Done;
    }
}
