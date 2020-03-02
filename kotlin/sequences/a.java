package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nCW;
    private final boolean nCX;
    private final kotlin.jvm.a.b<T, Boolean> nCY;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "sequence");
        q.j(bVar, "predicate");
        this.nCW = cVar;
        this.nCX = z;
        this.nCY = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0771a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nCZ = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0771a() {
            this.iterator = a.this.nCW.iterator();
        }

        private final void dKO() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nCY.invoke(next)).booleanValue() == a.this.nCX) {
                    this.nextItem = next;
                    this.nCZ = 1;
                    return;
                }
            }
            this.nCZ = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nCZ == -1) {
                dKO();
            }
            if (this.nCZ == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nCZ = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nCZ == -1) {
                dKO();
            }
            return this.nCZ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0771a();
    }
}
