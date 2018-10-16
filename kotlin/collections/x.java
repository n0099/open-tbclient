package kotlin.collections;
/* loaded from: classes2.dex */
public final class x<T> {
    private final int index;
    private final T value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof x)) {
                return false;
            }
            x xVar = (x) obj;
            if (!(this.index == xVar.index) || !kotlin.jvm.internal.p.h(this.value, xVar.value)) {
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
