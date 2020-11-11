package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
final class SafePublicationLazyImpl<T> implements Serializable, d<T> {
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> pRQ = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final  reason: not valid java name */
    private final Object f944final;
    private volatile kotlin.jvm.a.a<? extends T> initializer;

    public SafePublicationLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        q.n(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.pRR;
        this.f944final = k.pRR;
    }

    @Override // kotlin.d
    public T getValue() {
        T t = (T) this._value;
        if (t == k.pRR) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar != null) {
                T invoke = aVar.invoke();
                if (pRQ.compareAndSet(this, k.pRR, invoke)) {
                    this.initializer = null;
                    return invoke;
                }
            }
            return (T) this._value;
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != k.pRR;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @h
    /* loaded from: classes10.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
