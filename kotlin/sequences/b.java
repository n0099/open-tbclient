package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes17.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> pLh;
    private final kotlin.jvm.a.b<T, T> pLi;

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a implements Iterator<T> {
        private T nextItem;
        private int pLf = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void eEp() {
            T t;
            if (this.pLf == -2) {
                t = (T) b.this.pLh.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.pLi;
                T t2 = this.nextItem;
                if (t2 == null) {
                    p.eDZ();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.pLf = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.pLf < 0) {
                eEp();
            }
            if (this.pLf == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.pLf = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pLf < 0) {
                eEp();
            }
            return this.pLf == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.o(aVar, "getInitialValue");
        p.o(bVar, "getNextValue");
        this.pLh = aVar;
        this.pLi = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
