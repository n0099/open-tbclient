package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final kotlin.jvm.a.b<T, Boolean> nQA;
    private final c<T> nQy;
    private final boolean nQz;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.nQy = cVar;
        this.nQz = z;
        this.nQA = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0899a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nQB = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0899a() {
            this.iterator = a.this.nQy.iterator();
        }

        private final void dRd() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nQA.invoke(next)).booleanValue() == a.this.nQz) {
                    this.nextItem = next;
                    this.nQB = 1;
                    return;
                }
            }
            this.nQB = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nQB == -1) {
                dRd();
            }
            if (this.nQB == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nQB = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nQB == -1) {
                dRd();
            }
            return this.nQB == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0899a();
    }
}
