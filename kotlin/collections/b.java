package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State jRs = State.NotReady;
    private T jRt;

    protected abstract void cCg();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.jRs, State.Failed)) {
            switch (this.jRs) {
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
            this.jRs = State.NotReady;
            return this.jRt;
        }
        throw new NoSuchElementException();
    }

    private final boolean cCf() {
        this.jRs = State.Failed;
        cCg();
        return kotlin.jvm.internal.p.h(this.jRs, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bf(T t) {
        this.jRt = t;
        this.jRs = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.jRs = State.Done;
    }
}
