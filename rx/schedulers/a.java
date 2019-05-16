package rx.schedulers;
/* loaded from: classes2.dex */
public final class a<T> {
    private final long kum;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.kum = j;
    }

    public long getTimestampMillis() {
        return this.kum;
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
            if (this.kum == aVar.kum) {
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
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.kum ^ (this.kum >>> 32))) + 31) * 31);
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.kum), this.value.toString());
    }
}
