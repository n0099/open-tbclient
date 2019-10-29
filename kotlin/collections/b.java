package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kvv = State.NotReady;
    private T kvw;

    protected abstract void cMC();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.f(this.kvv, State.Failed)) {
            switch (this.kvv) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cMB();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kvv = State.NotReady;
            return this.kvw;
        }
        throw new NoSuchElementException();
    }

    private final boolean cMB() {
        this.kvv = State.Failed;
        cMC();
        return kotlin.jvm.internal.p.f(this.kvv, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bc(T t) {
        this.kvw = t;
        this.kvv = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kvv = State.Done;
    }
}
