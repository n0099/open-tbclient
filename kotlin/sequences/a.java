package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> ipI;
    private final boolean ipJ;
    private final kotlin.jvm.a.b<T, Boolean> ipK;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.i(cVar, "sequence");
        p.i(bVar, "predicate");
        this.ipI = cVar;
        this.ipJ = z;
        this.ipK = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0358a implements Iterator<T> {
        private T Gz;
        private final Iterator<T> ipL;
        private int ipM = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0358a() {
            this.ipL = a.this.ipI.iterator();
        }

        private final void cav() {
            while (this.ipL.hasNext()) {
                T next = this.ipL.next();
                if (((Boolean) a.this.ipK.invoke(next)).booleanValue() == a.this.ipJ) {
                    this.Gz = next;
                    this.ipM = 1;
                    return;
                }
            }
            this.ipM = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.ipM == -1) {
                cav();
            }
            if (this.ipM == 0) {
                throw new NoSuchElementException();
            }
            T t = this.Gz;
            this.Gz = null;
            this.ipM = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.ipM == -1) {
                cav();
            }
            return this.ipM == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0358a();
    }
}
