package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kjL = State.NotReady;
    private T kjM;

    protected abstract void cJN();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.kjL, State.Failed)) {
            switch (this.kjL) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cJM();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kjL = State.NotReady;
            return this.kjM;
        }
        throw new NoSuchElementException();
    }

    private final boolean cJM() {
        this.kjL = State.Failed;
        cJN();
        return kotlin.jvm.internal.p.h(this.kjL, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bh(T t) {
        this.kjM = t;
        this.kjL = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kjL = State.Done;
    }
}
