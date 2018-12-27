package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State iAW = State.NotReady;
    private T iAX;

    protected abstract void ccr();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.iAW, State.Failed)) {
            switch (this.iAW) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return ccq();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.iAW = State.NotReady;
            return this.iAX;
        }
        throw new NoSuchElementException();
    }

    private final boolean ccq() {
        this.iAW = State.Failed;
        ccr();
        return kotlin.jvm.internal.p.h(this.iAW, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void aT(T t) {
        this.iAX = t;
        this.iAW = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.iAW = State.Done;
    }
}
