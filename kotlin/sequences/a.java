package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes5.dex */
public final class a<T> implements c<T> {
    private final c<T> oDg;
    private final boolean oDh;
    private final kotlin.jvm.a.b<T, Boolean> oDi;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.oDg = cVar;
        this.oDh = z;
        this.oDi = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0969a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int oDj = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0969a() {
            this.iterator = a.this.oDg.iterator();
        }

        private final void ekI() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.oDi.invoke(next)).booleanValue() == a.this.oDh) {
                    this.nextItem = next;
                    this.oDj = 1;
                    return;
                }
            }
            this.oDj = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.oDj == -1) {
                ekI();
            }
            if (this.oDj == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.oDj = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.oDj == -1) {
                ekI();
            }
            return this.oDj == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0969a();
    }
}
