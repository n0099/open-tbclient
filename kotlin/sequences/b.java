package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> ksj;
    private final kotlin.jvm.a.b<T, T> ksk;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T Eu;
        private int ksh = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cNU() {
            T t;
            if (this.ksh == -2) {
                t = (T) b.this.ksj.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.ksk;
                T t2 = this.Eu;
                if (t2 == null) {
                    p.cNK();
                }
                t = (T) bVar.invoke(t2);
            }
            this.Eu = t;
            this.ksh = this.Eu == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.ksh < 0) {
                cNU();
            }
            if (this.ksh == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Eu;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.ksh = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ksh < 0) {
                cNU();
            }
            return this.ksh == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.ksj = aVar;
        this.ksk = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
