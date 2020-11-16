package rx.schedulers;
/* loaded from: classes14.dex */
public final class a<T> {
    private final long qlG;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.qlG = j;
    }

    public long eGM() {
        return this.qlG;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.qlG == aVar.qlG) {
                if (this.value == aVar.value) {
                    return true;
                }
                if (this.value != null && this.value.equals(aVar.value)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.qlG ^ (this.qlG >>> 32))) + 31) * 31);
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.qlG), this.value.toString());
    }
}
