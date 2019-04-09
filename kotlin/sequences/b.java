package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> jSp;
    private final kotlin.jvm.a.b<T, T> jSq;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T GD;
        private int jSn = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cCD() {
            T t;
            if (this.jSn == -2) {
                t = (T) b.this.jSp.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.jSq;
                T t2 = this.GD;
                if (t2 == null) {
                    p.cCt();
                }
                t = (T) bVar.invoke(t2);
            }
            this.GD = t;
            this.jSn = this.GD == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jSn < 0) {
                cCD();
            }
            if (this.jSn == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.jSn = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jSn < 0) {
                cCD();
            }
            return this.jSn == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.jSp = aVar;
        this.jSq = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
