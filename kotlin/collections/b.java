package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T> {
    private State jSi = State.NotReady;
    private T jSj;

    protected abstract void cCo();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.h(this.jSi, State.Failed)) {
            switch (this.jSi) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return cCn();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.jSi = State.NotReady;
            return this.jSj;
        }
        throw new NoSuchElementException();
    }

    private final boolean cCn() {
        this.jSi = State.Failed;
        cCo();
        return kotlin.jvm.internal.p.h(this.jSi, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bj(T t) {
        this.jSj = t;
        this.jSi = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.jSi = State.Done;
    }
}
