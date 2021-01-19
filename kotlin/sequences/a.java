package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes5.dex */
public final class a<T> implements c<T> {
    private final c<T> qjO;
    private final boolean qjP;
    private final kotlin.jvm.a.b<T, Boolean> qjQ;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.o(cVar, "sequence");
        p.o(bVar, "predicate");
        this.qjO = cVar;
        this.qjP = z;
        this.qjQ = bVar;
    }

    @kotlin.e
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1297a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int qjR = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1297a() {
            this.iterator = a.this.qjO.iterator();
        }

        private final void eJm() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.qjQ.invoke(next)).booleanValue() == a.this.qjP) {
                    this.nextItem = next;
                    this.qjR = 1;
                    return;
                }
            }
            this.qjR = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.qjR == -1) {
                eJm();
            }
            if (this.qjR == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.qjR = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qjR == -1) {
                eJm();
            }
            return this.qjR == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1297a();
    }
}
