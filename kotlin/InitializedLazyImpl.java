package kotlin;

import java.io.Serializable;
/* loaded from: classes4.dex */
final class InitializedLazyImpl<T> implements Serializable, c<T> {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // kotlin.c
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
