package rx.schedulers;
/* loaded from: classes2.dex */
public class a<T> {
    private final long iOc;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.iOc = j;
    }

    public int hashCode() {
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.iOc ^ (this.iOc >>> 32))) + 31) * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.iOc != aVar.iOc) {
                return false;
            }
            return this.value == null ? aVar.value == null : this.value.equals(aVar.value);
        }
        return false;
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.iOc + ", value=" + this.value + "]";
    }
}
