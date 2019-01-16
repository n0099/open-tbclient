package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> iCZ;
    private final kotlin.jvm.a.b<T, T> iDa;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T GE;
        private int iCX = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cdw() {
            T t;
            if (this.iCX == -2) {
                t = (T) b.this.iCZ.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.iDa;
                T t2 = this.GE;
                if (t2 == null) {
                    p.cdm();
                }
                t = (T) bVar.invoke(t2);
            }
            this.GE = t;
            this.iCX = this.GE == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.iCX < 0) {
                cdw();
            }
            if (this.iCX == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GE;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.iCX = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iCX < 0) {
                cdw();
            }
            return this.iCX == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.j(aVar, "getInitialValue");
        p.j(bVar, "getNextValue");
        this.iCZ = aVar;
        this.iDa = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
