package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State jRt = State.NotReady;
    private T jRu;

    protected abstract void cCg();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.jRt, State.Failed)) {
            switch (this.jRt) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cCf();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.jRt = State.NotReady;
            return this.jRu;
        }
        throw new NoSuchElementException();
    }

    private final boolean cCf() {
        this.jRt = State.Failed;
        cCg();
        return kotlin.jvm.internal.p.h(this.jRt, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bf(T t) {
        this.jRu = t;
        this.jRt = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.jRt = State.Done;
    }
}
