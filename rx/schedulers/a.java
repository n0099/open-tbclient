package rx.schedulers;
/* loaded from: classes4.dex */
public final class a<T> {
    private final long njV;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.njV = j;
    }

    public long dHx() {
        return this.njV;
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
            if (this.njV == aVar.njV) {
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
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.njV ^ (this.njV >>> 32))) + 31) * 31);
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.njV), this.value.toString());
    }
}
