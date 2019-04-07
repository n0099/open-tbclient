package rx.schedulers;
/* loaded from: classes2.dex */
public final class a<T> {
    private final long kbW;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.kbW = j;
    }

    public long getTimestampMillis() {
        return this.kbW;
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
            if (this.kbW == aVar.kbW) {
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
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.kbW ^ (this.kbW >>> 32))) + 31) * 31);
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.kbW), this.value.toString());
    }
}
