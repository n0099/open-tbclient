package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> kse;
    private final boolean ksf;
    private final kotlin.jvm.a.b<T, Boolean> ksg;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.kse = cVar;
        this.ksf = z;
        this.ksg = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0499a implements Iterator<T> {
        private T Eu;
        private final Iterator<T> iterator;
        private int ksh = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0499a() {
            this.iterator = a.this.kse.iterator();
        }

        private final void cNU() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.ksg.invoke(next)).booleanValue() == a.this.ksf) {
                    this.Eu = next;
                    this.ksh = 1;
                    return;
                }
            }
            this.ksh = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.ksh == -1) {
                cNU();
            }
            if (this.ksh == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Eu;
            this.Eu = null;
            this.ksh = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ksh == -1) {
                cNU();
            }
            return this.ksh == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0499a();
    }
}
