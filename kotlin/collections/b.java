package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kuN = State.NotReady;
    private T kuO;

    protected abstract void cOv();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.kuN, State.Failed)) {
            switch (this.kuN) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cOu();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kuN = State.NotReady;
            return this.kuO;
        }
        throw new NoSuchElementException();
    }

    private final boolean cOu() {
        this.kuN = State.Failed;
        cOv();
        return kotlin.jvm.internal.p.h(this.kuN, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bh(T t) {
        this.kuO = t;
        this.kuN = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kuN = State.Done;
    }
}
