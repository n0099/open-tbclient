package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> jSQ;
    private final boolean jSR;
    private final kotlin.jvm.a.b<T, Boolean> jSS;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.jSQ = cVar;
        this.jSR = z;
        this.jSS = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0472a implements Iterator<T> {
        private T GD;
        private final Iterator<T> jST;
        private int jSU = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0472a() {
            this.jST = a.this.jSQ.iterator();
        }

        private final void cCO() {
            while (this.jST.hasNext()) {
                T next = this.jST.next();
                if (((Boolean) a.this.jSS.invoke(next)).booleanValue() == a.this.jSR) {
                    this.GD = next;
                    this.jSU = 1;
                    return;
                }
            }
            this.jSU = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jSU == -1) {
                cCO();
            }
            if (this.jSU == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            this.GD = null;
            this.jSU = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jSU == -1) {
                cCO();
            }
            return this.jSU == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0472a();
    }
}
