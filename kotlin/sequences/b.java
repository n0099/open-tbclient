package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes14.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> quZ;
    private final kotlin.jvm.a.b<T, T> qva;

    @kotlin.e
    /* loaded from: classes14.dex */
    public static final class a implements Iterator<T> {
        private T nextItem;
        private int quX = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void eLs() {
            T t;
            if (this.quX == -2) {
                t = (T) b.this.quZ.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.qva;
                T t2 = this.nextItem;
                if (t2 == null) {
                    p.eLc();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.quX = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.quX < 0) {
                eLs();
            }
            if (this.quX == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.quX = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.quX < 0) {
                eLs();
            }
            return this.quX == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        p.p(aVar, "getInitialValue");
        p.p(bVar, "getNextValue");
        this.quZ = aVar;
        this.qva = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
