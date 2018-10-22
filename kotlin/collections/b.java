package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State ioS = State.NotReady;
    private T ioT;

    protected abstract void bZY();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.ioS, State.Failed)) {
            switch (this.ioS) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return bZX();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.ioS = State.NotReady;
            return this.ioT;
        }
        throw new NoSuchElementException();
    }

    private final boolean bZX() {
        this.ioS = State.Failed;
        bZY();
        return kotlin.jvm.internal.p.h(this.ioS, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aT(T t) {
        this.ioT = t;
        this.ioS = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.ioS = State.Done;
    }
}
