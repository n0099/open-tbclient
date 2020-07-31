package kotlin.coroutines;

import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.coroutines.c;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
/* loaded from: classes7.dex */
public final class CombinedContext implements Serializable, c {
    private final c.b element;
    private final c left;

    public CombinedContext(c cVar, c.b bVar) {
        q.m(cVar, "left");
        q.m(bVar, "element");
        this.left = cVar;
        this.element = bVar;
    }

    @Override // kotlin.coroutines.c
    public c plus(c cVar) {
        q.m(cVar, "context");
        return c.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.c
    public <E extends c.b> E get(c.InterfaceC0913c<E> interfaceC0913c) {
        q.m(interfaceC0913c, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(interfaceC0913c);
            if (e == null) {
                c cVar = combinedContext.left;
                if (cVar instanceof CombinedContext) {
                    combinedContext = (CombinedContext) cVar;
                } else {
                    return (E) cVar.get(interfaceC0913c);
                }
            } else {
                return e;
            }
        }
    }

    @Override // kotlin.coroutines.c
    public <R> R fold(R r, m<? super R, ? super c.b, ? extends R> mVar) {
        q.m(mVar, "operation");
        return mVar.invoke((Object) this.left.fold(r, mVar), this.element);
    }

    @Override // kotlin.coroutines.c
    public c minusKey(c.InterfaceC0913c<?> interfaceC0913c) {
        q.m(interfaceC0913c, "key");
        if (this.element.get(interfaceC0913c) != null) {
            return this.left;
        }
        c minusKey = this.left.minusKey(interfaceC0913c);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    private final int size() {
        CombinedContext combinedContext = this;
        int i = 2;
        while (true) {
            c cVar = combinedContext.left;
            if (!(cVar instanceof CombinedContext)) {
                cVar = null;
            }
            CombinedContext combinedContext2 = (CombinedContext) cVar;
            if (combinedContext2 == null) {
                return i;
            }
            i++;
            combinedContext = combinedContext2;
        }
    }

    private final boolean contains(c.b bVar) {
        return q.l(get(bVar.dTY()), bVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            c cVar = combinedContext.left;
            if (cVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) cVar;
            } else if (cVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            } else {
                return contains((c.b) cVar);
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof CombinedContext) && ((CombinedContext) obj).size() == size() && ((CombinedContext) obj).containsAll(this));
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", CombinedContext$toString$1.INSTANCE)) + "]";
    }

    private final Object writeReplace() {
        int size = size();
        c[] cVarArr = new c[size];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        fold(l.nXN, new CombinedContext$writeReplace$1(cVarArr, intRef));
        if (intRef.element == size) {
            return new Serialized(cVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @h
    /* loaded from: classes7.dex */
    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final c[] elements;

        @h
        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(o oVar) {
                this();
            }
        }

        public Serialized(c[] cVarArr) {
            q.m(cVarArr, "elements");
            this.elements = cVarArr;
        }

        public final c[] getElements() {
            return this.elements;
        }

        private final Object readResolve() {
            c[] cVarArr = this.elements;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            int length = cVarArr.length;
            EmptyCoroutineContext emptyCoroutineContext2 = emptyCoroutineContext;
            int i = 0;
            while (i < length) {
                c plus = emptyCoroutineContext2.plus(cVarArr[i]);
                i++;
                emptyCoroutineContext2 = plus;
            }
            return emptyCoroutineContext2;
        }
    }
}
