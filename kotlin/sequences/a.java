package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class a<T> implements c<T> {
    private final c<T> qmH;
    private final boolean qmI;
    private final kotlin.jvm.a.b<T, Boolean> qmJ;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.o(cVar, "sequence");
        p.o(bVar, "predicate");
        this.qmH = cVar;
        this.qmI = z;
        this.qmJ = bVar;
    }

    @kotlin.e
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1273a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int qmK = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1273a() {
            this.iterator = a.this.qmH.iterator();
        }

        private final void eMy() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.qmJ.invoke(next)).booleanValue() == a.this.qmI) {
                    this.nextItem = next;
                    this.qmK = 1;
                    return;
                }
            }
            this.qmK = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.qmK == -1) {
                eMy();
            }
            if (this.qmK == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.qmK = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qmK == -1) {
                eMy();
            }
            return this.qmK == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1273a();
    }
}
