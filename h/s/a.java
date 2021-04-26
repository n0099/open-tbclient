package h.s;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f68027a;

    /* renamed from: b  reason: collision with root package name */
    public final T f68028b;

    public a(long j, T t) {
        this.f68028b = t;
        this.f68027a = j;
    }

    public long a() {
        return this.f68027a;
    }

    public T b() {
        return this.f68028b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f68027a == aVar.f68027a) {
                T t = this.f68028b;
                T t2 = aVar.f68028b;
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
        long j = this.f68027a;
        int i2 = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f68028b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f68027a), this.f68028b.toString());
    }
}
