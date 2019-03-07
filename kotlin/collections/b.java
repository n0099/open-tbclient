package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State jRP = State.NotReady;
    private T jRQ;

    protected abstract void cCe();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.jRP, State.Failed)) {
            switch (this.jRP) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cCd();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.jRP = State.NotReady;
            return this.jRQ;
        }
        throw new NoSuchElementException();
    }

    private final boolean cCd() {
        this.jRP = State.Failed;
        cCe();
        return kotlin.jvm.internal.p.h(this.jRP, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bi(T t) {
        this.jRQ = t;
        this.jRP = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.jRP = State.Done;
    }
}
