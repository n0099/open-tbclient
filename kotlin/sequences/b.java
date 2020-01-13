package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> nCb;
    private final kotlin.jvm.a.b<T, T> nCc;

    /* loaded from: classes5.dex */
    public static final class a implements Iterator<T> {
        private int nBZ = -2;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void dJx() {
            T t;
            if (this.nBZ == -2) {
                t = (T) b.this.nCb.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.nCc;
                T t2 = this.nextItem;
                if (t2 == null) {
                    q.dJk();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.nBZ = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nBZ < 0) {
                dJx();
            }
            if (this.nBZ == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.nBZ = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nBZ < 0) {
                dJx();
            }
            return this.nBZ == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.j(aVar, "getInitialValue");
        q.j(bVar, "getNextValue");
        this.nCb = aVar;
        this.nCc = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
