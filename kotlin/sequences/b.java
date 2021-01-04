package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> qmM;
    private final kotlin.jvm.a.b<T, T> qmN;

    @kotlin.e
    /* loaded from: classes5.dex */
    public static final class a implements Iterator<T> {
        private T nextItem;
        private int qmK = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void eMy() {
            T t;
            if (this.qmK == -2) {
                t = (T) b.this.qmM.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.qmN;
                T t2 = this.nextItem;
                if (t2 == null) {
                    p.eMi();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.qmK = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.qmK < 0) {
                eMy();
            }
            if (this.qmK == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.qmK = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.qmK < 0) {
                eMy();
            }
            return this.qmK == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.o(aVar, "getInitialValue");
        p.o(bVar, "getNextValue");
        this.qmM = aVar;
        this.qmN = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
