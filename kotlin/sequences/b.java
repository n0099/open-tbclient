package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public final class b<T> implements c<T> {
    private final kotlin.jvm.a.a<T> nZm;
    private final kotlin.jvm.a.b<T, T> nZn;

    @kotlin.h
    /* loaded from: classes7.dex */
    public static final class a implements Iterator<T> {
        private int nZk = -2;
        private T nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        private final void dUz() {
            T t;
            if (this.nZk == -2) {
                t = (T) b.this.nZm.invoke();
            } else {
                kotlin.jvm.a.b bVar = b.this.nZn;
                T t2 = this.nextItem;
                if (t2 == null) {
                    q.dUg();
                }
                t = (T) bVar.invoke(t2);
            }
            this.nextItem = t;
            this.nZk = this.nextItem == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nZk < 0) {
                dUz();
            }
            if (this.nZk == 0) {
                throw new NoSuchElementException();
            }
            T t = this.nextItem;
            if (t == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            this.nZk = -1;
            return t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nZk < 0) {
                dUz();
            }
            return this.nZk == 1;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.a.a<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.a.b<? super T, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends T> bVar) {
        q.m(aVar, "getInitialValue");
        q.m(bVar, "getNextValue");
        this.nZm = aVar;
        this.nZn = bVar;
    }

    @Override // kotlin.sequences.c
    public Iterator<T> iterator() {
        return new a();
    }
}
