package kotlin;

import java.io.Serializable;
/* loaded from: classes2.dex */
final class InitializedLazyImpl<T> implements Serializable, a<T> {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

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
