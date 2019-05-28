package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kjM = State.NotReady;
    private T kjN;

    protected abstract void cJP();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.kjM, State.Failed)) {
            switch (this.kjM) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cJO();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kjM = State.NotReady;
            return this.kjN;
        }
        throw new NoSuchElementException();
    }

    private final boolean cJO() {
        this.kjM = State.Failed;
        cJP();
        return kotlin.jvm.internal.p.h(this.kjM, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bh(T t) {
        this.kjN = t;
        this.kjM = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kjM = State.Done;
    }
}
