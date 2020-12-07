package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes17.dex */
public final class a<T> implements c<T> {
    private final c<T> pLc;
    private final boolean pLd;
    private final kotlin.jvm.a.b<T, Boolean> pLe;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.o(cVar, "sequence");
        p.o(bVar, "predicate");
        this.pLc = cVar;
        this.pLd = z;
        this.pLe = bVar;
    }

    @kotlin.e
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1055a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int pLf = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1055a() {
            this.iterator = a.this.pLc.iterator();
        }

        private final void eEp() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.pLe.invoke(next)).booleanValue() == a.this.pLd) {
                    this.nextItem = next;
                    this.pLf = 1;
                    return;
                }
            }
            this.pLf = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.pLf == -1) {
                eEp();
            }
            if (this.pLf == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.pLf = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pLf == -1) {
                eEp();
            }
            return this.pLf == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1055a();
    }
}
