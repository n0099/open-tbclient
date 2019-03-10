package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> jTe;
    private final kotlin.jvm.a.b<T, T> jTf;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T GD;
        private int jTc = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cCL() {
            T t;
            if (this.jTc == -2) {
                t = (T) b.this.jTe.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.jTf;
                T t2 = this.GD;
                if (t2 == null) {
                    p.cCB();
                }
                t = (T) bVar.invoke(t2);
            }
            this.GD = t;
            this.jTc = this.GD == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jTc < 0) {
                cCL();
            }
            if (this.jTc == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.jTc = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jTc < 0) {
                cCL();
            }
            return this.jTc == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.jTe = aVar;
        this.jTf = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
