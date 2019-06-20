package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> kkK;
    private final kotlin.jvm.a.b<T, T> kkL;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private T Eo;
        private int kkI = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cKk() {
            T t;
            if (this.kkI == -2) {
                t = (T) b.this.kkK.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.kkL;
                T t2 = this.Eo;
                if (t2 == null) {
                    p.cKa();
                }
                t = (T) bVar.invoke(t2);
            }
            this.Eo = t;
            this.kkI = this.Eo == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.kkI < 0) {
                cKk();
            }
            if (this.kkI == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Eo;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.kkI = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.kkI < 0) {
                cKk();
            }
            return this.kkI == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.k(aVar, "getInitialValue");
        p.k(bVar, "getNextValue");
        this.kkK = aVar;
        this.kkL = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
