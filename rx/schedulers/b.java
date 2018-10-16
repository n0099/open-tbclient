package rx.schedulers;
/* loaded from: classes2.dex */
public final class b<T> {
    private final long iFl;
    private final T value;

    public b(long j, T t) {
        this.value = t;
        this.iFl = j;
    }

    public long getTimestampMillis() {
        return this.iFl;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.iFl == bVar.iFl) {
                if (this.value == bVar.value) {
                    return true;
                }
                if (this.value != null && this.value.equals(bVar.value)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.iFl ^ (this.iFl >>> 32))) + 31) * 31);
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.iFl), this.value.toString());
    }
}
