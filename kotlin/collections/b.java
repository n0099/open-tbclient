package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
@kotlin.e
/* loaded from: classes14.dex */
public abstract class b<T> implements Iterator<T> {
    private State qtR = State.NotReady;
    private T qtS;

    protected abstract void eKI();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!kotlin.jvm.internal.p.l(this.qtR, State.Failed)) {
            switch (this.qtR) {
                case Done:
                    return false;
                case Ready:
                    return true;
                default:
                    return eKH();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.qtR = State.NotReady;
            return this.qtS;
        }
        throw new NoSuchElementException();
    }

    private final boolean eKH() {
        this.qtR = State.Failed;
        eKI();
        return kotlin.jvm.internal.p.l(this.qtR, State.Ready);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void bS(T t) {
        this.qtS = t;
        this.qtR = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.qtR = State.Done;
    }
}
