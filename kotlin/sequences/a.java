package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> kkC;
    private final boolean kkD;
    private final kotlin.jvm.a.b<T, Boolean> kkE;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.kkC = cVar;
        this.kkD = z;
        this.kkE = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0493a implements Iterator<T> {
        private T Ep;
        private final Iterator<T> iterator;
        private int kkF = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0493a() {
            this.iterator = a.this.kkC.iterator();
        }

        private final void cKl() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.kkE.invoke(next)).booleanValue() == a.this.kkD) {
                    this.Ep = next;
                    this.kkF = 1;
                    return;
                }
            }
            this.kkF = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.kkF == -1) {
                cKl();
            }
            if (this.kkF == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Ep;
            this.Ep = null;
            this.kkF = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.kkF == -1) {
                cKl();
            }
            return this.kkF == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0493a();
    }
}
