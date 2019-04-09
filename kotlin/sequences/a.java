package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> jSj;
    private final boolean jSk;
    private final kotlin.jvm.a.b<T, Boolean> jSl;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.jSj = cVar;
        this.jSk = z;
        this.jSl = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0472a implements Iterator<T> {
        private T GD;
        private final Iterator<T> jSm;
        private int jSn = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0472a() {
            this.jSm = a.this.jSj.iterator();
        }

        private final void cCD() {
            while (this.jSm.hasNext()) {
                T next = this.jSm.next();
                if (((Boolean) a.this.jSl.invoke(next)).booleanValue() == a.this.jSk) {
                    this.GD = next;
                    this.jSn = 1;
                    return;
                }
            }
            this.jSn = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jSn == -1) {
                cCD();
            }
            if (this.jSn == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            this.GD = null;
            this.jSn = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jSn == -1) {
                cCD();
            }
            return this.jSn == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0472a();
    }
}
