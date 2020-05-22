package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final kotlin.jvm.a.b<T, Boolean> ntA;
    private final c<T> nty;
    private final boolean ntz;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.nty = cVar;
        this.ntz = z;
        this.ntA = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0878a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int ntB = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0878a() {
            this.iterator = a.this.nty.iterator();
        }

        private final void dMf() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.ntA.invoke(next)).booleanValue() == a.this.ntz) {
                    this.nextItem = next;
                    this.ntB = 1;
                    return;
                }
            }
            this.ntB = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.ntB == -1) {
                dMf();
            }
            if (this.ntB == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.ntB = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ntB == -1) {
                dMf();
            }
            return this.ntB == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0878a();
    }
}
