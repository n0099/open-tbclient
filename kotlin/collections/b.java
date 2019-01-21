package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State iCe = State.NotReady;
    private T iCf;

    protected abstract void ccZ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.iCe, State.Failed)) {
            switch (this.iCe) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return ccY();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.iCe = State.NotReady;
            return this.iCf;
        }
        throw new NoSuchElementException();
    }

    private final boolean ccY() {
        this.iCe = State.Failed;
        ccZ();
        return kotlin.jvm.internal.p.h(this.iCe, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aT(T t) {
        this.iCf = t;
        this.iCe = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.iCe = State.Done;
    }
}
