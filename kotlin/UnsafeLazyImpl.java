package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class UnsafeLazyImpl<T> implements Serializable, d<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        q.m(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.nPd;
    }

    @Override // kotlin.d
    public T getValue() {
        if (this._value == k.nPd) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                q.dQK();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != k.nPd;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
