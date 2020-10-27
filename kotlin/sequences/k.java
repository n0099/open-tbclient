package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class k<T, R> implements c<R> {
    private final c<T> pJR;
    private final kotlin.jvm.a.b<T, R> pKf;

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> iterator;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.iterator = k.this.pJR.iterator();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) k.this.pKf.invoke(this.iterator.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public k(c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        q.n(cVar, "sequence");
        q.n(bVar, "transformer");
        this.pJR = cVar;
        this.pKf = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<R> iterator() {
        return new a();
    }
}
