package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nuJ;
    private final boolean nuK;
    private final kotlin.jvm.a.b<T, Boolean> nuL;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.nuJ = cVar;
        this.nuK = z;
        this.nuL = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0879a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int nuM = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0879a() {
            this.iterator = a.this.nuJ.iterator();
        }

        private final void dMt() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nuL.invoke(next)).booleanValue() == a.this.nuK) {
                    this.nextItem = next;
                    this.nuM = 1;
                    return;
                }
            }
            this.nuM = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nuM == -1) {
                dMt();
            }
            if (this.nuM == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nuM = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nuM == -1) {
                dMt();
            }
            return this.nuM == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0879a();
    }
}
