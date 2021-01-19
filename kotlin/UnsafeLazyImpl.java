package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes5.dex */
public final class UnsafeLazyImpl<T> implements Serializable, c<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        p.o(aVar, "initializer");
        this.initializer = aVar;
        this._value = g.qiJ;
    }

    @Override // kotlin.c
    public T getValue() {
        if (this._value == g.qiJ) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                p.eIW();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != g.qiJ;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
