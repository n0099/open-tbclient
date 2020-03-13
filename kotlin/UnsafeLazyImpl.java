package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class UnsafeLazyImpl<T> implements Serializable, d<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        q.j(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.nBM;
    }

    @Override // kotlin.d
    public T getValue() {
        if (this._value == k.nBM) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                q.dKw();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != k.nBM;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
