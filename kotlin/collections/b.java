package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kjP = State.NotReady;
    private T kjQ;

    protected abstract void cJO();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.kjP, State.Failed)) {
            switch (this.kjP) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cJN();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kjP = State.NotReady;
            return this.kjQ;
        }
        throw new NoSuchElementException();
    }

    private final boolean cJN() {
        this.kjP = State.Failed;
        cJO();
        return kotlin.jvm.internal.p.h(this.kjP, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bh(T t) {
        this.kjQ = t;
        this.kjP = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kjP = State.Done;
    }
}
