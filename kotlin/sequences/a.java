package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class a<T> implements c<T> {
    private final c<T> oSv;
    private final boolean oSw;
    private final kotlin.jvm.a.b<T, Boolean> oSx;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.n(cVar, "sequence");
        q.n(bVar, "predicate");
        this.oSv = cVar;
        this.oSw = z;
        this.oSx = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0987a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int oSy = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0987a() {
            this.iterator = a.this.oSv.iterator();
        }

        private final void eov() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.oSx.invoke(next)).booleanValue() == a.this.oSw) {
                    this.nextItem = next;
                    this.oSy = 1;
                    return;
                }
            }
            this.oSy = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.oSy == -1) {
                eov();
            }
            if (this.oSy == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.oSy = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.oSy == -1) {
                eov();
            }
            return this.oSy == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0987a();
    }
}
