package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class g<T, R> implements c<R> {
    private final c<T> kwl;
    private final kotlin.jvm.a.b<T, R> kwx;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> iterator;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.iterator = g.this.kwl.iterator();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) g.this.kwx.invoke(this.iterator.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        p.i(cVar, "sequence");
        p.i(bVar, "transformer");
        this.kwl = cVar;
        this.kwx = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<R> iterator() {
        return new a();
    }
}
