package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> kkH;
    private final kotlin.jvm.a.b<T, T> kkI;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T Ep;
        private int kkF = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cKl() {
            T t;
            if (this.kkF == -2) {
                t = (T) b.this.kkH.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.kkI;
                T t2 = this.Ep;
                if (t2 == null) {
                    p.cKb();
                }
                t = (T) bVar.invoke(t2);
            }
            this.Ep = t;
            this.kkF = this.Ep == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.kkF < 0) {
                cKl();
            }
            if (this.kkF == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Ep;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.kkF = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.kkF < 0) {
                cKl();
            }
            return this.kkF == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.kkH = aVar;
        this.kkI = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
