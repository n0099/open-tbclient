package kotlin.collections;
@kotlin.h
/* loaded from: classes10.dex */
public final class ac<T> {
    private final int index;
    private final T value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof ac)) {
                return false;
            }
            ac acVar = (ac) obj;
            if (!(this.index == acVar.index) || !kotlin.jvm.internal.q.l(this.value, acVar.value)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.index * 31;
        T t = this.value;
        return (t != null ? t.hashCode() : 0) + i;
    }

    public String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ")";
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }
}
