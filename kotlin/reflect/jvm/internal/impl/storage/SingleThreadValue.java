package kotlin.reflect.jvm.internal.impl.storage;
/* loaded from: classes9.dex */
public class SingleThreadValue<T> {
    public final Thread thread = Thread.currentThread();
    public final T value;

    public SingleThreadValue(T t) {
        this.value = t;
    }

    public T getValue() {
        if (hasValue()) {
            return this.value;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean hasValue() {
        if (this.thread == Thread.currentThread()) {
            return true;
        }
        return false;
    }
}
