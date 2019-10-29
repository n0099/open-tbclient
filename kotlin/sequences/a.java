package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> kwl;
    private final boolean kwm;
    private final kotlin.jvm.a.b<T, Boolean> kwn;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.i(cVar, "sequence");
        p.i(bVar, "predicate");
        this.kwl = cVar;
        this.kwm = z;
        this.kwn = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0606a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int kwo = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0606a() {
            this.iterator = a.this.kwl.iterator();
        }

        private final void cNi() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.kwn.invoke(next)).booleanValue() == a.this.kwm) {
                    this.nextItem = next;
                    this.kwo = 1;
                    return;
                }
            }
            this.kwo = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.kwo == -1) {
                cNi();
            }
            if (this.kwo == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.kwo = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.kwo == -1) {
                cNi();
            }
            return this.kwo == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0606a();
    }
}
