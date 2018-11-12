package rx.schedulers;
/* loaded from: classes2.dex */
public class a<T> {
    private final long iGV;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.iGV = j;
    }

    public int hashCode() {
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.iGV ^ (this.iGV >>> 32))) + 31) * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.iGV != aVar.iGV) {
                return false;
            }
            return this.value == null ? aVar.value == null : this.value.equals(aVar.value);
        }
        return false;
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.iGV + ", value=" + this.value + "]";
    }
}
