package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> nQA;
    private final kotlin.jvm.a.b<T, T> nQB;

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<T> {
        private int nQy = -2;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void dQZ() {
            T t;
            if (this.nQy == -2) {
                t = (T) b.this.nQA.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.nQB;
                T t2 = this.nextItem;
                if (t2 == null) {
                    q.dQG();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.nQy = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nQy < 0) {
                dQZ();
            }
            if (this.nQy == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.nQy = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nQy < 0) {
                dQZ();
            }
            return this.nQy == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.m(aVar, "getInitialValue");
        q.m(bVar, "getNextValue");
        this.nQA = aVar;
        this.nQB = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
