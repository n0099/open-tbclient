package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> qjT;
    private final kotlin.jvm.a.b<T, T> qjU;

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<T> {
        private T nextItem;
        private int qjR = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void eJm() {
            T t;
            if (this.qjR == -2) {
                t = (T) b.this.qjT.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.qjU;
                T t2 = this.nextItem;
                if (t2 == null) {
                    p.eIW();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.qjR = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.qjR < 0) {
                eJm();
            }
            if (this.qjR == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.qjR = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qjR < 0) {
                eJm();
            }
            return this.qjR == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.o(aVar, "getInitialValue");
        p.o(bVar, "getNextValue");
        this.qjT = aVar;
        this.qjU = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
