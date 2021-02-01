package rx.schedulers;
/* loaded from: classes5.dex */
public final class a<T> {
    private final long qEt;
    private final T value;

    public a(long j, T t) {
        this.value = t;
        this.qEt = j;
    }

    public long eOa() {
        return this.qEt;
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
            if (this.qEt == aVar.qEt) {
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
        return (this.value == null ? 0 : this.value.hashCode()) + ((((int) (this.qEt ^ (this.qEt >>> 32))) + 31) * 31);
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.qEt), this.value.toString());
    }
}
