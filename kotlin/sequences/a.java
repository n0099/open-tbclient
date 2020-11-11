package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class a<T> implements c<T> {
    private final c<T> pTl;
    private final boolean pTm;
    private final kotlin.jvm.a.b<T, Boolean> pTn;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.n(cVar, "sequence");
        q.n(bVar, "predicate");
        this.pTl = cVar;
        this.pTm = z;
        this.pTn = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C1079a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int pTo = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1079a() {
            this.iterator = a.this.pTl.iterator();
        }

        private final void eCi() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.pTn.invoke(next)).booleanValue() == a.this.pTm) {
                    this.nextItem = next;
                    this.pTo = 1;
                    return;
                }
            }
            this.pTo = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.pTo == -1) {
                eCi();
            }
            if (this.pTo == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.pTo = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pTo == -1) {
                eCi();
            }
            return this.pTo == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1079a();
    }
}
