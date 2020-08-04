package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nZj;
    private final boolean nZk;
    private final kotlin.jvm.a.b<T, Boolean> nZl;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.nZj = cVar;
        this.nZk = z;
        this.nZl = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0914a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nZm = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0914a() {
            this.iterator = a.this.nZj.iterator();
        }

        private final void dUA() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nZl.invoke(next)).booleanValue() == a.this.nZk) {
                    this.nextItem = next;
                    this.nZm = 1;
                    return;
                }
            }
            this.nZm = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nZm == -1) {
                dUA();
            }
            if (this.nZm == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nZm = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nZm == -1) {
                dUA();
            }
            return this.nZm == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0914a();
    }
}
