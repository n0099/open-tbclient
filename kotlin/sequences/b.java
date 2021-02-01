package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes6.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> qtX;
    private final kotlin.jvm.a.b<T, T> qtY;

    @kotlin.e
    /* loaded from: classes6.dex */
    public static final class a implements Iterator<T> {
        private T nextItem;
        private int qtV = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void eLC() {
            T t;
            if (this.qtV == -2) {
                t = (T) b.this.qtX.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.qtY;
                T t2 = this.nextItem;
                if (t2 == null) {
                    p.eLm();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.qtV = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.qtV < 0) {
                eLC();
            }
            if (this.qtV == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.qtV = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qtV < 0) {
                eLC();
            }
            return this.qtV == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.o(aVar, "getInitialValue");
        p.o(bVar, "getNextValue");
        this.qtX = aVar;
        this.qtY = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
