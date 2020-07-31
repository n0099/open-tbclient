package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class a<T> implements c<T> {
    private final c<T> nZh;
    private final boolean nZi;
    private final kotlin.jvm.a.b<T, Boolean> nZj;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        q.m(cVar, "sequence");
        q.m(bVar, "predicate");
        this.nZh = cVar;
        this.nZi = z;
        this.nZj = bVar;
    }

    @kotlin.h
    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0914a implements Iterator<T> {
        private final Iterator<T> iterator;
        private int nZk = -1;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0914a() {
            this.iterator = a.this.nZh.iterator();
        }

        private final void dUz() {
            while (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) a.this.nZj.invoke(next)).booleanValue() == a.this.nZi) {
                    this.nextItem = next;
                    this.nZk = 1;
                    return;
                }
            }
            this.nZk = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nZk == -1) {
                dUz();
            }
            if (this.nZk == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            this.nextItem = null;
            this.nZk = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nZk == -1) {
                dUz();
            }
            return this.nZk == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0914a();
    }
}
