package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State kro = State.NotReady;
    private T krp;

    protected abstract void cNo();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.kro, State.Failed)) {
            switch (this.kro) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cNn();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.kro = State.NotReady;
            return this.krp;
        }
        throw new NoSuchElementException();
    }

    private final boolean cNn() {
        this.kro = State.Failed;
        cNo();
        return kotlin.jvm.internal.p.h(this.kro, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bh(T t) {
        this.krp = t;
        this.kro = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.kro = State.Done;
    }
}
