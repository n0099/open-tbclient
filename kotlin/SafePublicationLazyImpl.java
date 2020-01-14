package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
final class SafePublicationLazyImpl<T> implements Serializable, d<T> {
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> nAW = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final  reason: not valid java name */
    private final Object f955final;
    private volatile kotlin.jvm.a.a<? extends T> initializer;

    public SafePublicationLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        q.j(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.nAX;
        this.f955final = j.nAX;
    }

    @Override // kotlin.d
    public T getValue() {
        T t = (T) this._value;
        if (t == j.nAX) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar != null) {
                T invoke = aVar.invoke();
                if (nAW.compareAndSet(this, j.nAX, invoke)) {
                    this.initializer = null;
                    return invoke;
                }
            }
            return (T) this._value;
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != j.nAX;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
