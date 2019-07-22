package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public final class UnsafeLazyImpl<T> implements Serializable, a<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        p.k(aVar, "initializer");
        this.initializer = aVar;
        this._value = d.krm;
    }

    public T getValue() {
        if (this._value == d.krm) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                p.cNK();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != d.krm;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
