package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class a<T> implements c<T> {
    private final c<T> nBW;
    private final boolean nBX;
    private final kotlin.jvm.a.b<T, Boolean> nBY;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "sequence");
        q.j(bVar, "predicate");
        this.nBW = cVar;
        this.nBX = z;
        this.nBY = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0763a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nBZ = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0763a() {
            this.iterator = a.this.nBW.iterator();
        }

        private final void dJx() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nBY.invoke(next)).booleanValue() == a.this.nBX) {
                    this.nextItem = next;
                    this.nBZ = 1;
                    return;
                }
            }
            this.nBZ = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nBZ == -1) {
                dJx();
            }
            if (this.nBZ == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nBZ = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nBZ == -1) {
                dJx();
            }
            return this.nBZ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0763a();
    }
}
