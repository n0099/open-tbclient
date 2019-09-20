package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> kvD;
    private final boolean kvE;
    private final kotlin.jvm.a.b<T, Boolean> kvF;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.kvD = cVar;
        this.kvE = z;
        this.kvF = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0505a implements Iterator<T> {
        private T Eu;
        private final Iterator<T> iterator;
        private int kvG = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0505a() {
            this.iterator = a.this.kvD.iterator();
        }

        private final void cPb() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.kvF.invoke(next)).booleanValue() == a.this.kvE) {
                    this.Eu = next;
                    this.kvG = 1;
                    return;
                }
            }
            this.kvG = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.kvG == -1) {
                cPb();
            }
            if (this.kvG == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Eu;
            this.Eu = null;
            this.kvG = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.kvG == -1) {
                cPb();
            }
            return this.kvG == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0505a();
    }
}
