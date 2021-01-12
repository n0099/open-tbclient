package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes5.dex */
final class SynchronizedLazyImpl<T> implements Serializable, c<T> {
    private volatile Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(kotlin.jvm.a.a<? extends T> aVar, Object obj) {
        p.o(aVar, "initializer");
        this.initializer = aVar;
        this._value = g.qiI;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.a.a aVar, Object obj, int i, o oVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    @Override // kotlin.c
    public T getValue() {
        T t = (T) this._value;
        if (t == g.qiI) {
            synchronized (this.lock) {
                t = this._value;
                if (t == g.qiI) {
                    kotlin.jvm.a.a<? extends T> aVar = this.initializer;
                    if (aVar == null) {
                        p.eIW();
                    }
                    T invoke = aVar.invoke();
                    this._value = invoke;
                    this.initializer = null;
                    t = invoke;
                }
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != g.qiI;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
