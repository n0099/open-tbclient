package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes20.dex */
public final class k<T, R> implements c<R> {
    private final kotlin.jvm.a.b<T, R> otN;
    private final c<T> otz;

    @kotlin.h
    /* loaded from: classes20.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> iterator;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.iterator = k.this.otz.iterator();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) k.this.otN.invoke(this.iterator.next());
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
        q.m(cVar, "sequence");
        q.m(bVar, "transformer");
        this.otz = cVar;
        this.otN = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<R> iterator() {
        return new a();
    }
}
