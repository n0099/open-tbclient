package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> kwq;
    private final kotlin.jvm.a.b<T, T> kwr;

    /* loaded from: classes2.dex */
    public static final class a implements Iterator<T> {
        private int kwo = -2;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void cNi() {
            T t;
            if (this.kwo == -2) {
                t = (T) b.this.kwq.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.kwr;
                T t2 = this.nextItem;
                if (t2 == null) {
                    p.cMY();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.kwo = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.kwo < 0) {
                cNi();
            }
            if (this.kwo == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.kwo = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.kwo < 0) {
                cNi();
            }
            return this.kwo == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.i(aVar, "getInitialValue");
        p.i(bVar, "getNextValue");
        this.kwq = aVar;
        this.kwr = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
