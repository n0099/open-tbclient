package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes9.dex */
public final class a<T> implements c<T> {
    private final c<T> pUO;
    private final boolean pUP;
    private final kotlin.jvm.a.b<T, Boolean> pUQ;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.n(cVar, "sequence");
        q.n(bVar, "predicate");
        this.pUO = cVar;
        this.pUP = z;
        this.pUQ = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1082a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int pUR = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1082a() {
            this.iterator = a.this.pUO.iterator();
        }

        private final void eCj() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.pUQ.invoke(next)).booleanValue() == a.this.pUP) {
                    this.nextItem = next;
                    this.pUR = 1;
                    return;
                }
            }
            this.pUR = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.pUR == -1) {
                eCj();
            }
            if (this.pUR == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.pUR = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pUR == -1) {
                eCj();
            }
            return this.pUR == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1082a();
    }
}
