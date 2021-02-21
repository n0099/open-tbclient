package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes6.dex */
public final class a<T> implements c<T> {
    private final c<T> qus;
    private final boolean qut;
    private final kotlin.jvm.a.b<T, Boolean> quu;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.o(cVar, "sequence");
        p.o(bVar, "predicate");
        this.qus = cVar;
        this.qut = z;
        this.quu = bVar;
    }

    @kotlin.e
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1309a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int quv = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1309a() {
            this.iterator = a.this.qus.iterator();
        }

        private final void eLK() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.quu.invoke(next)).booleanValue() == a.this.qut) {
                    this.nextItem = next;
                    this.quv = 1;
                    return;
                }
            }
            this.quv = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.quv == -1) {
                eLK();
            }
            if (this.quv == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.quv = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.quv == -1) {
                eLK();
            }
            return this.quv == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1309a();
    }
}
