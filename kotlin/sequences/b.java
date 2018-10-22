package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> ipO;
    private final kotlin.jvm.a.b<T, T> ipP;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T Gz;
        private int ipM = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cav() {
            T t;
            if (this.ipM == -2) {
                t = (T) b.this.ipO.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.ipP;
                T t2 = this.Gz;
                if (t2 == null) {
                    p.cal();
                }
                t = (T) bVar.invoke(t2);
            }
            this.Gz = t;
            this.ipM = this.Gz == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.ipM < 0) {
                cav();
            }
            if (this.ipM == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Gz;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.ipM = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ipM < 0) {
                cav();
            }
            return this.ipM == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.i(aVar, "getInitialValue");
        p.i(bVar, "getNextValue");
        this.ipO = aVar;
        this.ipP = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
