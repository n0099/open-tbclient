package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> jSF;
    private final boolean jSG;
    private final kotlin.jvm.a.b<T, Boolean> jSH;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.k(cVar, "sequence");
        p.k(bVar, "predicate");
        this.jSF = cVar;
        this.jSG = z;
        this.jSH = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0375a implements Iterator<T> {
        private T GD;
        private final Iterator<T> jSI;
        private int jSJ = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0375a() {
            this.jSI = a.this.jSF.iterator();
        }

        private final void cCB() {
            while (this.jSI.hasNext()) {
                T next = this.jSI.next();
                if (((Boolean) a.this.jSH.invoke(next)).booleanValue() == a.this.jSG) {
                    this.GD = next;
                    this.jSJ = 1;
                    return;
                }
            }
            this.jSJ = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.jSJ == -1) {
                cCB();
            }
            if (this.jSJ == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GD;
            this.GD = null;
            this.jSJ = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.jSJ == -1) {
                cCB();
            }
            return this.jSJ == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0375a();
    }
}
