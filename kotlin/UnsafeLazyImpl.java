package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class UnsafeLazyImpl<T> implements Serializable, d<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        q.n(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.oRa;
    }

    @Override // kotlin.d
    public T getValue() {
        if (this._value == k.oRa) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                q.eob();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != k.oRa;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
