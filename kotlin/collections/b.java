package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State ksu = State.NotReady;
    private T ksv;

    protected abstract void cNJ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.ksu, State.Failed)) {
            switch (this.ksu) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cNI();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.ksu = State.NotReady;
            return this.ksv;
        }
        throw new NoSuchElementException();
    }

    private final boolean cNI() {
        this.ksu = State.Failed;
        cNJ();
        return kotlin.jvm.internal.p.h(this.ksu, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bh(T t) {
        this.ksv = t;
        this.ksu = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.ksu = State.Done;
    }
}
