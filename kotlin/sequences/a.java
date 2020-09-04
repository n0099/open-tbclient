package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes20.dex */
public final class a<T> implements c<T> {
    private final boolean otA;
    private final kotlin.jvm.a.b<T, Boolean> otB;
    private final c<T> otz;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.otz = cVar;
        this.otA = z;
        this.otB = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C0972a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int otC = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0972a() {
            this.iterator = a.this.otz.iterator();
        }

        private final void egL() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.otB.invoke(next)).booleanValue() == a.this.otA) {
                    this.nextItem = next;
                    this.otC = 1;
                    return;
                }
            }
            this.otC = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.otC == -1) {
                egL();
            }
            if (this.otC == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.otC = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.otC == -1) {
                egL();
            }
            return this.otC == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0972a();
    }
}
