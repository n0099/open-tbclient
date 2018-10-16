package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State ioR = State.NotReady;
    private T ioS;

    protected abstract void bZY();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.ioR, State.Failed)) {
            switch (this.ioR) {
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
            this.ioR = State.NotReady;
            return this.ioS;
        }
        throw new NoSuchElementException();
    }

    private final boolean bZX() {
        this.ioR = State.Failed;
        bZY();
        return kotlin.jvm.internal.p.h(this.ioR, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aT(T t) {
        this.ioS = t;
        this.ioR = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.ioR = State.Done;
    }
}
