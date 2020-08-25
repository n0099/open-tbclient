package kotlin;

import java.io.Serializable;
@h
/* loaded from: classes20.dex */
public final class InitializedLazyImpl<T> implements Serializable, d<T> {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // kotlin.d
    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
