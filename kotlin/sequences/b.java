package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> iDa;
    private final kotlin.jvm.a.b<T, T> iDb;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T GE;
        private int iCY = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cdw() {
            T t;
            if (this.iCY == -2) {
                t = (T) b.this.iDa.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.iDb;
                T t2 = this.GE;
                if (t2 == null) {
                    p.cdm();
                }
                t = (T) bVar.invoke(t2);
            }
            this.GE = t;
            this.iCY = this.GE == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.iCY < 0) {
                cdw();
            }
            if (this.iCY == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GE;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.iCY = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iCY < 0) {
                cdw();
            }
            return this.iCY == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.j(aVar, "getInitialValue");
        p.j(bVar, "getNextValue");
        this.iDa = aVar;
        this.iDb = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
