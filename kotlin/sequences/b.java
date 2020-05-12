package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> mYB;
    private final kotlin.jvm.a.b<T, T> mYC;

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<T> {
        private int mYz = -2;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void dEl() {
            T t;
            if (this.mYz == -2) {
                t = (T) b.this.mYB.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.mYC;
                T t2 = this.nextItem;
                if (t2 == null) {
                    q.dDS();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.mYz = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.mYz < 0) {
                dEl();
            }
            if (this.mYz == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.mYz = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mYz < 0) {
                dEl();
            }
            return this.mYz == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.j(aVar, "getInitialValue");
        q.j(bVar, "getNextValue");
        this.mYB = aVar;
        this.mYC = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
