package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class g<T, R> implements c<R> {
    private final kotlin.jvm.a.b<T, R> irF;
    private final c<T> irs;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> irv;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
            this.irv = g.this.irs.iterator();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) g.this.irF.invoke(this.irv.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.irv.hasNext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(c<? extends T> cVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        p.h((Object) cVar, "sequence");
        p.h((Object) bVar, "transformer");
        this.irs = cVar;
        this.irF = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<R> iterator() {
        return new a();
    }
}
