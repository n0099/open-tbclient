package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes17.dex */
public final class UnsafeLazyImpl<T> implements Serializable, c<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        p.o(aVar, "initializer");
        this.initializer = aVar;
        this._value = g.pJX;
    }

    @Override // kotlin.c
    public T getValue() {
        if (this._value == g.pJX) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                p.eDZ();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != g.pJX;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
