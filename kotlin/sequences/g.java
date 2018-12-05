package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class g<T, R> implements c<R> {
    private final c<T> iyC;
    private final kotlin.jvm.a.b<T, R> iyP;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> iyF;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.iyF = g.this.iyC.iterator();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) g.this.iyP.invoke(this.iyF.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iyF.hasNext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        p.h((Object) cVar, "sequence");
        p.h((Object) bVar, "transformer");
        this.iyC = cVar;
        this.iyP = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<R> iterator() {
        return new a();
    }
}
