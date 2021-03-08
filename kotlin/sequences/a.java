package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
public final class a<T> implements c<T> {
    private final c<T> quU;
    private final boolean quV;
    private final kotlin.jvm.a.b<T, Boolean> quW;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.p(cVar, "sequence");
        p.p(bVar, "predicate");
        this.quU = cVar;
        this.quV = z;
        this.quW = bVar;
    }

    @kotlin.e
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1291a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int quX = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1291a() {
            this.iterator = a.this.quU.iterator();
        }

        private final void eLs() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.quW.invoke(next)).booleanValue() == a.this.quV) {
                    this.nextItem = next;
                    this.quX = 1;
                    return;
                }
            }
            this.quX = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.quX == -1) {
                eLs();
            }
            if (this.quX == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.quX = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.quX == -1) {
                eLs();
            }
            return this.quX == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1291a();
    }
}
