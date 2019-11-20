package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kuE = State.NotReady;
    private T kuF;

    protected abstract void cMA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.f(this.kuE, State.Failed)) {
            switch (this.kuE) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cMz();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kuE = State.NotReady;
            return this.kuF;
        }
        throw new NoSuchElementException();
    }

    private final boolean cMz() {
        this.kuE = State.Failed;
        cMA();
        return kotlin.jvm.internal.p.f(this.kuE, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bc(T t) {
        this.kuF = t;
        this.kuE = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kuE = State.Done;
    }
}
