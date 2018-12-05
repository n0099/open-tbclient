package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> iyC;
    private final boolean iyD;
    private final kotlin.jvm.a.b<T, Boolean> iyE;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.h((Object) cVar, "sequence");
        p.h((Object) bVar, "predicate");
        this.iyC = cVar;
        this.iyD = z;
        this.iyE = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0400a implements Iterator<T> {
        private T GE;
        private final Iterator<T> iyF;
        private int iyG = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0400a() {
            this.iyF = a.this.iyC.iterator();
        }

        private final void cbY() {
            while (this.iyF.hasNext()) {
                T next = this.iyF.next();
                if (((Boolean) a.this.iyE.invoke(next)).booleanValue() == a.this.iyD) {
                    this.GE = next;
                    this.iyG = 1;
                    return;
                }
            }
            this.iyG = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.iyG == -1) {
                cbY();
            }
            if (this.iyG == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GE;
            this.GE = null;
            this.iyG = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iyG == -1) {
                cbY();
            }
            return this.iyG == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0400a();
    }
}
