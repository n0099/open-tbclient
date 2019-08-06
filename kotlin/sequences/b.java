package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> ktp;
    private final kotlin.jvm.a.b<T, T> ktq;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T Eu;
        private int ktn = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cOp() {
            T t;
            if (this.ktn == -2) {
                t = (T) b.this.ktp.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.ktq;
                T t2 = this.Eu;
                if (t2 == null) {
                    p.cOf();
                }
                t = (T) bVar.invoke(t2);
            }
            this.Eu = t;
            this.ktn = this.Eu == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.ktn < 0) {
                cOp();
            }
            if (this.ktn == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Eu;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.ktn = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ktn < 0) {
                cOp();
            }
            return this.ktn == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.ktp = aVar;
        this.ktq = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
