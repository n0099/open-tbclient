package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class SafePublicationLazyImpl<T> implements Serializable, kotlin.a<T> {
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> kvs = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final  reason: not valid java name */
    private final Object f6final;
    private volatile kotlin.jvm.a.a<? extends T> initializer;

    public SafePublicationLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        p.i(aVar, "initializer");
        this.initializer = aVar;
        this._value = d.kvt;
        this.f6final = d.kvt;
    }

    public T getValue() {
        T t = (T) this._value;
        if (t == d.kvt) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar != null) {
                T invoke = aVar.invoke();
                if (Companion.cMA().compareAndSet(this, d.kvt, invoke)) {
                    this.initializer = null;
                    return invoke;
                }
            }
            return (T) this._value;
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != d.kvt;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> cMA() {
            return SafePublicationLazyImpl.kvs;
        }
    }
}
