package h.s;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f68707a;

    /* renamed from: b  reason: collision with root package name */
    public final T f68708b;

    public a(long j, T t) {
        this.f68708b = t;
        this.f68707a = j;
    }

    public long a() {
        return this.f68707a;
    }

    public T b() {
        return this.f68708b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f68707a == aVar.f68707a) {
                T t = this.f68708b;
                T t2 = aVar.f68708b;
                if (t == t2) {
                    return true;
                }
                if (t != null && t.equals(t2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f68707a;
        int i2 = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f68708b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f68707a), this.f68708b.toString());
    }
}
