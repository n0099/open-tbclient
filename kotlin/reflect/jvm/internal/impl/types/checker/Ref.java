package kotlin.reflect.jvm.internal.impl.types.checker;
/* loaded from: classes2.dex */
public final class Ref<T> {
    public T value;

    public Ref(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }
}
