package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes20.dex */
public final class a<T> implements c<T> {
    private final c<T> oth;
    private final boolean oti;
    private final kotlin.jvm.a.b<T, Boolean> otj;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.oth = cVar;
        this.oti = z;
        this.otj = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C0972a implements Iterator<T> {
        private final Iterator<T> iterator;
        private T nextItem;
        private int otk = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0972a() {
            this.iterator = a.this.oth.iterator();
        }

        private final void egC() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.otj.invoke(next)).booleanValue() == a.this.oti) {
                    this.nextItem = next;
                    this.otk = 1;
                    return;
                }
            }
            this.otk = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.otk == -1) {
                egC();
            }
            if (this.otk == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.otk = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.otk == -1) {
                egC();
            }
            return this.otk == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0972a();
    }
}
