package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> iBM;
    private final boolean iBN;
    private final kotlin.jvm.a.b<T, Boolean> iBO;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.j(cVar, "sequence");
        p.j(bVar, "predicate");
        this.iBM = cVar;
        this.iBN = z;
        this.iBO = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0400a implements Iterator<T> {
        private T GE;
        private final Iterator<T> iBP;
        private int iBQ = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0400a() {
            this.iBP = a.this.iBM.iterator();
        }

        private final void ccO() {
            while (this.iBP.hasNext()) {
                T next = this.iBP.next();
                if (((Boolean) a.this.iBO.invoke(next)).booleanValue() == a.this.iBN) {
                    this.GE = next;
                    this.iBQ = 1;
                    return;
                }
            }
            this.iBQ = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.iBQ == -1) {
                ccO();
            }
            if (this.iBQ == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GE;
            this.GE = null;
            this.iBQ = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iBQ == -1) {
                ccO();
            }
            return this.iBQ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0400a();
    }
}
