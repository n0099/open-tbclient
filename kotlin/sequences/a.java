package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nEU;
    private final boolean nEV;
    private final kotlin.jvm.a.b<T, Boolean> nEW;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "sequence");
        q.j(bVar, "predicate");
        this.nEU = cVar;
        this.nEV = z;
        this.nEW = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0772a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nEX = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0772a() {
            this.iterator = a.this.nEU.iterator();
        }

        private final void dLp() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nEW.invoke(next)).booleanValue() == a.this.nEV) {
                    this.nextItem = next;
                    this.nEX = 1;
                    return;
                }
            }
            this.nEX = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nEX == -1) {
                dLp();
            }
            if (this.nEX == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nEX = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nEX == -1) {
                dLp();
            }
            return this.nEX == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0772a();
    }
}
