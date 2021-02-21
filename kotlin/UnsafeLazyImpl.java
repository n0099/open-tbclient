package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes6.dex */
public final class UnsafeLazyImpl<T> implements Serializable, c<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        p.o(aVar, "initializer");
        this.initializer = aVar;
        this._value = g.qtn;
    }

    @Override // kotlin.c
    public T getValue() {
        if (this._value == g.qtn) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                p.eLu();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != g.qtn;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
