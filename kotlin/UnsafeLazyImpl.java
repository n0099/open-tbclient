package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class UnsafeLazyImpl<T> implements Serializable, c<T> {
    private Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;

    public UnsafeLazyImpl(kotlin.jvm.a.a<? extends T> aVar) {
        p.j(aVar, "initializer");
        this.initializer = aVar;
        this._value = f.mYz;
    }

    @Override // kotlin.c
    public T getValue() {
        if (this._value == f.mYz) {
            kotlin.jvm.a.a<? extends T> aVar = this.initializer;
            if (aVar == null) {
                p.dER();
            }
            this._value = aVar.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != f.mYz;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
