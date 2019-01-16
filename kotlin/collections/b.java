package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State iCd = State.NotReady;
    private T iCe;

    protected abstract void ccZ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.iCd, State.Failed)) {
            switch (this.iCd) {
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
            this.iCd = State.NotReady;
            return this.iCe;
        }
        throw new NoSuchElementException();
    }

    private final boolean ccY() {
        this.iCd = State.Failed;
        ccZ();
        return kotlin.jvm.internal.p.h(this.iCd, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aT(T t) {
        this.iCe = t;
        this.iCd = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.iCd = State.Done;
    }
}
