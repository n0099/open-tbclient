package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes10.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> pJW;
    private final kotlin.jvm.a.b<T, T> pJX;

    @kotlin.h
    /* loaded from: classes10.dex */
    public static final class a implements Iterator<T> {
        private T nextItem;
        private int pJU = -2;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void eyt() {
            T t;
            if (this.pJU == -2) {
                t = (T) b.this.pJW.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.pJX;
                T t2 = this.nextItem;
                if (t2 == null) {
                    q.eya();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.pJU = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.pJU < 0) {
                eyt();
            }
            if (this.pJU == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.pJU = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pJU < 0) {
                eyt();
            }
            return this.pJU == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.n(aVar, "getInitialValue");
        q.n(bVar, "getNextValue");
        this.pJW = aVar;
        this.pJX = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
