package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> mYw;
    private final boolean mYx;
    private final kotlin.jvm.a.b<T, Boolean> mYy;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.j(cVar, "sequence");
        q.j(bVar, "predicate");
        this.mYw = cVar;
        this.mYx = z;
        this.mYy = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0816a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int mYz = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0816a() {
            this.iterator = a.this.mYw.iterator();
        }

        private final void dEk() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.mYy.invoke(next)).booleanValue() == a.this.mYx) {
                    this.nextItem = next;
                    this.mYz = 1;
                    return;
                }
            }
            this.mYz = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.mYz == -1) {
                dEk();
            }
            if (this.mYz == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.mYz = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mYz == -1) {
                dEk();
            }
            return this.mYz == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0816a();
    }
}
