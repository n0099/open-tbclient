package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class a<T> implements c<T> {
    private final c<T> mZp;
    private final boolean mZq;
    private final kotlin.jvm.a.b<T, Boolean> mZr;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.j(cVar, "sequence");
        p.j(bVar, "predicate");
        this.mZp = cVar;
        this.mZq = z;
        this.mZr = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0718a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int mZs = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0718a() {
            this.iterator = a.this.mZp.iterator();
        }

        private final void dFb() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.mZr.invoke(next)).booleanValue() == a.this.mZq) {
                    this.nextItem = next;
                    this.mZs = 1;
                    return;
                }
            }
            this.mZs = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.mZs == -1) {
                dFb();
            }
            if (this.mZs == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.mZs = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mZs == -1) {
                dFb();
            }
            return this.mZs == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0718a();
    }
}
