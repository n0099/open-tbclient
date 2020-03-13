package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nDh;
    private final boolean nDi;
    private final kotlin.jvm.a.b<T, Boolean> nDj;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "sequence");
        q.j(bVar, "predicate");
        this.nDh = cVar;
        this.nDi = z;
        this.nDj = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0771a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nDk = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0771a() {
            this.iterator = a.this.nDh.iterator();
        }

        private final void dKP() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nDj.invoke(next)).booleanValue() == a.this.nDi) {
                    this.nextItem = next;
                    this.nDk = 1;
                    return;
                }
            }
            this.nDk = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nDk == -1) {
                dKP();
            }
            if (this.nDk == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nDk = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nDk == -1) {
                dKP();
            }
            return this.nDk == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0771a();
    }
}
