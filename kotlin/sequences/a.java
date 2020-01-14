package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class a<T> implements c<T> {
    private final c<T> nCb;
    private final boolean nCc;
    private final kotlin.jvm.a.b<T, Boolean> nCd;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "sequence");
        q.j(bVar, "predicate");
        this.nCb = cVar;
        this.nCc = z;
        this.nCd = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0763a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nCe = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0763a() {
            this.iterator = a.this.nCb.iterator();
        }

        private final void dJz() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nCd.invoke(next)).booleanValue() == a.this.nCc) {
                    this.nextItem = next;
                    this.nCe = 1;
                    return;
                }
            }
            this.nCe = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nCe == -1) {
                dJz();
            }
            if (this.nCe == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nCe = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nCe == -1) {
                dJz();
            }
            return this.nCe == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0763a();
    }
}
