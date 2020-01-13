package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class UnsafeLazyImpl<T> implements Serializable, d<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        q.j(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.nAS;
    }

    @Override // kotlin.d
    public T getValue() {
        if (this._value == j.nAS) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                q.dJk();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != j.nAS;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
