package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> iCT;
    private final boolean iCU;
    private final kotlin.jvm.a.b<T, Boolean> iCV;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.j(cVar, "sequence");
        p.j(bVar, "predicate");
        this.iCT = cVar;
        this.iCU = z;
        this.iCV = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0399a implements Iterator<T> {
        private T GE;
        private final Iterator<T> iCW;
        private int iCX = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0399a() {
            this.iCW = a.this.iCT.iterator();
        }

        private final void cdw() {
            while (this.iCW.hasNext()) {
                T next = this.iCW.next();
                if (((Boolean) a.this.iCV.invoke(next)).booleanValue() == a.this.iCU) {
                    this.GE = next;
                    this.iCX = 1;
                    return;
                }
            }
            this.iCX = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.iCX == -1) {
                cdw();
            }
            if (this.iCX == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GE;
            this.GE = null;
            this.iCX = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iCX == -1) {
                cdw();
            }
            return this.iCX == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0399a();
    }
}
