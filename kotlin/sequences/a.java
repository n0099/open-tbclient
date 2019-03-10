package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> jSY;
    private final boolean jSZ;
    private final kotlin.jvm.a.b<T, Boolean> jTa;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.jSY = cVar;
        this.jSZ = z;
        this.jTa = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0378a implements Iterator<T> {
        private T GD;
        private final Iterator<T> jTb;
        private int jTc = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0378a() {
            this.jTb = a.this.jSY.iterator();
        }

        private final void cCL() {
            while (this.jTb.hasNext()) {
                T next = this.jTb.next();
                if (((Boolean) a.this.jTa.invoke(next)).booleanValue() == a.this.jSZ) {
                    this.GD = next;
                    this.jTc = 1;
                    return;
                }
            }
            this.jTc = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jTc == -1) {
                cCL();
            }
            if (this.jTc == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            this.GD = null;
            this.jTc = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jTc == -1) {
                cCL();
            }
            return this.jTc == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0378a();
    }
}
