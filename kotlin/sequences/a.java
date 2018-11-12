package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class a<T> implements c<T> {
    private final c<T> irs;
    private final boolean irt;
    private final kotlin.jvm.a.b<T, Boolean> iru;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.c<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.a.b<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c<? extends T> cVar, boolean z, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        p.h((Object) cVar, "sequence");
        p.h((Object) bVar, "predicate");
        this.irs = cVar;
        this.irt = z;
        this.iru = bVar;
    }

    /* renamed from: kotlin.sequences.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0386a implements Iterator<T> {
        private T GE;
        private final Iterator<T> irv;
        private int irw = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        C0386a() {
            this.irv = a.this.irs.iterator();
        }

        private final void bZS() {
            while (this.irv.hasNext()) {
                T next = this.irv.next();
                if (((Boolean) a.this.iru.invoke(next)).booleanValue() == a.this.irt) {
                    this.GE = next;
                    this.irw = 1;
                    return;
                }
            }
            this.irw = 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.irw == -1) {
                bZS();
            }
            if (this.irw == 0) {
                throw new NoSuchElementException();
            }
            T t = this.GE;
            this.GE = null;
            this.irw = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.irw == -1) {
                bZS();
            }
            return this.irw == 1;
        }
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new C0386a();
    }
}
