package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> jSW;
    private final kotlin.jvm.a.b<T, T> jSX;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T GD;
        private int jSU = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cCO() {
            T t;
            if (this.jSU == -2) {
                t = (T) b.this.jSW.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.jSX;
                T t2 = this.GD;
                if (t2 == null) {
                    p.cCE();
                }
                t = (T) bVar.invoke(t2);
            }
            this.GD = t;
            this.jSU = this.GD == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jSU < 0) {
                cCO();
            }
            if (this.jSU == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.jSU = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jSU < 0) {
                cCO();
            }
            return this.jSU == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.jSW = aVar;
        this.jSX = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
