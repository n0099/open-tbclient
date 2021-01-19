package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes5.dex */
public abstract class b<T> implements Iterator<T> {
    private State qiL = State.NotReady;
    private T qiM;

    protected abstract void eIC();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qiL, State.Failed)) {
            switch (this.qiL) {
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
            this.qiL = State.NotReady;
            return this.qiM;
        }
        throw new NoSuchElementException();
    }

    private final boolean eIB() {
        this.qiL = State.Failed;
        eIC();
        return kotlin.jvm.internal.p.l(this.qiL, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bR(T t) {
        this.qiM = t;
        this.qiL = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qiL = State.Done;
    }
}
