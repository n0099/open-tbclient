package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nQv;
    private final boolean nQw;
    private final kotlin.jvm.a.b<T, Boolean> nQx;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.nQv = cVar;
        this.nQw = z;
        this.nQx = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0898a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nQy = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0898a() {
            this.iterator = a.this.nQv.iterator();
        }

        private final void dQZ() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nQx.invoke(next)).booleanValue() == a.this.nQw) {
                    this.nextItem = next;
                    this.nQy = 1;
                    return;
                }
            }
            this.nQy = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nQy == -1) {
                dQZ();
            }
            if (this.nQy == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nQy = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nQy == -1) {
                dQZ();
            }
            return this.nQy == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0898a();
    }
}
