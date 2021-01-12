package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State qiK = State.NotReady;
    private T qiL;

    protected abstract void eIC();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qiK, State.Failed)) {
            switch (this.qiK) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eIB();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.qiK = State.NotReady;
            return this.qiL;
        }
        throw new NoSuchElementException();
    }

    private final boolean eIB() {
        this.qiK = State.Failed;
        eIC();
        return kotlin.jvm.internal.p.l(this.qiK, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.qiL = t;
        this.qiK = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qiK = State.Done;
    }
}
