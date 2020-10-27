package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class a<T> implements c<T> {
    private final c<T> pJR;
    private final boolean pJS;
    private final kotlin.jvm.a.b<T, Boolean> pJT;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.n(cVar, "sequence");
        q.n(bVar, "predicate");
        this.pJR = cVar;
        this.pJS = z;
        this.pJT = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C1059a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int pJU = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C1059a() {
            this.iterator = a.this.pJR.iterator();
        }

        private final void eyt() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.pJT.invoke(next)).booleanValue() == a.this.pJS) {
                    this.nextItem = next;
                    this.pJU = 1;
                    return;
                }
            }
            this.pJU = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.pJU == -1) {
                eyt();
            }
            if (this.pJU == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.pJU = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pJU == -1) {
                eyt();
            }
            return this.pJU == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C1059a();
    }
}
